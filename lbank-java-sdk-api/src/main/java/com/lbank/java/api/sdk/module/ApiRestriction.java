package com.lbank.java.api.sdk.module;

/**
 * @ClassName ApiRestriction
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:51 下午
 **/
public class ApiRestriction {
    private Boolean enableSpotTrading;
    private Long createTime;
    private Boolean enableReading;
    private Boolean ipRestrict;
    private Boolean enableWithdrawals;

    public Boolean getEnableSpotTrading() {
        return enableSpotTrading;
    }

    public void setEnableSpotTrading(Boolean enableSpotTrading) {
        this.enableSpotTrading = enableSpotTrading;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnableReading() {
        return enableReading;
    }

    public void setEnableReading(Boolean enableReading) {
        this.enableReading = enableReading;
    }

    public Boolean getIpRestrict() {
        return ipRestrict;
    }

    public void setIpRestrict(Boolean ipRestrict) {
        this.ipRestrict = ipRestrict;
    }

    public Boolean getEnableWithdrawals() {
        return enableWithdrawals;
    }

    public void setEnableWithdrawals(Boolean enableWithdrawals) {
        this.enableWithdrawals = enableWithdrawals;
    }

    @Override
    public String toString() {
        return "ApiRestriction{" +
                "enableSpotTrading=" + enableSpotTrading +
                ", createTime=" + createTime +
                ", enableReading=" + enableReading +
                ", ipRestrict=" + ipRestrict +
                ", enableWithdrawals=" + enableWithdrawals +
                '}';
    }
}
