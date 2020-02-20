package com.lbank.java.api.sdk.module;

/**
 * 订单
 *
 * @author chen.li
 */
public class CreateOrder {
    //订单ID
    private String order_id;
    //用户发单请求时自定义字段
    private String customer_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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
                ", order_id='" + order_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
