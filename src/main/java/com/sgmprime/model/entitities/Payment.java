package com.sgmprime.model.entitities;

import com.sgmprime.model.User;

import javax.persistence.*;

@Entity
@Table(name = "t_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYMENT_PK_ID")
    private int paymentPkId;
    @Column(name = "INVESTMENT_FK_ID")
    private int investmentFkId;
    @Column(name = "USER_FK_ID")
    private String userFkId;
    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;
    @Column(name = "TRANSACTION")
    private String transactionId;
    @Column(name = "AMOUNT")
    private String amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PAID_AT")
    private String paidAt;
    @Column(name = "CREATED_AT")
    private String createdAt;
    @Column(name = "IMAGE_ID")
    private String imageId;
    @Transient
    private String imageUrl;
    @Transient
    private User user;

    public int getPaymentPkId() {
        return paymentPkId;
    }

    public void setPaymentPkId(int paymentPkId) {
        this.paymentPkId = paymentPkId;
    }

    public int getInvestmentFkId() {
        return investmentFkId;
    }

    public void setInvestmentFkId(int investmentFkId) {
        this.investmentFkId = investmentFkId;
    }

    public String getUserFkId() {
        return userFkId;
    }

    public void setUserFkId(String userFkId) {
        this.userFkId = userFkId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
