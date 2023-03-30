package com.example.hncs.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author 小明
 * @date 2023/3/29
 * @description
 */
public class MD5Util {
    public static String md5(String dateString) throws Exception {
        MessageDigest md5 = null;
        byte[] digest = MessageDigest.getInstance("md5").digest(dateString.getBytes("utf-8"));
        String md5code = new BigInteger(1, digest).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    //解密+盐
    public static String md5MinusSalt(String md5) {
        char[] cArray = md5.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] >= 48 && cArray[i] <= 57) {
                cArray[i] = (char) (105 - cArray[i]);
            }
        }
        return String.valueOf(cArray);
        //return  "".valueOf(cArray);
    }
}
