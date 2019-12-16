package com.lbank.java.api.sdk.test.hmacsha;

import com.lbank.java.api.sdk.response.*;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Test;

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
            ResCreateOrderVo createOrder = service.createOrder("eth_btc", "sell", "0.6", "1", customId);
            logger.info(createOrder.toString());
        }
    }

    @Test
    public void testCancelOrder() throws Exception {
        String orderid = "43fc61bb-b6d8-458c-89a8-8f16e8b02319";
        ResCancelOrderVo cancelOrder = service.cancelOrder("eth_btc", orderid);
        logger.info(cancelOrder.toString());

    }

    @Test
    public void testCustomerCancelOrder() throws Exception {
        String customer_id = "a8f188f8-eabe-4b37-8bd4-3f55cdc32f72,ea075a3f-419e-48b2-8d85-4182fa83ee8c,631a2452-85ec-487b-82b4-f712493ebfa7";
        ResCancelOrderVo cancelOrder = service.cancelOrderByCustomer("lbk_usdt", customer_id);
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
        ResOrderHistoryVo ordersInfoHistory = service.getOrdersInfoHistory("usdt_btc", "1", "20", "");
        logger.info(ordersInfoHistory.toString());

    }

    @Test
    public void testGetOrdNoDeal() throws Exception {
        for (int i = 0; i < 100; i++) {
            ResOrderHistoryVo ordersInfoNoDeal = service.getOrdersInfoNoDeal("eth_usdt", "1", "10");
            logger.info(i + "/" + ordersInfoNoDeal.toString());
        }
    }

    @Test
    public void testGetOrderDetail() throws Exception {
        String orderid = "1ca440b9-1a85-4ca1-a8b6-a1b309ce25d3";
        ResOrderDetailVo orderDetailVo = service.getOrdersDetail("eth_usdt", orderid);
        logger.info(orderDetailVo.toString());
    }

    @Test
    public void testGetOrderHistoryDetail() throws Exception {
        ResOrderDetailVo orderDetailVo = service.getOrdersHistoryDetail("eth_usdt", "", "2019-10-23", "2019-10-25", "", "", "");
        logger.info(orderDetailVo.toString());
    }


}
