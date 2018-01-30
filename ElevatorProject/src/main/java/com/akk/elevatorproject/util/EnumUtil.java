package com.akk.elevatorproject.util;

import com.akk.elevatorproject.enums.CodeEnum;

/**
 * ͨ��ö�ٵ�code���ȡ��ö�ٶ���
 * Created by tianjun on 2018/1/29.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
