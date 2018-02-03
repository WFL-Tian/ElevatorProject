package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Company;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:17
 */
public interface CompanyService {


    /**
     * 添加公司信息
     * @param company
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(Company company);


    /**
     * 修改公司信息
     * @param company
     * @return 返回受到影响的行数
     */
    int update(Company company);

    /**
     * 删除公司信息
     * @param company
     * @return
     */
    int delete(Company company);

    /**
     * 通过companyType和companyShStatus查询
     * 如果companyShStatus为空 则仅通过companyType查询
     * 如果均为空 则通过 companyId查询
     * @param company
     * @return 返回查到的对象
     */
    List<Company> selectCompany(Company company);
}
