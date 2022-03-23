package com.lbank.java.api.sdk.module;

/**
 * @ClassName CustomerTradeFee
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:40 下午
 **/
public class CustomerTradeFee {
    private String symbol;
    private String makerCommission;
    private String takerCommission;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(String makerCommission) {
        this.makerCommission = makerCommission;
    }

    public String getTakerCommission() {
        return takerCommission;
    }

    public void setTakerCommission(String takerCommission) {
        this.takerCommission = takerCommission;
    }

    @Override
    public String toString() {
        return "CustomerTradeFee{" +
                "symbol='" + symbol + '\'' +
                ", makerCommission='" + makerCommission + '\'' +
                ", takerCommission='" + takerCommission + '\'' +
                '}';
    }
}
