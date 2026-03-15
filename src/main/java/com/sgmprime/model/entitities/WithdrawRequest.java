package com.sgmprime.model.entitities;

import com.sgmprime.model.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
 @Table(name = "t_withdraw_request")
public class WithdrawRequest {
    @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       @Column(name = "WITHDRAW_REQUEST_PK_ID")
       private int withdrawRequestPkId;
       @Column(name = "USER_FK_ID")
       private String userFkId;
       @Column(name = "INVESTMENT_FK_ID")
       private int investmentFkId;
       @Column(name = "REQUEST_AMOUNT")
       private BigDecimal requestAmount;
       @Column(name = "CURRENCY")
       private String currency;
       @Column(name = "WITHDRAWAL_METHOD")
       private String withdrawalMethod;
       @Column(name = "STATUS")
       private String status;
       @Column(name = "REQUESTED_AT")
       private String requestedAt;
       @Column(name = "APPROVED_AT")
       private String approvedAt;
       @Column(name = "PAID_AT")
       private String paidAt;
       @Column(name = "ADMIN_REMARK")
       private String adminRemark;
       @Transient
       private User user;

   public int getWithdrawRequestPkId() {
      return withdrawRequestPkId;
   }

   public void setWithdrawRequestPkId(int withdrawRequestPkId) {
      this.withdrawRequestPkId = withdrawRequestPkId;
   }

   public String getUserFkId() {
      return userFkId;
   }

   public void setUserFkId(String userFkId) {
      this.userFkId = userFkId;
   }

   public int getInvestmentFkId() {
      return investmentFkId;
   }

   public void setInvestmentFkId(int investmentFkId) {
      this.investmentFkId = investmentFkId;
   }

   public BigDecimal getRequestAmount() {
      return requestAmount;
   }

   public void setRequestAmount(BigDecimal requestAmount) {
      this.requestAmount = requestAmount;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   public String getWithdrawalMethod() {
      return withdrawalMethod;
   }

   public void setWithdrawalMethod(String withdrawalMethod) {
      this.withdrawalMethod = withdrawalMethod;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getRequestedAt() {
      return requestedAt;
   }

   public void setRequestedAt(String requestedAt) {
      this.requestedAt = requestedAt;
   }

   public String getApprovedAt() {
      return approvedAt;
   }

   public void setApprovedAt(String approvedAt) {
      this.approvedAt = approvedAt;
   }

   public String getPaidAt() {
      return paidAt;
   }

   public void setPaidAt(String paidAt) {
      this.paidAt = paidAt;
   }

   public String getAdminRemark() {
      return adminRemark;
   }

   public void setAdminRemark(String adminRemark) {
      this.adminRemark = adminRemark;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
}
