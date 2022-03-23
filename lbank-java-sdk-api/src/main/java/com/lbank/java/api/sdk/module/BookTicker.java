package com.lbank.java.api.sdk.module;

/**
 * @ClassName BookTicker
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:32 下午
 **/
public class BookTicker {
    private String symbol;
    private String askPrice;
    private String askQty;
    private String bidQty;
    private String bidPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public String getAskQty() {
        return askQty;
    }

    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }

    public String getBidQty() {
        return bidQty;
    }

    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    @Override
    public String toString() {
        return "BookTicker{" +
                "symbol='" + symbol + '\'' +
                ", askPrice='" + askPrice + '\'' +
                ", askQty='" + askQty + '\'' +
                ", bidQty='" + bidQty + '\'' +
                ", bidPrice='" + bidPrice + '\'' +
                '}';
    }
}