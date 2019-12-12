# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-12 13:47
# project name: project
# file name : BaseConfigMan
from LBank.APIV2Excu import APIV2Excu


class MarketMan:
    def __init__(self):

        self.excuReq=APIV2Excu()

    def getTicker(self,**d):
        str = self.getTicker.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def getDepth(self,**d):
        str = self.getDepth.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def getIncrDepth(self,**d):
        str = self.getIncrDepth.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def getTrades(self,**d):
        str = self.getTrades.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def getKline(self,**d):
        str = self.getKline.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

