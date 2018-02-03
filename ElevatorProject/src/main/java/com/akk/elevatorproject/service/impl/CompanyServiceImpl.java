package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.mapper.CompanyMapper;
import com.akk.elevatorproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:18
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper mapper;

    /**
     * 添加公司信息
     * @param company
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(Company company) {
        return mapper.insertCompany(company);
    }

    /**
     * 修改公司信息
     * @param company
     * @return 返回受到影响的行数
     */
    @Override
    public int update(Company company) {
        return mapper.updateByPrimaryKey(company);
    }

    /**
     * 删除公司信息
     * @param company
     * @return
     */
    @Override
    public int delete(Company company) {
        return mapper.deleteByPrimaryKey(company);
    }

    /**
     * 通过companyType和companyShStatus查询
     * 如果companyShStatus为空 则仅通过companyType查询
     * 如果均为空 则通过 companyId查询
     * @param company
     * @return 返回查到的对象
     */
    @Override
    public List<Company> selectCompany(Company company) {
        return mapper.selectCompany(company);
    }
}
