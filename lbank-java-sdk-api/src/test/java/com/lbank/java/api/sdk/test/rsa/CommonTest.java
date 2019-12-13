package com.lbank.java.api.sdk.test.rsa;

import com.lbank.java.api.sdk.response.*;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Test;

/**
 * @program: lbank_api_v2
 * @description: 所有GET请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class CommonTest extends BaseTest {


    @Test
    public void testAccuracy() throws Exception {
        ResCurrencysVo accuracys = service.getAccuracy();
        logger.info(accuracys.toString());

    }

    @Test
    public void testCuccuracyPairs() throws Exception {
        ResCurrencyPairsVo accuracys = service.getCurrencyPairs();
        logger.info(accuracys.toString());
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
        ResUsdToCnyVo vo = service.getUsdToCny();
        logger.info(vo.toString());
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
        ResTickerVo vo = service.getTicker("all");
        logger.info(vo.toString());
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
        ResTradeVo trades = service.getTrades("eth_btc", 10, null);

        logger.info(trades.toString());
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
        ResTradeVo trades = service.getTrades("eth_btc", 10, null);
        logger.info(trades.toString());
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
        ResDepthVo vo = service.getDepth("gki_usdt", 60, "-1");
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
        ResDepthVo vo = service.getIncrDepth("eth_btc", 1);
        logger.info(vo.toString());
    }

    @Test
    public void testGetTimestamp() throws Exception {
        ResTimestampVo vo = service.getTimestamp();
        logger.info(vo.toString());
    }
}
