package com.akk.elevatorproject.util;

import com.akk.elevatorproject.constant.CompanyTypeEnum;
import com.akk.elevatorproject.constant.ElevatorStatusEnum;
import com.akk.elevatorproject.constant.ElevatorTypeEnum;
import com.akk.elevatorproject.constant.UserTypeEnum;
import com.akk.elevatorproject.dto.CompanyTypeDto;
import com.akk.elevatorproject.dto.ElevatorStatusDto;
import com.akk.elevatorproject.dto.ElevatorTypeDto;
import com.akk.elevatorproject.dto.UserTypeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-27
 *         时间: 22:56
 */
public class EnumToList {

    public static List<UserTypeDto> UserType(){
        List<UserTypeDto> userTypeList = new ArrayList<>();
        // 将枚举存放到list里面
        for (CompanyTypeEnum companyTypeEnum : CompanyTypeEnum.values()) {
            UserTypeDto userTypeDto = new UserTypeDto();
            userTypeDto.setUserTypeId(companyTypeEnum.getCode());
            userTypeDto.setUserTypeName(companyTypeEnum.getType());
            userTypeList.add(userTypeDto);
        }
        return userTypeList;
    }

    public static List<CompanyTypeDto> CompanyType(){
        List<CompanyTypeDto> companyTypeList = new ArrayList<>();
        // 将枚举存放到list里面
        for (CompanyTypeEnum companyTypeEnum : CompanyTypeEnum.values()) {
            CompanyTypeDto companyTypeDto = new CompanyTypeDto();
            companyTypeDto.setCompanyTypeId(companyTypeEnum.getCode());
            companyTypeDto.setCompanyTypeName(companyTypeEnum.getType());
            companyTypeList.add(companyTypeDto);
        }
        return companyTypeList;
    }

    public static List<ElevatorTypeDto> ElevatorType(){
        List<ElevatorTypeDto> elevatorTypeList = new ArrayList<>();
        // 将枚举存放到list里面
        for (ElevatorTypeEnum elevatorTypeEnum : ElevatorTypeEnum.values()) {
            ElevatorTypeDto elevatorTypeDto = new ElevatorTypeDto();
            elevatorTypeDto.setElevatorTypeId(elevatorTypeEnum.getId());
            elevatorTypeDto.setElevatorTypeName(elevatorTypeEnum.getName());
            elevatorTypeList.add(elevatorTypeDto);
        }
        return elevatorTypeList;
    }

    public static List<ElevatorStatusDto> ElevatorStatus(){
        List<ElevatorStatusDto> elevatorStatusList = new ArrayList<>();
        // 将枚举存放到list里面
        for (ElevatorStatusEnum elevatorStatusEnum : ElevatorStatusEnum.values()) {
            ElevatorStatusDto elevatorStatusDto = new ElevatorStatusDto();
            elevatorStatusDto.setElevatorStatusId(elevatorStatusEnum.getId());
            elevatorStatusDto.setElevatorStatusName(elevatorStatusEnum.getName());
            elevatorStatusList.add(elevatorStatusDto);
        }
        return elevatorStatusList;
    }


}
