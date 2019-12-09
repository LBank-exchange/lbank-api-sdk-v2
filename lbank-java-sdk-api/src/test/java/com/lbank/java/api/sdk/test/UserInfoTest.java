package com.lbank.java.api.sdk.test;

import com.lbank.java.api.sdk.response.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

/**
 * @program: lbank_api_v2
 * @description: 用户请求的单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:56
 **/
public class UserInfoTest extends BaseTest{


    @Test
    public void testUserInfo() throws Exception{
        for (int i = 0; i < 1000; i++) {
            ResUserInfoVo accuracys = apiSdkService.getUserInfo();
            logger.info(i+"/"+accuracys.toString());
        }

//        Assert.assertTrue(accuracys.getResult());
//
//        Map<String,Map<String,String>> data = accuracys.getData();
//        if(data!=null && !data.isEmpty()){
//            for (Map.Entry<String, Map<String,String>> dataEntry : data.entrySet()) {
//                String key = dataEntry.getKey();
//                Map<String,String> detailsData = dataEntry.getValue();
//                logger.info("key:"+key);
//                if(!detailsData.isEmpty()){
//                    for (Map.Entry<String, String> detailEntry : detailsData.entrySet()) {
//                        logger.info(detailEntry.getKey()+"/"+detailEntry.getValue());
//                    }
//                }
//
//            }
//        }
    }

    @Test
    public void testUserInfoLimit() throws Exception{
        for (int i = 0; i < 300; i++) {
            ResUserInfoVo accuracys = apiSdkService.getUserInfo();
            logger.info(accuracys.getResult()+"/"+accuracys.getError_code());
            if(i==200) {
                Assert.assertFalse(accuracys.getResult());
            }
        }
    }


}
