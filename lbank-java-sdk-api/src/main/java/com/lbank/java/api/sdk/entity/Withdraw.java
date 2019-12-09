package com.lbank.java.api.sdk.entity;

import java.util.Date;

/**
 * 提币结果
 *
 * @author steel.cheng
 */
public class Withdraw {

    //提币数量
    private String amount;
    //币种编号
    private String assetCode;
    //提币地址
    private String address;
    //提币手续费
    private String fee;
    //提币记录编号
    private String id;
    //提币时间
    private String time;
    //提币hash
    private String txHash;
    //提币状态
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", assetCode='" + assetCode + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", amount='" + amount + '\'' +
                ", fee='" + fee + '\'' +
                ", txHash='" + txHash + '\'' +
                '}';
    }
}
