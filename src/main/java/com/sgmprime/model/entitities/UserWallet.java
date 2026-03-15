package com.sgmprime.model.entitities;

import com.sgmprime.model.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_user_wallet ")
public class UserWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_WALLET_PK_ID")
    private int userWalletPkId;

    @Column(name = "USER_FK_ID")
    private String userFkId;

    @Column(name = "TOTAL_EARNED")
    private BigDecimal totalEarned;

    @Column(name = "TOTAL_WITHDRAWN")
    private BigDecimal totalWithdrawn;

    @Column(name = "AVAILABLE_BALANCE")
    private BigDecimal availableBalance;

    @Column(name = "LAST_UPDATE")
    private String lastUpdated;

    @Transient
    private User user;

    public int getUserWalletPkId() {
        return userWalletPkId;
    }

    public void setUserWalletPkId(int userWalletPkId) {
        this.userWalletPkId = userWalletPkId;
    }

    public String getUserFkId() {
        return userFkId;
    }

    public void setUserFkId(String userFkId) {
        this.userFkId = userFkId;
    }

    public BigDecimal getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(BigDecimal totalEarned) {
        this.totalEarned = totalEarned;
    }

    public BigDecimal getTotalWithdrawn() {
        return totalWithdrawn;
    }

    public void setTotalWithdrawn(BigDecimal totalWithdrawn) {
        this.totalWithdrawn = totalWithdrawn;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
