package com.ours.userappservice.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class EncryptUtil {
    public static final String HASH_ALOG = "SHA-256";
    public static final int HASH_ITERATIONS = 1;

    /**
     * 给注册时输入的密码加密
     *
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        //给注册时输入的密码加密
        SimpleHash simpleHash = new SimpleHash(HASH_ALOG, password);

        simpleHash.setIterations(HASH_ITERATIONS);
        System.out.println("加密后的密码：" + simpleHash.toString());
        return simpleHash.toString();
    }

}
