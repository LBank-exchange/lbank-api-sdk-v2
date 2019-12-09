package main

import (
	"fmt"
	"github.com/google/uuid"
	"github.com/lbank-golang-api-sdk/apiservice"
)

//http://api.lbank.info/
func init() {
	apiservice.	InitConfig("https://www.lbkex.net/", "a42ac959-7c40-4b76-ae68-562f0fd28deb", "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIpzwNXrsO8rZG0AMFeSylauopjX0XHgr+F/tac/yjYKsTmZr8xNyo7zYZnpxTjMwWtWGWgsSLRYztYenYTHqZCvNprYrfl6qX9ZYNMnUtX05V7qXF1+tBS2RG5lgO30nW+nEtKme9runcwN010eZMmZF2GHf54NJYSabBPwUlnlAgMBAAECgYBrjkDf7pklM7BwfRUQ8xf8/u2RjxdGQCZiJ7QWmZedI/FJrfrD3CrfonLP/qsX1PjtSZWzN7PDZrpH3MDBxdoTPz18nHvC4QqtZjAx021VXf1WkP1Z6Wz8dRPpj5E185P3Mvg4BKv8fhgnzV74pMOWBHhkf3Yn304E0CKVgatgAQJBAO69q1nrDmFIDMCej/AMQhHITowRfmuN1RAMZteky/WEHHLIR3jip50Q1e4vbD/QrUBHGJJYO+VFLCzdnTd5qaUCQQCUdg9iev86dXz4gmxjsJHmPNHdd964Ct18n3+SZDsS1yOKnqRLgbPUvs/2F8MnU50w/2KVHtGOGhby6N0yfHtBAkEAofi+eyfVPrzyIfCxuOuoG4Zpe/AWdAPq7JNtZppg4fY6ksk8bFBh5VbZvVohN/5svHI/wnHoWPkgKmREWLHLHQJAF3NOms+y4RkN1HNFi7moUiXpQIJeu9N7iOPo0sbiTeeNxaepbAPg1AoP719xhBTBD6xHdiaYE0ortdLynbbsAQJBAKMk5Rgqh0EcL4PgKsWZD6H9h+dmoCIjgnwTPsRwEYXeX6G0oJ0NYXp+/LeLByNnqSVF0r811aPIVA5e7v5MBc8=")
}

func main() {
	fmt.Println("================Lbank API Call Start================")
	//1. 调用查询用户信息接口
	fmt.Println("1. Call The User Info API")
	resUserInfo, err := apiservice.GetUserInfo( )
	if err != nil {
		panic(err)
	}
	fmt.Println(resUserInfo)

	//2. 调用创建订单接口
	fmt.Println("\n2. Call The Create Order API")
	//用户自定义ID
	customerid, _ := uuid.NewRandom()
	resCreateOrder, err := apiservice.CreateOrder("lbk_usdt","sell","0.4928885049374586","1",customerid.String())
	if err != nil {
		panic(err)
	}
	if !resCreateOrder.GetResult() {
		fmt.Println(fmt.Sprintf("创建订单失败, 错误码：%d", resCreateOrder.GetError_code()))
	} else {
		fmt.Println(fmt.Sprintf("创建订单成功，Order_id: %s", resCreateOrder.GetOrder_id()))
	}

	//3. 调用撤销订单接口(单笔订单）
	fmt.Println("\n3. Call The Cancel Order API")
	resCancelOrder, err := apiservice.CancelOrder("lbk_usdt", "abe7bd4f-6262-479f-8e08-88281c872b61")
	if err != nil {
		panic(err)
	}
	if !resCancelOrder.GetResult() {
		fmt.Println(fmt.Sprintf("撤销订单失败，错误吗：%d", resCancelOrder.GetError_code()))
	} else {
		fmt.Println(fmt.Sprintf("撤销订单成功, 撤销订单号: %s", resCancelOrder.GetOrder_id()))
	}

	//4. 调用撤销订单接口(多笔订单)
	resCancelOrder, err = apiservice.CancelOrder("lbk_usdt", "abe7bd4f-6262-479f-8e08-88281c872b61,abe7bd4f-6262-479f-8e08-88281c872b61")
	if err != nil {
		panic(err)
	}
	if !resCancelOrder.GetResult() {
		fmt.Println("撤销多笔订单执行失败!!")
	} else {
		fmt.Println(fmt.Sprintf("撤销成功订单号：%s \n撤销失败订单号：%s", resCancelOrder.GetSuccess(), resCancelOrder.GetError()))
	}

	//5. 查询订单接口
	fmt.Println("\n4. Call The Orders Info API")
	resOrderInfo, err := apiservice.OrderInfo("lbk_usdt", "78332c1d-ba90-4b64-b44b-5a05b40511a4")
	if err != nil {
		panic(err)
	}
	if !resOrderInfo.GetResult() {
		fmt.Println(fmt.Sprintf("查询订单失败, 错误码：%d", resOrderInfo.GetError_code()))
	} else {
		for key, value := range resOrderInfo.GetOrderData() {
			fmt.Println(fmt.Sprintf("第%d笔：\n" +
				"symbol:%s\n" +
				"amount:%v\n" +
				"create_time:%v\n" +
				"price:%f\n" +
				"avg_price:%f\n" +
				"type:%s\n" +
				"order_id:%s\n" +
				"deal_amount:%f\n" +
				"status:%d\n",key, value.GetSymbol(), value.GetAmount(), value.GetCreate_time(), value.GetPrice(), value.GetAvg_price(), value.GetType(),
				value.GetOrder_id(), value.GetDeal_amount(), value.GetStatus()))
		}
	}
	fmt.Println("================Lbank API Call End================")
}
