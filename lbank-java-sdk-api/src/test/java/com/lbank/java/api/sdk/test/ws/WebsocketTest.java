package com.lbank.java.api.sdk.test.ws;

import com.alibaba.fastjson.JSONObject;
import com.lbank.java.api.sdk.websocket.WebSocket;
import com.lbank.java.api.sdk.websocket.WebSocketAdapter;
import com.lbank.java.api.sdk.websocket.WebSocketClient;
import org.junit.Test;

/**
 * @program: lbank-api-sdk-v2
 * @description: WebsocketTest
 * @author: steel.cheng
 * @create: 2019-12-17 17:05
 **/
public class WebsocketTest {

    @Test
    public void wsTest() {
        WebSocket ws = new WebSocketClient(new WebSocketAdapter() {
            @Override
            public void onTextMessage(WebSocket ws, String text) throws Exception {
                System.out.println("ws message: " + text);
                if (text.contains("checksum")) {
                    boolean res = ws.checkSum(text);
                }
            }

            @Override
            public void onWebsocketOpen(WebSocket ws) {
                System.out.println("ws open");
                ws.subscribe(paramJson());
            }

            @Override
            public void handleCallbackError(WebSocket websocket, Throwable cause) {
                cause.printStackTrace();
            }


            @Override
            public void onWebsocketClose(WebSocket ws, int code) {
                System.out.println("ws close code = " + code);
            }

            @Override
            public void onWebsocketPong(WebSocket ws) {
                System.out.println("receive pong");
            }
        });
        ws.connect();
    }


    private String paramJson(){
//        {
//            "action":"subscribe",
//                "subscribe":"depth",
//                "depth":"200",
//                "pair":"lbk_usdt",
//                "type":"100"
//        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action","subscribe");
        jsonObject.put("subscribe","depth");
        jsonObject.put("depth","200");
        jsonObject.put("pair","lbk_usdt");
        jsonObject.put("type","-1");
        return jsonObject.toJSONString();
    }
}
