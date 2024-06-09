package com.lbank.java.api.sdk.response;

import com.lbank.java.api.sdk.module.AssetDetail;
import com.lbank.java.api.sdk.module.DepositAddress;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName ResAssetDetailVo
 * @Description
 * @Author csj
 * @Date 2022/3/14 4:31 下午
 **/
public class ResAssetDetailVo implements Serializable {
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
    private Map<String, AssetDetail> data;

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

    public Map<String, AssetDetail> getData() {
        return data;
    }

    public void setData(Map<String, AssetDetail> data) {
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
        return "ResAssetDetailVo{" +
                "result=" + result +
                ", error_code='" + error_code + '\'' +
                ", code='" + code + '\'' +
                ", ts=" + ts +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
