package com.lbank.java.api.sdk.module;

/**
 * @ClassName Transaction
 * @Description
 * @Author csj
 * @Date 2022/3/14 7:35 下午
 **/
public class Transaction {
    private String symbol;
    private String id;
    private String orderId;
    private String price;
    private String qty;
    private String quoteQty;
    private String commission;
    private Long time;
    private Boolean isBuyer;
    private Boolean isMaker;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(String quoteQty) {
        this.quoteQty = quoteQty;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Boolean getBuyer() {
        return isBuyer;
    }

    public void setBuyer(Boolean buyer) {
        isBuyer = buyer;
    }

    public Boolean getMaker() {
        return isMaker;
    }

    public void setMaker(Boolean maker) {
        isMaker = maker;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "symbol='" + symbol + '\'' +
                ", id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                ", quoteQty='" + quoteQty + '\'' +
                ", commission='" + commission + '\'' +
                ", time=" + time +
                ", isBuyer=" + isBuyer +
                ", isMaker=" + isMaker +
                '}';
    }
}
