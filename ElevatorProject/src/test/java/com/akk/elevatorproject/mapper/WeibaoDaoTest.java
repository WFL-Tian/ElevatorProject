package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.entity.Weibao;
import com.akk.elevatorproject.util.JsonUtil;
import com.akk.elevatorproject.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tianjun on 2018/1/19.
 */
@Slf4j
public class WeibaoDaoTest extends BaseTest{


    @Autowired
    private WeibaoMapper weibaoMapper;

    /**
     * 按时间查询维保单信息
     */
    @Test
    public void selectWeibaobyTimeToNow(){

        Weibao weibaoCondition = new Weibao();
        weibaoCondition.setElevatorId("12644526666");


        List<Weibao> result = weibaoMapper.queryWeibaoList(weibaoCondition);

        log.info("【用户查询】：result={}", result);
        Assert.assertNotNull(result);

    }


}
