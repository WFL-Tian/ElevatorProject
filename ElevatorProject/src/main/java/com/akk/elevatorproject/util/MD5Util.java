package com.akk.elevatorproject.util;

import java.security.MessageDigest;

/**
 *生成32位MD5信息摘要的工具类
 * */
public class MD5Util {
    /**
     * 功能：给指定字符串生成MD5摘要
     * 参数：需要生成摘要的字符串
     * 返回值：字符串生成的摘要
     * */
    public final static String MD5(String s) {
    	//大写的32位MD5
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
           // System.out.print(str);//测试输出
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}