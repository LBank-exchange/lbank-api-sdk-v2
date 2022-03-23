package com.lbank.java.api.sdk.service;

import com.lbank.java.api.sdk.response.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;


/**
 * @author steel.cheng
 */
public interface LBankJavaApiService {
    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/user_info.do")
    Call<ResUserInfoVo> getUserInfo();

    /**
     * 下单
     *
     * @param symbol   交易对
     * @param type     委托买卖类型buy/sell
     * @param price    下单价格
     * @param amount   交易数量
     * @param customId 自定义ID
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/create_order.do")
    Call<ResCreateOrderVo> createOrder(@Query("symbol") String symbol, @Query("type") String type, @Query("price") String price, @Query("amount") String amount, @Query("custom_id") String customId);

    /**
     * 批量下单
     *
     * @param orders   [{"symbol":"eth_btc","amount":"1","price":"0.6","custom_id":"","type":"sell"},{"symbol":"eth_btc","amount":"1","price":"0.7","custom_id":"","type":"sell"}]
     * @param symbol   交易对
     * @param type     委托买卖类型buy/sell
     * @param price    下单价格
     * @param amount   交易数量
     * @param customId 自定义ID
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/batch_create_order.do")
    Call<ResBatchCreateOrderVo> batchCreateOrder(@Query("orders") String orders);

    /**
     * 撤销订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/cancel_order.do")
    Call<ResCancelOrderVo> cancelOrder(@Query("symbol") String symbol, @Query("order_id") String order_id);

    /**
     * 根据自定义ID撤销订单
     *
     * @param symbol      交易对
     * @param customer_id 订单id
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/cancel_clientOrders.do")
    Call<ResCancelOrderVo> cancelOrderByCustomerId(@Query("symbol") String symbol, @Query("customer_id") String customer_id);


    /**
     * 查询订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/orders_info.do")
    Call<ResOrderVo> getOrdersInfo(@Query("symbol") String symbol, @Query("order_id") String order_id);

    /**
     * 查询订单历史
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/orders_info_history.do")
    Call<ResOrderHistoryVo> getOrdersInfoHistory(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length, @Query("status") String status);

    /**
     * 获取所有币对的基本信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/accuracy.do")
    Call<ResCurrencysVo> getAccuracy();


    /**
     * 获取用户开放订单
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/orders_info_no_deal.do")
    Call<ResOrderHistoryVo> getOrdersInfoNoDeal(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length);

    /**
     * 获取订单历史成交明细信息
     *
     * @param symbol 交易对eth_btc:以太坊； zec_btc:零币
     * @param type   订单类型 sell, buy
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/transaction_history.do")
    Call<ResOrderDetailVo> getOrderHistoryDetail(@Query("symbol") String symbol, @Query("type") String type, @Query("start_date") String start_date,
                                                 @Query("end_date") String end_date, @Query("from") String from, @Query("direct") String direct, @Query("size") String size);

    /**
     * 获取订单成交明细信息
     *
     * @param symbol   交易对eth_btc:以太坊； zec_btc:零币
     * @param order_id 订单
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/order_transaction_detail.do")
    Call<ResOrderDetailVo> getOrderDetail(@Query("symbol") String symbol, @Query("order_id") String order_id);

    /**
     * 获取LBank币币行情数据
     *
     * @param symbol 币对
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/ticker.do")
    Call<ResTickerVo> getTicker(@Query("symbol") String symbol);

    /**
     * 获取LBank可用交易对接口
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/currencyPairs.do")
    Call<ResCurrencyPairsVo> getCurrencyPairs();

    /**
     * 获取LBank市场深度
     *
     * @param symbol 币对
     * @param size   返回的条数(1-60)
     * @param type   深度:
     *               precision 0=>1
     *               precision 10=>0.1
     *               precision 100=>0.01
     *               precision 1000=>0.001
     *               precision 10000=>0.0001
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/depth.do")
    Call<ResDepthVo> getDepth(@Query("symbol") String symbol, @Query("size") Integer size, @Query("type") String type);

    /**
     * 获取LBank市场深度增量
     *
     * @param symbol 币对
     * @param merge  深度: 0,1
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/incrDepth.do")
    Call<ResDepthVo> getIncrDepth(@Query("symbol") String symbol, @Query("merge") Integer merge);


    /**
     * 获取LBank历史交易信息
     *
     * @param symbol 币对
     * @param size   返回的条数(1-600)
     * @param time   返回时间戳之后 size 条数据，为空则返回最新 size 条数据
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/trades.do")
    Call<ResTradeVo> getTrades(@Query("symbol") String symbol, @Query("size") Integer size, @Query("time") String time);

    /**
     * 获取K线数据
     *
     * @param symbol 币对
     * @param size   返回的条数(1-2880)
     * @param type   minute1：1分钟
     *               minute5：5分钟
     *               minute15：15分钟
     *               minute30：30分钟
     *               hour1：1小时
     *               hour2：2小时
     *               hour4：4小时
     *               hour6：6小时
     *               hour8：8小时
     *               hour12：12小时
     *               day1：1日
     *               week1：1周
     * @param time   时间戳 (为空则返回当前最新 size 条数据,填写则返回时间戳之后的 size 条数据)
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/kline.do")
    Call<ResKlineVo> getKline(@Query("symbol") String symbol, @Query("size") Integer size, @Query("type") String type, @Query("time") String time);


    /**
     * 美元对人民币的比例
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/usdToCny.do")
    Call<ResUsdToCnyVo> getUsdToCny();

    /**
     * 获取时间戳
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/timestamp.do")
    Call<ResTimestampVo> getTimestamp();

    /**
     * 币种提币参数接口
     *
     * @param assetCode
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/withdrawConfigs.do")
    Call<ResWithdrawConfigVo> getWithdrawConfigs(@Query("assetCode") String assetCode);

    /**
     * 提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param account   提币地址
     * @param assetCode 提币币种
     * @param amount    提币数量（对于neo，必须是整数）
     * @param memo      对于bts、dct可能需要
     * @param mark      用户备注(长度小于255)
     * @param fee       提币手续费（单位：数量）
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/withdraw.do")
    Call<ResWithdrawVo> getWithdraw(@Query("account") String account, @Query("assetCode") String assetCode, @Query("amount") String amount,
                                    @Query("memo") String memo, @Query("mark") String mark, @Query("fee") String fee, @Query("type") String type);

    /**
     * 提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param address 提币地址
     * @param coin    提币币种
     * @param amount  提币数量（对于neo，必须是整数）
     * @param memo    对于bts、dct可能需要
     * @param mark    用户备注(长度小于255)
     * @param fee     提币手续费（单位：数量）
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/withdraw.do")
    Call<ResWithdrawVo> withdraw(@Query("address") String address, @Query("coin") String coin, @Query("amount") String amount,
                                 @Query("memo") String memo, @Query("mark") String mark, @Query("fee") String fee, @Query("type") String type);

    /**
     * 撤销提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param withdrawId 提币记录编号
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/withdrawCancel.do")
    Call<ResCancelWithdrawVo> getWithdrawCancel(@Query("withdrawId") String withdrawId);

    /**
     * 提币记录接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param assetCode 币种编号
     * @param status    提币状态（0：全部，1：申请中，2：已撤销，3：提现失败，4：提现完成）
     * @param pageNo    当前分页页码（默认：1）
     * @param pageSize  每页大小（默认：20，最大100条）
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/withdraws.do")
    Call<ResGetWithdrawsVo> getWithdraws(@Query("assetCode") String assetCode, @Query("status") String status, @Query("pageNo") String pageNo, @Query("pageSize") String pageSize);

    /**
     * 生成subscribeKey
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/subscribe/get_key.do")
    Call<ResSubscribeKeyVo> getSubscribeKey();


    /**
     * 延长subscribeKey有效期
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/subscribe/refresh_key.do")
    Call<ResSubscribeKeyVo> refreshKey(@Query("subscribeKey") String subscribeKey);


    /**
     * 关闭subscribeKey
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/subscribe/destroy_key.do")
    Call<ResSubscribeKeyVo> destroyKey(@Query("subscribeKey") String subscribeKey);

    /**
     * 获取系统状态
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/system_status.do")
    Call<ResSystemStatusVo> getSystemStatus();

    /**
     * 获取所有币信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/user_info.do")
    Call<ResUserAssetInfoVo> getUserAssetInfo();

    /**
     * 获取充值历史
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/deposit_history.do")
    Call<ResDepositHistoryVo> depositHistory(@Query("coin") String coin, @Query("status") String status, @Query("startTime") String startTime, @Query("endTime") String endTime);

    /**
     * 获取提现历史
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/withdraws.do")
    Call<ResWithdrawsHistoryVo> withdraws(@Query("coin") String coin, @Query("status") String status, @Query("withdrawOrderId") String withdrawOrderId, @Query("startTime") String startTime, @Query("endTime") String endTime);

    /**
     * 获取充值地址
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/get_deposit_address.do")
    Call<ResDepositAddressVo> getDepositAddress(@Query("coin") String coin, @Query("networkName") String networkName);

    /**
     * 上架资产详情
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/asset_detail.do")
    Call<ResAssetDetailVo> assetDetail(@Query("coin") String coin);

    /**
     * 交易手续费率查询
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/customer_trade_fee.do")
    Call<ResCustomerTradeFeeVo> customerTradeFee(@Query("category") String category);

    /**
     * 查询用户API Key权限
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/api_Restrictions.do")
    Call<ResApiRestrictionsVo> apiRestrictions();

    /**
     * 测试服务器连通性
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/system_ping.do")
    Call<ResSystemStatusVo> systemPing();

    /**
     * 获取深度信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/supplement/incrDepth.do")
    Call<ResIncrDepthVo> incrDepth(@Query("symbol") String symbol, @Query("limit") int limit);

    /**
     * 近期成交列表
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/supplement/trades.do")
    Call<ResTradesVo> trades(@Query("symbol") String symbol, @Query("size") int size, @Query("time") String time);

    /**
     * 获取交易对最新价格
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/supplement/ticker/price.do")
    Call<ResLatestPriceVo> latestPrice(@Query("symbol") String symbol);

    /**
     * 当前最优挂单
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @GET("/v2/supplement/ticker/bookTicker.do")
    Call<ResBookTickerVo> bookTicker(@Query("symbol") String symbol);

    /**
     * 测试下单
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/create_order_test.do")
    Call<ResCancelOrderVo> createOrderTest(@Query("symbol") String symbol, @Query("type") String type, @Query("price") String price, @Query("amount") String amount, @Query("custom_id") String custom_id);

    /**
     * 下单新
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/create_order.do")
    Call<ResCancelOrderVo> createOrderNew(@Query("symbol") String symbol, @Query("type") String type, @Query("price") String price, @Query("amount") String amount, @Query("custom_id") String custom_id);

    /**
     * 撤销订单(新)
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/cancel_order.do")
    Call<ResCancelOrderNewVo> cancelOrderNew(@Query("symbol") String symbol, @Query("orderId") String orderId, @Query("origClientOrderId") String origClientOrderId);

    /**
     * 撤销单一交易对的所有挂单
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/cancel_order_by_symbol.do")
    Call<ResCancelOrderBySymbolVo> cancelOrderBySymbol(@Query("symbol") String symbol);

    /**
     * 查询订单(新)
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/orders_info.do")
    Call<ResOrderInfoVo> orderInfo(@Query("symbol") String symbol, @Query("orderId") String orderId, @Query("origClientOrderId") String origClientOrderId);

    /**
     * 当前挂单
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/orders_info_no_deal.do")
    Call<ResOrderInfoNoDealVo> ordersInfoNoDeal(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length);

    /**
     * 查询所有订单
     * 查询所有订单(备注：默认查询24小时内的订单，状态不传默认查询已撤销和完全成交的订单)
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/orders_info_history.do")
    Call<ResOrderInfoNoDealVo> ordersInfoHistory(@Query("symbol") String symbol, @Query("current_page") String current_page, @Query("page_length") String page_length, @Query("status") String status);

    /**
     * 账户信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/user_info_account.do")
    Call<ResUserInfoAccountVo> userInfoAccount();

    /**
     * 历史成交明细
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/supplement/transaction_history.do")
    Call<ResTransactionHistoryVo> transactionHistory(@Query("symbol") String symbol, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("fromId") String fromId, @Query("limit") String limit);
}
