package com.lbank.java.api.sdk.module;

import java.util.List;

/**
 * @ClassName DepositPage
 * @Description
 * @Author csj
 * @Date 2022/3/23 5:00 下午
 **/
public class DepositPage {
    private Integer current_page;

    private Integer page_length;

    private Integer total;

    private List<Deposit> depositOrders;

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

    public List<Deposit> getDepositOrders() {
        return depositOrders;
    }

    public void setDepositOrders(List<Deposit> depositOrders) {
        this.depositOrders = depositOrders;
    }

    @Override
    public String toString() {
        return "DepositPage{" +
                "current_page=" + current_page +
                ", page_length=" + page_length +
                ", total=" + total +
                ", depositOrders=" + depositOrders +
                '}';
    }
}
