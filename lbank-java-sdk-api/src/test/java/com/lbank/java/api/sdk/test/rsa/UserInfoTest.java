package com.lbank.java.api.sdk.test.rsa;

import com.lbank.java.api.sdk.response.ResUserInfoVo;
import com.lbank.java.api.sdk.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @program: lbank_api_v2
 * @description: 用户请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class UserInfoTest extends BaseTest{


    @Test
    public void testUserInfo() throws Exception{
            ResUserInfoVo accuracys = service.getUserInfo();
            logger.info(accuracys.toString());

    }

    @Test
    public void testUserInfoLimit() throws Exception{
        ResUserInfoVo accuracys = service.getUserInfo();
        logger.info(accuracys.getResult()+"/"+accuracys.getError_code());

    }


}
