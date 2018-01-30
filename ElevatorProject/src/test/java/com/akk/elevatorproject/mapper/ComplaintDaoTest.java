package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Complaint;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Slf4j
public class ComplaintDaoTest extends BaseTest {

    @Autowired
    private ComplaintMapper complaintMapper;

    @Test
    public void queryComplaintCondition(){

        Complaint complaintCondition = new Complaint();
        //complaint.setComplaintNumber("11111");
        complaintCondition.setElevatorId("12644526666");
        List<Complaint> complaints=complaintMapper.selectComplaintByElevatorId(complaintCondition);
       Complaint complaint1 = complaints.get(1);
       int result = complaint1.getComplaintStatus();



        log.info("°æ≤È—Ø°ø£∫result={}", result);
        Assert.assertNotNull(result);
    }



}
