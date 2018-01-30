package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.entity.Weibao;

import java.util.List;

/**
 * Created by tianjun on 2018/1/21.
 */
public interface UserService {

    /**
     * 根据不同条件(username、password)查询用户信息
     * @param userCondition
     * @return
     */
    User queryUser(User userCondition);


}
