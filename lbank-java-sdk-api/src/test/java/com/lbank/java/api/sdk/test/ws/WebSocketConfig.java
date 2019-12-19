package com.lbank.java.api.sdk.test.ws;

import com.lbank.java.api.sdk.constant.Contant;

/**
 * @program: lbank-api-sdk-v2
 * @description: WebSocketConfig
 * @author: steel.cheng
 * @create: 2019-12-17 17:39
 **/
public class WebSocketConfig {

    public static void publicConnect(WebSocketClient webSocketClient) {
        webSocketClient.connection(Contant.WS_URL);
    }

}
