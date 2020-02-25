package com.lbank.java.api.sdk.security;

import com.lbank.java.api.sdk.constant.Contant;
import com.lbank.java.api.sdk.utils.SdkUtil;
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
 *
 * @return
 * @Author: steel.cheng
 * @Date: 2019/9/4-10:34 AM
 * @Version: 1.0
 */
public class AuthenticationInterceptor implements Interceptor {
    /**
     * 用户apikey
     */
    private final String apiKey;

    /**
     * 用户私钥
     */
    private final String secret;

    private final String method;

    public AuthenticationInterceptor(String apiKey, String secret, String method) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.method = method;
    }

    /**
     * Description:处理请求参数
     *
     * @param chain
     * @return
     * @Author: steel.cheng
     * @Date: 2019/9/4-10:36 AM
     * @Version: 1.0
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Long times = System.currentTimeMillis();

        Request original = chain.request();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //请求头Header增加三个固定参数，时间戳和签名方式和随机数（长度在30-40之间）
        Request.Builder newRequestBuilder = original.newBuilder().
                addHeader("timestamp", times + "").
                addHeader("echostr", uuid).
                addHeader("signature_method", method);

        System.out.println(times);
        //参数拦截器只在非get请求中添加
        String oriMethod = original.method();
        if (StringUtils.equals("GET", oriMethod)) {
            return chain.proceed(original);
        }
        String sign = "";
        //加密请求参数获取数字签名
        String payload = original.url().query();

        StringBuffer buffer = null;
        //v2版本新增参数 timestamp/signature_method
        if (StringUtils.isBlank(payload)) {
            buffer = new StringBuffer();
            buffer.append("timestamp=" + times);
        } else {
            buffer = new StringBuffer(payload);
            buffer.append("&timestamp=" + times);
        }
        buffer.append("&echostr=" + uuid);
        buffer.append("&signature_method=" + method);
        if (StringUtils.equalsIgnoreCase(method, Contant.SIGN_METHODS_RSA)) {
            sign = SdkUtil.getSignForRSA(buffer.toString(), apiKey, secret);
        } else if (StringUtils.equalsIgnoreCase(method, Contant.SIGN_METHODS_SHA256)) {
            sign = SdkUtil.getSignForHmacsha256(buffer.toString(), apiKey, secret);
        }
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
                Objects.equals(secret, that.secret) &&
                Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret, method);
    }
}