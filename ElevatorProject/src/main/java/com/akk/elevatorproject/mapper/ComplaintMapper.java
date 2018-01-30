package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Complaint;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ComplaintMapper extends Mapper<Complaint> {
    /**
     * ��ѯά����¼������desc����
     * @return
     */
    List<Complaint> selectComplaintByElevatorId(@Param("complaintCondition")Complaint complaintCondition);
}