package com.sgmprime.service.Service;

import com.sgmprime.model.Util;
import com.sgmprime.model.entitities.RoiTransaction;
import com.sgmprime.model.entitities.WithdrawRequest;
import com.sgmprime.model.entitities.WithdrawRequestDTO;
import com.sgmprime.repo.RoiTransactionRepository;
import com.sgmprime.repo.WithdrawRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class WithdrawRequestService {

    @Autowired
    private WithdrawRequestRepository withdrawRepo;
    @Autowired
    private RoiTransactionRepository roiRepo; // your existing repo

    public WithdrawRequest addWithdrawRequest(WithdrawRequestDTO dto) {

        // 1. Validate ROI exists and is ACTIVE
        List<RoiTransaction> activeRois = roiRepo
                .findByInvestmentFkIdAndStatus(
                        dto.getInvestmentFkId(), "ACTIVE"
                );

        if (activeRois.isEmpty()) {
            throw new RuntimeException("No active ROI found");
        }

        // 2. Check 30-day eligibility
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        boolean eligible = activeRois.stream().anyMatch(roi -> {
            LocalDate creditedDate = LocalDate.parse(roi.getCreditedAt());

            long days = ChronoUnit.DAYS.between(
                    creditedDate,
                    LocalDate.now()
            );

            return days >= 30;
        });

        if (!eligible) {
            throw new RuntimeException("Withdrawal allowed only after 30 days");
        }

        // 3. Check total available vs requested
        BigDecimal totalAvailable = activeRois.stream()
                .map(RoiTransaction::getMonthlyPayout)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (dto.getRequestAmount().compareTo(totalAvailable) > 0) {
            throw new RuntimeException("Amount exceeds available interest");
        }

        // 4. Save withdraw request
        WithdrawRequest request = new WithdrawRequest();
        request.setUserFkId(dto.getUserFkId());
        request.setInvestmentFkId(dto.getInvestmentFkId());
        request.setRequestAmount(dto.getRequestAmount());
        request.setCurrency(dto.getCurrency());
        request.setWithdrawalMethod(dto.getWithdrawalMethod());
        request.setWithdrawalAddress(dto.getWithdrawalAddress());
        request.setStatus(WithdrawRequest.WithdrawStatus.PENDING);
        request.setRequestedAt(Util.formatLocalDateTime(LocalDateTime.now()));

        WithdrawRequest saved = withdrawRepo.save(request);

        // ✅ 5. Update ALL active ROI records to PENDING
        // This is what makes totalInterest drop on the frontend
        // after fetchRoi() re-fetches — they will no longer be ACTIVE
        activeRois.forEach(roi -> {
//            roi.setStatus("PENDING");
            roi.setMonthlyPayout(roi.getMonthlyPayout().subtract(dto.getRequestAmount()));
            roiRepo.save(roi);
        });

        return saved;
    }


    public Page<WithdrawRequest> getWithdrawRequests(String userFkId, int page, int size, WithdrawRequest.WithdrawStatus filterBy) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("requestedAt").descending());
        if(filterBy.equals(WithdrawRequest.WithdrawStatus.ALL)){
            return  withdrawRepo.findAll(pageable);
        }
        if(Util.isDefined(userFkId)) {
            return withdrawRepo.findByUserFkId(userFkId, pageable);
        }
        else{
            return withdrawRepo.findByStatus(filterBy,pageable);
        }
    }

    // Admin: approve a request
    public WithdrawRequest approveRequest(
            Integer id, String adminRemark) {
        WithdrawRequest req = withdrawRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Request not found"));

        req.setStatus(WithdrawRequest.WithdrawStatus.APPROVED);
        req.setApprovedAt(Util.formatLocalDateTime(LocalDateTime.now()));
        req.setAdminRemark(adminRemark);
        return withdrawRepo.save(req);

    }
}
