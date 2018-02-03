package com.akk.elevatorproject.constant;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 20:21
 */
public enum ShStatusEnum {

    NOTSH(0,"未审核"),
    SH_SUCCESS(1,"审核成功"),
    SH_FAIL(2,"审核不通过"),
    ;

    private Integer code;
    private String type;

    public static final String KEY = "ShStatus";

    ShStatusEnum(Integer code, String type) {
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
