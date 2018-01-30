package com.akk.elevatorproject.service;

import com.akk.elevatorproject.dto.ElevatorDTO;
import com.akk.elevatorproject.entity.Elevator;


/**
 * Created by tianjun on 2018/1/20.
 */
public interface ElevatorService {

    /**
     * 根据电梯编号查询电梯信息(这里的电梯数据需要组装)
     * @param elevatorId
     * @return
     */
    ElevatorDTO selectOne(String elevatorId);

    Elevator selectElevatorById(String elevatorId);

    int updateElevator(Elevator elevator);
}
