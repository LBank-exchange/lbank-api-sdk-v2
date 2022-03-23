package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.LatestPrice;
import com.lbank.java.api.sdk.module.OrderInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResOrderInfoVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 6:06 下午
 **/
public class ResOrderInfoVo implements Serializable {
    /**
     * 返回结果，true/false
     */
    private Boolean result;

    /**
     * 返回错误码
     */
    private String error_code;

    /**
     * 返回时间戳
     */
    private Long ts;

    /**
     * 返回数据结构
     */
    private OrderInfo data;


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public OrderInfo getData() {
        return data;
    }

    public void setData(OrderInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResOrderInfoVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", data=" + data +
                '}';
    }
}
