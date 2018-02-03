package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Shenpi;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-19
 *         时间: 17:43
 */
@Slf4j
public class ShenpiMapperTest extends BaseTest {

    @Autowired
    private ShenpiMapper mapper;

    @Test
    public void selectShenpi() throws Exception {

        Shenpi shenpi = new Shenpi();

        shenpi.setShenpiId("11");
        shenpi.setCompanyId(1);

        List<Shenpi> result = mapper.selectShenpi(shenpi);
        Assert.assertNotNull(result);
    }

}