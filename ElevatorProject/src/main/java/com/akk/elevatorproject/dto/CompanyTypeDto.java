package com.akk.elevatorproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-28
 *         时间: 1:09
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CompanyTypeDto {
    private Integer companyTypeId;
    private String  companyTypeName;

}
