package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.CancelOrder;

import java.util.List;

/**
 * @ClassName ResCancelOrderBySymbolVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 6:01 下午
 **/
public class ResCancelOrderBySymbolVo {
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
    private List<CancelOrder> data;


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

    public List<CancelOrder> getData() {
        return data;
    }

    public void setData(List<CancelOrder> data) {
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
        return "ResCancelOrderBySymbolVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", ts=" + ts +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
