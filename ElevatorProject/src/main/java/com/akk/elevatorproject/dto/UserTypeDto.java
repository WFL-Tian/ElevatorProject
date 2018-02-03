package com.akk.elevatorproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-27
 *         时间: 22:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserTypeDto {
    private Integer userTypeId;
    private String  userTypeName;
}
