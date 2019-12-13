package com.lbank.java.api.sdk.module;

import java.util.List;

/**
 * 订单
 *
 * @author steel.cheng
 */
public class WithdrawPage {

    private Integer current_page;

    private Integer page_length;

    private Integer total;

    private List<Withdraw> withdraws;

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

    public List<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(List<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    @Override
    public String toString() {
        return "WithdrawPage{" +
                "current_page=" + current_page +
                ", page_length=" + page_length +
                ", total=" + total +
                ", withdraws=" + withdraws +
                '}';
    }
}
