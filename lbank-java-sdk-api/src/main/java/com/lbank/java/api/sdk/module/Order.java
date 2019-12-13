package com.lbank.java.api.sdk.module;

/**
 * 订单
 *
 * @author chen.li
 */
public class Order {
    //交易对
    private String symbol;
    //下单数量
    private String amount;
    //委托时间
    private String create_time;
    //委托价格
    private String price;
    //平均成交价
    private String avg_price;
    //类型
    private String type;
    //订单ID
    private String order_id;
    //成交数量
    private String deal_amount;
    //委托状态
    private String status;
    //用户发单请求时自定义字段
    private String customer_id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(String avg_price) {
        this.avg_price = avg_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDeal_amount() {
        return deal_amount;
    }

    public void setDeal_amount(String deal_amount) {
        this.deal_amount = deal_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "symbol='" + symbol + '\'' +
                ", amount='" + amount + '\'' +
                ", create_time='" + create_time + '\'' +
                ", price='" + price + '\'' +
                ", avg_price='" + avg_price + '\'' +
                ", type='" + type + '\'' +
                ", order_id='" + order_id + '\'' +
                ", deal_amount='" + deal_amount + '\'' +
                ", status='" + status + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
