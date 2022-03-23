package constant

type Config struct {
	//Rest API地址
	Endpoint string
	//websocket API地址
	WSEndpoint string

	//API key
	ApiKey string
	//密钥
	SecretKey string

	//签名方法
	SignatureMethod string

	//http请求超时
	TimeoutSecond int
	//打印API信息
	IsPrint bool
}

//需要初始化时填写相关的配置选项
func InitConfig() *Config {
	return &Config{
		Endpoint:        LBANK_REST_API_ENDPOINT,
		WSEndpoint:      LBANK_WS_ENDPOINT,
		SignatureMethod: LBANK_SIGN_METH,
		ApiKey:          LBANK_REST_API_KEY,
		SecretKey:       LBANK_REST_API_SECRETKEY,
		IsPrint:         LBANK_IS_PRINT_REQUEST,
	}
}
