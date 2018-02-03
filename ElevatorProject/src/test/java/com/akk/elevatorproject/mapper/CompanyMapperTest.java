package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-19
 *         时间: 18:03
 */
@Slf4j
public class CompanyMapperTest extends BaseTest {

    @Autowired
    private CompanyMapper mapper;

    @Test
    public void selectCompany() throws Exception {
        Company company = new Company();

        company.setCompanyType(1);
        company.setCompanyId(1);

        List<Company> result = mapper.selectCompany(company);
        Assert.assertNotNull(result);
    }

    @Test
    public void creat() throws Exception {
        Company company = new Company();

        company.setCompanyName("ceshi");
        company.setCompanyType(3);
        company.setCompanyShStatus(1);
        System.out.println(mapper.insertCompany(company));
        System.out.println(company.getCompanyId());
    }

}