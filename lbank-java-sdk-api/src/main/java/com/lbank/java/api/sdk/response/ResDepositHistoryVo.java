package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.Accuracy;
import com.lbank.java.api.sdk.module.Deposit;
import com.lbank.java.api.sdk.module.DepositPage;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResDepositHistoryVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 3:20 下午
 **/
public class ResDepositHistoryVo implements Serializable {
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
    private DepositPage data;

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

    public DepositPage getData() {
        return data;
    }

    public void setData(DepositPage data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResDepositHistoryVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", data=" + data +
                '}';
    }
}
