package utils

import (
	"crypto/hmac"
	"crypto/md5"
	"crypto/sha256"
	"encoding/hex"
	"strings"
)

func HmacSha256Base64Signer(message string, secretKey string) (string, error) {
	//对参数使用MD5进行签名运算
	md5Hash := md5.Sum([]byte(message))
	//转换小写字母为大写
	md5String := strings.ToUpper(hex.EncodeToString(md5Hash[:]))

	mac := hmac.New(sha256.New, []byte(secretKey))
	_, err := mac.Write([]byte(md5String))
	if err != nil {
		return "", err
	}

	return hex.EncodeToString(mac.Sum(nil)), nil
}