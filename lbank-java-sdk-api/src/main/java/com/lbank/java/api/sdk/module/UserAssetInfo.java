package com.lbank.java.api.sdk.module;

import java.util.List;

public class UserAssetInfo {

    private String usableAmt;
    private String assetAmt;
    private List<NetworkList> networkList;
    private String freezeAmt;
    private String coin;

    public void setUsableAmt(String usableAmt) {
        this.usableAmt = usableAmt;
    }

    public String getUsableAmt() {
        return usableAmt;
    }

    public void setAssetAmt(String assetAmt) {
        this.assetAmt = assetAmt;
    }

    public String getAssetAmt() {
        return assetAmt;
    }

    public void setNetworkList(List<NetworkList> networkList) {
        this.networkList = networkList;
    }

    public List<NetworkList> getNetworkList() {
        return networkList;
    }

    public void setFreezeAmt(String freezeAmt) {
        this.freezeAmt = freezeAmt;
    }

    public String getFreezeAmt() {
        return freezeAmt;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCoin() {
        return coin;
    }

    @Override
    public String toString() {
        return "UserAssetInfo{" +
                "usableAmt='" + usableAmt + '\'' +
                ", assetAmt='" + assetAmt + '\'' +
                ", networkList=" + networkList +
                ", freezeAmt='" + freezeAmt + '\'' +
                ", coin='" + coin + '\'' +
                '}';
    }
}