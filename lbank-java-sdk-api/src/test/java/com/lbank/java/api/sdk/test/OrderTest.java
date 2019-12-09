package com.lbank.java.api.sdk.test;

import com.lbank.java.api.sdk.entity.Order;
import com.lbank.java.api.sdk.entity.OrderPage;
import com.lbank.java.api.sdk.entity.UserTransaction;
import com.lbank.java.api.sdk.response.*;
import org.junit.Assert;
import org.junit.Test;

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
            String customerId = UUID.randomUUID().toString();
            logger.info("customerId:" + customerId);
            ResCreateOrderVo createOrder = apiSdkService.createOrder("lbk_usdt", "sell", "0.6", "1", customerId);
            logger.info(createOrder.toString());
        }
    }

    @Test
    public void testCancelOrder() throws Exception {
        String orderid = "8118f8b3-642e-4a05-97c8-1e45f38f8744";
        ResCancelOrderVo cancelOrder = apiSdkService.cancelOrder("lbk_usdt", orderid);
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
        String customer_id = "a8f188f8-eabe-4b37-8bd4-3f55cdc32f72,ea075a3f-419e-48b2-8d85-4182fa83ee8c,631a2452-85ec-487b-82b4-f712493ebfa7";
        ResCancelOrderVo cancelOrder = apiSdkService.cancelOrderByCustomer("lbk_usdt", customer_id);
        logger.info(cancelOrder.toString());

        Map<String, String> data = cancelOrder.getData();
        if (data != null && !data.isEmpty()) {
            for (Map.Entry<String, String> detailEntry : data.entrySet()) {
                logger.info(detailEntry.getKey() + "/" + detailEntry.getValue());
            }
        }
    }


    @Test
    public void testGetOrderInfo() throws Exception {
        String orderid = "12074652-d827-4f8d-8f52-92a005c6ce53";
        ResOrderVo orderVo = apiSdkService.getOrdersInfo("eth_btc", orderid);
        logger.info(orderVo.toString());

        List<Order> data = orderVo.getData();
        if (data != null && !data.isEmpty()) {
            data.forEach(order ->
                    logger.info(order.toString())
            );
        }
    }

    @Test
    public void testGetOrderHistory() throws Exception {

        ResOrderHistoryVo ordersInfoHistory = apiSdkService.getOrdersInfoHistory("usdt_btc", "1", "20", "");
        logger.info(ordersInfoHistory.toString());

//            OrderPage page = ordersInfoHistory.getData();
//            if(page!=null && page.getOrders() != null) {
//                page.getOrders().forEach(order ->
//                        logger.info(order.toString())
//                );
//            }

    }

    @Test
    public void testGetOrdNoDeal() throws Exception {
        for (int i = 0; i < 100; i++) {
            ResOrderHistoryVo ordersInfoNoDeal = apiSdkService.getOrdersInfoNoDeal("eth_usdt", "1", "10");
            logger.info(i + "/" + ordersInfoNoDeal.toString());

//            OrderPage page = ordersInfoNoDeal.getData();
//            if(page!=null && page.getOrders() != null) {
//                page.getOrders().forEach(order ->
//                        logger.info(order.toString())
//                );
//            }
        }
    }

    @Test
    public void testGetOrderDetail() throws Exception {
        String orderid = "1ca440b9-1a85-4ca1-a8b6-a1b309ce25d3";
        ResOrderDetailVo orderDetailVo = apiSdkService.getOrdersDetail("eth_usdt", orderid);
        logger.info(orderDetailVo.toString());

        List<UserTransaction> datas = orderDetailVo.getData();
        if (datas != null && !datas.isEmpty()) {
            datas.forEach(order ->
                    logger.info(order.toString())
            );
        }
    }

    @Test
    public void testGetOrderHistoryDetail() throws Exception {
        ResOrderDetailVo orderDetailVo = apiSdkService.getOrdersHistoryDetail("eth_usdt", "", "2019-10-23", "2019-10-25", "", "", "");
        logger.info(orderDetailVo.toString());

        List<UserTransaction> datas = orderDetailVo.getData();
        logger.info("size:" + datas.size());
        if (datas != null && !datas.isEmpty()) {
            datas.forEach(order ->
                    logger.info(order.toString())
            );
        }
    }


}
