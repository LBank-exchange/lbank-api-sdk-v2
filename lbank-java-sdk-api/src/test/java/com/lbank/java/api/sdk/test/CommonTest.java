package com.lbank.java.api.sdk.test;


import com.lbank.java.api.sdk.entity.Accuracy;
import com.lbank.java.api.sdk.entity.TicketMessage;
import com.lbank.java.api.sdk.entity.Trades;
import com.lbank.java.api.sdk.response.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @program: lbank_api_v2
 * @description: 所有GET请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class CommonTest extends BaseTest {


    @Test
    public void testAccuracy() throws Exception {
        for (int i = 0; i < 1000; i++) {
            ResCurrencysVo accuracys = apiSdkService.getAccuracy();
            logger.info(accuracys.toString());

//            List<Accuracy> data = accuracys.getData();
//            if(data != null && data.size()>0) {
//                data.forEach(accuracy -> logger.info(accuracy.toString()));
//            }
        }


    }

    @Test
    public void testCuccuracyPairs() throws Exception {
        ResCurrencyPairsVo accuracys = apiSdkService.getCurrencyPairs();
        logger.info(accuracys.toString());

        List<String> data = accuracys.getData();
        if (data != null && data.size() > 0) {
            data.forEach(accuracy -> logger.info(accuracy));
        }
    }

    /**
     * Description:美元和人民币的汇率
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetUSDToCny() throws Exception {
        for (int i = 0; i < 110; i++) {
            ResUsdToCnyVo vo = apiSdkService.getUsdToCny();
            logger.info(i + "/" + vo.toString());
        }

    }


    /**
     * Description:获取LBank行情数据
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetTicker() throws Exception {
        ResTickerVo vo = apiSdkService.getTicker("all");
        logger.info(vo.toString());

        List<TicketMessage> data = vo.getData();
        if (data != null && data.size() > 0) {
            data.forEach(ticketMessage ->
                    logger.info(ticketMessage.toString())
            );
        }
    }

    /**
     * Description:获取LBank行情数据
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetTrades() throws Exception {
        ResTradeVo trades = apiSdkService.getTrades("eth_btc", 10, null);

        logger.info(trades.toString());
        List<Trades> data = trades.getData();
        if (data != null && data.size() > 0) {
            data.forEach(trade ->
                    logger.info(trade.toString())
            );
        }
    }

    /**
     * Description:获取Kline行情数据
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetKlines() throws Exception {
        ResTradeVo trades = apiSdkService.getTrades("eth_btc", 10, null);

        logger.info(trades.toString());
        List<Trades> data = trades.getData();
        if (data != null && data.size() > 0) {
            data.forEach(trade ->
                    logger.info(trade.toString())
            );
        }
    }

    /**
     * Description:获取全量深度数据
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetDepth() throws Exception {
        ResDepthVo vo = apiSdkService.getDepth("gki_usdt", 60, "-1");
        logger.info(vo.toString());
    }

    /**
     * Description:获取增量深度数据
     *
     * @Author: steel.cheng
     * @Date: 2019/9/5-2:29 PM
     * @Version: 1.0
     */
    @Test
    public void testGetIncrDepth() throws Exception {
        ResDepthVo vo = apiSdkService.getIncrDepth("eth_btc", 1);
        logger.info(vo.toString());
    }

    @Test
    public void testGetTimestamp() throws Exception {
        ResTimestampVo vo = apiSdkService.getTimestamp();
        logger.info(vo.toString());

//        for (int i = 0; i < 210; i++) {
//            vo = apiSdkService.getTimestamp();
//            logger.info(vo.toString());
//        }

        String uuid = UUID.randomUUID().toString();
        String uuid2 = StringUtils.replaceAll(uuid, "-", "");
        logger.info(uuid2 + "");
        logger.info(UUID.randomUUID().toString().length() + "");
    }

    @Test
    public void testSort() {
        int[] arrays = new int[]{1,20,12,34,35,34,98,100};
        bubbleSort(arrays);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            //外层循环移动游标 //内层循环遍历游标及之后(或之前)的元素
            for (int j = 0; j < i && (j + 1) < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }
            }
        }
    }


}
