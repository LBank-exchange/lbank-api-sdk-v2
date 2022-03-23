
package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;

public class NetworkList {

    private boolean isDefault;
    private String withdrawFeeRate;
    private String name;
    private BigDecimal withdrawMin;
    private BigDecimal minLimit;
    private BigDecimal minDeposit;
    private String feeAssetCode;
    private String withdrawFee;
    private int type;
    private String coin;
    private String network;

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setWithdrawFeeRate(String withdrawFeeRate) {
        this.withdrawFeeRate = withdrawFeeRate;
    }

    public String getWithdrawFeeRate() {
        return withdrawFeeRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFeeAssetCode(String feeAssetCode) {
        this.feeAssetCode = feeAssetCode;
    }

    public String getFeeAssetCode() {
        return feeAssetCode;
    }

    public void setWithdrawFee(String withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getWithdrawFee() {
        return withdrawFee;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCoin() {
        return coin;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetwork() {
        return network;
    }

    public BigDecimal getWithdrawMin() {
        return withdrawMin;
    }

    public void setWithdrawMin(BigDecimal withdrawMin) {
        this.withdrawMin = withdrawMin;
    }

    public BigDecimal getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }

    public BigDecimal getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(BigDecimal minDeposit) {
        this.minDeposit = minDeposit;
    }

    @Override
    public String toString() {
        return "NetworkList{" +
                "isDefault=" + isDefault +
                ", withdrawFeeRate='" + withdrawFeeRate + '\'' +
                ", name='" + name + '\'' +
                ", withdrawMin=" + withdrawMin +
                ", minLimit=" + minLimit +
                ", minDeposit=" + minDeposit +
                ", feeAssetCode='" + feeAssetCode + '\'' +
                ", withdrawFee='" + withdrawFee + '\'' +
                ", type=" + type +
                ", coin='" + coin + '\'' +
                ", network='" + network + '\'' +
                '}';
    }
}