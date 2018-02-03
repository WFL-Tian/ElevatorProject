package com.akk.elevatorproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-29
 *         时间: 20:43
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ElevatorStatusDto {
    private Integer elevatorStatusId;
    private String  elevatorStatusName;
}
