package com.sgmprime.controller;

import com.sgmprime.model.entitities.WithdrawRequest;
import com.sgmprime.model.entitities.WithdrawRequestDTO;
import com.sgmprime.service.Service.WithdrawRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/container/withdraw")
@CrossOrigin(origins = "*")
public class WithdrawRequestController {
    @Autowired
    private WithdrawRequestService withdrawService;

    @PostMapping("/addWithdrawRequest")
    public ResponseEntity<?> addWithdrawRequest(
            @RequestBody WithdrawRequestDTO dto) {
        try {
            WithdrawRequest saved =
                    withdrawService.addWithdrawRequest(dto);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", saved);
            response.put("message", "Withdraw request submitted");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message",  e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/getWithdrawRequests")
    public ResponseEntity<?> getWithdrawRequests(
            @RequestParam String userFkId,
            @RequestParam WithdrawRequest.WithdrawStatus filterBy,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "25") int size) {
        return ResponseEntity.ok(
                withdrawService.getWithdrawRequests(
                        userFkId, page, size,filterBy)
        );
    }

    // Admin endpoint
    @PutMapping("/approveWithdrawRequest/{id}")
    public ResponseEntity<?> approveRequest(
            @PathVariable Integer id,
            @RequestParam String adminRemark) {
        return ResponseEntity.ok(
                withdrawService.approveRequest(id, adminRemark)
        );
    }
}
