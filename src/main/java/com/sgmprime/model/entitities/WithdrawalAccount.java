package com.sgmprime.model.entitities;

import com.sgmprime.model.User;

import javax.persistence.*;

@Entity
@Table(name = "t_withdraw_request")
public class WithdrawalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WITHDRAW_REQUEST_PK_ID")
    private int withdrawRequestPkId;

    @Column(name = "USER_FK_ID")
    private String userFkId;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "UPI_ID")
    private String upiId;

    @Column(name = "IS_DEFAULT")
    private String isDefault;

    @Column(name = "CREATED_AT")
    private String createdAt;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
