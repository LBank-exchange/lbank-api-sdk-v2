package apiservice

import (
	"encoding/json"
	"errors"
	"fmt"
	"github.com/google/uuid"
	"github.com/lbank-golang-api-sdk/common"
	"github.com/lbank-golang-api/libsignature"
	"io/ioutil"
	"net/http"
	"strconv"
	"strings"
	"time"
)

const GET_USER_INFO = "/v2/user_info.do"
const CREATE_ORDER  = "/v2/create_order.do"
const CANCEL_ORDER  = "/v2/cancel_order.do"
const ORDER_INFO	= "/v2/orders_info.do"

const SIGN_METHOD	  = "RSA"

var   BASE_URL 		string
var   API_KEY  		string
var   SECRET_KEY 	string

func cleanVariable(key1, key2, key3 *string) {
	*key1 = ""
	*key2 = ""
	*key3 = ""
}

func checkGlobalParams() (bool, error) {
	if BASE_URL == "" {
		return false, errors.New("BaseUrl not NULL, please using InitConfig function setting")
	}
	if API_KEY == "" {
		return false, errors.New("Api_key not NULL, please using InitConfig function setting")
	}
	if SECRET_KEY == "" {
		return false, errors.New("Secret_key not NULL, please using InitConfig function setting")
	}
	return true, nil
}

func InitConfig(baseUrl, api_key, secret_key string) error {
	if baseUrl == "" {
		return errors.New("The BaseUrl Not NULL")
	}
	if api_key == "" {
		return errors.New("The API_KEY Not NULL")
	}
	if secret_key == "" {
		return errors.New("The SECRET_KEY Not NULL")
	}
	cleanVariable(&BASE_URL, &API_KEY, &SECRET_KEY)
	BASE_URL = baseUrl
	API_KEY  = api_key
	SECRET_KEY = secret_key

	return nil
}

func getSign(secret string, params []string) (string, error) {
	if secret == "" {
		return "", errors.New("The Secret not NULL")
	}
	privateKey, err := libsignature.ParsePKCS1PrivateKey(libsignature.FormatPrivateKey(secret))
	if err != nil {
		return "", err
	}

	return libsignature.RSASign(libsignature.FormatStringBySign(params),privateKey), nil
}


/**
 * 获取用户账户资产信息
 *
 *
 */
func GetUserInfo( ) (string, error) {
	check, err := checkGlobalParams()
	if !check && err != nil {
		return "", err
	}

	var params []string
	var url = BASE_URL + GET_USER_INFO

	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)

	echostr, _ := uuid.NewRandom()

	params = append(params, "api_key=" + API_KEY, "echostr=" + echostr.String(), "timestamp=" + timestamp, "signature_method=" + SIGN_METHOD)
	sign, err := getSign(SECRET_KEY, params)
	if err != nil {
		return "", errors.New("The Signature error")
	}

	var r http.Request
	_ = r.ParseForm()
	r.Form.Add("api_key", API_KEY)
	r.Form.Add("signature_method", SIGN_METHOD)
	r.Form.Add("timestamp", timestamp)
	r.Form.Add("echostr", echostr.String())
	r.Form.Add("sign", sign)
	body := strings.NewReader(r.Form.Encode())
	client := http.Client{}
	response, err := client.Post(url,"application/x-www-form-urlencoded",body)
	if err != nil {
		panic(err)
	}
	content, err := ioutil.ReadAll(response.Body)
	if err != nil {
		panic("Response Body Decode Error")
	}

	//fmt.Println(fmt.Sprintf("response = %s", string(content)))

	return string(content), nil
}

/**
 * 下单
 *
 * @param _symbol 交易对
 * @param _typ   委托买卖类型buy/sell
 * @param _price  下单价格
 * @param _amount 交易数量
 * @param _customerId 自定义ID, 可以为空值
 * @return
 */
