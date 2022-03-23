package module

import (
	"encoding/json"
	"github.com/lbank-go-sdk-api/constant"
	"github.com/shopspring/decimal"
	"math/big"
)

//ping and pong消息
type PingMessage struct {
	Action string `json:"action"`
	Ping   string `json:"ping"`
}

type PongMessage struct {
	Action string `json:"action"`
	Pong   string `json:"pong"`
}

//K线订阅和返回值
type SubscribeKbar struct {
	Action    string `json:"action"`
	Subscribe string `json:"subscribe"`
	Kbar      string `json:"kbar"`
	Pair      string `json:"pair"`
	Start     string `json:"start"`
	End       string `json:"end"`
	Size      string `json:"size"`
}

func NewSubscribeKbar(action, kbar, pair, start, end, size string) *SubscribeKbar {
	subkbar := &SubscribeKbar{
		Action:    action,
		Subscribe: constant.SUBSCRIBE_KBAR,
		Kbar:      kbar,
		Pair:      pair,
	}
	if start != "" {
		subkbar.Start = start
	}
	if end != "" {
		subkbar.End = end
	}
	if size != "" {
		subkbar.Size = size
	}
	return subkbar
}

type Kbar struct {
	T    string          `json:"t"`
	O    decimal.Decimal `json:"o"`
	H    decimal.Decimal `json:"h"`
	L    decimal.Decimal `json:"l"`
	C    decimal.Decimal `json:"c"`
	V    decimal.Decimal `json:"v"`
	A    decimal.Decimal `json:"a"`
	N    decimal.Decimal `json:"n"`
	Slot string          `json:"slot"`
}

type ResponseKbar struct {
	Type   string `json:"type"`
	Pair   string `json:"pair"`
	Server string `json:"SERVER"`
	Ts     string `json:"TS"`
	Kbar   Kbar   `json:"kbar"`
}

//深度订阅和返回值
type SubscribeDepth struct {
	Action    string `json:"action"`
	Subscribe string `json:"subscribe"`
	Depth     string `json:"depth"`
	Pair      string `json:"pair"`
}

type Depth struct {
	Asks [][4]interface{} `json:"asks"`
	Bids [][4]interface{} `json:"bids"`
}

type ResponseDepth struct {
	Type   string   `json:"type"`
	Pair   string   `json:"pair"`
	Server string   `json:"SERVER"`
	Ts     string   `json:"TS"`
	Count  *big.Int `json:"count"`
	Depth  Depth    `json:"depth"`
}

func NewSubscribeDepth(action, depth, pair string) *SubscribeDepth {
	return &SubscribeDepth{
		Action:    action,
		Subscribe: constant.SUBSCRIBE_DEPTH,
		Depth:     depth,
		Pair:      pair,
	}
}

//增量深度订阅和返回值
type SubscribeIncrDepth struct {
	Action    string `json:"action"`
	Subscribe string `json:"subscribe"`
	Pair      string `json:"pair"`
}

//市场行情订阅和返回值
type SubscribeTick struct {
	Action    string `json:"action"`
	Subscribe string `json:"subscribe"`
	Pair      string `json:"pair"`
}

type Tick struct {
	Hight    *decimal.Decimal `json:"height"`
	Low      *decimal.Decimal `json:"low"`
	Latest   *decimal.Decimal `json:"latest"`
	Vol      *decimal.Decimal `json:"vol"`
	Turnover *decimal.Decimal `json:"turnover"`
	To_cny   *decimal.Decimal `json:"to_cny"`
	To_usd   *decimal.Decimal `json:"to_usd"`
	Cny      *decimal.Decimal `json:"cny"`
	Usd      *decimal.Decimal `json:"usd"`
	Dir      string           `json:"dir"`
	Change   *decimal.Decimal `json:"change"`
}

type ResponseTick struct {
	Type   string `json:"type"`
	Pair   string `json:"pair"`
	Server string `json:"SERVER"`
	Ts     string `json:"TS"`
	Tick   Tick   `json:"tick"`
}

