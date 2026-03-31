package com.sgmprime.service.Service;


import com.sgmprime.model.FinalResponse;
import com.sgmprime.model.entitities.BtcWithdrawRequest;
import com.sgmprime.model.entitities.DepositRequest;

import java.math.BigDecimal;
import java.util.Map;

public interface CryptoDepositService {
    Map<String, Object> createDeposit(DepositRequest request);

//    void processWebhook(Map<String, Object> payload, String signature);

    FinalResponse getHistory(String userId);

    FinalResponse createBtcWithdrawal(String userNodeId, BtcWithdrawRequest request);

    void processWebhook(Map<String, Object> payload);

    FinalResponse confirmManually(String paymentId, String txHash);

    Map<String, Object> createDepositV2(DepositRequest request);

//    void processWebhookRaw(String rawBody, String signature);

//     void processWebhook(Map<String, Object> body, String sig, String rawBody);
     BigDecimal fetchConversionRate(String from, String to);
}
