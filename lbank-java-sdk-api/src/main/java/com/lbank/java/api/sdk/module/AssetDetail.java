package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;

/**
 * @ClassName AssetDetail
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:32 下午
 **/
public class AssetDetail {
    private BigDecimal minWithdrawAmount;
    private Boolean stationDrawStatus;
    private Boolean depositStatus;
    private BigDecimal withdrawFee;
    private Boolean withdrawStatus;

    public BigDecimal getMinWithdrawAmount() {
        return minWithdrawAmount;
    }

    public void setMinWithdrawAmount(BigDecimal minWithdrawAmount) {
        this.minWithdrawAmount = minWithdrawAmount;
    }

    public Boolean getStationDrawStatus() {
        return stationDrawStatus;
    }

    public void setStationDrawStatus(Boolean stationDrawStatus) {
        this.stationDrawStatus = stationDrawStatus;
    }

    public Boolean getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(Boolean depositStatus) {
        this.depositStatus = depositStatus;
    }

    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public Boolean getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Boolean withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    @Override
    public String toString() {
        return "AssetDetail{" +
                "minWithdrawAmount=" + minWithdrawAmount +
                ", stationDrawStatus=" + stationDrawStatus +
                ", depositStatus=" + depositStatus +
                ", withdrawFee=" + withdrawFee +
                ", withdrawStatus=" + withdrawStatus +
                '}';
    }
}
