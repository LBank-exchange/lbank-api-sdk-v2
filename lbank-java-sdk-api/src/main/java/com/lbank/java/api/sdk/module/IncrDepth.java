package com.lbank.java.api.sdk.module;

import java.util.List;

/**
 * @ClassName IncrDepth
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:08 下午
 **/
public class IncrDepth {
    private List<List<String>> bids;

    private List<List<String>> asks;

    public List<List<String>> getBids() {
        return bids;
    }

    public void setBids(List<List<String>> bids) {
        this.bids = bids;
    }

    public List<List<String>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<String>> asks) {
        this.asks = asks;
    }

    @Override
    public String toString() {
        return "IncrDepth{" +
                "bids=" + bids +
                ", asks=" + asks +
                '}';
    }
}
