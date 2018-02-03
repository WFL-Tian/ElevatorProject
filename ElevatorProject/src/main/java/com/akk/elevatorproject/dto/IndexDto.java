package com.akk.elevatorproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-02-01
 *         时间: 16:05
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class IndexDto {

    /**
     * 坏电梯数量
     */
    private int badElevator;

    /**
     * 好电梯数量
     */
    private int goodElevator;
}
