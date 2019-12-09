package com.lbank.java.api.sdk.entity;

/**
 * @author chen.li
 */
public class Trades {
    //交易时间
    private String date_ms;
    //交易数量
    private String amount;
    //交易价格
    private String price;
    //类型
    private String type;
    //交易ID
    private String tid;

    public String getDate_ms() {
        return date_ms;
    }

    public void setDate_ms(String date_ms) {
        this.date_ms = date_ms;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Trades [date_ms=" + date_ms + ", amount=" + amount + ", price=" + price + ", type=" + type + ", tid="
                + tid + "]";
    }

}
