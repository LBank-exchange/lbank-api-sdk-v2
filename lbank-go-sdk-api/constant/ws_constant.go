package constant

import "errors"

const (
	SUBSCRIBE_KBAR 		= "kbar"
	SUBSCRIBE_TICK 		= "tick"
	SUBSCRIBE_DEPTH 	= "depth"
	SUBSCRIBE_TRADE     = "trade"

	SUBSCRIBE_ORDER_UPDATE = "orderUpdate"

	WEBSOCKET_VERSION  = "/ws/V3/"
)

var (
	ERR_WS_SUBSCRIOTION_PARAMS = errors.New(`ws subscription parameter error`)
	ERR_WS_CACHE_NOT_MATCH     = errors.New(`ws hot cache not matched`)
)
