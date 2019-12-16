# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 14:28
# project name: project
# file name : module
import os
from configparser import ConfigParser

from LBank.client import client


class APIV2Excu:

    def __init__(self):

        configfile=u'./constant.ini'
        filePath=os.path.abspath(configfile)
        self.config = ConfigParser()
        self.config.read(filePath)

        self.apiKey=self.config.get("API","APIKEY")
        self.secrtkey=self.config.get("API","SECRTKEY")
        privKey=self.config.get("priveKey","PriveKey")
        self.privKey="-----BEGIN RSA PRIVATE KEY-----\n"+privKey+"\n-----END RSA PRIVATE KEY-----"
        # print(self.privKey)
        self.signMethod=self.config.get("SIGNMETHOD","signmethod")
        self.excuReq=client()

    def ExcuRequests(self,par,str):
        url,me=self.config.get("URL",str).split(",")
        par["api_key"]=self.apiKey
        if self.signMethod=='RSA':
            res=self.excuReq.excuteRequestsRSA( par=par, url=url, method=me, privKey=self.privKey )
        else:
            res=self.excuReq.excuteRequestsHmac(par=par,url=url,method=me,secrtkey=self.secrtkey)
        return res
















