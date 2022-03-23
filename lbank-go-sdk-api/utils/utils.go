package utils

import (
	"encoding/json"
	"github.com/lbank-go-sdk-api/constant"
	"net/http"
	"strconv"
	"time"
)

//HTTP请求头
func Headers(request *http.Request, signmethod, timestamp, echostr string) {
	request.Header.Set(constant.CONTENT_TYPE, constant.APPLICATION_URLENCODE)
	request.Header.Add(constant.SIGNATURE_METHOD, signmethod)
	request.Header.Add(constant.TIME_STAMP, timestamp)
	request.Header.Add(constant.ECHOSTR, echostr)
}

//配置检查
func CheckConfig(config *constant.Config) bool {
	if config.SecretKey == "" || config.ApiKey == "" || config.SignatureMethod == "" {
		return false
	}
	if config.Endpoint == "" && config.WSEndpoint == "" {
		return false
	}
	return true
}

func CheckTimeAndEchostr(params map[string]string) bool {
	if _, ok := params[constant.TIME_STAMP]; !ok {
		return false
	}
	if _, ok := params[constant.ECHOSTR]; !ok {
		return false
	}
	return true
}

//参数构建
func SignParams(params map[string]string, sigmethod string) []string {
	var result []string
	result = append(result, constant.SIGNATURE_METHOD+"="+sigmethod)
	for key, value := range params {
		result = append(result, key+"="+value)
	}
	return result
}

//常用方法
func IntToString(arg int) string {
	return strconv.Itoa(arg)
}

func JsonBytes2Struct(jsonBytes []byte, result interface{}) error {
	err := json.Unmarshal(jsonBytes, result)
	return err
}

func IsoTime() string {
	utcTime := time.Now().UTC()
	iso := utcTime.String()
	isoBytes := []byte(iso)
	iso = string(isoBytes[:10]) + "T" + string(isoBytes[11:23]) + "Z"
	return iso
}
