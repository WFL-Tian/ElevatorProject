package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Company;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CompanyMapper extends Mapper<Company> {


//    /**
//     * 修改公司审核状态
//     * @param companyId
//     * @param companyShStatus
//     * @return 返回受到影响的行数
//     */
//    int updateStatus(@Param("companyId") int companyId,
//                     @Param("companyShStatus") int companyShStatus);
//
//
//    /**
//     * 添加公司信息
//     * @param company
//     * @return 返回1 或者 0 确认添加成功与否
//     */
//    @Override
//    int insert(Company company);
//
//
//    /**
//     * 修改公司信息
//     * @param company
//     * @return 返回受到影响的行数
//     */
//    int update(Company company);
//

/**
//     * 添加公司信息
//     * @param company
//     * @return 返回1 或者 0 确认添加成功与否
//     *//*
//    @Override
//    int insert(Company company);*/

    /**
     * 添加公司信息
     * @param company
     * @return
     */
    int insertCompany(Company company);

    /**
     * 通过companyType和companyShStatus查询
     * 如果companyShStatus为空 则仅通过companyType查询
     * 如果均为空 则通过 companyId查询
     * @param company
     * @return 返回查到的对象
     */
    List<Company> selectCompany(Company company);

}