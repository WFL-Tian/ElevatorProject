package com.akk.elevatorproject.service;

import com.akk.elevatorproject.dto.ElevatorDTO;
import com.akk.elevatorproject.entity.Elevator;


/**
 * Created by tianjun on 2018/1/20.
 */
public interface ElevatorService {

    /**
     * ���ݵ��ݱ�Ų�ѯ������Ϣ(����ĵ���������Ҫ��װ)
     * @param elevatorId
     * @return
     */
    ElevatorDTO selectOne(String elevatorId);

    Elevator selectElevatorById(String elevatorId);

    int updateElevator(Elevator elevator);
}
