package com.lbank.java.api.sdk.test.ws;

import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: lbank-api-sdk-v2
 * @description: PublicChannelTest
 * @author: steel.cheng
 * @create: 2019-12-17 17:42
 **/
public class PublicChannelTest {
    private static final WebSocketClient webSocketClient = new WebSocketClient();

    @Before
    public void connect() {
        WebSocketConfig.publicConnect(webSocketClient);
    }

    @After
    public void close() {
        webSocketClient.closeConnection();
    }

    /**
     * 深度
     * Depth Channel
     */
    @Test
    public void depthChannel() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action","subscribe");
        jsonObject.put("subscribe","depth");
        jsonObject.put("depth","200");
        jsonObject.put("pair","lbk_usdt");
        jsonObject.put("type","-1");
        jsonObject.toJSONString();

        webSocketClient.subscribe(jsonObject.toJSONString());
        //为保证测试方法不停，需要让线程延迟
        try {
            Thread.sleep(100000000);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
