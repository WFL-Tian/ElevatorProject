package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 11:04
 */
@Slf4j
public class LoupanMapperTest extends BaseTest {
    @Autowired
    private LoupanMapper mapper;

    @Test
    public void selectUser() throws Exception {



        String result= mapper.selectByPrimaryKey(1).getLoupanAddr();
        Assert.assertNotNull(result);
    }

}