package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Complaint;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.mapper.ComplaintMapper;
import com.akk.elevatorproject.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    private ComplaintMapper complaintMapper;


    @Override
    public List<Complaint> selectComplaintByElevatorId(String elevatorId) {
        Complaint complaint = new Complaint();
        complaint.setElevatorId(elevatorId);
        return complaintMapper.selectComplaintByElevatorId(complaint);
    }

    @Override
    @Transactional
    public int insertComplaint(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }

    @Override
    public int updateComplaint(Complaint complaint) {
        return complaintMapper.updateByPrimaryKeySelective(complaint);
    }
}
