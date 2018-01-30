package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.QR;
import com.akk.elevatorproject.mapper.QRMapper;
import com.akk.elevatorproject.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianjun on 2018/1/23.
 */
@Service
public class QRServiceImpl implements QRService {

    @Autowired
    private QRMapper qrMapper;

    @Override
    public QR selectOne(Integer qrId) {
        return qrMapper.selectByPrimaryKey(qrId);
    }
}
