package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Elevator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tianjun on 2018/1/19.
 */
@Slf4j
public class ElevatorDaoTest extends BaseTest {

    @Autowired
    private ElevatorMapper elevatorMapper;

    @Test
    public void selectElevatorList(){
        Elevator elevator = new Elevator();
        elevator.setElevatorId("12644526666");

//        List<Elevator> result = elevatorMapper.selectElevatorList(elevator, 0, 1);
//        log.info("°æ”√ªß≤È—Ø°ø£∫result={}", result);
//        Assert.assertNotNull(result);
    }



}
