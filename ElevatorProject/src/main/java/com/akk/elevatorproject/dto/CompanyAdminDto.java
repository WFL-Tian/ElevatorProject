package com.akk.elevatorproject.dto;

import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-30
 *         时间: 20:21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CompanyAdminDto {
    User user;
    Company company;
}
