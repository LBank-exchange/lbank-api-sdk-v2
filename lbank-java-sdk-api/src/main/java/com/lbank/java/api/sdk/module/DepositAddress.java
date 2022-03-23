package com.lbank.java.api.sdk.module;

/**
 * @ClassName DepositAddress
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:24 下午
 **/
public class DepositAddress {
    private String address;
    private String memo;
    private String coin;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "DepositAddress{" +
                "address='" + address + '\'' +
                ", memo='" + memo + '\'' +
                ", coin='" + coin + '\'' +
                '}';
    }
}
