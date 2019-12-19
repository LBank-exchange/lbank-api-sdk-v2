package com.lbank.java.api.sdk.websocket;

/**
 * @program: lbank-api-sdk-v2
 * @description: websocket接口
 * @author: steel.cheng
 * @create: 2019-12-17 15:52
 **/
public interface WebSocket {
    void connect();

    void close();

    void subscribe(String args);

    void unSubscribe(String args);

    void sendPing();

    boolean checkSum(String data);

}
