# -*- coding:utf-8 -*-
# project name: project
# file name : run

import LBank.BasicDataMan as bd
import LBank.new_v2_inter.WalletMan as wm
import LBank.new_v2_inter.MarketMan as mm
import LBank.new_v2_inter.OrderMan as om

if __name__=="__main__":

    ###############################
    ########### Order #############
    ###############################
    # orderMan= ord.Orders()
    ###create order#####
    # orderMan.createOrders(symbol='lbk_usdt',type='buy',price=0.0222,amount=10,customer_id='')

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
    # accountMan=ac.AccountMan()

    ####get user info ########
    # accountMan.getUserInfo()

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

    # basicdataMan=bd.BaseConfigMan()

    ####get accuracy info######
    # basicdataMan.getAccuracyInfo()

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

    # marketMan = ma.MarketMan()

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


    ########################################
     #############   new inter  ###########
    ########################################
    # accountMan=ac.AccountMan()
    ####get user info ########
    # accountMan.getUserInfo()
    # walletMan = wm.WalletMan()
    # walletMan.getSystem_status()
    # walletMan.getUser_info()
    # walletMan.getWithdraw(address = 'TDD8xpRpYQxhURoqf3cXwtgnyq6JKP3sr1', networkName = 'trc20', coin = 'usdt', amount = '2', memo = '',mark = '测试', fee = 1,name = 'trc20地址',withdrawOrderId = 'test0001',type = 2)
    # walletMan.getDeposit_history(status = '', coin = 'usdt', startTime = '', endTime = '')
    # walletMan.getWithdraws(status = '', coin = 'usdt', withdrawOrderId = '', startTime = '', endTime = '')
    # walletMan.get_deposit_address(networkName = 'erc20',coin = 'usdt')
    # walletMan.getAsset_detail(coin = '')
    # walletMan.getCustomer_trade_fee(category = '')
    # walletMan.getapi_Restrictions()

    # market = mm.MarketMan()
    # market.getSystem_ping()
    # market.getIncrDepthV2(symbol = 'btc_usdt')
    # market.getTradesV2(symbol = 'lbk_usdt', size = '100', time = '1644903969000')
    # market.getPrice(symbol = '')
    # market.getBookTicker(symbol = 'btc_usdt')

    order = om.OrderMan()
    # order.getCreate_order_test(symbol = 'lbk_usdt',type = 'buy',price = '0.026',amount = '10', custom_id = '')
    # order.getCreate_order(symbol = 'lbk_usdt',type = 'buy',price = '0.022',amount = '10', custom_id = '')
    # order.getCancel_orderV2(symbol = 'lbk_usdt', orderId = '3f05d548-8d4d-4034-b326-cf8de25a9caf', origClientOrderId = '')
    # order.getCancel_order_by_symbol(symbol = 'lbk_usdt')
    # order.getOrders_infoV2(symbol = 'lbk_usdt',orderId = '728cf9ee-d650-456b-9835-dbfe8f3a2e58')
    # order.getOrders_info_no_deal(symbol = 'lbk_usdt' ,current_page = '1' ,page_length = '100')
    # order.getOrders_info_history(symbol = 'lbk_usdt', current_page = '1',page_length = '100', status = '')
    # order.getUser_info_account()
    order.getTransaction_history(symbol = 'lbk_usdt', startTime = '', endTime = '',fromId = '', limit = '')