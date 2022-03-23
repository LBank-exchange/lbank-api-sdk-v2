package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.AssetDetail;
import com.lbank.java.api.sdk.module.BookTicker;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName ResBookTickerVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:32 下午
 **/
public class ResBookTickerVo implements Serializable {
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
    private BookTicker data;

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

    public BookTicker getData() {
        return data;
    }

    public void setData(BookTicker data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResBookTickerVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", data=" + data +
                '}';
    }
}
