package com.akk.elevatorproject.service;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Shenpi;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:33
 */
@Slf4j
public class ShenpiServiceTest extends BaseTest {

    @Autowired
    private ShenpiService service;

    @Test
    public void selectShenpi() throws Exception {

        Shenpi shenpi = new Shenpi();

        shenpi.setShenpiId("11");
        shenpi.setCompanyId(1);

        List<Shenpi> result = service.selectShenpi(shenpi);
        Assert.assertNotNull(result);
    }

    @Test
    public void insert() throws Exception {
        Shenpi shenpi = new Shenpi();
        shenpi.setShenpiId("14224");
        shenpi.setCompanyId(256);
        shenpi.setLoupanId(12);
        shenpi.setCreateTime(new Date());
        shenpi.setShenpiStatus(0);

        service.insert(shenpi);
    }

    @Test
    public void update() throws Exception {
        Shenpi shenpi = new Shenpi();
        shenpi.setShenpiId("14224");
        shenpi.setCompanyId(256);
        shenpi.setLoupanId(12);
        shenpi.setCreateTime(new Date());
        shenpi.setShenpiStatus(2);


        service.update(shenpi);
    }

    @Test
    public void delete() throws Exception {
        Shenpi shenpi = new Shenpi();
        shenpi.setShenpiId("14224");

        service.delete(shenpi);
    }


}