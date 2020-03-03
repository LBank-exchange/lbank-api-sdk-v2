package constant

const (
	//基础数据
	BASE_CURRENCY_PAIR    = "/v2/currencyPairs.do"
	BASE_ACCURACY 		  = "/v2/accuracy.do"
	BASE_USD_TO_CNY 	  = "/v2/usdToCny.do"
	BASE_WITHDRAW_CONFIG  = "/v2/withdrawConfigs.do"
	BASE_TIMESTAMP 		  = "/v2/timestamp.do"
	BASE_TICKER 		  = "/v2/ticker.do"
	BASE_DEPTH			  = "/v2/depth.do"
	BASE_INCR_DEPTH		  = "/v2/incrDepth.do"
	BASE_TRADES 		  = "/v2/trades.do"
	BASE_KLINE			  = "/v2/kline.do"

	//账户相关
 	ACCOUNT_GET_USER_INFO 		= "/v2/user_info.do"
	ACCOUNT_SUBSCRIBE	  		= "/v2/subscribe/get_key.do"
	ACCOUNT_REFRESH_SUBSCRIBE 	= "/v2/subscribe/refresh_key.do"
	ACCOUNT_CLOSE_SUBSCRIBE     = "/v2/subscribe/destroy_key.do"

	//订单相关
	ORDER_CREATE_ORDER 			 	 = "/v2/create_order.do"
	ORDER_CANCEL_ORDER  			 = "/v2/cancel_order.do"
	ORDER_CANCEL_ORDER_BY_CUSTOMERID = "/v2/cancel_clientOrders.do"
	ORDER_ORDER_INFO				 = "/v2/orders_info.do"
	ORDER_ORDERS_INFO_HISTORY 		 = "/v2/orders_info_history.do"
	ORDER_TRANSACTION_DETAIL		 = "/v2/order_transaction_detail.do"
	ORDER_TRANSACTION_HISTORY		 = "/v2/transaction_history.do"
	ORDER_ORDERS_INFO_NO_DEAL  		 = "/v2/orders_info_no_deal.do"
	//新增批量下单接口
	ORDER_BATCH_CREATE_ORDER 		 = "/v2/batch_create_order.do"
	
	//提币相关
	WITHDRAW		= "/v2/withdraw.do"
	WITHDRAW_CANCEL = "/v2/withdrawCancel.do"
	WITHDRAWS 		= "/v2/withdraws.do"
)
