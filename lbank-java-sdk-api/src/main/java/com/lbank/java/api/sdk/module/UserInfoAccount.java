package com.lbank.java.api.sdk.module;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserInfoAccount
 * @Description
 * @Author csj
 * @Date 2022/3/14 7:24 下午
 **/
public class UserInfoAccount {
    private Boolean canTrade;
    private Boolean canWithdraw;
    private Boolean canDeposit;
    private List<CustomerAssetInfo> balances;

    public Boolean getCanTrade() {
        return canTrade;
    }

    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public List<CustomerAssetInfo> getBalances() {
        return balances;
    }

    public void setBalances(List<CustomerAssetInfo> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "UserInfoAccount{" +
                "canTrade=" + canTrade +
                ", canWithdraw=" + canWithdraw +
                ", canDeposit=" + canDeposit +
                ", balances=" + balances +
                '}';
    }
}
