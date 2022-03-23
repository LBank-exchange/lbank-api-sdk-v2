package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;

/**
 * @ClassName LatestPrice
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:25 下午
 **/
public class LatestPrice {
    private String symbol;
    private BigDecimal price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LatestPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
