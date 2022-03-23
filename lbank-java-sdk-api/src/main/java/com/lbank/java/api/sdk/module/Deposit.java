package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Deposit
 * @Description
 * @Author csj
 * @Date 2022/3/14 3:15 下午
 **/
public class Deposit {
    private String coin;
    private String status;
    private String txId;
    private String networkName;
    private String address;
    private BigDecimal amount;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "coin='" + coin + '\'' +
                ", status='" + status + '\'' +
                ", txId='" + txId + '\'' +
                ", networkName='" + networkName + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
