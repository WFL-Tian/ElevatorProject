package com.akk.elevatorproject.constant;

/**
 * @author gchiaway
 *         日期: 2018-01-27
 *         时间: 18:39
 */
public enum ElevatorStatusEnum {

    Normal(1,"正常使用"),
    disable(2,"停用"),
    abnormal(3,"运行异常"),
    serious(4,"严重故障"),
    urgent(5,"紧急故障"),
    ;

    private Integer id;
    private String name;

    public static final String KEY = "elevatorStatus";

    ElevatorStatusEnum(Integer id, String name) {
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
