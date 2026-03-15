package com.sgmprime.model.entitities;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "t_investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVESTMENT_PK_ID")
    private int investmentPkId;
    @Column(name = "USER_FK_ID")
    private String userFkId;
    @Column(name = "CONTAINER_TYPE")
    private String containerType;
    @Column(name = "OWNERSHIP_TYPE")
    private String ownershipType;
    @Column(name = "INVESTED_AMOUNT")
    private BigDecimal investedAmount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "SHARES")
    private int shares;
    @Column(name = "ROI_PERCENTAGE")
    private BigDecimal roiPercentage;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    @Transient
    private String imageUrl;

    public int getInvestmentPkId() {
        return investmentPkId;
    }

    public void setInvestmentPkId(int investmentPkId) {
        this.investmentPkId = investmentPkId;
    }

    public String getUserFkId() {
        return userFkId;
    }

    public void setUserFkId(String userFkId) {
        this.userFkId = userFkId;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public BigDecimal getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(BigDecimal investedAmount) {
        this.investedAmount = investedAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
