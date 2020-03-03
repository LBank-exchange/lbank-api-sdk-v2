package main

import (
	"encoding/json"
	"fmt"
	"github.com/lbank-go-sdk-api/module"
	"strconv"
	"time"
)

func main() {
	//新建Lbank Rest API 客户端
	client := module.NewLbankClient( )

	//base API 测试
	//1. 获取可用交易对
	fmt.Println("1. 获取交易对")
	res, _ := client.GetCurrencyPairs()
	result, _:=json.Marshal(res)
	fmt.Println(string(result))
	fmt.Println("-----------------------------------------------------")

	////2. 获取所有币对基本信息
	//fmt.Println("2. 获取所有币种基本信息")
	//res, _ = client.GetAccuracy()
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////3. 获取美元对人民币兑换比例
	//fmt.Println("3. 获取美元对人民币兑换比例")
	//res, _ = client.GetUsdToCny()
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////4. 获取提币参数
	//fmt.Println("4. 获取提币参数")
	//res, _ = client.GetWithDrawConfigs("btc")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////5. 获取当前时间戳
	//fmt.Println("5. 获取当前时间戳")
	//res, _ = client.GetTimeStamp()
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//账户相关API
	//1. 获取用户资产信息
	//fmt.Println("6. 获取用户资产信息")
	//res, _ = client.GetUserInfo()
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//2. 生成subscribeKey
	//fmt.Println("7. 生成subscribeKey")
	//var subKey string
	//res, _ = client.GetSubscribeKey()
	//subKey = fmt.Sprintf("%v",(*res)["data"])
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////3. 延长subscribeKey时间
	//fmt.Println("8. 延长subscribeKey时间")
	//res, _ = client.RefreshSubscribeKey(subKey)
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////4. 关闭subscribeKey
	//fmt.Println("9. 关闭subscribeKey")
	//res, _ = client.CloseSubscribeKey(subKey)
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//5. 用户发起提现
	//fmt.Println("10. 用户发起提现")
	//var witdDrawID string
	//res, _ = client.WithDraw("btc_usdt", "qwertyuqawsedrftgyh", "btc", "0.3","0.001","","","")
	//if fmt.Sprintf("%v", (*res)["error_code"]) != "0" {
	//	witdDrawID = ""
	//} else {
	//	data := (*res)["data"].(map[string]interface{})
	//	witdDrawID = fmt.Sprintf("%v", data["withdrawId"])
	//}
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("用户提现ID = ", witdDrawID)
	//fmt.Println("-----------------------------------------------------")

	////6.撤销提币
	//fmt.Println("11. 用户撤销提现")
	//fmt.Println("撤销提币ID = ", witdDrawID)
	//res, _ = client.WithdrawCancel(witdDrawID)
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////7. 查询提币记录
	//fmt.Println("12. 查询提币记录")
	//res, _ = client.WithDraws("btc", "0", "", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//订单相关
	//1. 用户下单
	//fmt.Println("13. 用户下单")
	////var orderId string
	//res, _ = client.CreateOrder("lbk_usdt", "buy", "0.0222", "10", "")
	////orderId = fmt.Sprintf("%v", (*res)["data"].(map[string]interface{})["order_id"])
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//2. 用户撤销订单
	//fmt.Println("14. 撤销订单")
	//res, _ = client.CancelOrder("", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////3. 根据用户自定义ID撤销订单
	//fmt.Println("15. 根据用户自定义ID撤单")
	//res, _ = client.CancelOrderByCustomerId("eth_btc", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	//////4. 用户查询订单
	//fmt.Println("16. 用户查询订单")
	//res, _ = client.OrdersInfo("lbk_usdt", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////5. 查询订单历史
	//fmt.Println("17. 用户查询订单历史")
	//res, _ = client.OrdersInfoHistory("lbk_usdt", "1", "10","")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////6. 查询订单明细
	//fmt.Println("18. 查询订单明细")
	//res, _ = client.OrderTransactionDetail("lbk_usdt", orderId)
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////7. 查询历史成交明细
	//fmt.Println("19. 查询历史成交明细")
	//res, _ = client.TransactionHistory("lbk_usdt","", "", "", "","", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////8. 用户查询开放订单
	//fmt.Println("20. 查询开放订单")
	//res, _ = client.OrdersInfoNoDeal("lbk_usdt","1", "20")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////9. 批量下单
	//fmt.Println("26. 批量下单")
	//type orderParams struct {
	//	Symbol 		string 		`json:"symbol"`
	//	Typ		string 		`json:"type"`
	//	Price 		string  	`json:"price"`
	//	Amount 		string 		`json:"amount"`
	//	CustomerId 	string 		`json:"customer_id"`
	//}
	//
	//var paramsList []orderParams
	//
	//paramsList = append(paramsList,orderParams{
	//	Symbol:"lbk_usdt",
	//	Typ:"buy",
	//	Price:"0.05",
	//	Amount:"100",
	//	CustomerId:"",
	//})
	//paramsList = append(paramsList, orderParams{
	//	Symbol:"lbk_usdt",
	//	Typ:"buy",
	//	Price:"0.05",
	//	Amount:"100",
	//})
	//
	//params, err := json.Marshal(paramsList)
	//if err != nil {
	//	fmt.Println("参数组合错误，error = ", err)
	//	panic(err)
	//}
	//
	//res, _ := client.CreateBatchOrder(string(params))
	//result, _ :=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")
	
	//市场相关
	//1. 获取币币行情
	//fmt.Println("21. 获取币币行情")
	//res, _ = client.GetTicker("lbk_usdt")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////2. 获取市场深度
	//fmt.Println("22. 获取市场深度")
	//res, _ = client.GetDepth("lbk_usdt","","")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////3. 获取增量市场深度
	//fmt.Println("23. 获取市场增量深度")
	//res, _ = client.GetIncrDepth("lbk_usdt","")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////4. 获取历史交易信息
	//fmt.Println("24. 获取历史交易信息")
	//res, _ = client.GetTrades("lbk_usdt","10", "")
	//result, _=json.Marshal(res)
	//fmt.Println(string(result))
	//fmt.Println("-----------------------------------------------------")

	////5. 获取K线数据
	fmt.Println("25. 获取K线数据")
	tt := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatInt(tt, 10)
	res, _ = client.GetKline("lbk_usdt","10", "5min", timestamp)
	result, _=json.Marshal(res)
	fmt.Println(string(result))
	fmt.Println("-----------------------------------------------------")
}
