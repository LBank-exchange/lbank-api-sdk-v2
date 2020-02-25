# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 14:28
# project name: project
# file name : run
import json
import LBank.OrdersMan as ord
import LBank.AccountMan as ac
import LBank.BasicDataMan as bd
import LBank.MarketMan as ma
from LBank.WebsocketMan import WebSocket

if __name__=="__main__":

    ###############################
    ########### Order #############
    ###############################
    orderMan= ord.Orders()
    ###create order#####
    #orderMan.createOrders(symbol='lbk_usdt',type='buy',price=0.0222,amount=10,customer_id='')

    ###batch create orders#####
    # list = []
    #
    # list.append({"symbol":'lbk_usdt', "type":'buy', "price":0.0222, "amount":10, "custom_id":''})
    # list.append({"symbol":'lbk_usdt', "type":'buy', "price":0.0222, "amount":20, "custom_id":''})
    #
    # res = json.dumps(list)
    # orderMan.batchCreateOrders(orders = res)

    ###cancel order#####
    #orderMan.cancelOrders(symbol='lbk_usdt',order_id='')

    ####cancel client orders####
    #orderMan.cancelClientOrders(symbol='lbk_usdt',customer_id='')

    ####get order info######
    #orderMan.getOrderInfo(symbol='lbk_usdt',order_id='')

    ####get history order info######
    #orderMan.getHistOrderInfo(symbol='lbk_usdt',current_page=1,page_length=10,status=0)

    ####get detail info of transaction######
    #orderMan.getTransDetail(symbol='lbk_usdt',order_id='')

    #####get history transaction#####
    #orderMan.getHistTran(symbol='lbk_usdt',direct='prev',size=50)

    #####get open order ########
    #orderMan.getOpenOrder(symbol='lbk_usdt',current_page=1,page_length=15)

    ###############################
    ########### Account ###########
    ###############################
    accountMan=ac.AccountMan()

    ####get user info ########
    #accountMan.getUserInfo()

    #####get subscribe keys ######
    #accountMan.genSubKey()

    ####enlarge the duration of the subscribe key#####
    #accountMan.refreshKey(subscribeKey='')

    ######close the subscribe key#######
    #accountMan.closeSubKey(subscribeKey = '')

    ####withdraw######
    #accountMan.withdraw(symbol='eth_btc',account='',assetCode='',amount=,memo='',mark='')

    ###cancel withdraw#########
    #accountMan.cancelWithdraw(withdrawId='')

    ####list withdraws######
    #accountMan.withdrawList(status=0)

    ###############################
    ###########basic data ###########
    ###############################

    basicdataMan=bd.BaseConfigMan()

    ####get accuracy info######
    #basicdataMan.getAccuracyInfo()

    ####get currency pairs#####
    #basicdataMan.getcurrencyPairs()

    ####get exchange ratio#####
    #basicdataMan.getRatio()

    ####get withdraw configs####
    #basicdataMan.getWithdrawConf(assetCode='btc')

    ####get time stamp#####
    #basicdataMan.getTimestamp()

    ###############################
    ###########  Market ###########
    ###############################

    marketMan = ma.MarketMan()

    ####get ticker#####
    #marketMan.getTicker(symbol='eth_usdt')

    ####get depth####
    #marketMan.getDepth(symbol='eth_usdt', size=10, merge=0)

    ####get incremental depth######
    #marketMan.getIncrDepth(symbol='eth_usdt', merge=0)

    ####get trades######
    #marketMan.getTrades(symbol='eth_usdt',size=10)

    ####get kline######
    #marketMan.getKline(symbol='eth_usdt', size=20, type='day1', time='1576135557318')

    #######################################
    #########websocket management##########
    ######################################
    # websocket = WebSocket()
    #######websocket for order updation#####
    # websocket.websocketOrderUpdation('eth_usdt')
    #####websocket for trade######
    # websocket.websocketTrade( 'eth_usdt' )
    #####websocket for kbar######
    # websocket.websocketKbar('eth_usdt')
    ####websocket for incremental depth######
    # websocket.websocketIncreDepth('eth_usdt')
    ####websocket for depth#####
    # websocket.websocketDepth('eth_usdt')
    ####websocket for ticker#####
    # websocket.webSocketTicker('eth_usdt')