func NewSubscribeTick(action, pair string) *SubscribeTick {
	return &SubscribeTick{
		Action:    action,
		Subscribe: constant.SUBSCRIBE_TICK,
		Pair:      pair,
	}
}

//成交记录订阅结构和返回值
type SubscribeTrade struct {
	Action    string `json:"action"`
	Subscribe string `json:"subscribe"`
	Pair      string `json:"pair"`
}

type Trade struct {
	Amount      string `json:"amount"`
	Price       string `json:"price"`
	VolumePrice string `json:"volumePrice"`
	Direction   string `json:"direction"`
	Ts          string `json:"TS"`
}

type ResponseTrade struct {
	Type   string `json:"type"`
	Pair   string `json:"pair"`
	Server string `json:"SERVER"`
	Ts     string `json:"TS"`
	Trade  Trade  `json:"trade"`
}

func NewSubscribeTrade(action, pair string) *SubscribeTrade {
	return &SubscribeTrade{
		Action:    action,
		Subscribe: constant.SUBSCRIBE_TRADE,
		Pair:      pair,
	}
}

type SubscribeOrderUpdate struct {
	Action       string `json:"action"`
	Subscribe    string `json:"subscribe"`
	SubscribeKey string `json:"subscribeKey"`
	Pair         string `json:"pair"`
}

type OrderUpdate struct {
	Uuid        string `json:"uuid"`
	TxUuid      string `json:"txUuid"`
	Amount      string `json:"amount"`
	VolumePrice string `json:"volumePrice"`
	Role        string `json:"role"`
	Price       string `json:"price"`
	OrderStatus int    `json:"orderStatus"`
	UpdateTime  string `json:"updateTime"`
}

type ResponseOrderUpdate struct {
	Type        string      `json:"type"`
	Pair        string      `json:"pair"`
	Server      string      `json:"SERVER"`
	Ts          string      `json:"TS"`
	OrderUpdate OrderUpdate `json:"orderUpdate"`
}

func NewSubscribeOrderUpdate(action, subscribeKey, pair string) *SubscribeOrderUpdate {
	return &SubscribeOrderUpdate{
		Action:       action,
		Subscribe:    constant.SUBSCRIBE_ORDER_UPDATE,
		SubscribeKey: subscribeKey,
		Pair:         pair,
	}
}

//返回值结构转换
func LoadResponse(rspMsg []byte) (interface{}, error) {
	evtR := new(ResponseKbar)
	err := JsongToStruct(rspMsg, evtR)
	if err == nil && evtR.Type == constant.SUBSCRIBE_KBAR {
		return evtR, nil
	}

	dtR := new(ResponseDepth)
	err = JsongToStruct(rspMsg, dtR)
	if err == nil && dtR.Type == constant.SUBSCRIBE_DEPTH {
		return dtR, nil
	}

	tickR := new(ResponseTick)
	err = JsongToStruct(rspMsg, tickR)
	if err == nil && tickR.Type == constant.SUBSCRIBE_TICK {
		return tickR, nil
	}

	tradeR := new(ResponseTrade)
	err = JsongToStruct(rspMsg, tradeR)
	if err == nil && tradeR.Type == constant.SUBSCRIBE_TRADE {
		return tradeR, nil
	}

	orderR := ResponseOrderUpdate{}
	err = JsongToStruct(rspMsg, orderR)
	if err == nil && orderR.Type == constant.SUBSCRIBE_ORDER_UPDATE {
		return orderR, nil
	}

	if string(rspMsg) != "" {
		return string(rspMsg), nil
	}
	return nil, err
}

func LoadPingResponse(rspMsg []byte) string {
	ping := PingMessage{}
	JsongToStruct(rspMsg, ping)
	pong := PongMessage{
		Action: "pong",
		Pong:   ping.Ping,
	}
	return StructToJsonString(pong)
}

func JsongToStruct(jsonBytes []byte, result interface{}) error {
	err := json.Unmarshal(jsonBytes, &result)
	return err
}

func StructToJsonString(message interface{}) string {
	jsonSubKar, _ := json.Marshal(message)
	return string(jsonSubKar)
}
