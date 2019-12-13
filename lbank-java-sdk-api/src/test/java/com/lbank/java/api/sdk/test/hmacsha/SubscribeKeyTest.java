package com.lbank.java.api.sdk.test.hmacsha;

import com.lbank.java.api.sdk.response.ResSubscribeKeyVo;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Test;


/**
 * @program: lbank_api_v2
 * @description: 所有subscribe key请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class SubscribeKeyTest extends BaseTest{


    @Test
    public void testGetSubscribeKey() throws Exception{
        logger.info("**GetSubscribeKey**");
        ResSubscribeKeyVo resSubscribeKeyVo = service.getSubscribeKey();
        logger.info(resSubscribeKeyVo.toString());

        String key = resSubscribeKeyVo.getData();

        logger.info("**refreshKey**");
        resSubscribeKeyVo = service.refreshKey(key);
        logger.info(resSubscribeKeyVo.toString());

        logger.info("**destroyKey**");
        resSubscribeKeyVo = service.destroyKey(key);
        logger.info(resSubscribeKeyVo.toString());


    }

}
