package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.entity.Weibao;

import java.util.List;

/**
 * Created by tianjun on 2018/1/21.
 */
public interface UserService {

    /**
     * ���ݲ�ͬ����(username��password)��ѯ�û���Ϣ
     * @param userCondition
     * @return
     */
    User queryUser(User userCondition);


}
