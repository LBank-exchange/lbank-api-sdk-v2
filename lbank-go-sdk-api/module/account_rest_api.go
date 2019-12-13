package module

import (
	"github.com/lbank-go-sdk-api/constant"
)

/*
获取用户账户资产信息

POST 请求
POST /v2/user_info.do
*/
func (cli *Client) GetUserInfo() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	userInfoParams := make(map[string]string)
	res, err := cli.CombinePOSTParams(&userInfoParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_GET_USER_INFO, userInfoParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}


/*
生成subscribeKey，从创建时刻起有效期为60分钟

POST 请求
POST /v2/subscribe/get_key.do
*/
func  (cli *Client) GetSubscribeKey() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	subKeyParams := make(map[string]string)
	res, err := cli.CombinePOSTParams(&subKeyParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_SUBSCRIBE, subKeyParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
延长subscribeKey有效期，有效期延长至本次调用后60分钟

POST 请求
POST /v2/subscribe/refresh_key.do
*/
func  (cli *Client) RefreshSubscribeKey(subscribeKey string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	subKeyParams := make(map[string]string)
	subKeyParams["subscribeKey"] = subscribeKey
	res, err := cli.CombinePOSTParams(&subKeyParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_REFRESH_SUBSCRIBE, subKeyParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
关闭subscribeKey，关闭某账户数据流

POST 请求
POST /v2/subscribe/destroy_key.do
*/
func  (cli *Client) CloseSubscribeKey(subscribeKey string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	closeSubKeyParams := make(map[string]string)
	closeSubKeyParams["subscribeKey"] = subscribeKey
	res, err := cli.CombinePOSTParams(&closeSubKeyParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_CLOSE_SUBSCRIBE, closeSubKeyParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户发起提币

POST 请求
POST /v2/withdraw.do
*/
func  (cli *Client) WithDraw(symbol, account, assetCode, amount, fee, memo, mark, typ string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["symbol"] = symbol
	withdrawParams["account"] = account
	withdrawParams["assetCode"] = assetCode
	withdrawParams["amount"] = amount
	withdrawParams["fee"] = fee
	if memo != "" {
		withdrawParams["memo"] = memo
	}
	if mark != "" {
		withdrawParams["mark"] = mark
	}

	if typ != "" {
		withdrawParams["type"] = typ
	}

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.WITHDRAW, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户撤销提币订单

POST 请求
POST /v2/withdrawCancel.do
*/
func  (cli *Client) WithdrawCancel(withdrawId string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawCancelParams := make(map[string]string)
	withdrawCancelParams["withdrawId"] = withdrawId

	res, err := cli.CombinePOSTParams(&withdrawCancelParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.WITHDRAW_CANCEL, withdrawCancelParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询提币记录

POST 请求
POST /v2/withdraws.do
*/
func  (cli *Client) WithDraws(assetCode, status, pageNo, pageSize string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawsParams := make(map[string]string)
	withdrawsParams["status"] = status
	if assetCode != "" {
		withdrawsParams["assetCode"] = assetCode
	}
	if pageNo != "" {
		withdrawsParams["pageNo"] = pageNo
	}
	if pageSize != "" {
		withdrawsParams["pageSize"] = pageSize
	}

	res, err := cli.CombinePOSTParams(&withdrawsParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.WITHDRAWS, withdrawsParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}