func CreateOrder(_symbol, _typ, _price, _amount, _customerId string)(*common.ResCreateOrderVo, error) {
	check, err := checkGlobalParams()
	if !check && err != nil {
		return nil, err
	}

	var params []string
	var url = BASE_URL + CREATE_ORDER

	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)

	echostr, _ := uuid.NewRandom()

	params = append(params, "api_key=" + API_KEY, "echostr=" + echostr.String(), "timestamp=" + timestamp, "signature_method=" + SIGN_METHOD, "symbol=" + _symbol, "type=" + _typ, "price=" + _price, "amount=" + _amount, "customer_id=" + _customerId)
	sign, err := getSign(SECRET_KEY,params)
	if err != nil {
		return nil, errors.New("The Signature error")
	}
	var r http.Request
	_ = r.ParseForm()
	r.Form.Add("api_key", API_KEY)
	r.Form.Add("signature_method", SIGN_METHOD)
	r.Form.Add("timestamp", timestamp)
	r.Form.Add("echostr", echostr.String())
	r.Form.Add("symbol", _symbol)
	r.Form.Add("type", _typ)
	r.Form.Add("price", _price)
	r.Form.Add("amount", _amount)
	r.Form.Add("customer_id", _customerId)
	r.Form.Add("sign", sign)
	body := strings.NewReader(r.Form.Encode())
	client := http.Client{}
	response, err := client.Post(url,"application/x-www-form-urlencoded",body)
	if err != nil {
		return nil, err
	}
	content, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return nil, err
	}

	fmt.Println(fmt.Sprintf("response = %s", string(content)))

	var result = new(common.ResCreateOrderVo)
	json.Unmarshal(content, result)

	return result, nil
}

/**
 * 撤销订单
 *
 * @param _symbol   交易对
 * @param _orderId  订单id
 * @return
 */
func CancelOrder(_symbol, _orderId string) (*common.ResCancelOrderVo, error){
	check, err := checkGlobalParams()
	if !check && err != nil {
		return nil, err
	}

	var params []string
	var url = BASE_URL + CANCEL_ORDER

	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)

	echostr, _ := uuid.NewRandom()

	params = append(params, "api_key=" + API_KEY, "echostr=" + echostr.String(), "timestamp=" + timestamp, "signature_method=" + SIGN_METHOD, "symbol=" + _symbol, "order_id=" + _orderId)
	sign, err := getSign(SECRET_KEY,params)
	if err != nil {
		return nil, errors.New("The Signature error")
	}
	var r http.Request
	_ = r.ParseForm()
	r.Form.Add("api_key", API_KEY)
	r.Form.Add("signature_method", SIGN_METHOD)
	r.Form.Add("timestamp", timestamp)
	r.Form.Add("echostr", echostr.String())
	r.Form.Add("symbol",_symbol)
	r.Form.Add("order_id",_orderId)
	r.Form.Add("sign", sign)
	body := strings.NewReader(r.Form.Encode())
	client := http.Client{}
	response, err := client.Post(url,"application/x-www-form-urlencoded",body)
	if err != nil {
		panic(err)
	}
	content, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return nil, err
	}

	fmt.Println(fmt.Sprintf("response = %s", string(content)))

	var result = new(common.ResCancelOrderVo)
	json.Unmarshal(content, result)

	return result, nil
}

/**
 * 查询订单
 *
 * @param _symbol   交易对
 * @param _orderId  订单id
 * @return
 */
func OrderInfo(_symbol, _orderId string) (*common.ResOrdersInfo, error) {
	check, err := checkGlobalParams()
	if !check && err != nil {
		return nil, err
	}

	var params []string
	var url = BASE_URL + ORDER_INFO

	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)

	echostr, _ := uuid.NewRandom()

	params = append(params, "api_key=" + API_KEY, "echostr=" + echostr.String(), "timestamp=" + timestamp, "signature_method=" + SIGN_METHOD, "symbol=" + _symbol, "order_id=" + _orderId)
	fmt.Println(params)
	sign, err := getSign(SECRET_KEY,params)
	if err != nil {
		return nil, errors.New("The Signature error")
	}
	var r http.Request
	_ = r.ParseForm()
	r.Form.Add("api_key", API_KEY)
	r.Form.Add("signature_method", SIGN_METHOD)
	r.Form.Add("timestamp", timestamp)
	r.Form.Add("echostr", echostr.String())
	r.Form.Add("symbol",_symbol)
	r.Form.Add("order_id",_orderId)
	r.Form.Add("sign", sign)
	body := strings.NewReader(r.Form.Encode())
	client := http.Client{}
	response, err := client.Post(url,"application/x-www-form-urlencoded",body)
	if err != nil {
		return nil, err
	}
	content, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return nil, err
	}

	fmt.Println(fmt.Sprintf("response = %s", string(content)))

	var result = new(common.ResOrdersInfo)
	json.Unmarshal(content, result)

	return result, nil
}