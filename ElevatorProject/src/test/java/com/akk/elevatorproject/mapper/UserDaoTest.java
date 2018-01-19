package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by KHM
 * 2018/1/17 19:21
 */
@Slf4j
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testBQueryUser() throws Exception {

        List<User> result = mapper.selectAll();
        log.info("【用户查询】：result={}", JsonUtil.toJson(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUserId(2);
        user.setUsername("sadf");
        user.setPassword("111");
        user.setUserType(1);
        user.setCreateTime(new Date());

        int result = mapper.insert(user);
        log.info("【用户查询】：result={}", JsonUtil.toJson(result));
        Assert.assertNotNull(result);
    }
}
