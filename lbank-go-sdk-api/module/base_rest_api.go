package module

import (
	"github.com/lbank-go-sdk-api/constant"
)

/*
获取LBank可用交易对接口

GET 请求
GET /v2/currencyPairs.do
*/
func (cli *Client) GetCurrencyPairs() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	currencyInfo := make(map[string]string)
	res, err := cli.CombineGETParams(&currencyInfo)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_CURRENCY_PAIR, currencyInfo)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取所有币对的基本信息

GET 请求
GET /v2/accuracy.do
*/
func (cli *Client) GetAccuracy() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	accuracyInfo := make(map[string]string)
	res, err := cli.CombineGETParams(&accuracyInfo)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_ACCURACY, accuracyInfo)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取美元对人民币的兑换比例

GET 请求
GET /v2/usdToCny.do
*/
func (cli *Client) GetUsdToCny() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	usdToCnyInfo := make(map[string]string)
	res, err := cli.CombineGETParams(&usdToCnyInfo)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_USD_TO_CNY, usdToCnyInfo)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取币种提币参数

GET 请求
GET /v2/withdrawConfigs.do
*/
func (cli *Client) GetWithDrawConfigs(assetCode string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withDrawConfigParams := make(map[string]string)
	if assetCode != "" {
		withDrawConfigParams["assetCode"] = assetCode
	}
	res, err := cli.CombineGETParams(&withDrawConfigParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_WITHDRAW_CONFIG, withDrawConfigParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取当前的系统时间，单位毫秒

GET 请求
GET /v2/timestamp.do
*/
func (cli *Client) GetTimeStamp() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	timestampParams := make(map[string]string)
	res, err := cli.CombineGETParams(&timestampParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_TIMESTAMP, timestampParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取系统状态。

POST 请求
POST /v2/supplement/system_status.do
*/
func (cli *Client) GetSystemStatus() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	timestampParams := make(map[string]string)
	res, err := cli.CombineGETParams(&timestampParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_SYSTEM_STATUS, timestampParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
测试服务器连通性

POST 请求
POST /v2/supplement/system_ping.do
*/
func (cli *Client) SystemPing() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	timestampParams := make(map[string]string)
	res, err := cli.CombineGETParams(&timestampParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_SYSTEM_PING, timestampParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取深度信息

GET 请求
GET /v2/supplement/incrDepth.do
*/
func (cli *Client) IncrDepth(symbol, limit string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	incrDepthParams := make(map[string]string)
	incrDepthParams["symbol"] = symbol
	incrDepthParams["limit"] = limit
	res, err := cli.CombineGETParams(&incrDepthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_INCRDEPTH, incrDepthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
近期成交列表

GET 请求
GET /v2/supplement/trades.do
*/
func (cli *Client) NowTrades(symbol, size, time string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	incrDepthParams := make(map[string]string)
	incrDepthParams["symbol"] = symbol
	incrDepthParams["size"] = size
	incrDepthParams["time"] = time
	res, err := cli.CombineGETParams(&incrDepthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_NOW_TRADES, incrDepthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取交易对最新价格

GET 请求
GET /v2/supplement/ticker/price.do
*/
func (cli *Client) LatestPrice(symbol string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	incrDepthParams := make(map[string]string)
	incrDepthParams["symbol"] = symbol
	res, err := cli.CombineGETParams(&incrDepthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_LATEST_PRICE, incrDepthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
当前最优挂单

GET 请求
GET /v2/supplement/ticker/bookTicker.do
*/
func (cli *Client) BookTicker(symbol string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	incrDepthParams := make(map[string]string)
	incrDepthParams["symbol"] = symbol
	res, err := cli.CombineGETParams(&incrDepthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_BOOK_TICKER, incrDepthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}
