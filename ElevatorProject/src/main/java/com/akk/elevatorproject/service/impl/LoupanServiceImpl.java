package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Loupan;
import com.akk.elevatorproject.mapper.LoupanMapper;
import com.akk.elevatorproject.service.LoupanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianjun on 2018/1/23.
 */
@Service
public class LoupanServiceImpl implements LoupanService{

    @Autowired
    private LoupanMapper loupanMapper;

    @Override
    public Loupan selectOne(Integer loupanId) {
        return loupanMapper.selectByPrimaryKey(loupanId);
    }
}
