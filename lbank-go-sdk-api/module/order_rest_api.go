package module

import (
	"github.com/lbank-go-sdk-api/constant"
)

/*
用户下单，创建交易订单

POST 请求
POST /v2/create_order.do
*/
func (cli *Client) CreateOrder(symbol, typ, price, amount, custom_id string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	createOrderParams := make(map[string]string)
	createOrderParams["symbol"] = symbol
	createOrderParams["type"] = typ
	createOrderParams["price"] = price
	createOrderParams["amount"] = amount

	if custom_id != "" {
		createOrderParams["custom_id"] = custom_id
	}
	res, err := cli.CombinePOSTParams(&createOrderParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_CREATE_ORDER, createOrderParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户撤销订单

POST 请求
POST /v2/cancel_order.do
*/
func (cli *Client) CancelOrder(symbol, order_id string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	cancelOrderParams := make(map[string]string)
	cancelOrderParams["symbol"] = symbol
	cancelOrderParams["order_id"] = order_id

	res, err := cli.CombinePOSTParams(&cancelOrderParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_CANCEL_ORDER, cancelOrderParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
据自定义ID撤销订单

POST 请求
POST /v2/cancel_clientOrders.do
*/
func (cli *Client) CancelOrderByCustomerId(symbol, customer_id string ) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	cancelOrderByCustomerIDParams := make(map[string]string)
	cancelOrderByCustomerIDParams["symbol"] = symbol
	cancelOrderByCustomerIDParams["customer_id"] = customer_id

	res, err := cli.CombinePOSTParams(&cancelOrderByCustomerIDParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_CANCEL_ORDER_BY_CUSTOMERID, cancelOrderByCustomerIDParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询订单

POST 请求
POST /v2/orders_info.do
*/
func (cli *Client) OrdersInfo(symbol, order_id string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	orderInfoParams := make(map[string]string)
	orderInfoParams["symbol"] = symbol
	orderInfoParams["order_id"] = order_id

	res, err := cli.CombinePOSTParams(&orderInfoParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_ORDER_INFO, orderInfoParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询订单历史

POST 请求
POST /v2/orders_info_history.do
*/
func (cli *Client) OrdersInfoHistory(symbol, current_page, page_length, status string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	orderInfoHistoryParams := make(map[string]string)
	orderInfoHistoryParams["symbol"] = symbol
	orderInfoHistoryParams["current_page"] = current_page
	orderInfoHistoryParams["page_length"] = page_length
	if status != "" {
		orderInfoHistoryParams["status"] = status
	}

	res, err := cli.CombinePOSTParams(&orderInfoHistoryParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_ORDERS_INFO_HISTORY, orderInfoHistoryParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询订单成交明细

POST 请求
POST /v2/order_transaction_detail.do
*/
func (cli *Client) OrderTransactionDetail(symbol, order_id string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	orderTransactionDetailParams := make(map[string]string)
	orderTransactionDetailParams["symbol"] = symbol
	orderTransactionDetailParams["order_id"] = order_id

	res, err := cli.CombinePOSTParams(&orderTransactionDetailParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_TRANSACTION_DETAIL, orderTransactionDetailParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询订单历史成交明细

POST 请求
POST /v2/transaction_history.do
*/
func (cli *Client) TransactionHistory(symbol, typ, start_date, end_date, from, direct, size string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	transactionHistoryParams := make(map[string]string)
	transactionHistoryParams["symbol"] = symbol
	if typ != "" {
		transactionHistoryParams["type"] = typ
	}
	if start_date != "" {
		transactionHistoryParams["start_date"] = start_date
	}
	if end_date != "" {
		transactionHistoryParams["end_date"] = end_date
	}
	if from != "" {
		transactionHistoryParams["from"] = from
	}
	if direct != "" {
		transactionHistoryParams["direct"] = direct
	}
	if size != "" {
		transactionHistoryParams["size"] = size
	}

	res, err := cli.CombinePOSTParams(&transactionHistoryParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_TRANSACTION_HISTORY, transactionHistoryParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}

/*
用户查询开放订单

POST 请求
POST /v2/orders_info_no_deal.do
*/
func (cli *Client) OrdersInfoNoDeal(symbol, current_page, page_length string) (*map[string]interface{}, error) {
	p := map[string]interface{}{}

	orderInfoNoDealParams := make(map[string]string)
	orderInfoNoDealParams["symbol"] = symbol
	orderInfoNoDealParams["current_page"] = current_page
	orderInfoNoDealParams["page_length"] = page_length

	res, err := cli.CombinePOSTParams(&orderInfoNoDealParams)
	if err != nil {
		return nil, err
	}
	urlPath := cli.BuildParams(constant.ORDER_ORDERS_INFO_NO_DEAL, orderInfoNoDealParams)
	if _, err := cli.Request(constant.POST, urlPath, res, &p); err != nil {
		return nil, err
	}

	return &p, nil
}