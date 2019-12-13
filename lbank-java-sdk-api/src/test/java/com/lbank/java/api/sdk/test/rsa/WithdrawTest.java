package com.lbank.java.api.sdk.test.rsa;

import com.lbank.java.api.sdk.response.ResCancelWithdrawVo;
import com.lbank.java.api.sdk.response.ResGetWithdrawsVo;
import com.lbank.java.api.sdk.response.ResWithdrawConfigVo;
import com.lbank.java.api.sdk.response.ResWithdrawVo;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Test;

/**
 * @program: lbank_api_v2
 * @description: 所有提币请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class WithdrawTest extends BaseTest {


    @Test
    public void testWithraw() throws Exception {
        ResWithdrawVo withdraw = service.getWithdraw("13434342323232323", "eth", "1", "1", "1", "0.01", "");
        logger.info(withdraw.toString());
    }

    @Test
    public void testTransfer() throws Exception {
        ResWithdrawVo withdraw = service.getWithdraw("67567@qq.com", "eth", "0.1", "steel", "steel", "0", "1");
        logger.info(withdraw.toString());
    }

    @Test
    public void testWithrawCancel() throws Exception {
        String withdrawId = "91645";
        ResCancelWithdrawVo vo = service.getWithdrawCancel(withdrawId);
        logger.info(vo.toString());
    }

    @Test
    public void testGetWithraws() throws Exception {
        ResGetWithdrawsVo withdraws = service.getWithdraws("eth", "1", "1", "10");
        logger.info(withdraws.toString());
    }

    @Test
    public void testGetWithrawConfigs() throws Exception {
        ResWithdrawConfigVo configs = service.getWithdrawConfigs("eth");
        logger.info(configs.toString());
    }

}
