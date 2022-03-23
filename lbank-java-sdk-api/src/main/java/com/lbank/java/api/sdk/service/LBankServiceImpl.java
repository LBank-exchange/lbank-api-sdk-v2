package com.lbank.java.api.sdk.service;

import com.lbank.java.api.sdk.client.LBankJavaApiSdkServiceGenerator;
import com.lbank.java.api.sdk.constant.Contant;
import com.lbank.java.api.sdk.response.*;
import org.apache.commons.lang3.StringUtils;
import retrofit2.http.Query;

import java.util.List;

/**
 * @author steel.cheng
 */
public class LBankServiceImpl {

    private LBankJavaApiService lBankJavaApiService;

    public LBankServiceImpl(String apiKey, String secret, String signMethod) {
        lBankJavaApiService = LBankJavaApiSdkServiceGenerator.createService(LBankJavaApiService.class, apiKey, secret, signMethod);
    }

    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    public ResUserInfoVo getUserInfo() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUserInfo());
    }

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
    public ResCreateOrderVo createOrder(String symbol, String type, String price, String amount, String customId) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(type)) {
            throw new Exception("type参数为空");
        }
        if (StringUtils.isEmpty(price)) {
            throw new Exception("price参数为空");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.createOrder(symbol, type, price, amount, customId));
    }


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
    public ResBatchCreateOrderVo batchCreateOrder(String orders) throws Exception {
        if (StringUtils.isEmpty(orders)) {
            throw new Exception("orders参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.batchCreateOrder(orders));
    }


    /**
     * 撤销订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    public ResCancelOrderVo cancelOrder(String symbol, String order_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(order_id)) {
            throw new Exception("order_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.cancelOrder(symbol, order_id));
    }

    /**
     * 撤销订单
     *
     * @param symbol      交易对
     * @param customer_id 订单id
     * @return
     */
    public ResCancelOrderVo cancelOrderByCustomer(String symbol, String customer_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(customer_id)) {
            throw new Exception("customer_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.cancelOrderByCustomerId(symbol, customer_id));
    }

    /**
     * 查询订单
     *
     * @param symbol   交易对
     * @param order_id 订单id
     * @return
     */
    public ResOrderVo getOrdersInfo(String symbol, String order_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(order_id)) {
            throw new Exception("order_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfo(symbol, order_id));
    }

    /**
     * 查询订单历史
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    public ResOrderHistoryVo getOrdersInfoHistory(String symbol, String current_page, String page_length, String status) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(current_page)) {
            throw new Exception("current_page参数为空");
        }
        if (StringUtils.isEmpty(page_length)) {
            throw new Exception("page_length参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfoHistory(symbol, current_page, page_length, status));
    }

    /**
     * 查询订单成交明细
     *
     * @param symbol   交易对eth_btc:以太坊； zec_btc:零币
     * @param order_id 订单ID
     * @return
     */
    public ResOrderDetailVo getOrdersDetail(String symbol, String order_id) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(order_id)) {
            throw new Exception("order_id参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrderDetail(symbol, order_id));
    }

    /**
     * 查询订单历史成交明细
     *
     * @param symbol 交易对eth_btc:以太坊； zec_btc:零币
     * @param type   订单ID
     * @return
     */
    public ResOrderDetailVo getOrdersHistoryDetail(String symbol, String type, String start_date, String end_date, String from, String direct, String size) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrderHistoryDetail(symbol, type, start_date, end_date, from, direct, size));
    }

    /**
     * 获取所有币对的基本信息
     *
     * @return
     */
    public ResCurrencysVo getAccuracy() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getAccuracy());
    }


    /**
     * 获取用户开放订单
     *
     * @param symbol       交易对eth_btc:以太坊； zec_btc:零币
     * @param current_page 当前页码
     * @param page_length  每页数据条数(不得小于1,不得大于200)
     * @return
     */
    public ResOrderHistoryVo getOrdersInfoNoDeal(String symbol, String current_page, String page_length) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(current_page)) {
            throw new Exception("current_page参数为空");
        }
        if (StringUtils.isEmpty(page_length)) {
            throw new Exception("page_length参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getOrdersInfoNoDeal(symbol, current_page, page_length));
    }

    /**
     * 获取LBank行情数据
     *
     * @param symbol 币对
     * @return
     */
    public ResTickerVo getTicker(String symbol) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getTicker(symbol));
    }

    /**
     * 获取LBank可用交易对接口
     *
     * @return
     */
    public ResCurrencyPairsVo getCurrencyPairs() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getCurrencyPairs());
    }

    /**
     * 获取LBank市场深度
     *
     * @param symbol 币对
     * @param size   返回的条数(1-60)
     * @param type   深度的精度类型
     * @return
     */
    public ResDepthVo getDepth(String symbol, Integer size, String type) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getDepth(symbol, size, type));
    }

    /**
     * 获取LBank市场深度增量
     *
     * @param symbol 币对
     * @param merge  深度: 0,1
     * @return
     */
    public ResDepthVo getIncrDepth(String symbol, Integer merge) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getIncrDepth(symbol, merge));
    }

    /**
     * 获取LBank历史交易信息
     *
     * @param symbol 币对
     * @param size   返回的条数(1-600)
     * @param time   返回时间戳之后 size 条数据，为空则返回最新 size 条数据
     * @return
     */
    public ResTradeVo getTrades(String symbol, Integer size, String time) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getTrades(symbol, size, time));
    }

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
    public ResKlineVo getKline(String symbol, Integer size, String type, String time) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (size == null) {
            throw new Exception("size参数为空");
        }
        if (StringUtils.isEmpty(type)) {
            throw new Exception("type参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getKline(symbol, size, type, time));
    }


    /**
     * 美元对人民币的比例
     *
     * @return
     * @throws Exception
     */
    public ResUsdToCnyVo getUsdToCny() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUsdToCny());
    }

    /**
     * 币种提币参数接口
     *
     * @param assetCode
     * @return
     * @throws Exception
     */
    public ResWithdrawConfigVo getWithdrawConfigs(String assetCode) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdrawConfigs(assetCode));
    }

    /**
     * 提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param account   提币地址
     * @param assetCode 提币币种
     * @param amount    提币数量（对于neo，必须是整数）
     * @param memo      对于bts、dct可能需要
     * @param mark      用户备注(长度小于255)
     * @param fee       提币手续费（单位：数量）
     * @param type      提现类型，1：内部转账，2：正常提现
     * @return
     * @throws Exception
     */
    public ResWithdrawVo getWithdraw(@Query("account") String account, @Query("assetCode") String assetCode, @Query("amount") String amount,
                                     @Query("memo") String memo, @Query("mark") String mark, @Query("fee") String fee, @Query("type") String type) throws Exception {
        if (StringUtils.isEmpty(account)) {
            throw new Exception("account参数为空");
        }
        if (StringUtils.isEmpty(assetCode)) {
            throw new Exception("assetCode参数为空");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdraw(account, assetCode, amount, memo, mark, fee, type));
    }

    /**
     * 提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param address 提币地址
     * @param coin    提币币种
     * @param amount  提币数量（对于neo，必须是整数）
     * @param memo    对于bts、dct可能需要
     * @param mark    用户备注(长度小于255)
     * @param fee     提币手续费（单位：数量）
     * @param type    提现类型，1：内部转账，2：正常提现
     * @return
     * @throws Exception
     */
    public ResWithdrawVo withdraw(@Query("address") String address, @Query("coin") String coin, @Query("amount") String amount,
                                  @Query("memo") String memo, @Query("mark") String mark, @Query("fee") String fee, @Query("type") String type) throws Exception {
        if (StringUtils.isEmpty(address)) {
            throw new Exception("address参数为空");
        }
        if (StringUtils.isEmpty(coin)) {
            throw new Exception("coin参数为空");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.withdraw(address, coin, amount, memo, mark, fee, type));
    }

    /**
     * 撤销提币接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param withdrawId 提币记录编号
     * @return
     * @throws Exception
     */
    public ResCancelWithdrawVo getWithdrawCancel(String withdrawId) throws Exception {
        if (StringUtils.isEmpty(withdrawId)) {
            throw new Exception("withdrawId参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdrawCancel(withdrawId));
    }

    /**
     * 提币记录接口 (需要绑定IP,可以在lbank网页端api提现页面申请)
     *
     * @param assetCode 币种编号
     * @param status    提币状态（0：全部，1：申请中，2：已撤销，3：提现失败，4：提现完成）
     * @param pageNo    当前分页页码（默认：1）
     * @param pageSize  每页大小（默认：20，最大100条）
     * @return
     * @throws Exception
     */
    public ResGetWithdrawsVo getWithdraws(String assetCode, String status, String pageNo, String pageSize) throws Exception {
        if (StringUtils.isEmpty(status)) {
            throw new Exception("status参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getWithdraws(assetCode, status, pageNo, pageSize));
    }

    /**
     * 生成subscribeKey
     *
     * @return
     * @throws Exception
     */
    public ResSubscribeKeyVo getSubscribeKey() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getSubscribeKey());
    }

    /**
     * 延长subscribeKey有效期
     *
     * @return
     * @throws Exception
     */
    public ResSubscribeKeyVo refreshKey(String subscribeKey) throws Exception {
        if (StringUtils.isEmpty(subscribeKey)) {
            throw new Exception("subscribeKey参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.refreshKey(subscribeKey));
    }


    /**
     * 销毁subscribeKey
     *
     * @return
     * @throws Exception
     */
    public ResSubscribeKeyVo destroyKey(String subscribeKey) throws Exception {
        if (StringUtils.isEmpty(subscribeKey)) {
            throw new Exception("subscribeKey参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.destroyKey(subscribeKey));
    }

    /**
     * 获取时间戳
     *
     * @return
     * @throws Exception
     */
    public ResTimestampVo getTimestamp() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getTimestamp());
    }

    /**
     * 获取系统状态
     *
     * @return
     * @throws Exception
     */
    public ResSystemStatusVo getSystemStatus() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getSystemStatus());
    }

    /**
     * 获取所有币信息
     *
     * @return
     * @throws Exception
     */
    public ResUserAssetInfoVo getUserAssetInfo() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUserAssetInfo());
    }

    public ResDepositHistoryVo depositHistory(String coin, String status, String startTime, String endTime) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.depositHistory(coin, status, startTime, endTime));
    }

    public ResWithdrawsHistoryVo withdraws(String coin, String status, String withdrawOrderId, String startTime, String endTime) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.withdraws(coin, status, withdrawOrderId, startTime, endTime));
    }

    public ResDepositAddressVo getDepositAddress(String coin, String networkName) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getDepositAddress(coin, networkName));
    }

    public ResAssetDetailVo assetDetail(String coin) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.assetDetail(coin));
    }

    public ResCustomerTradeFeeVo customerTradeFee(String category) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.customerTradeFee(category));
    }

    public ResApiRestrictionsVo apiRestrictions() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.apiRestrictions());
    }

    public ResSystemStatusVo systemPing() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.systemPing());
    }

    public ResIncrDepthVo incrDepth(String symbol, int limit) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.incrDepth(symbol, limit));
    }

    public ResTradesVo trades(String symbol, int size, String time) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.trades(symbol, size, time));
    }

    public ResLatestPriceVo latestPrice(String symbol) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.latestPrice(symbol));
    }

    public ResBookTickerVo bookTicker(String symbol) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.bookTicker(symbol));
    }

    public ResCancelOrderVo createOrderTest(String symbol, String type, String price, String amount, String custom_id) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.createOrderTest(symbol, type, price, amount, custom_id));
    }

    public ResCancelOrderVo createOrderNew(String symbol, String type, String price, String amount, String custom_id) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.createOrderNew(symbol, type, price, amount, custom_id));
    }

    public ResCancelOrderNewVo cancelOrderNew(String symbol, String orderId, String origClientOrderId) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.cancelOrderNew(symbol, orderId, origClientOrderId));

    }

    public ResCancelOrderBySymbolVo cancelOrderBySymbol(String symbol) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.cancelOrderBySymbol(symbol));
    }

    public ResOrderInfoVo orderInfo(String symbol, String orderId, String origClientOrderId) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.orderInfo(symbol, orderId, origClientOrderId));
    }

    public ResOrderInfoNoDealVo ordersInfoNoDeal(String symbol, String current_page, String page_length) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.ordersInfoNoDeal(symbol, current_page, page_length));
    }

    public ResOrderInfoNoDealVo ordersInfoHistory(String symbol, String current_page, String page_length, String status) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.ordersInfoHistory(symbol, current_page, page_length, status));
    }

    public ResUserInfoAccountVo userInfoAccount() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.userInfoAccount());
    }

    public ResTransactionHistoryVo transactionHistory(String symbol, String startTime, String endTime, String fromId, String limit) throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.transactionHistory(symbol,startTime,endTime,fromId,limit));
    }
}
