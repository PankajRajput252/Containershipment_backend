package com.sgmprime.service.Service;

import com.sgmprime.model.FinalResponse;
import com.sgmprime.model.entitities.Container;
import com.sgmprime.model.entitities.Investment;
import com.sgmprime.model.entitities.Payment;
import com.sgmprime.model.entitities.RoiTransaction;
import com.sgmprime.model.entitities.SellRequest;
import com.sgmprime.model.entitities.UserWallet;
import com.sgmprime.model.entitities.WithdrawRequest;
import com.sgmprime.model.entitities.WithdrawalAccount;
import com.sgmprime.model.entitities.enduser.SupportTicket;

public interface ContainerService {
  FinalResponse getContainer(Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  FinalResponse addContainer(Container paramContainer);
  
  FinalResponse updateContainer(Integer paramInteger, Container paramContainer);
  
  FinalResponse deleteContainer(Integer paramInteger);
  
  FinalResponse getInvestment(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addInvestment(Investment paramInvestment);
  
  FinalResponse updateInvestment(Integer paramInteger, Investment paramInvestment);
  
  FinalResponse deleteInvestment(Integer paramInteger);
  
  FinalResponse getPayment(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addPayment(Payment paramPayment);
  
  FinalResponse updatePayment(Integer paramInteger, Payment paramPayment);
  
  FinalResponse deletePayment(Integer paramInteger);
  
  FinalResponse getRoiTransaction(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addRoiTransaction(RoiTransaction paramRoiTransaction);
  
  FinalResponse updateRoiTransaction(Integer paramInteger, RoiTransaction paramRoiTransaction);
  
  FinalResponse deleteRoiTransaction(Integer paramInteger);
  
  FinalResponse getSellRequest(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addSellRequest(SellRequest paramSellRequest);
  
  FinalResponse updateSellRequest(Integer paramInteger, SellRequest paramSellRequest);
  
  FinalResponse deleteSellRequest(Integer paramInteger);
  
  FinalResponse getUserWallet(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addUserWallet(UserWallet paramUserWallet);
  
  FinalResponse updateUserWallet(Integer paramInteger, UserWallet paramUserWallet);
  
  FinalResponse deleteUserWallet(Integer paramInteger);
  
  FinalResponse getWithdrawalAccount(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addWithdrawalAccount(WithdrawalAccount paramWithdrawalAccount);
  
  FinalResponse updateWithdrawalAccount(Integer paramInteger, WithdrawalAccount paramWithdrawalAccount);
  
  FinalResponse deleteWithdrawalAccount(Integer paramInteger);
  
  FinalResponse getWithdrawRequest(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addWithdrawRequest(WithdrawRequest paramWithdrawRequest);
  
  FinalResponse updateWithdrawRequest(Integer paramInteger, WithdrawRequest paramWithdrawRequest);
  
  FinalResponse deleteWithdrawRequest(Integer paramInteger);
  
  FinalResponse getSupportTicket(Integer paramInteger, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  FinalResponse addSupportTicket(SupportTicket paramSupportTicket);
  
  FinalResponse updateSupportTicket(Integer paramInteger, SupportTicket paramSupportTicket);
  
  FinalResponse resolveSupport(Integer paramInteger);
  
  FinalResponse deleteSupportTicket(Integer paramInteger);
  
  String generateAndSave(String paramString1, String paramString2);
  
  FinalResponse sendOtp(String paramString1, String paramString2);
  
  FinalResponse getOtpForVerification(String paramString);
}

