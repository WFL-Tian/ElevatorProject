package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    /**
     * 通过用户类型查询,如果用户类型为空则通过用户id查询
     * @param user
     * @return
     */
    List<User> selectUser(User user);

}