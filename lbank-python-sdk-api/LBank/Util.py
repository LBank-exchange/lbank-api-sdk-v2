# -*- coding:utf-8 -*-
# Author: yongli.luo
# Date: 2019-12-10 16:15
# project name: project
# file name : util
import hashlib
import hmac
from base64 import b64encode

from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_v1_5


class Util:

    def buildRSASignV2(self, params, privKey, t):
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

    def buildHmacSHA256(self,params,secrtkey,t):
        '''build the signature of the HmacSHA256'''

        p = params
        p[ "timestamp" ] = t
        p[ "signature_method" ] = 'HmacSHA256'
        par = [ ]
        for k in sorted( p.keys() ):
            par.append( k + '=' + str( p[ k ] ) )
        par = '&'.join( par )
        msg = hashlib.md5( par.encode( "utf8" ) ).hexdigest().upper()

        appsecret = bytes(secrtkey, encoding='utf8' )
        data=bytes(msg,encoding='utf8')
        signature=hmac.new(appsecret,data,digestmod=hashlib.sha256).hexdigest().lower()

        return signature

