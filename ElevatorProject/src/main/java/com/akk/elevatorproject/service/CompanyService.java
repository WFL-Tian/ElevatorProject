package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Company;

/**
 * Created by tianjun on 2018/1/23.
 */
public interface CompanyService {
    /**
     * ͨ��id��ѯ��˾��Ϣ
     * @param companyId ��˾id
     * @return
     */
    Company selectOne(Integer companyId);
}
