package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;

/**
 * @ClassName Withdraws
 * @Description
 * @Author csj
 * @Date 2022/3/14 3:43 下午
 **/
public class Withdraws {
    private BigDecimal amount;
    private String coid;
    private String address;
    private String withdrawOrderId;
    private BigDecimal fee;
    private String networkName;
    private String transferType;
    private String txId;
    private String feeAssetCode;
    private Long id;
    private Long applyTime;
    private String status;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWithdrawOrderId() {
        return withdrawOrderId;
    }

    public void setWithdrawOrderId(String withdrawOrderId) {
        this.withdrawOrderId = withdrawOrderId;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getFeeAssetCode() {
        return feeAssetCode;
    }

    public void setFeeAssetCode(String feeAssetCode) {
        this.feeAssetCode = feeAssetCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Withdraws{" +
                "amount=" + amount +
                ", coid='" + coid + '\'' +
                ", address='" + address + '\'' +
                ", withdrawOrderId='" + withdrawOrderId + '\'' +
                ", fee=" + fee +
                ", networkName='" + networkName + '\'' +
                ", transferType='" + transferType + '\'' +
                ", txId='" + txId + '\'' +
                ", feeAssetCode='" + feeAssetCode + '\'' +
                ", id=" + id +
                ", applyTime=" + applyTime +
                ", status='" + status + '\'' +
                '}';
    }
}
