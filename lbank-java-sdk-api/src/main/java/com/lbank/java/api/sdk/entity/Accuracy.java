package com.lbank.java.api.sdk.entity;

/**
 * @program: lbank_api_v2
 * @description: 交易对信息
 * @author: steel.cheng
 * @create: 2019-09-05 13:55
 **/
public class Accuracy {

    private String minTranQua;

    private String symbol;

    private String quantityAccuracy;

    private String priceAccuracy;

    public String getMinTranQua() {
        return minTranQua;
    }

    public void setMinTranQua(String minTranQua) {
        this.minTranQua = minTranQua;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuantityAccuracy() {
        return quantityAccuracy;
    }

    public void setQuantityAccuracy(String quantityAccuracy) {
        this.quantityAccuracy = quantityAccuracy;
    }

    public String getPriceAccuracy() {
        return priceAccuracy;
    }

    public void setPriceAccuracy(String priceAccuracy) {
        this.priceAccuracy = priceAccuracy;
    }

    @Override
    public String toString() {
        return "Accuracy{" +
                "minTranQua='" + minTranQua + '\'' +
                ", symbol='" + symbol + '\'' +
                ", quantityAccuracy='" + quantityAccuracy + '\'' +
                ", priceAccuracy='" + priceAccuracy + '\'' +
                '}';
    }
}
