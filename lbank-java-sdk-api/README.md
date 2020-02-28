# Java API Reference

---
[TOC]
用户需要在Constant.java中配置API_KEY（RSA模式），或者SECRET_KEY（hmacSHA256模式）

## Order

- create order
```java
createOrder(symbol='',type='',price=,amount=,customer_id='')
```
- cancel order by orderID
```java
cancelOrder(symbol='',order_id='')
```
- cancel client by customerID
```java
cancelOrderByCustomer(symbol='',customer_id='')
```
- order info
```java
orderMan.getOrdersInfo(symbol='',order_id='')
```
- order info history
```java
getOrdersInfoHistory(symbol='',current_page=,page_length=,status=)
```
- transaction detail info
```java
getOrdersDetail(symbol='',order_id='')
```
- transaction history
```java
getOrdersHistoryDetail(symbol='',direct='',size=)
```
- open order
```java
getOrdersInfoNoDeal(symbol='',current_page=,page_length=)
```


## Account
- user info
```java
getUserInfo()
```
- subscribe key
```java
getSubscribeKey()
```
- enlarge the duration of the subscribe key
```java
refreshKey(subscribeKey='')
```

- close the subscribe key
```java
destroyKey(subscribeKey = '')
```
- withdraw
```java
getWithdraw(symbol='',account='',assetCode='',amount=,memo='',mark='')
```

- cancel withdraw
```java
getWithdrawCancel(withdrawId='')
```
- list withdraws
```java
getWithdraws(assetCode='',status='',pageNo='',pageSize='')
```


## Basic data
- accuracy info
```java
getAccuracy()
```
- currency pairs
```java
getCurrencyPairs()
```
- exchange ratio
```java
getUsdToCny()
```
- withdraw configs
```java
getWithdrawConfigs(assetCode='')
```
- time stamp
```java
getTimestamp()
```

## Market

- ticker
```java
getTicker(symbol='')
```
- depth
```java
getDepth(symbol='', size=, merge=)
```
- incremental depth
```java
getIncrDepth(symbol='', merge=)
```

- trades
```java
getTrades(symbol='',size=)
```
- kline
```java
getKline(symbol='', size=, type='', time='')
```

关于API的调用方式demo见包com.lbank.java.api.sdk.test.hmacsha