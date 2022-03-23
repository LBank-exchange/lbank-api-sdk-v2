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
func (cli *Client) GetSubscribeKey() (*map[string]interface{}, error) {
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
func (cli *Client) RefreshSubscribeKey(subscribeKey string) (*map[string]interface{}, error) {
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
func (cli *Client) CloseSubscribeKey(subscribeKey string) (*map[string]interface{}, error) {
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
func (cli *Client) WithDraw(symbol, account, assetCode, amount, fee, memo, mark, typ string) (*map[string]interface{}, error) {
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
func (cli *Client) WithdrawCancel(withdrawId string) (*map[string]interface{}, error) {
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
func (cli *Client) WithDraws(assetCode, status, pageNo, pageSize string) (*map[string]interface{}, error) {
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

/*
获取所有币信息

POST 请求
POST /v2/supplement/user_info.do
*/
func (cli *Client) GetUserAssetInfo() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawsParams := make(map[string]string)

	res, err := cli.CombinePOSTParams(&withdrawsParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_USER_INFO, withdrawsParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取充值历史

POST 请求
POST /v2/supplement/deposit_history.do
*/
func (cli *Client) DepositHistory(coin, status, startTime, endTime string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	depositHistoryParams := make(map[string]string)

	res, err := cli.CombinePOSTParams(&depositHistoryParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.DEPOSIT_HISTORY, depositHistoryParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户发起提币

POST 请求
POST /v2/supplement/withdraw.do
*/
func (cli *Client) WithDrawNew(address, coin, amount, memo, mark, fee, typ string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["coin"] = coin
	withdrawParams["address"] = address
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
	urlPath := cli.BuildParams(constant.WITHDRAW_NEW, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取提币历史

POST 请求
POST /v2/supplement/withdraw.do
*/
func (cli *Client) WithDrawsNew(coin, status, withdrawOrderId, startTime, endTime string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["coin"] = coin
	withdrawParams["status"] = status
	if withdrawOrderId != "" {
		withdrawParams["withdrawOrderId"] = withdrawOrderId
	}
	if startTime != "" {
		withdrawParams["startTime"] = startTime
	}

	if endTime != "" {
		withdrawParams["endTime"] = endTime
	}

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.WITHDRAWs_NEW, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
获取充值地址

POST 请求
POST /v2/supplement/get_deposit_address.do
*/
func (cli *Client) GetDepositAddress(coin, networkName string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["coin"] = coin
	if networkName != "" {
		withdrawParams["networkName"] = networkName
	}

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.DEPOSIT_ADDRESS, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
上架资产详情

POST 请求
POST /v2/supplement/get_deposit_address.do
*/
func (cli *Client) AssetDetail(coin string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["coin"] = coin

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_ASSET_DETAIL, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户交易手续费率查询

POST 请求
POST /v2/supplement/customer_trade_fee.do
*/
func (cli *Client) CustomerTradeFee(category string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)
	withdrawParams["category"] = category

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_CUSTOMER_TRADE_FEE, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
查询用户API Key权限

POST 请求
POST /v2/supplement/api_Restrictions.do
*/
func (cli *Client) ApiRestrictions() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_API_RESTRICTIONS, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
账户信息

POST 请求
POST /v2/supplement/user_info_account.do
*/
func (cli *Client) UserInfoAccount() (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	withdrawParams := make(map[string]string)

	res, err := cli.CombinePOSTParams(&withdrawParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ACCOUNT_USER_INFO_ACCOUNT, withdrawParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}
