# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 14:33
# project name: project
# file name : ExcuHttp

import datetime
import hashlib
import random
from base64 import b64encode
from configparser import ConfigParser
import requests as req
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5


class ExcuHttp:

    def __init__(self):

        configfile=u'./config.ini'

        cfg=ConfigParser()
        cfg.read(configfile)

        self.host=cfg.get("BASE","host")
        # self.port=cfg.get("BASE","port")
        # if self.port==80:
        #     self.baseUrl=self.host
        # else:
        #     self.baseUrl=self.host+":"+self.port
        self.baseUrl=self.host

    def buildNewSignV2( self,params, privKey, t):
        '''build the sign'''

        p=params
        p[ "timestamp" ] = t
        p[ "signature_method" ] = 'RSA'
        par = [ ]
        for k in sorted( p.keys() ):
            par.append( k + '=' + str( p[ k ] ) )
        par = '&'.join( par )
        msg = hashlib.md5( par.encode( "utf8" ) ).hexdigest().upper()
        key = RSA.importKey( privKey )
        signer = PKCS1_v1_5.new( key )
        digest = SHA256.new()
        digest.update( msg.encode( 'utf8' ) )
        sig1 = signer.sign( digest )
        sig = b64encode( sig1 )
        return sig

    def excuteRequests(self,par,url, method, privKey):
        '''execute requests'''
        urlstr=self.baseUrl+url

        randomstr = "".join( random.sample( 'abcdefghijklmnopqrstuvwxyz!@#$%^&*()', 35 ) )

        t = str( datetime.datetime.now().timestamp() * 1000 ).split( "." )[ 0 ]

        header = {"Accept-Language": 'zh-CN', "signature_method": 'RSA', 'timestamp': t, 'echostr': randomstr}

        par['echostr'] = randomstr

        sign = self.buildNewSignV2( params=par, privKey=privKey, t=t )

        par[ 'sign' ] = sign

        # del par[ 'echostr' ]
        # del par[ 'timestamp' ]
        # del par[ 'signature_method' ]

        if method == 'post':
            res = req.post( url=urlstr, data=par, headers=header )
        else:
            res = req.get( url=urlstr, params=par, headers=header )

        if res.status_code == 200:
            resp = res.json()
            print( resp )
        else:
            print( res.status_code )


