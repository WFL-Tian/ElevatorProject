package com.akk.elevatorproject.enums;

import lombok.Getter;

/**
 * Created by tianjun on 2018/1/29.
 */
@Getter
public enum ComplaintTypeEnum {

    abnormal(1,"运行异常"),
    serious(2,"严重故障"),
    urgent(3,"紧急故障"),
    ;
    private Integer code;
    private String message;

    ComplaintTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}