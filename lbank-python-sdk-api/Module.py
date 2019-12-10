# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 14:28
# project name: project
# file name : module
import os
from configparser import ConfigParser

from demo.ExcuHttp import ExcuHttp


class APIV2Excu:

    def __init__(self,):

        configfile=u'./config.ini'
        filePath=os.path.abspath(configfile)
        config = ConfigParser()
        config.read(filePath)

        self.apiKey=config.get("API","APIKEY")
        privKey=config.get("priveKey","PriveKey")
        self.privKey="-----BEGIN RSA PRIVATE KEY-----\n"+privKey+"\n-----END RSA PRIVATE KEY-----"
        print(self.privKey)
        self.excuReq=ExcuHttp()

    def UserInfo(self,par):

        url=u'/v2/user_info.do'
        method='post'
        par["api_key"]=self.apiKey
        self.excuReq.excuteRequests(par=par,url=url,method=method,privKey=self.privKey)



