package com.lbank.java.api.sdk.entity;

import java.util.List;

/**
 * @author steel.cheng
 */
public class Depth {

    private List<List<Double>> bids;

    private List<List<Double>> asks;

    private Long version;

    private Long timestamp;

    public List<List<Double>> getBids() {
        return bids;
    }

    public void setBids(List<List<Double>> bids) {
        this.bids = bids;
    }

    public List<List<Double>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Double>> asks) {
        this.asks = asks;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Depth{" +
                "bids=" + bids +
                ", asks=" + asks +
                ", version=" + version +
                ", timestamp=" + timestamp +
                '}';
    }
}
