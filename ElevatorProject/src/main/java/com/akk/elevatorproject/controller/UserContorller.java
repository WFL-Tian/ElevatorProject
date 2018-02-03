package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.akk.elevatorproject.constant.PageCodeEnum.ADD_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.MODIFY_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.REMOVE_FAIL;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMIN;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMINISTRATOR;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;
import static com.akk.elevatorproject.util.CommonUtil.isNotEmpty;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 17:30
 */
@Controller
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/add")
    public @ResponseBody
    ResultVO add(User newUser) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        //通过在数据库中查询添加账户的用户名得到的user对象来判断用户名是否重名
        if (isNotEmpty(userService.selectByUsername(newUser.getUsername()))){
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        //判断添加什么类型的用户
        if (ADMINISTRATOR.getCode().equals(user.getUserType())){
            //超级管理员添加管理员
            newUser.setCompanyId(user.getCompanyId());
            newUser.setUserType(ADMIN.getCode());
            newUser.setShStatus(1);
        }else {
            if (user.getIfCAdmin()!=0&&!ADMIN.getCode().equals(user.getUserType())){
                //公司管理员添加下级账户
                newUser.setCompanyId(user.getCompanyId());
                newUser.setUserType(user.getUserType());
                newUser.setShStatus(1);
            }else {
                return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
            }
        }

        if (userService.insert(newUser)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    ResultVO delete(User newUser) {
        if (userService.delete(newUser)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(REMOVE_FAIL.getCode(),REMOVE_FAIL.getMsg());
        }
    }

    /**
     * 修改用户
     * @return
     */
    @RequestMapping("/modify")
    public @ResponseBody
    ResultVO modify(User newUser) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        newUser.setCompanyId(user.getCompanyId());

        newUser.setShStatus(1);

        if (userService.update(newUser)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(MODIFY_FAIL.getCode(),MODIFY_FAIL.getMsg());
        }
    }


    /**
     * 查找用户
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    ResultVO search(User newUser) {
        List<User> list = userService.selectUser(newUser);

        return ResultVOUtil.success(list);
    }

}
