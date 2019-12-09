package com.lbank.java.api.sdk.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbank.java.api.sdk.entity.TicketMessage;
import com.lbank.java.api.sdk.entity.Trades;
import com.lbank.java.api.sdk.entity.Withdraw;
import com.lbank.java.api.sdk.entity.WithdrawPage;
import com.lbank.java.api.sdk.response.*;
import com.lbank.java.api.sdk.service.impl.LBankJavaApiSdkServiceImpl;

import java.util.List;
import java.util.Map;

public class LbankJavaApiSdkTest {

	public static void main(String[] args) throws Exception {
		String apiKey = "";
		String SecretKey = "";

		LBankJavaApiSdkServiceImpl LBankJavaApiSdkServiceImpl = new LBankJavaApiSdkServiceImpl(apiKey,SecretKey);
		//获取用户账户资产信息测试
		ResUserInfoVo userInfo = LBankJavaApiSdkServiceImpl.getUserInfo();
		System.out.println(userInfo);
		//下单测试
		ResCreateOrderVo createOrder = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "buy", "0.011", "100","");
		System.out.println(createOrder);
		//下单测试
        ResCreateOrderVo createOrder2 = LBankJavaApiSdkServiceImpl.createOrder("eth_btc", "sell", "0.011", "100","");
		System.out.println(createOrder2);
		//撤销订单测试
		ResCancelOrderVo cancelOrder = LBankJavaApiSdkServiceImpl.cancelOrder("eth_btc", "bfeadf5e-0960-45d0-8760-cea3c1f5f617");
		System.out.println(cancelOrder);
		//查询订单测试
		ResOrderVo ordersInfo = LBankJavaApiSdkServiceImpl.getOrdersInfo("eth_btc", "0d7269f7-0a0a-47aa-a9a1-2b08c3e8f539");
		System.out.println(ordersInfo);
		//查询订单历史测试
        ResOrderHistoryVo ordersInfoHistory = LBankJavaApiSdkServiceImpl.getOrdersInfoHistory("eth_btc","1", "10","");
		System.out.println(ordersInfoHistory);
		//获取所有币对的基本信息测试
		ResCurrencysVo accuracy = LBankJavaApiSdkServiceImpl.getAccuracy();
		System.out.println(accuracy);
		//获取用户开放订单测试
        ResOrderHistoryVo ordersInfoNoDeal = LBankJavaApiSdkServiceImpl.getOrdersInfoNoDeal("eth_btc","1", "10");
		System.out.println(ordersInfoNoDeal);
		//获取LBank币币行情数据测试
		Object ticker = LBankJavaApiSdkServiceImpl.getTicker("eth_btc");
		ObjectMapper m = new ObjectMapper();
		TicketMessage convertValue = m.convertValue(ticker, TicketMessage.class);
		System.out.println(convertValue);
		//获取LBank行情数据测试
		ResTickerVo tickerList = LBankJavaApiSdkServiceImpl.getTicker("all");
		List<TicketMessage> ls = tickerList.getData();
		System.out.println(ls);
		//获取LBank可用交易对接口测试
		ResCurrencyPairsVo currencyPairs = LBankJavaApiSdkServiceImpl.getCurrencyPairs();
		System.out.println(currencyPairs);
		//获取LBank市场深度测试
		ResDepthVo depth = LBankJavaApiSdkServiceImpl.getDepth("eth_btc", 10, "1000");
		System.out.println(depth);

		ResTradeVo trades = LBankJavaApiSdkServiceImpl.getTrades("eth_btc", 1, null);
		System.out.println(trades);
		//获取K线数据测试
		ResKlineVo kline = LBankJavaApiSdkServiceImpl.getKline("eth_btc", 10, "day1", String.valueOf(System.currentTimeMillis()));

		System.out.println(kline);

		//美元对人民币的比例测试
		ResUsdToCnyVo usdToCny = LBankJavaApiSdkServiceImpl.getUsdToCny();
		System.out.println(usdToCny);
		//币种提币参数接口测试
		ResWithdrawConfigVo withdrawConfigs = LBankJavaApiSdkServiceImpl.getWithdrawConfigs("eth");
		System.out.println(withdrawConfigs);
		//提币接口测试
        ResWithdrawVo withdraw = LBankJavaApiSdkServiceImpl.getWithdraw("121", "eth", "1", "1", "1", "0,01","");
		System.out.println(withdraw);
		//撤销提币接口测试
		ResCancelWithdrawVo withdrawCancel = LBankJavaApiSdkServiceImpl.getWithdrawCancel("89961");
		System.out.println(withdrawCancel);
		//提币记录接口测试
		ResGetWithdrawsVo withdraws = LBankJavaApiSdkServiceImpl.getWithdraws("eth", "1", "1", "10");
		WithdrawPage withdrawPage = withdraws.getData();

		if(withdrawPage != null) {
			List<Withdraw> withdraws2 = withdrawPage.getWithdraws();
			if (withdraws2!=null){
				withdraws2.forEach(withdraw1 -> System.out.println(withdraw1.toString()));
			}

		}
	}
}
