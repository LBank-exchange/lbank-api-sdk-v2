package com.lbank.java.api.sdk.entity;

/**
 * @author chen.li
 */
public class TicketMessage {
    private String symbol;
    private String timestamp;
    private Ticker ticker;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "TicketMessage [symbol=" + symbol + ", timestamp=" + timestamp + ", ticker=" + ticker + "]";
    }

}
