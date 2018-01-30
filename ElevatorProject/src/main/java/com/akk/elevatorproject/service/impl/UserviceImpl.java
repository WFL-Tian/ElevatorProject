package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.mapper.UserMapper;
import com.akk.elevatorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianjun on 2018/1/21.
 */
@Service
public class UserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryUser(User userCondition) {
        return userMapper.selectOne(userCondition);
    }
}
