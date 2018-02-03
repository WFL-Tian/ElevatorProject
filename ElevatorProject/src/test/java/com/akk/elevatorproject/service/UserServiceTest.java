package com.akk.elevatorproject.service;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static com.akk.elevatorproject.constant.PageCodeEnum.ADD_FAIL;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;
import static com.akk.elevatorproject.util.CommonUtil.isNotEmpty;
import static org.junit.Assert.*;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:38
 */
@Slf4j
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService service;

    @Test
    public void selectUser() throws Exception {
        User user = new User();
        user.setUserType(1);
        user.setUserId(2);

        List<User> result = service.selectUser(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void selectByUsername() throws Exception {

        if (isNotEmpty(service.selectByUsername("aaa"))){
            System.out.println("重名");
        }

    }

    @Test
    public void validate() throws Exception {
        User user = new User();
        user.setUsername("tianjun");
        user.setPassword("123456");
        service.validate(user);

    }



    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setUsername("sss");
        user.setPassword("ppp");
        user.setCompanyId(12);
        user.setShStatus(1);
        user.setUserType(3);
        user.setCreateTime(new Date());
        user.setLastEditTime(new Date());

        service.insert(user);
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setUserId(8);
        user.setUsername("sss");
        user.setPassword("p22");
        user.setCompanyId(12);
        user.setShStatus(1);
        user.setUserType(3);

        service.update(user);
    }

    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setUserId(3);

        service.delete(user);
    }
}