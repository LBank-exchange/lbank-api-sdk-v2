# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-09 11:39
# project name: project
# file name : demo
import datetime
import hashlib
import random
from base64 import b64encode

import requests as re

from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5


def buildNewSignV2(params,privKey,t):
    '''build the sign'''

    p = params

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


def excuteRequests(par,url,method,privKey):
    '''create orders'''

    randomstr = "".join( random.sample( 'abcdefghijklmnopqrstuvwxyz!@#$%^&*()', 35) )

    t = str( datetime.datetime.now().timestamp() * 1000 ).split( "." )[ 0 ]

    header={"Accept-Language": 'zh-CN', "signature_method": 'RSA','timestamp':t,'echostr':randomstr}

    par['echostr']=randomstr

    sign = buildNewSignV2(params=par,privKey=privKey,t=t )

    par[ 'sign' ] = sign

    # del par[ 'echostr' ]
    # del par[ 'timestamp' ]
    # del par[ 'signature_method' ]

    if method=='post':
        res=re.post(url=url,data=par,headers=header)
    else:
        res=re.get(url=url,params=par,headers=header)

    if res.status_code==200:
        resp=res.json()
        print(resp)
    else:
        print(res.status_code)

if __name__=="__main__":

    '''用户在使用的时候需要准备自己的私钥，参数，以及相关的要调用接口的url'''

    ##个人的私钥
    priveKey = '''-----BEGIN RSA PRIVATE KEY-----
            MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIpzwNXrsO8rZG0AMFeSylauopjX0XHgr+F/tac/yjYKsTmZr8xNyo7zYZnpxTjMwWtWGWgsSLRYztYenYTHqZCvNprYrfl6qX9ZYNMnUtX05V7qXF1+tBS2RG5lgO30nW+nEtKme9runcwN010eZMmZF2GHf54NJYSabBPwUlnlAgMBAAECgYBrjkDf7pklM7BwfRUQ8xf8/u2RjxdGQCZiJ7QWmZedI/FJrfrD3CrfonLP/qsX1PjtSZWzN7PDZrpH3MDBxdoTPz18nHvC4QqtZjAx021VXf1WkP1Z6Wz8dRPpj5E185P3Mvg4BKv8fhgnzV74pMOWBHhkf3Yn304E0CKVgatgAQJBAO69q1nrDmFIDMCej/AMQhHITowRfmuN1RAMZteky/WEHHLIR3jip50Q1e4vbD/QrUBHGJJYO+VFLCzdnTd5qaUCQQCUdg9iev86dXz4gmxjsJHmPNHdd964Ct18n3+SZDsS1yOKnqRLgbPUvs/2F8MnU50w/2KVHtGOGhby6N0yfHtBAkEAofi+eyfVPrzyIfCxuOuoG4Zpe/AWdAPq7JNtZppg4fY6ksk8bFBh5VbZvVohN/5svHI/wnHoWPkgKmREWLHLHQJAF3NOms+y4RkN1HNFi7moUiXpQIJeu9N7iOPo0sbiTeeNxaepbAPg1AoP719xhBTBD6xHdiaYE0ortdLynbbsAQJBAKMk5Rgqh0EcL4PgKsWZD6H9h+dmoCIjgnwTPsRwEYXeX6G0oJ0NYXp+/LeLByNnqSVF0r811aPIVA5e7v5MBc8=
            -----END RSA PRIVATE KEY-----'''
    ##params
    par={"symbol":'eth_usdt',"api_key":'a42ac959-7c40-4b76-ae68-562f0fd28deb',"type":"buy","price":134.77,"amount":1}
    ##被调用接口的url
    url='https://www.lbkex.net/v2/create_order.do'
    ###返回的response
    res=excuteRequests(par=par,url=url,method='post',privKey=priveKey)


