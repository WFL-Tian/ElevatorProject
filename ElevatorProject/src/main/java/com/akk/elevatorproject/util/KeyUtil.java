package com.akk.elevatorproject.util;

import java.util.Random;

/**
 * Created by tianjun on 2018/1/19.
 */
public class KeyUtil {
    /**
     * ����Ψһ������(����Id)
     * ��ʽ��ʱ��+�����
     * ��ֹ���̻߳��ظ�Ҫ��synchronized
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        System.currentTimeMillis();
        //�������ɵ����������6λ��
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
