package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.Accuracy;

import java.io.Serializable;
import java.util.List;

/**
 * @program: lbank_api_v2
 * @description: 数据返回:获取所有币对的基本信息
 * @author: steel.cheng
 * @create: 2019-09-04 14:05
 **/
public class ResCurrencysVo implements Serializable {

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
     * 返回错误信息
     */
    private String msg;

    /**
     * 返回数据结构
     */
    private List<Accuracy> data;


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

    public List<Accuracy> getData() {
        return data;
    }

    public void setData(List<Accuracy> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
