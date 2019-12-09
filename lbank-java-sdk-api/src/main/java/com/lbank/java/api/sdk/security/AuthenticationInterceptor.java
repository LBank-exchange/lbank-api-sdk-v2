package com.lbank.java.api.sdk.security;

import com.lbank.java.api.sdk.util.LBankJavaApiSdkUtil;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Description:Http请求参数认证拦截处理
 * @return
 * @Author: steel.cheng
 * @Date: 2019/9/4-10:34 AM
 * @Version: 1.0
 */
public class AuthenticationInterceptor implements Interceptor {
    /**
     *
     * 用户apikey
     *
     */
    private final String apiKey;

    /**
     * 用户私钥
     */
    private final String secret;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * Description:处理请求参数
     * @param chain
     * @return 
     * @Author: steel.cheng
     * @Date: 2019/9/4-10:36 AM
     * @Version: 1.0
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Long times = System.currentTimeMillis();
        //System.out.println(times);
        Request original = chain.request();
        String uuid = UUID.randomUUID().toString();
        //请求头Header增加三个固定参数，时间戳和签名方式和随机数（长度在30-40之间）
        Request.Builder newRequestBuilder = original.newBuilder().
                addHeader("timestamp",times+"").
                addHeader("echostr",uuid).
                addHeader("signature_method","RSA");

        System.out.println(times);
        //参数拦截器只在非get请求中添加
        String method = original.method();
        if (StringUtils.equals("GET", method)) {
            return chain.proceed(original);
        }
        //加密请求参数获取数字签名
        String payload = original.url().query();
        //assetCode=eth&status=1&pageNo=1&pageSize=10
        //System.out.println("payload:"+payload);

        StringBuffer buffer = null;
        //v2版本新增参数 timestamp/signature_method
        if(StringUtils.isBlank(payload)) {
            buffer = new StringBuffer();
            buffer.append("timestamp=" + times);
        }else {
            buffer = new StringBuffer(payload);
            buffer.append("&timestamp=" + times);
        }
        buffer.append("&signature_method=RSA&echostr="+uuid);

        String sign = LBankJavaApiSdkUtil.getSign(buffer.toString(),apiKey,secret);

        HttpUrl signedUrl = original.url().newBuilder().
                addQueryParameter("api_key", apiKey).
                addQueryParameter("sign", sign).build();
        newRequestBuilder.url(signedUrl);
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }
}