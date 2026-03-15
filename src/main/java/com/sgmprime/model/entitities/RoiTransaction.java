package com.sgmprime.model.entitities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_roi_transaction")
public class RoiTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROI_TXN_PK_ID")
    private int roiTxnPkId;
    @Column(name = "INVESTMENT_FK_ID")
    private int investmentFkId;
    @Column(name = "USER_FK_ID")
    private String userFkId;
    @Column(name = "RENT_START_DATE")
    private String rentStartDate;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "CONTRACT_MONTH")
    private int contractMonth;
    @Column(name = "MONTHLY_PAYOUT")
    private BigDecimal monthlyPayout;
    @Column(name = "ROI_PERCENTAGE")
    private BigDecimal roiPercentage;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATED_AT")
    private String creditedAt;

    public int getRoiTxnPkId() {
        return roiTxnPkId;
    }

    public void setRoiTxnPkId(int roiTxnPkId) {
        this.roiTxnPkId = roiTxnPkId;
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

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(int contractMonth) {
        this.contractMonth = contractMonth;
    }

    public BigDecimal getMonthlyPayout() {
        return monthlyPayout;
    }

    public void setMonthlyPayout(BigDecimal monthlyPayout) {
        this.monthlyPayout = monthlyPayout;
    }

    public BigDecimal getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreditedAt() {
        return creditedAt;
    }

    public void setCreditedAt(String creditedAt) {
        this.creditedAt = creditedAt;
    }
}
