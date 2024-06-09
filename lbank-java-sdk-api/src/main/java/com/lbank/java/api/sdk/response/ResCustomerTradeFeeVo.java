package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.CustomerTradeFee;
import com.lbank.java.api.sdk.module.DepositAddress;

import java.util.List;

/**
 * @ClassName ResCustomerTradeFeeVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:40 下午
 **/
public class ResCustomerTradeFeeVo {
    /**
     * 返回结果，true/false
     */
    private Boolean result;

    /**
     * 返回错误码
     */
    private String error_code;

    private String code;

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
    private List<CustomerTradeFee> data;

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

    public List<CustomerTradeFee> getData() {
        return data;
    }

    public void setData(List<CustomerTradeFee> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResCustomerTradeFeeVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", code='" + code + '\'' +
                ", ts=" + ts +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
