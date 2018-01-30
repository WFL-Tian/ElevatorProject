package com.akk.elevatorproject.enums;

import lombok.Getter;

/**
 * Created by tianjun on 2018/1/29.
 */
@Getter
public enum WeibaoTypeEnum {

    fifteen(1, "15��1ά��"),
    complaint_repair(2, "Ͷ��ά��"),
    year(3, "һ��һ���");

    private Integer code;
    private String  message;

    WeibaoTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
