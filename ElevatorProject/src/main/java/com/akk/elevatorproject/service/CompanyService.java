package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Company;

/**
 * Created by tianjun on 2018/1/23.
 */
public interface CompanyService {
    /**
     * 通过id查询公司信息
     * @param companyId 公司id
     * @return
     */
    Company selectOne(Integer companyId);
}
