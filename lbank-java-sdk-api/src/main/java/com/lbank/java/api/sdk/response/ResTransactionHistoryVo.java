package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.Transaction;
import com.lbank.java.api.sdk.module.UserAssetInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ResTransactionHistoryVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 7:35 下午
 **/
public class ResTransactionHistoryVo implements Serializable {

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
    private List<Transaction> data;


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

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
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
