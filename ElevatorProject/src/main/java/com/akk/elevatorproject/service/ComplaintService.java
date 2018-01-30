package com.akk.elevatorproject.service;


import com.akk.elevatorproject.entity.Complaint;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.entity.Img;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
public interface ComplaintService {

    /**
     * 根据电梯编号查询投诉信息并按照创建时间desc排序
     * @param elevatorId
     * @return
     */
    List<Complaint> selectComplaintByElevatorId(String elevatorId);

    /**
     * 添加投诉记录
     * @param complaint
     * @return
     */
    @Transactional
    int insertComplaint(Complaint complaint);

    @Transactional
    int updateComplaint(Complaint complaint);


}
