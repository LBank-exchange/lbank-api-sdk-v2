# Python API Reference

---
[TOC]
用户需要下constant.ini中配置APIKEY，PriveKey（RSA模式），SECRTKEY（hmacSHA256模式）

## Order

- create order
```python
createOrders(symbol='',type='',price=,amount=,customer_id='')
```
- batch create order
```python
batchCreateOrders(orders = '')
```
- cancel order by orderID
```python
cancelOrders(symbol='',order_id='')
```
- cancel client by customerID
```python
cancelClientOrders(symbol='',customer_id='')
```
- order info
```python
orderMan.getOrderInfo(symbol='',order_id='')
```
- order info history
```python
getHistOrderInfo(symbol='',current_page=,page_length=,status=)
```
- transaction detail info
```python
getTransDetail(symbol='',order_id='')
```
- transaction history
```python
getHistTran(symbol='',direct='',size=)
```
- open order
```python
getOpenOrder(symbol='',current_page=,page_length=)
```


## Account
- user info
```python
getUserInfo()
```
- subscribe key
```python
genSubKey()
```
- enlarge the duration of the subscribe key
```python
refreshKey(subscribeKey='')
```

- close the subscribe key
```python
closeSubKey(subscribeKey = '')
```
- withdraw
```python
withdraw(symbol='',account='',assetCode='',amount=,memo='',mark='')
```

- cancel withdraw
```python
cancelWithdraw(withdrawId='')
```
- list withdraws
```python
withdrawList(status=)
```


## Basic data
- accuracy info
```python
getAccuracyInfo()
```
- currency pairs
```python
getcurrencyPairs()
```
- exchange ratio
```python
getRatio()
```
- withdraw configs
```python
getWithdrawConf(assetCode='')
```
- time stamp
```python
getTimestamp()
```

## Market

- ticker
```python
getTicker(symbol='')
```
- depth
```python
getDepth(symbol='', size=, merge=)
```
- incremental depth
```python
getIncrDepth(symbol='', merge=)
```

- trades
```python
getTrades(symbol='',size=)
```
- kline
```python
getKline(symbol='', size=, type='', time='')
```

关于API的调用方式demo见example.py。