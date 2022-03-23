package com.lbank.java.api.sdk.module;

import java.math.BigDecimal;

/**
 * @author chen.li
 */
public class TradesNew {
    private String quoteQty;
    private String price;
    private String qty;
    private String id;
    private String time;
    private String isBuyerMaker;

    public String getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(String quoteQty) {
        this.quoteQty = quoteQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

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

    public String getIsBuyerMaker() {
        return isBuyerMaker;
    }

    public void setIsBuyerMaker(String isBuyerMaker) {
        this.isBuyerMaker = isBuyerMaker;
    }

    @Override
    public String toString() {
        return "TradesNew{" +
                "quoteQty='" + quoteQty + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                ", id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", isBuyerMaker='" + isBuyerMaker + '\'' +
                '}';
    }
}
