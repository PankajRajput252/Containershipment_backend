package com.sgmprime.model.entitities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTAINER_PK_ID")
    private int containerPkId;
    @Column(name = "CONTAINER_TYPE")
    private String containerType;
    @Column(name = "OWNERSHIP_TYPE")
    private String ownershipType;
    @Column(name = "PRICE_USD")
    private BigDecimal priceUsd;
    @Column(name = "PRICE_INR")
    private BigDecimal priceInr;
    @Column(name = "MIN_SHARES")
    private int min_shares;
    @Column(name = "CONTRACT_MONTHS")
    private int contract_months;
    @Column(name = "ROI_PERCENTAGE")
    private BigDecimal roiPercentage;

    public int getContainerPkId() {
        return this.containerPkId;
    }

    public void setContainerPkId(int containerPkId) {
        this.containerPkId = containerPkId;
    }


    public String getContainerType() {
        return this.containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getOwnershipType() {
        return this.ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public BigDecimal getPriceUsd() {
        return this.priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public BigDecimal getPriceInr() {
        return this.priceInr;
    }

    public void setPriceInr(BigDecimal priceInr) {
        this.priceInr = priceInr;
    }

    public int getMin_shares() {
        return this.min_shares;
    }

    public void setMin_shares(int min_shares) {
        this.min_shares = min_shares;
    }

    public int getContract_months() {
        return this.contract_months;
    }

    public void setContract_months(int contract_months) {
        this.contract_months = contract_months;
    }

    public BigDecimal getRoiPercentage() {
        return this.roiPercentage;
    }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }
}
