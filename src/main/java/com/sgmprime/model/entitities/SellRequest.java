package com.sgmprime.model.entitities;

import com.sgmprime.model.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_sell_request")
public class SellRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SELL_REQUEST_PK_ID")
    private int sellRequestPkId;
    @Column(name = "INVESTMENT_FK_ID")
    private int investmentFkId;
    @Column(name = "USER_FK_ID")
    private String userFkId;
    @Column(name = "REQUESTED_AT")
    private String requestedAt;
    @Column(name = "APPROVED_AT")
    private String approvedAt;
    @Column(name = "SELLING_CHARGE_PERCENTAGE")
    private BigDecimal sellingChargePercentage;
    @Column(name = "MARKET_MARGIN_PERCENTAGE")
    private BigDecimal marketMarginPercentage;
    @Column(name = "FINAL_AMOUNT")
    private BigDecimal final_amount;
    @Column(name = "STATUS")
    private String status;
    @Transient
    private User user;
    @Transient
    private Investment investment;

    public int getSellRequestPkId() {
        return sellRequestPkId;
    }

    public void setSellRequestPkId(int sellRequestPkId) {
        this.sellRequestPkId = sellRequestPkId;
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

    public BigDecimal getSellingChargePercentage() {
        return sellingChargePercentage;
    }

    public void setSellingChargePercentage(BigDecimal sellingChargePercentage) {
        this.sellingChargePercentage = sellingChargePercentage;
    }

    public BigDecimal getMarketMarginPercentage() {
        return marketMarginPercentage;
    }

    public void setMarketMarginPercentage(BigDecimal marketMarginPercentage) {
        this.marketMarginPercentage = marketMarginPercentage;
    }

    public BigDecimal getFinal_amount() {
        return final_amount;
    }

    public void setFinal_amount(BigDecimal final_amount) {
        this.final_amount = final_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }
}
