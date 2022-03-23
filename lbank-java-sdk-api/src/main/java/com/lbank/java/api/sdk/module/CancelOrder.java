package com.lbank.java.api.sdk.module;

/**
 * @ClassName CancelOrder
 * @Description
 * @Author csj
 * @Date 2022/3/14 5:54 下午
 **/
public class CancelOrder {
    private String symbol;
    private String origClientOrderId;
    private String orderId;
    private String price;
    private String origQty;
    private String executedQty;
    private Integer status;
    private String timeInForce;
    private String tradeType;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOrigClientOrderId() {
        return origClientOrderId;
    }

    public void setOrigClientOrderId(String origClientOrderId) {
        this.origClientOrderId = origClientOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrigQty() {
        return origQty;
    }

    public void setOrigQty(String origQty) {
        this.origQty = origQty;
    }

    public String getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(String executedQty) {
        this.executedQty = executedQty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public String toString() {
        return "CancelOrder{" +
                "symbol='" + symbol + '\'' +
                ", origClientOrderId='" + origClientOrderId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price='" + price + '\'' +
                ", origQty='" + origQty + '\'' +
                ", executedQty='" + executedQty + '\'' +
                ", status=" + status +
                ", timeInForce='" + timeInForce + '\'' +
                ", tradeType='" + tradeType + '\'' +
                '}';
    }
}
