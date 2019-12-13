package utils

import (
	"bytes"
	"crypto"
	"crypto/md5"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha256"
	"crypto/x509"
	"encoding/base64"
	"encoding/hex"
	"encoding/pem"
	"errors"
	"sort"
	"strings"
)

//格式化输入密钥
func FormatPrivateKey(raw string) (result []byte) {
	return formatKey(raw, "-----BEGIN RSA PRIVATE KEY-----", "-----END RSA PRIVATE KEY-----")
}

func formatKey(raw, prefix, suffix string) (result []byte) {
	if raw == "" {
		return nil
	}
	raw = strings.Replace(raw, prefix, "", 1)
	raw = strings.Replace(raw, suffix, "", 1)
	raw = strings.Replace(raw, " ", "", -1)
	raw = strings.Replace(raw, "\n", "", -1)
	raw = strings.Replace(raw, "\r", "", -1)
	raw = strings.Replace(raw, "\t", "", -1)

	var ll = 64
	var sl = len(raw)
	var c = sl / ll
	if sl%ll > 0 {
		c = c + 1
	}

	var buf bytes.Buffer
	buf.WriteString(prefix + "\n")
	for i := 0; i < c; i++ {
		var b = i * ll
		var e = b + ll
		if e > sl {
			buf.WriteString(raw[b:])
		} else {
			buf.WriteString(raw[b:e])
		}
		buf.WriteString("\n")
	}
	buf.WriteString(suffix)
	return buf.Bytes()
}

//获取用户密钥
func ParsePKCS1PrivateKey(data []byte) ( *rsa.PrivateKey,  error) {
	var block *pem.Block
	block, _ = pem.Decode(data)
	if block == nil {
		return nil, errors.New("private key error")
	}

	privateKey, err := x509.ParsePKCS8PrivateKey(block.Bytes)
	if err != nil {
		return nil, err
	}

	return privateKey.(*rsa.PrivateKey), err
}

func RSASign( params string, privateKey *rsa.PrivateKey ) string {
	//对参数使用MD5进行签名运算
	md5Hash := md5.Sum([]byte(params))
	//转换小写字母为大写
	md5String := strings.ToUpper(hex.EncodeToString(md5Hash[:]))

	//对参数进行sha256运算
	paramsSha256 := sha256.New()
	paramsSha256.Write([]byte(md5String))
	sha256Hash := paramsSha256.Sum(nil)

	//使用rsa私钥进行签名
	sigMsg, err := rsa.SignPKCS1v15(rand.Reader, privateKey, crypto.SHA256, sha256Hash)
	if err != nil {
		panic(err)
	}

	return base64.StdEncoding.EncodeToString(sigMsg)
}

//生成签名字符串
func FormatStringBySign(params []string) string {
	var result string
	//对字符串进行排序
	sort.Strings(params)
	//组合参数字符串
	result = strings.Join(params,"&")

	return result
}

func GetSign(secret string, params []string) (string ,error) {
	if secret == "" {
		return "", errors.New("The Secret not NULL")
	}
	privateKey, err := ParsePKCS1PrivateKey(FormatPrivateKey(secret))
	if err != nil {
		return "", err
	}

	return RSASign(FormatStringBySign(params),privateKey), nil
}
