package com.akk.elevatorproject.constant;

/**
 * @author gchiaway
 *         日期: 2018-01-27
 *         时间: 18:33
 */
public enum ElevatorTypeEnum {

    SHOUFU(1,"手扶电梯"),
    ;

    private Integer id;
    private String name;

    public static final String KEY = "elevatorType";

    ElevatorTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
