package com.lbank.java.api.sdk.entity;

/**
 * @author chen.li
 */
public class Ticker {
    private String change;
    private String high;
    private String latest;
    private String low;
    private String turnover;
    private String vol;

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    @Override
    public String toString() {
        return "Ticket [change=" + change + ", high=" + high + ", latest=" + latest + ", low=" + low + ", turnover="
                + turnover + ", vol=" + vol + "]";
    }

}
