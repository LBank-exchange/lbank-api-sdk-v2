package com.lbank.java.api.sdk.util;


import org.apache.commons.lang3.CharEncoding;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by cong.peng on 2018/8/13.
 */
public class RSAUtil {

    private static String RSA = "RSA";
    private static final int key_size = 1024;
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String RSA_SIGNATURE = "SHA256WithRSA";

    private RSAUtil() {
    }

    @SuppressWarnings("unused")
	private static KeyPair generateRsaKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(key_size);
        java.security.KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        byte[] publicKeyBytes = publicKey.getEncoded();
        String pub =  Base64.getEncoder().encodeToString(publicKeyBytes);
        Key privateKey = keyPair.getPrivate();
        byte[] privateBytes = privateKey.getEncoded();
        String pri = Base64.getEncoder().encodeToString(privateBytes);
        KeyPair newKeyPair = new KeyPair();
        newKeyPair.setPrivateKey(pri);
        newKeyPair.setPublicKey(pub);
        return newKeyPair;
    }

    private static class KeyPair {
        private String publicKey;
        private String privateKey;

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }
    }

    private static PublicKey getPublicKey(String key) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    private static PrivateKey getPrivateKey(String key) {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
        PrivateKey privateKey = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    /**
     * 公钥加密
     *
     * @param source
     * @param publicKey
     * @return
     */
    private static String encrypt(String source, String publicKey) {
        try {
            Key key = getPublicKey(publicKey);
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] b = source.getBytes();
            byte[] b1 = cipher.doFinal(b);
            return new String(Base64.getEncoder().encode(b1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param source
     * @param privateKey
     * @return
     */
    public static String decrypt(String source, String privateKey) {
        try {
            Key key = getPrivateKey(privateKey);
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] b1 =Base64.getDecoder().decode(source.getBytes());
            byte[] b = cipher.doFinal(b1);
            return new String(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥签名
     *
     * @param content
     * @param privateKey
     * @return
     */
    public static String sign(String content, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(RSA_SIGNATURE);
            signature.initSign(priKey);
            signature.update(content.getBytes(CharEncoding.UTF_8));
            byte[] signed = signature.sign();
            return new String(Base64.getEncoder().encode(signed));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥验签
     *
     * @param content
     * @param sign
     * @param publicKey
     * @return
     */
    public static boolean checkSign(String content, String sign, String publicKey) {
        try {
            PublicKey pubKey = getPublicKey(publicKey);
            Signature signature = Signature.getInstance(RSA_SIGNATURE);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(CharEncoding.UTF_8));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            String source = "93F59779E9355ED5DA9382E8DA4BFB11";
            String priKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJamKtUABxI1vV/DC1xY+zja8tv+WvB6LRhPIUaQ1/vbO2oZMZU21MnCwOEofw5lEUzMRlKjUmbyz2P0VgXVT0jef5nwFSGr72PjT1aDtrHmSU/pHRq2gQHnKjEhabDDjhCTmKlUxs/snzdCh6/0fcTnn7BVu59IixEyRogR6wPvAgMBAAECgYAqzvc25bYcr5aroqIU0Ng6lMUUTJgM47rywHGlOr2VPPwKLzSOwTEAUE487SQFtCSRXS7ShsSAqpjSP3k+WRoZHA0brgjPMVMaHiw7YKH8AdzIkYTaxopzZ51N5yv/gDPd7i3aCw12ETpl/G1j9dR9rY/M6PdT4h2/vlb85UIYAQJBANAKehVPZ+3vuUmtre/KseBUha3+IWjkVrzUWhvvBuZHFmrGZIRk5VbRg7P+pCyk+k4GtpGU8QRTQ9CyNKs+7+8CQQC5YLb0Ga+KXO4QWs1BVAnCAqr+r5GRLDIrFOUFwWS7EjBjd3hyayqCqX2Fm9UDBOIM+ocVNenyiqrx8r8ygSwBAkEAiPdM1vjXWLwqBcr1p9iP8TxUYm/ceR1TybAYvylIJpWIubVx+gQfRWBc0EUGu2nGbVZYHlKrtwhGroCU0mV2OwJAeTjtaqKBUBGE+9zk7BtwZhYoi3Nz1WL5S4LWYPUeUdaLHgA6G1hI7Di5hG1q1haTW7lYLF6dJaXYM29x6CzgAQJAAJaQyPcHOyqiu9vpHxuqZSCNgvj/JahNzvcoiO5UByuao4nmqs8m9gQxqS++8Zfc7fZVzWaruqUADKvYw4p0kA==";
            String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWpirVAAcSNb1fwwtcWPs42vLb/lrwei0YTyFGkNf72ztqGTGVNtTJwsDhKH8OZRFMzEZSo1Jm8s9j9FYF1U9I3n+Z8BUhq+9j409Wg7ax5klP6R0atoEB5yoxIWmww44Qk5ipVMbP7J83Qoev9H3E55+wVbufSIsRMkaIEesD7wIDAQAB";
            String signString = sign(source, priKey);
            System.out.println("SIGN STRING === " + signString);
            System.out.println(checkSign(source, signString, pubKey));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
