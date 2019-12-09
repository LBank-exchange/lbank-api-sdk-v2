package com.lbank.java.api.sdk.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author steel.cheng
 */
public class LBankJavaApiSdkUtil {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * 根据参数加密
     *
     * @param str
     * @param apiKey
     * @param secretKey
     * @return
     */
    public static String getSign(String str, String apiKey,String secretKey) {
        StringBuffer buffer = new StringBuffer();
        String result = null;
        if (StringUtils.isNoneBlank(str)) {
            str = str + "&api_key=" + apiKey;
            String[] split = StringUtils.split(str, "&");
            Arrays.sort(split);
            for (int i = 0; i < split.length; i++) {
                buffer.append(split[i]).append("&");
            }
            result = buffer.toString();
            result = result.substring(0,result.length()-1);
        } else {
        	result = buffer.append("api_key=").append(apiKey).toString();
        }
        //MD5后大写字母
        StringBuilder sign = new StringBuilder(DigestUtils.md5Hex(result).toUpperCase());
        return  RSAUtil.sign(sign.toString(),secretKey);
    }
}
