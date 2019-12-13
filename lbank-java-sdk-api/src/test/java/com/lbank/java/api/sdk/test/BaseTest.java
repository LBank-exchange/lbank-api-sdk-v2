package com.lbank.java.api.sdk.test;

import com.lbank.java.api.sdk.constant.Contant;
import com.lbank.java.api.sdk.service.LBankServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: lbank_api_v2
 * @description: 单元测试
 * @author: steel.cheng
 * @create: 2019-09-04 10:51
 **/
public class BaseTest {

    protected final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    /**两种加密方式进行切换*/
    protected LBankServiceImpl service = new LBankServiceImpl(Contant.API_KEY, Contant.SECRET_KEY,Contant.SIGN_METHODS_SHA256);

    //protected LBankServiceImpl service = new LBankServiceImpl(Contant.API_KEY, Contant.SECRET_KEY,Contant.SIGN_METHODS_RSA);

}
