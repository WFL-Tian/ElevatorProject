package com.akk.elevatorproject.service;

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
 *         日期: 2018-01-20
 *         时间: 10:20
 */
@Slf4j
public class CompanyServiceTest extends BaseTest {


    @Autowired
    private CompanyService service;

    @Test
    public void insert() throws Exception {
        Company company = new Company();
        company.setCompanyName("ssdsd");
        company.setCompanyId(123);
        company.setCompanyShStatus(1);
        company.setCompanyType(1);
        service.insert(company);
    }

    @Test
    public void update() throws Exception {
        Company company = new Company();
        company.setCompanyName("ssdsd");
        company.setCompanyId(123);
        company.setCompanyShStatus(2);
        company.setCompanyType(2);
        service.update(company);
    }

    @Test
    public void delete() throws Exception {
        Company company = new Company();
        company.setCompanyId(123);
        service.delete(company);
    }

    @Test
    public void selectCompany() throws Exception {
        Company company = new Company();

        company.setCompanyType(1);
        company.setCompanyId(1);

        List<Company> result = service.selectCompany(company);
        Assert.assertNotNull(result);
    }
}