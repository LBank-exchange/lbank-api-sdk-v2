package com.lbank.java.api.sdk.test.rsa;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lbank.java.api.sdk.module.Order;
import com.lbank.java.api.sdk.module.UserTransaction;
import com.lbank.java.api.sdk.response.*;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: lbank_api_v2
 * @description: 所有订单相关请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class OrderTest extends BaseTest {

    @Test
    public void testCreateOrder() throws Exception {
        for (int i = 0; i < 1; i++) {
            String customId = UUID.randomUUID().toString();
            logger.info("customId:" + customId);
            ResCreateOrderVo createOrder = service.createOrder("eth_btc", "buy", "0.01", "1", customId);
            logger.info(createOrder.toString());
        }
    }


    @Test
    public void testBatchCreateOrder() throws Exception {
        StringBuffer str = new StringBuffer("[");
        str.append("{\"symbol\":\"eth_btc\",\"amount\":\"1\",\"price\":\"0.6\",\"custom_id\":\"\",\"type\":\"sell\"}");
        str.append(",");
        str.append("{\"symbol\":\"eth_btc\",\"amount\":\"1\",\"price\":\"0.7\",\"custom_id\":\"\",\"type\":\"sell\"}");
        str.append("]");

        String orders = URLEncoder.encode(str.toString(), "UTF-8");

        List<ResCreateOrderVo> createOrder = service.batchCreateOrder(orders);
        logger.info(createOrder.toString());
    }


    @Test
    public void testCancelOrder() throws Exception {
        String orderid = "323edc94-6c05-4d0e-90cb-6f8ccd67cb18";
        ResCancelOrderVo cancelOrder = service.cancelOrder("eth_btc", orderid);
        logger.info(cancelOrder.toString());

        Map<String, String> data = cancelOrder.getData();
        if (data != null && !data.isEmpty()) {
            for (Map.Entry<String, String> detailEntry : data.entrySet()) {
                logger.info(detailEntry.getKey() + "/" + detailEntry.getValue());
            }
        }
    }

    @Test
    public void testCustomerCancelOrder() throws Exception {
        String customer_id = "62f3faf6-d26e-4a30-b21a-a64dc4e3b030";
        ResCancelOrderVo cancelOrder = service.cancelOrderByCustomer("eth_btc", customer_id);
        logger.info(cancelOrder.toString());
    }


    @Test
    public void testGetOrderInfo() throws Exception {
        String orderid = "12074652-d827-4f8d-8f52-92a005c6ce53";
        ResOrderVo orderVo = service.getOrdersInfo("eth_btc", orderid);
        logger.info(orderVo.toString());
    }

    @Test
    public void testGetOrderHistory() throws Exception {

        ResOrderHistoryVo ordersInfoHistory = service.getOrdersInfoHistory("eth_btc", "1", "20", "");
        logger.info(ordersInfoHistory.toString());

    }

    @Test
    public void testGetOrdNoDeal() throws Exception {
        ResOrderHistoryVo ordersInfoNoDeal = service.getOrdersInfoNoDeal("eth_btc", "1", "10");
        logger.info(ordersInfoNoDeal.toString());

    }

    @Test
    public void testGetOrderDetail() throws Exception {
        String orderid = "1ca440b9-1a85-4ca1-a8b6-a1b309ce25d3";
        ResOrderDetailVo orderDetailVo = service.getOrdersDetail("eth_btc", orderid);
        logger.info(orderDetailVo.toString());

    }

    @Test
    public void testGetOrderHistoryDetail() throws Exception {
        ResOrderDetailVo orderDetailVo = service.getOrdersHistoryDetail("eth_usdt", "", "2019-10-23", "2019-10-25", "", "", "");
        logger.info(orderDetailVo.toString());

    }


}
