package com.akk.elevatorproject.service;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Loupan;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 11:00
 */
@Slf4j
public class LoupanServiceTest extends BaseTest {


    @Autowired
    private LoupanService service;

    @Test
    public void insert() throws Exception {
        Loupan loupan = new Loupan();
        loupan.setLoupanId(256);
        loupan.setLoupanAddr("sdsad");
        Date date = new Date();
        loupan.setCreateTime(date);
        loupan.setUpdateTime(date);

        service.insert(loupan);
    }

    @Test
    public void update() throws Exception {
        Loupan loupan = new Loupan();
        loupan.setLoupanId(256);
        loupan.setLoupanAddr("ss");

        service.update(loupan);
    }

    @Test
    public void delete() throws Exception {
        Loupan loupan = new Loupan();
        loupan.setLoupanId(256);

        service.delete(loupan);
    }

    @Test
    public void test() throws Exception {

        String result = service.selectLoupan(1).getLoupanAddr();
        Assert.assertNotNull(result);
    }
}