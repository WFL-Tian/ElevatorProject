package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.User;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:36
 */
public interface UserService {

    /**
     * 添加用户信息
     * @param user
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(User user);

    /**
     * 修改用户信息
     * @param user
     * @return 返回受到影响的行数
     */
    int update(User user);

    /**
     * 删除用户信息
     * @param user
     * @return
     */
    int delete(User user);


    /**
     * 根据 userName 查询user
     * @param username 用户名
     * @return
     */
    User selectByUsername(String username);


    /**
     * 校验用户名/密码是否正确
     * @param user 待校验user对象
     * @return true：用户名/密码正确，如果正确，将user对象里其他属性补齐
     *                false：用户名/密码错误
     */
    boolean validate(User user);


    /**
     * 通过用户类型查询,如果用户类型为空则通过用户id查询
     * @param user
     * @return
     */
    List<User> selectUser(User user);
}
