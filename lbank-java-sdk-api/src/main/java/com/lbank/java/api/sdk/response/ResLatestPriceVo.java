package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.IncrDepth;
import com.lbank.java.api.sdk.module.LatestPrice;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResLatestPriceVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:27 下午
 **/
public class ResLatestPriceVo implements Serializable {
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
    private List<LatestPrice> data;


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

    public List<LatestPrice> getData() {
        return data;
    }

    public void setData(List<LatestPrice> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", data=" + data +
                '}';
    }
}
