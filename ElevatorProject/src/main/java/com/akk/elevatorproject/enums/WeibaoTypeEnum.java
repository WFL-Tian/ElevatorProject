package com.akk.elevatorproject.enums;

import lombok.Getter;

/**
 * Created by tianjun on 2018/1/29.
 */
@Getter
public enum WeibaoTypeEnum {

    fifteen(1, "15天1维保"),
    complaint_repair(2, "投诉维修"),
    year(3, "一年一检查");

    private Integer code;
    private String  message;

    WeibaoTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
