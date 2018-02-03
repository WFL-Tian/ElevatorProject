package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-19
 *         时间: 18:24
 */
@Slf4j
public class ElevatorMapperTest extends BaseTest {

    @Autowired
    private ElevatorMapper mapper;

    @Test
    public void select() throws Exception {

        Elevator elevator =new Elevator();
        elevator.setElevatorType(1);
        //elevator.setElevatorStatus(2);
        elevator.setWeibaoId("123");
        List<Elevator> result = mapper.selectElevator(elevator);
        Assert.assertNotNull(result);
    }

    @Test
    public void in() throws Exception {
        Elevator elevator =new Elevator();
        elevator.setElevatorStatus(2);
        elevator.setProductionDate(new Date());
        elevator.setElevatorId(KeyUtil.genUniqueKey());

        mapper.insert(elevator);
    }


    @Test
    public void se() throws Exception {
        Elevator elevator =new Elevator();
        mapper.selectElevator(elevator);
    }


    @Test
    public void developAllot() throws Exception {
        mapper.developAllot(157,1455,134);
    }

    @Test
    public void wuyeAllot() throws Exception {
        mapper.wuyeAllot(1455,"1455",134);
    }

}