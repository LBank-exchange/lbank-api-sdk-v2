package constant



const (
	//需要填写的配置项：
	LBANK_REST_API_ENDPOINT    = "https://www.lbkex.net"
	LBANK_WS_ENDPOINT          = "wss://www.lbkex.net"
	LBANK_REST_API_KEY         = ""
	LBANK_REST_API_SECRETKEY   = ""
	LBANK_IS_PRINT_REQUEST     = false

	//签名方法，默认采用RSA签名算法
	LBANK_SIGN_METH 		   = LBANK_RSA_SIGN_METHOD
	//LBANK_SIGN_METH			   = LBANK_SHA256_SIGN_METHOD
)
