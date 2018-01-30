package com.akk.elevatorproject.service;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.QR;
import com.akk.elevatorproject.mapper.QRMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tianjun on 2018/1/23.
 */
@Slf4j
public class QRDaoTest extends BaseTest {

    @Autowired
    private QRService qrService;

    @Test
    public void selectOne() {
        QR result = qrService.selectOne(1);

        log.info("°æ”√ªß≤È—Ø°ø£∫result={}", result);
        Assert.assertNotNull(result);

    }


}
