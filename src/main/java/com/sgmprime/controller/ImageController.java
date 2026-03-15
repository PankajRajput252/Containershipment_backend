package com.sgmprime.controller;

import com.sgmprime.model.FinalResponse;
import com.sgmprime.model.Util;
import com.sgmprime.model.entitities.Payment;
import com.sgmprime.repo.InvestmentRepository;
import com.sgmprime.repo.PaymentRepository;
import com.sgmprime.repo.UserRepository;
import com.sgmprime.service.Service.ContainerService;
import com.sgmprime.service.Service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ContainerService containerService;
    @Autowired
    private InvestmentRepository investmentRepository;

    @PostMapping({"/depositAmount"})
    public FinalResponse uploadImage(@RequestParam("file") MultipartFile file, @RequestParam(value = "userNodeId", required = false) String userNodeId, @RequestParam(value = "investmentId", required = false) String investmentId, @RequestParam(value = "transactionId", required = false) String transactionId, @RequestParam(value = "amount", required = false) String amount, @RequestParam(value = "currency", required = false) String currency, @RequestParam(value = "paidAt", required = false) String paidAt) {
        FinalResponse finalResponse = new FinalResponse();

        try {
            Payment payment = new Payment();
            payment.setInvestmentFkId(Integer.parseInt(investmentId));
            payment.setUserFkId(userNodeId);
            payment.setPaymentMethod("BANK_TRANSFER");
            payment.setTransactionId(transactionId);
            payment.setAmount(amount);
            payment.setCurrency(currency);
            payment.setPaidAt(paidAt);
            payment.setStatus("PENDING");
            finalResponse = this.containerService.addPayment(payment);
            if (!finalResponse.getStatusCode().equalsIgnoreCase("200")) {
                return finalResponse;
            }
            Payment payment1 = (Payment) finalResponse.getResponse();
            String imageId = this.imageUploadService.uploadFile(file);

            int count = this.paymentRepository.updateProfileImageUrlBasedOnNodeId(imageId, userNodeId, payment1.getPaymentPkId());
            this.investmentRepository.updateInvestmentStatus("REQUESTED", userNodeId, Integer.parseInt(investmentId));
            Util.setSuccessMessage(finalResponse);
            finalResponse.setMessage("Image uploaded successfully: " + imageId);
        } catch (Exception e) {
            finalResponse.setMessage("Upload failed: " + e.getMessage());
        }
        return finalResponse;
    }
}
