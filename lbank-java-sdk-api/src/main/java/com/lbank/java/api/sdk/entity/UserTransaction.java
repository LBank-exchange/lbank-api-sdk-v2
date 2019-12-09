package com.lbank.java.api.sdk.entity;

import java.math.BigDecimal;

/**
 * Created by cong.peng on 2018/9/26.
 */
public class UserTransaction {

    private String txUuid;
    private String orderUuid;
    private String tradeType;
    private Long dealTime;
    private BigDecimal dealPrice;
    private BigDecimal dealQuantity;
    private BigDecimal dealVolumePrice;
    private BigDecimal tradeFee;
    private BigDecimal tradeFeeRate;

    public String getTxUuid() {
        return txUuid;
    }

    public void setTxUuid(String txUuid) {
        this.txUuid = txUuid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Long getDealTime() {
        return dealTime;
    }

    public void setDealTime(Long dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getDealQuantity() {
        return dealQuantity;
    }

    public void setDealQuantity(BigDecimal dealQuantity) {
        this.dealQuantity = dealQuantity;
    }

    public BigDecimal getDealVolumePrice() {
        return dealVolumePrice;
    }

    public void setDealVolumePrice(BigDecimal dealVolumePrice) {
        this.dealVolumePrice = dealVolumePrice;
    }

    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }

    public BigDecimal getTradeFeeRate() {
        return tradeFeeRate;
    }

    public void setTradeFeeRate(BigDecimal tradeFeeRate) {
        this.tradeFeeRate = tradeFeeRate;
    }

    @Override
    public String toString() {
        return "UserTransaction{" +
                "txUuid='" + txUuid + '\'' +
                ", orderUuid='" + orderUuid + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", dealTime=" + dealTime +
                ", dealPrice=" + dealPrice +
                ", dealQuantity=" + dealQuantity +
                ", dealVolumePrice=" + dealVolumePrice +
                ", tradeFee=" + tradeFee +
                ", tradeFeeRate=" + tradeFeeRate +
                '}';
    }
}
