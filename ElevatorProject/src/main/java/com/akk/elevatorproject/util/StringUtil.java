package com.akk.elevatorproject.util;

/**
 * ×Ö·ûÅÐ¶ÏÊÇ·ñÎª¿Õ
 * Created by tianjun on 2018/1/29.
 */
public class StringUtil {


    /**
     * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
     * @param s
     * @return
     */
    public static boolean isNull(String s){
        return null==s||s.length()==0||s.equals("")
                ||s.matches("\\s*");
    }


    /**
     * ·Ç¿ÕÅÐ¶Ï
     * @param s
     * @return
     */
    public static boolean isNotNull(String s){
        return !isNull(s);
    }
}
