# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-07-10 13:34
# project name: project
# file name : TestWebsocket
import configparser
import time
from json import dumps

from LBank.AccountMan import AccountMan


import websocket as ws


class WebSocket():
    '''websocket management'''

    def __init__(self):

        configfile=u'./constant.ini'

        cfg = configparser.ConfigParser()

        cfg.read(configfile)
        self.url = cfg.get("WEBSOCKET", "url")

        self.apikey=cfg.get("API","APIKEY")

        self.accountman=AccountMan()

        self.resultfileDepthtxt = './websocketDepth.txt'

    def websocketOrderUpdation(self,*data):
        '''subscribe the order updation for pair'''

        s=ws.create_connection(self.url)

        subkey=self.accountman.genSubKey()
        pair=data[0]
        par={
            "action": "subscribe",
            "subscribe": "orderUpdate",
            "subscribeKey":subkey,
            "pair": pair,
        }

        data=dumps(par)
        t=time.ctime()
        print("Start to subscribe the order updation")
        s.send(data)
        i=0
        with open(self.resultfileDepthtxt,'a') as f:
            f.writelines("Start to receiving the order updation data at {}".format(t))
            while True:
                i+=1
                if i % 2 ==0:
                    t1=time.ctime()
                    r = s.recv()
                    print("get the order updation data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the order updation data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")
                if i % 300 ==0:
                    self.accountman.refreshKey(subkey)

    def websocketTrade(self,*data):

        s = ws.create_connection(self.url)
        pair=data[0]

        par = {'action': 'subscribe', 'subscribe': 'trade', 'pair': pair}
        data = dumps(par)
        t = time.ctime()
        print("Start to subscribe the trade for {}".format(pair))
        s.send(data)
        i = 0
        with open(self.resultfileDepthtxt, 'a') as f:
            f.writelines("Start to receiving the trade data at {}".format(t))
            while True:
                i += 1
                if i % 2 == 0:
                    t1 = time.ctime()
                    r = s.recv()
                    print("get the trade data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the trade data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")

    def websocketKbar(self,*data):

        s = ws.create_connection(self.url)

        kbarmin=data[0]
        pair=data[1]

        par={
            "action": "subscribe",
            "subscribe": "kbar",
            "kbar": kbarmin,
            "pair": pair
        }
        data = dumps(par)
        t = time.ctime()
        print("Start to subscribe the kbar for {}".format(pair))
        s.send(data)
        i = 0
        with open(self.resultfileDepthtxt, 'a') as f:
            f.writelines("Start to receiving the kbar data at {}".format(t))
            while True:
                i += 1
                if i % 2 == 0:
                    t1 = time.ctime()
                    r = s.recv()
                    print("get the kbar data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the kbar data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")

    def websocketIncreDepth(self, *data):



        s = ws.create_connection(self.url)


        depth=data[0]
        pair=data[1]

        par={"action": "subscribe", "subscribe": "incrdepth", "depth": depth, "pair": pair}
        data = dumps(par)
        t = time.ctime()
        print("Start to subscribe the depth for {}".format(pair))
        s.send(data)
        i = 0
        with open(self.resultfileDepthtxt, 'a') as f:
            f.writelines("Start to receiving the depth data at {}".format(t))
            while True:
                i += 1
                if i % 1 == 0:
                    t1 = time.ctime()
                    r = s.recv()
                    print("get the depth data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the depth data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")
                # if i % 30 == 0:
                #     self.refreshSubKey()

    def websocketDepth(self, *data):

        s = ws.create_connection(self.url)

        depth=data[0]
        pair=data[1]

        par={"action": "subscribe", "subscribe": "depth", "depth": depth, "pair": pair}
        data = dumps(par)
        t = time.ctime()
        print("Start to subscribe the depth for {}".format(pair))
        s.send(data)
        i = 0
        with open(self.resultfileDepthtxt, 'a') as f:
            f.writelines("Start to receiving the depth data at {}".format(t))
            while True:
                i += 1
                if i % 2 == 0:
                    t1 = time.ctime()
                    r = s.recv()
                    print("get the depth data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the depth data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")



    def webSocketTicker(self, *data):

        s = ws.create_connection(self.url)


        pair=data[0]

        par={"action": "subscribe", "subscribe": "tick", "pair": pair}

        data = dumps(par)
        t = time.ctime()
        print("Start to subscribe the ticker for {}".format(pair))
        s.send(data)
        i = 0
        with open(self.resultfileDepthtxt, 'a') as f:
            f.writelines("Start to receiving the ticker data at {}".format(t))
            while True:
                i += 1
                if i % 2 == 0:
                    t1 = time.ctime()
                    r = s.recv()
                    print("get the ticker data at {}".format(t1))
                    print(r)
                    print("\n")
                    f.writelines("get the ticker data at {}".format(t1))
                    f.writelines(r)
                    f.write("\n")

if __name__=='__main__':

    websocket=WebSocket()
    websocket.websocketOrderUpdation('eth_usdt')

