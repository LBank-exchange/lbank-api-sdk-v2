package module

import (
	"github.com/lbank-go-sdk-api/constant"
	"strconv"
)

/*
获取LBank币币行情数据

GET 请求
GET /v2/ticker.do
*/
func (cli *Client) GetTicker(symbol string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	tickerParams := make(map[string]string)
	tickerParams["symbol"] = symbol
	res, err := cli.CombineGETParams(&tickerParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_TICKER, tickerParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取LBank市场深度

GET 请求
GET /v2/depth.do

当size 和 merge 为空值时，系统默认size = 60  merge = 0
*/
func (cli *Client) GetDepth(symbol, size, merge string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	depthParams := make(map[string]string)
	depthParams["symbol"] = symbol
	if size == "" {
		depthParams["size"] = strconv.Itoa(60)
	} else {
		depthParams["size"] = size
	}
	if merge == "" {
		depthParams["merge"] = strconv.Itoa(0)
	} else {
		depthParams["merge"] = merge
	}
	res, err := cli.CombineGETParams(&depthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_DEPTH, depthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取LBank市场深度，这是带版本号的根据增量合并起来的深度

GET 请求
GET /v2/incrDepth.do
*/
func (cli *Client) GetIncrDepth(symbol, merge string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	incrDepthParams := make(map[string]string)
	incrDepthParams["symbol"] = symbol
	if merge == "" {
		incrDepthParams["merge"] = strconv.Itoa(0)
	} else {
		incrDepthParams["merge"] = merge
	}
	res, err := cli.CombineGETParams(&incrDepthParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_INCR_DEPTH, incrDepthParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取LBank历史交易信息

GET 请求
GET /v2/trades.do
*/
func (cli *Client) GetTrades(symbol, size, time string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	tradesParams := make(map[string]string)
	tradesParams["symbol"] = symbol
	tradesParams["size"] = size
	tradesParams["time"] = time
	res, err := cli.CombineGETParams(&tradesParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_TRADES, tradesParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取K线数据

GET 请求
GET /v2/kline.do
*/
func (cli *Client) GetKline(symbol, size, typ, time string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	klineParams := make(map[string]string)
	klineParams["symbol"] = symbol
	klineParams["size"] = size
	klineParams["type"] = typ
	klineParams["time"] = time
	res, err := cli.CombineGETParams(&klineParams)
	if err != nil {
		return nil, err
	}

	urlPath := cli.BuildParams(constant.BASE_KLINE, klineParams)
	if _, err := cli.Request(constant.GET, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}