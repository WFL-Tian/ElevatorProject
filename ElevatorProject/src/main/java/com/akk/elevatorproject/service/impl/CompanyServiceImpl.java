package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.mapper.CompanyMapper;
import com.akk.elevatorproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianjun on 2018/1/23.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company selectOne(Integer companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }
}
