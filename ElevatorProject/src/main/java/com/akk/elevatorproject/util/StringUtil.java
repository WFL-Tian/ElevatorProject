package com.akk.elevatorproject.util;

/**
 * �ַ��ж��Ƿ�Ϊ��
 * Created by tianjun on 2018/1/29.
 */
public class StringUtil {


    /**
     * �ж��ַ����Ƿ�Ϊ��
     * @param s
     * @return
     */
    public static boolean isNull(String s){
        return null==s||s.length()==0||s.equals("")
                ||s.matches("\\s*");
    }


    /**
     * �ǿ��ж�
     * @param s
     * @return
     */
    public static boolean isNotNull(String s){
        return !isNull(s);
    }
}
