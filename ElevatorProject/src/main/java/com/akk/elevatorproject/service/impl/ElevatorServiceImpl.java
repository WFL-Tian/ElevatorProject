package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.dto.ElevatorDTO;
import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.entity.Loupan;
import com.akk.elevatorproject.mapper.ElevatorMapper;
import com.akk.elevatorproject.service.CompanyService;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.LoupanService;
import com.akk.elevatorproject.service.QRService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianjun on 2018/1/23.
 */
@Service
public class ElevatorServiceImpl implements ElevatorService{

    @Autowired
    private ElevatorMapper elevatorMapper;

    @Autowired
    private LoupanService loupanService;

    @Autowired
    private CompanyService companyService;


    @Override
    public ElevatorDTO selectOne(String elevatorId) {
        ElevatorDTO elevatorDTO = new ElevatorDTO();
        //1.���ȸ��ݵ��ݱ�Ų�ѯ�����ݵĻ�����Ϣ
        Elevator elevator = elevatorMapper.selectByPrimaryKey(elevatorId);
        if (elevator == null){
            return null;
        }
        //��Elevator������ElevatorDTO��
        BeanUtils.copyProperties(elevator,elevatorDTO);
        //¥������
        Loupan loupan = loupanService.selectOne(elevator.getLoupanId());
        elevatorDTO.setLoupanAddr(loupan.getLoupanAddr());

        //�����̹�˾����
        Company company = companyService.selectOne(elevator.getDevelopId());
        elevatorDTO.setDevelopName(company.getCompanyName());
        //��ҵ��˾���֡��绰
        company = companyService.selectOne(elevator.getWuyeId());
        elevatorDTO.setWuyeName(company.getCompanyName());
        elevatorDTO.setPhone(company.getCompanyPhone());

        //ά����˾��
        company = companyService.selectOne(elevator.getWeibaoId());
        elevatorDTO.setWeibaoCompanyName(company.getCompanyName());

        return elevatorDTO;
    }

    @Override
    public Elevator selectElevatorById(String elevatorId) {
        Elevator elevator = new Elevator();
        elevator.setElevatorId(elevatorId);
        return elevatorMapper.selectOne(elevator);
    }

    @Override
    public int updateElevator(Elevator elevator) {
        return elevatorMapper.updateByPrimaryKeySelective(elevator);
    }
}
