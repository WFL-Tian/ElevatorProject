package com.akk.elevatorproject.constant;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 20:15
 */
public enum UserTypeEnum {


    ADMINISTRATOR(1,"超级管理员"),
    ADMIN(2,"管理员"),
    DEVELOP(3,"开发商"),
    WUYE(4,"物业"),
    WEIBAO(5,"维保"),
    ;


    private Integer code;
    private String type;

    public static final String KEY = "userType";

    UserTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
