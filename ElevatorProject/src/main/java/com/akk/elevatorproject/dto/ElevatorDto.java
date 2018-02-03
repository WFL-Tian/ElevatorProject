package com.akk.elevatorproject.dto;

import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.Loupan;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-29
 *         时间: 20:40
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ElevatorDto {
    List<ElevatorTypeDto> elevatorTypeList;
    List<ElevatorStatusDto> elevatorStatusList;
    List<Loupan> loupanList;
    List<Company> developList;
    List<Company> wuyeList;
    List<Company> weibaoList;
}
