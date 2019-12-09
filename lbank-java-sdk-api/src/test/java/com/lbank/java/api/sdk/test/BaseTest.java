package com.lbank.java.api.sdk.test;

import com.lbank.java.api.sdk.service.impl.LBankJavaApiSdkServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: lbank_api_v2
 * @description: 单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:51
 **/
public class BaseTest {

    final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    String apiKey = "";

    String SecretKey = "";

   LBankJavaApiSdkServiceImpl apiSdkService = new LBankJavaApiSdkServiceImpl(apiKey,SecretKey);

}
