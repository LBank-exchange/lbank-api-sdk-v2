package com.lbank.java.api.sdk.module;

import java.io.Serializable;
import java.util.Objects;

/**
 * 深度数据详细信息
 */
public class DetailDepth implements Serializable {

    /**
     * 价格
     */
    private Double price;

    /**
     * 数量
     */
    private Double mount;


    public DetailDepth(Double price, Double mount) {
        this.price = price;
        this.mount = mount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailDepth that = (DetailDepth) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(mount, that.mount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, mount);
    }
}
