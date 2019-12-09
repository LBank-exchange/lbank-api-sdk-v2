package com.lbank.java.api.sdk.entity;

import java.util.List;

/**
 * 订单
 *
 * @author chen.li
 */
public class OrderPage {

    private Integer current_page;

    private Integer page_length;

    private Integer total;

    private List<Order> orders;

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public Integer getPage_length() {
        return page_length;
    }

    public void setPage_length(Integer page_length) {
        this.page_length = page_length;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderPage{" +
                "current_page=" + current_page +
                ", page_length=" + page_length +
                ", total=" + total +
                ", orders=" + orders +
                '}';
    }
}
