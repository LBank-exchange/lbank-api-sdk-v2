package module

import (
	"testing"
	"time"
)

func TestLbankWSAgent_HandleResponse(t *testing.T) {
	agent := LbankWSAgent{}
	agent.Start( )

	//订阅K线数据
	sub := NewSubscribeKbar("subscribe", "5min", "eth_btc","","","")
	agent.Subscribe(StructToJsonString(sub))
	////取消订阅K线数据
	//sub := NewSubscribeKbar("unsubscribe", "5min", "eth_btc","","","")
	//agent.Subscribe(StructToJsonString(sub))

	//订阅深度数据
	//sub := NewSubscribeDepth("subscribe","10","lbk_usdt")
	//agent.Subscribe(StructToJsonString(sub))
	////取消订阅深度数据
	//sub = NewSubscribeDepth("unsubscribe","10","lbk_usdt")
	//agent.Subscribe(StructToJsonString(sub))

	//订阅市场行情
	//sub := NewSubscribeTick("subscribe", "eth_btc")
	//agent.Subscribe(StructToJsonString(sub))
	//取消订阅市场行情
	//sub := NewSubscribeTick("unsubscribe", "eth_btc")
	//agent.Subscribe(StructToJsonString(sub))

	//订阅成交记录
	//sub := NewSubscribeTrade("subscribe", "lbk_usdt")
	//agent.Subscribe(StructToJsonString(sub))
	//取消订阅成绩记录
	//sub := NewSubscribeTrade("unsubscribe", "eth_btc")
	//agent.Subscribe(StructToJsonString(sub))

	//订阅更新
	//sub := NewSubscribeOrderUpdate("subscribe", "", "all")
	//agent.Subscribe(StructToJsonString(sub))
	//取消订阅更新
	//sub := NewSubscribeOrderUpdate("unsubscribe", "", "all")
	//agent.Subscribe(StructToJsonString(sub))

	for {
		time.Sleep(2 * time.Second)
	}
}