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
     * ���ݵ��ݱ�Ų�ѯͶ����Ϣ�����մ���ʱ��desc����
     * @param elevatorId
     * @return
     */
    List<Complaint> selectComplaintByElevatorId(String elevatorId);

    /**
     * ���Ͷ�߼�¼
     * @param complaint
     * @return
     */
    @Transactional
    int insertComplaint(Complaint complaint);

    @Transactional
    int updateComplaint(Complaint complaint);


}
