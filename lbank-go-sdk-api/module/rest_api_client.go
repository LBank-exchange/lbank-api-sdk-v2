package module

import (
	"errors"
	"fmt"
	"github.com/google/uuid"
	"github.com/lbank-go-sdk-api/constant"
	"github.com/lbank-go-sdk-api/utils"
	"io/ioutil"
	"net/http"
	"net/url"
	"strconv"
	"strings"
	"time"
)

type Client struct {
	Config 		constant.Config
	HttpClient 	*http.Client
}

type ApiMessage struct {
	Code 		int 	`json:"code"`
	Message     string 	`json:"message"`
}


//获取新客户端
func NewLbankClient( ) *Client {
	var client Client
	config := constant.InitConfig()
	client.Config = *config
	timeout := config.TimeoutSecond
	if timeout <= 0 {
		timeout = 30
	}
	client.HttpClient = &http.Client{
		Timeout: time.Duration(timeout) * time.Second,
	}
	return &client
}

//发送请求
//params 包含：timestamp 和 echostr参数
func (client *Client) Request(method string, requestPath string,
	params map[string]string, result interface{}) (response *http.Response, err error) {

	var _url string
	config := client.Config
	if !utils.CheckConfig(&config) {
		return nil, errors.New("the config error")
	}
	endpoint := config.Endpoint
	if strings.HasSuffix(config.Endpoint, "/") {
		endpoint = config.Endpoint[0 : len(config.Endpoint)-1]
	}
	_url = endpoint + requestPath
	request, err := http.NewRequest(method, _url, nil)
	if err != nil {
		return response, err
	}

	if !utils.CheckTimeAndEchostr(params) {
		return nil, errors.New("timestamp or echostr null")
	}
	utils.Headers(request, client.Config.SignatureMethod, params[constant.TIME_STAMP], params[constant.ECHOSTR])

	response, err = client.HttpClient.Do(request)
	if err != nil {
		return response, err
	}
	defer response.Body.Close()

	// get a response results and parse
	status := response.StatusCode
	message := response.Status
	body, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return response, err
	}

	if config.IsPrint {
		printResponse(status, message, body)
	}

	responseBodyString := string(body)

	if status >= 200 && status < 300 {
		if body != nil && result != nil {
			err := utils.JsonBytes2Struct(body, result)
			if err != nil {
				return response, err
			}
		}
		return response, nil
	} else if status >= 400 || status <= 500 {
		errMsg := "Http error(400~500) result: status=" + utils.IntToString(status) + ", message=" + message + ", body=" + responseBodyString
		fmt.Println(errMsg)
		if body != nil {
			err := errors.New(errMsg)
			return response, err
		}
	} else {
		fmt.Println("Http error result: status=" + utils.IntToString(status) + ", message=" + message + ", body=" + responseBodyString)
		return response, errors.New(message)
	}
	return response, nil
}

func printRequest(config constant.Config, request *http.Request, body string, preHash string) {
	if config.SecretKey != "" {
		fmt.Println("  Secret-Key: " + config.SecretKey)
	}
	fmt.Println("  Request("  + utils.IsoTime() + "):")
	fmt.Println("\tUrl: " + request.URL.String())
	fmt.Println("\tMethod: " + strings.ToUpper(request.Method))
	if len(request.Header) > 0 {
		fmt.Println("\tHeaders: ")
		for k, v := range request.Header {
			if strings.Contains(k, "Ok-") {
				k = strings.ToUpper(k)
			}
			fmt.Println("\t\t" + k + ": " + v[0])
		}
	}
	fmt.Println("\tBody: " + body)
	if preHash != "" {
		fmt.Println("  PreHash: " + preHash)
	}
}

func printResponse(status int, message string, body []byte) {
	fmt.Println("\tResponse(" + utils.IsoTime() + "):")
	statusString := strconv.Itoa(status)
	message = strings.Replace(message, statusString, "", -1)
	message = strings.Trim(message, " ")
	fmt.Println("\tStatus: " + statusString)
	fmt.Println("\tMessage: " + message)
	fmt.Println("\tBody: " + string(body))
}

func (client *Client) BuildParams(requestPath string, params map[string]string) string {
	urlParams := url.Values{}
	for k, v := range params {
		urlParams.Add(k, v)
	}
	return requestPath + "?" + urlParams.Encode()
}

func (client *Client)CombineGETParams(paramsInfo *map[string]string) (map[string]string, error) {
	var result = make(map[string]string)
	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)
	var echostr string
	tmpStr, _ := uuid.NewRandom()
	echostr = tmpStr.String()
	//返回签名请求头包含参数
	result[constant.TIME_STAMP] = timestamp
	result[constant.ECHOSTR]    = echostr
	return result, nil
}

func (client *Client)CombinePOSTParams(paramsInfo *map[string]string) (map[string]string, error) {
	var result = make(map[string]string)

	(*paramsInfo)[constant.API_KEY] = client.Config.ApiKey

	tmp := time.Now().UnixNano() / 1000000
	timestamp := strconv.FormatUint(uint64(tmp), 10)
	apiParams := utils.SignParams(*paramsInfo, client.Config.SignatureMethod)
	apiParams = append(apiParams, constant.TIME_STAMP + "=" + timestamp)

	var echostr string
	var tmpEcho string
	tmpStr, _ := uuid.NewRandom()
	tmpEcho = tmpStr.String()
	echostr = strings.Replace(tmpEcho, "-", strconv.Itoa(rand.Int()%10), -1)

	apiParams = append(apiParams, constant.ECHOSTR + "=" + echostr)
	var sign string
	var err error
	if client.Config.SignatureMethod == constant.LBANK_RSA_SIGN_METHOD {
		sign, err = utils.GetSign(client.Config.SecretKey, apiParams)
		if err != nil {
			return nil, errors.New("signature error")
		}
	} else if client.Config.SignatureMethod == constant.LBANK_SHA256_SIGN_METHOD {
		sign, err = utils.HmacSha256Base64Signer(utils.FormatStringBySign(apiParams), client.Config.SecretKey)
		if err != nil {
			return nil, errors.New("signature error")
		}
	} else {
		return nil, errors.New("the signature method not found")
	}

	(*paramsInfo)[constant.SIGN] = sign

	//返回签名请求头包含参数
	result[constant.TIME_STAMP] = timestamp
	result[constant.ECHOSTR]    = echostr
	return result, nil
}
