package com.akk.elevatorproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-29
 *         时间: 19:35
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ElevatorTypeDto {
    private Integer elevatorTypeId;
    private String  elevatorTypeName;
}
