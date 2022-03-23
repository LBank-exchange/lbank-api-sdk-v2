package com.lbank.java.api.sdk.module;

/**
 * @ClassName CustomerAssetInfo
 * @Description
 * @Author csj
 * @Date 2022/3/14 7:26 下午
 **/
public class CustomerAssetInfo {
    private String asset;
    private String free;
    private String locked;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "CustomerAssetInfo{" +
                "asset='" + asset + '\'' +
                ", free='" + free + '\'' +
                ", locked='" + locked + '\'' +
                '}';
    }
}
