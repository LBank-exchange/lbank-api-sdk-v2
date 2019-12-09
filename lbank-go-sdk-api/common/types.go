package common

import "math/big"

type Rdata 	struct {
	Order_id 		string
}

type ResCreateOrderVo struct {
	Result 			bool
	Error_code     	int
	Ts 				*big.Int
	Data 			Rdata
}

func (res *ResCreateOrderVo) GetResult() bool {
	return res.Result
}

func (res *ResCreateOrderVo) GetError_code() int {
	return res.Error_code
}

func(res *ResCreateOrderVo) GetTs() *big.Int {
	return res.Ts
}

func (res *ResCreateOrderVo) GetOrder_id() string{
	return res.Data.Order_id
}

type RCanceldata 	struct {
	Order_id 		string
	Success 		string
	Error 			string
}

type ResCancelOrderVo struct {
	Result 			bool
	Error_code 		int
	Ts				*big.Int
	Data 			RCanceldata
}

func (res *ResCancelOrderVo) GetResult() bool {
	return res.Result
}

func (res *ResCancelOrderVo) GetError_code() int {
	return res.Error_code
}

func (res *ResCancelOrderVo) GetTs() *big.Int {
	return res.Ts
}

func(res *ResCancelOrderVo) GetOrder_id() string {
	return res.Data.Order_id
}

func (res *ResCancelOrderVo) GetSuccess() string {
	return res.Data.Success
}

func (res *ResCancelOrderVo) GetError() string {
	return res.Data.Error
}

type OrderData struct {
	Symbol 			string
	Amount 			float64
	Create_time 	*big.Int
	Price 			float64
	Avg_price 		float64
	Type 			string
	Order_id 		string
	Deal_amount 	float64
	Status 			int
}

type ResOrdersInfo struct {
	Result 		bool
	Error_code 	int
	Ts 			*big.Int
	Data 		[]OrderData
}

func (res *ResOrdersInfo) GetResult() bool {
	return res.Result
}

func (res *ResOrdersInfo) GetError_code() int {
	return res.Error_code
}

func (res *ResOrdersInfo) GetTs() *big.Int {
	return res.Ts
}

func (res *ResOrdersInfo) GetOrderData() []OrderData {
	return res.Data
}

func (resData *OrderData) GetSymbol() string {
	return resData.Symbol
}

func (resData *OrderData) GetAmount() float64 {
	return resData.Amount
}

func (resData *OrderData) GetCreate_time() *big.Int {
	return resData.Create_time
}

func (resData *OrderData) GetPrice() float64 {
	return resData.Price
}

func (resData *OrderData) GetAvg_price() float64 {
	return resData.Avg_price
}

func (resData *OrderData) GetType() string {
	return resData.Type
}

func (resData *OrderData) GetOrder_id() string {
	return resData.Order_id
}

func (resData *OrderData) GetDeal_amount() float64 {
	return resData.Deal_amount
}

func (resData *OrderData) GetStatus() int {
	return resData.Status
}