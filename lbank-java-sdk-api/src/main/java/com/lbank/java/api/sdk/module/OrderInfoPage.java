package com.lbank.java.api.sdk.module;

import java.util.List;

/**
 * @ClassName OrderInfoPage
 * @Description
 * @Author csj
 * @Date 2022/3/23 4:54 下午
 **/
public class OrderInfoPage {
    private Integer current_page;

    private Integer page_length;

    private Integer total;

    private List<OrderInfo> orders;

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

    public List<OrderInfo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderInfo> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderInfoPage{" +
                "current_page=" + current_page +
                ", page_length=" + page_length +
                ", total=" + total +
                ", orders=" + orders +
                '}';
    }
}
