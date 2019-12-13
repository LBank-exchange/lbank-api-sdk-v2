package module

import (
	"fmt"
	"github.com/google/uuid"
	"github.com/gorilla/websocket"
	"github.com/lbank-go-sdk-api/constant"
	"log"
	"os"
	"os/signal"
	"runtime/debug"
	"strings"
	"sync"
	"syscall"
	"time"
)

type LbankWSAgent struct {
	baseUrl 		string
	config 			*constant.Config
	conn 			*websocket.Conn

	wsResponse 		chan interface{}

	stopCh   chan interface{}
	errCh    chan error
	signalCh chan os.Signal

	//subMap         map[string][]ReceivedDataCallback
	activeChannels map[string]bool

	processMut sync.Mutex
}

func (lbank *LbankWSAgent) Start( ) error {
	config := constant.InitConfig()
	endpoint := config.WSEndpoint
	if strings.HasSuffix(config.Endpoint, "/") {
		endpoint = config.Endpoint[0 : len(config.Endpoint)-1]
	}
	lbank.baseUrl = endpoint + constant.WEBSOCKET_VERSION
	lbank.config = config
	log.Printf("Connecting to %s", lbank.baseUrl)
	c, _, err := websocket.DefaultDialer.Dial(lbank.baseUrl, nil)
	if err != nil {
		log.Fatalf("dial: %+v", err)
		return err
	} else {
		if lbank.config.IsPrint {
			log.Printf("Connected to %s", lbank.baseUrl)
		}
		lbank.conn = c

		lbank.wsResponse = make(chan interface{})

		lbank.errCh = make(chan error)
		lbank.stopCh = make(chan interface{}, 16)
		lbank.signalCh = make(chan os.Signal)
		lbank.activeChannels = make(map[string]bool)

		signal.Notify(lbank.signalCh, syscall.SIGHUP, syscall.SIGINT, syscall.SIGTERM, syscall.SIGQUIT)

		go lbank.work()
		go lbank.receive()
		go lbank.finalize()
	}

	return nil
}

func (lbank *LbankWSAgent) work() {
	defer func() {
		a := recover()
		log.Printf("Work End. Recover msg: %+v", a)
		debug.PrintStack()
	}()

	defer lbank.Stop()

	ticker := time.NewTicker(30 * time.Second)
	defer ticker.Stop()

	for {
		select {
		case <-ticker.C:
			lbank.keepalive()
		case rsp := <- lbank.wsResponse:
			lbank.HandleResponse(rsp)
		case <-lbank.stopCh:
			return

		}
	}
}

func (lbank *LbankWSAgent) receive() {
	defer func() {
		a := recover()
		if a != nil {
			log.Printf("Receive End. Recover msg: %+v", a)
			debug.PrintStack()
		}
	}()
	for {
		messageType, message, err := lbank.conn.ReadMessage()
		if err != nil {
			lbank.errCh <- err
			break
		}

		txtMsg := message
		switch messageType {
		case websocket.TextMessage:
		case websocket.BinaryMessage:
			break
		case websocket.PingMessage:
			if err := lbank.conn.WriteMessage(websocket.PongMessage, []byte(LoadPingResponse(txtMsg))); err != nil {
				break
			}
		}

		rsp, err := LoadResponse(txtMsg)
		if rsp != nil {
			if lbank.config.IsPrint {
				log.Printf("LoadedRep: %+v, err: %+v", rsp, err)
			}
		} else {
			log.Printf("TextMsg: %s", txtMsg)
		}
		if err != nil {
			fmt.Println(err)
			break
		}

		switch rsp.(type) {
		case string :
			break
		case interface{}:
			lbank.wsResponse <- rsp
		}
	}
}

func (lbank *LbankWSAgent) finalize() error {
	defer func() {
		log.Printf("Finalize End. Connection to WebSocket is closed.")
	}()

	select {
	case <-lbank.stopCh:
		if lbank.conn != nil {
			close(lbank.errCh)
			close(lbank.wsResponse)
			return lbank.conn.Close()
		}
	}

	return nil
}

func (lbank *LbankWSAgent)Subscribe(message string) error {
	lbank.processMut.Lock()
	defer lbank.processMut.Unlock()

	if lbank.config.IsPrint {
		log.Printf("Send Msg: %s", message)
	}
	if err := lbank.conn.WriteMessage(websocket.TextMessage, []byte(message)); err != nil {
		return err
	}

	return nil
}


func (lbank *LbankWSAgent) keepalive() {
	lbank.Ping()
}

func (lbank *LbankWSAgent) Stop() error {
	defer func() {
		a := recover()
		log.Printf("Stop End. Recover msg: %+v", a)
	}()

	close(lbank.stopCh)
	return nil
}

func (lbank *LbankWSAgent) Ping() {
	randId, _ := uuid.NewRandom()
	msg := PingMessage {
		Action:"ping",
		Ping:randId.String(),
	}
	log.Printf("Send Msg: %s", msg)
	lbank.conn.WriteMessage(websocket.TextMessage, []byte(StructToJsonString(msg)))
}

//返回响应处理
func (lbank *LbankWSAgent) HandleResponse(rsp interface{}) error {
	log.Println("结果：=", rsp)
	return nil
}