# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-12 13:41
# project name: project
# file name : OrdersMan
from LBank.APIV2Excu import APIV2Excu


class Orders:
    '''orders management'''

    def __init__(self):

        self.excuReq=APIV2Excu()

    def createOrders(self,**d):

        str= self.createOrders.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)

    def batchCreateOrders(self,**d):

        str= self.batchCreateOrders.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)

    def cancelOrders(self,**d):
        str=self.cancelOrders.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)

    def getOrderInfo(self,**d):
        str=self.getOrderInfo.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests( par, str )

    def getHistOrderInfo(self,**d):
        str=self.getHistOrderInfo.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)

    def getTransDetail(self,**d):
        str=self.getTransDetail.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)


    def getHistTran(self,**d):
        str=self.getHistTran.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)


    def getOpenOrder(self,**d):
        str=self.getOpenOrder.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)

    def cancelClientOrders(self,**d):

        str=self.cancelClientOrders.__name__

        par={}
        for key in d.keys():
            par[key]=d[key]

        self.excuReq.ExcuRequests(par,str)
