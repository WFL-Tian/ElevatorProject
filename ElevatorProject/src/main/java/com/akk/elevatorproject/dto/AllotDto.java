package com.akk.elevatorproject.dto;

import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.Loupan;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-31
 *         时间: 0:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AllotDto {
    List<Company> companyList;
    List<Loupan> loupanList;
}
