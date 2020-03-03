LBank open api v2 go sdk usage :
-----

[TOC]

### Usage

-----
Set the environment variable `GO111MODULE=on` or `GO111MODULE=auto` before using `go mod`

```go
mv lbank-go-sdk-api $GOPATH/src/github.com
cd $GOPATH/src/github.com/lbank-go-sdk-api
go mod download
```

用户需要在`constant/user_config_constant.go`中添加必要参数，具体如下：
```go
LBANK_REST_API_ENDPOINT         REST API地址
LBANK_WS_ENDPOINT               WSS 地址
LBANK_REST_API_KEY              API_KEY
LBANK_REST_API_SECRETKEY        密钥
LBANK_IS_PRINT_REQUEST          是否打印请求

//签名方法，默认采用RSA签名算法
LBANK_SIGN_METH 		   = LBANK_RSA_SIGN_METHOD 
//SHA256签名
//LBANK_SIGN_METH		   = LBANK_SHA256_SIGN_METHOD
```

## Order

- create order
```golang
CreateOrder(symbol, typ, price, amount, custom_id string)
```
- cancel order by orderID
```golang
CancelOrder(symbol, order_id string)
```
- cancel client by customerID
```golang
CancelOrderByCustomerId(symbol, customer_id string )
```
- order info
```golang
OrdersInfo(symbol, order_id string)
```
- order info history
```golang
OrdersInfoHistory(symbol, current_page, page_length, status string)
```
- transaction detail info
```golang
OrderTransactionDetail(symbol, order_id string)
```
- transaction history
```golang
TransactionHistory(symbol, typ, start_date, end_date, from, direct, size string)
```
- open order
```golang
OrdersInfoNoDeal(symbol, current_page, page_length string)
```
- create batch order
```golang
CreateBatchOrder(orders string)
```


## Account
- user info
```golang
GetUserInfo()
```
- subscribe key
```golang
GetSubscribeKey()
```
- enlarge the duration of the subscribe key
```golang
RefreshSubscribeKey(subscribeKey string)
```

- close the subscribe key
```golang
CloseSubscribeKey(subscribeKey string)
```
- withdraw
```golang
WithDraw(symbol, account, assetCode, amount, fee, memo, mark, typ string)
```

- cancel withdraw
```golang
WithdrawCancel(withdrawId string)
```
- list withdraws
```golang
WithDraws(assetCode, status, pageNo, pageSize string)
```


## Basic data
- accuracy info
```golang
GetAccuracy()
```
- currency pairs
```golang
GetCurrencyPairs()
```
- exchange ratio
```golang
GetUsdToCny()
```
- withdraw configs
```golang
GetWithDrawConfigs(assetCode string)
```
- time stamp
```golang
GetTimeStamp()
```

## Market

- ticker
```golang
GetTicker(symbol string)
```
- depth
```golang
GetDepth(symbol, size, merge string)
```
- incremental depth
```golang
GetIncrDepth(symbol, merge string)
```

- trades
```golang
GetTrades(symbol, size, time string)
```
- kline
```golang
GetKline(symbol, size, typ, time string)
```

关于API的调用方式demo见demo/main.go。
