# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-12 13:44
# project name: project
# file name : AccountMan
from LBank.APIV2Excu import APIV2Excu


class AccountMan:
    def __init__(self):
        self.excuReq = APIV2Excu()

    def getUserInfo(self,**d):

        str = self.getUserInfo.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def genSubKey(self, **d):

        str = self.genSubKey.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def validDuration(self, **d):

        str = self.validDuration.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def closeSubKey(self, **d):

        str = self.validDuration.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def withdraw(self,**d):

        str = self.withdraw.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def cancelWithdraw(self,**d):

        str = self.withdraw.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )

    def withdrawList(self,**d):

        str = self.withdraw.__name__

        par = {}
        for key in d.keys():
            par[ key ] = d[ key ]

        self.excuReq.ExcuRequests( par, str )