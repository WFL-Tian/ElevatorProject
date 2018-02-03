package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-19
 *         时间: 17:04
 */
@Slf4j
public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void selectUser() throws Exception {

        User user = new User();
        user.setUserType(1);
        user.setUserId(2);

        List<User> result = mapper.selectUser(user);
        Assert.assertNotNull(result);
    }

}