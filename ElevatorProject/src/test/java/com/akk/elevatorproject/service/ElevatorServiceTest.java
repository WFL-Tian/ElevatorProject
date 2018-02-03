package com.akk.elevatorproject.service;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Elevator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:29
 */
@Slf4j
public class ElevatorServiceTest extends BaseTest {
    @Autowired
    private ElevatorService service;

    @Test
    public void insert() throws Exception {
        Elevator elevator = new Elevator();
        elevator.setElevatorId("123");
        elevator.setProductionDate(new Date());
        elevator.setElevatorStatus(2);

        service.insert(elevator);
    }

    @Test
    public void update() throws Exception {
        Elevator elevator = new Elevator();
        elevator.setElevatorId("123");
        elevator.setProductionDate(new Date());
        elevator.setElevatorStatus(3);

        service.update(elevator);
    }

    @Test
    public void delete() throws Exception {
        Elevator elevator = new Elevator();
        elevator.setElevatorId("123");
        elevator.setProductionDate(new Date());
        elevator.setElevatorStatus(3);

        service.delete(elevator);
    }

    @Test
    public void selectElevator() throws Exception {
        Elevator elevator =new Elevator();
        elevator.setElevatorType(1);
        elevator.setElevatorStatus(2);
        List<Elevator> result = service.selectElevator(elevator);
        Assert.assertNotNull(result);
    }

}