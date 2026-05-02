package com.sgmprime.model.entitities;

import java.math.BigDecimal;

public class WithdrawRequestDTO {
    private Integer withdrawRequestPkId;
    private String userFkId;
    private Integer investmentFkId;
    private BigDecimal requestAmount;
    private String currency;
    private String withdrawalMethod;
    private String withdrawalAddress;  // ← add this field
    private String status;
    private String requestedAt;
    private String approvedAt;
    private String paidAt;
    private String adminRemark;

    public Integer getWithdrawRequestPkId() {
        return withdrawRequestPkId;
    }

    public void setWithdrawRequestPkId(Integer withdrawRequestPkId) {
        this.withdrawRequestPkId = withdrawRequestPkId;
    }

    public String getUserFkId() {
        return userFkId;
    }

    public void setUserFkId(String userFkId) {
        this.userFkId = userFkId;
    }

    public Integer getInvestmentFkId() {
        return investmentFkId;
    }

    public void setInvestmentFkId(Integer investmentFkId) {
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

    public String getWithdrawalAddress() {
        return withdrawalAddress;
    }

    public void setWithdrawalAddress(String withdrawalAddress) {
        this.withdrawalAddress = withdrawalAddress;
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
}
