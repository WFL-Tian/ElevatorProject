package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.mapper.UserMapper;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    /**
     * 添加用户信息
     *
     * @param user
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return mapper.insert(user);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return 返回受到影响的行数
     */
    @Override
    public int update(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return mapper.updateByPrimaryKey(user);
    }

    /**
     * 删除用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int delete(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return mapper.deleteByPrimaryKey(user);
    }

    /**
     * 根据 userName 查询user
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User selectByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }

    /**
     * 校验用户名/密码是否正确
     *
     * @param user 待校验user对象
     * @return true：用户名/密码正确，如果正确，将user对象里其他属性补齐
     * false：用户名/密码错误
     */
    @Override
    public boolean validate(User user) {
        if (user != null && !isEmpty(user.getUsername()) && !isEmpty(user.getPassword())) {
            user.setPassword(MD5Util.MD5(user.getPassword()));
            User user1 = mapper.selectOne(user);
            if (user1 == null) {
                //用户名不存在
                return false;
            } else {
                if (user1.getPassword().equals(user.getPassword())) {
                    //登录成功
                    //补全user对象中的属性
                    BeanUtils.copyProperties(user1,user);
                    return true;
                } else {
                    //密码错误
                    return false;
                }
            }
        }
        return false;

    }

    /**
     * 通过用户类型查询,如果用户类型为空则通过用户id查询
     *
     * @param user
     * @return
     */
    @Override
    public List<User> selectUser(User user) {
        user.setPassword(MD5Util.MD5(user.getPassword()));
        return mapper.selectUser(user);
    }
}
