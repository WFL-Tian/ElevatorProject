package com.akk.elevatorproject.constant;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 20:30
 */
public enum CompanyTypeEnum {


    DEVELOP(3,"开发商"),
    WUYE(4,"物业"),
    WEIBAO(5,"维保"),
    ;

    private Integer code;
    private String type;

    public static final String KEY = "companyType";

    CompanyTypeEnum(Integer code, String type) {
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
