package com.akk.elevatorproject.controller.mobile;

import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.enums.ResultEnum;
import com.akk.elevatorproject.enums.UserTypeEnum;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.CodeUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.util.StringUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tianjun on 2018/1/25.
 */
@Controller
@RequestMapping("/mobile/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO login(@RequestParam(value = "username", required = false)String username,
                          @RequestParam(value = "password", required = false)String password,
                          @RequestParam(value = "verifycode", required = false)String verifycode,
                          HttpServletRequest request){

        //检查验证码是否正确
        if (!CodeUtil.checkVerifyCode(request, verifycode)){
            return ResultVOUtil.error(ResultEnum.VERIFYCODE_ERROR.getCode(),ResultEnum.VERIFYCODE_ERROR.getMessage());
        }

        //判断用户名和密码是否为空
        if ( StringUtil.isNull(username)){
            return ResultVOUtil.error(ResultEnum.USER_NULL.getCode(),ResultEnum.USER_NULL.getMessage());
        }else if (StringUtil.isNull(password)){
            return ResultVOUtil.error(ResultEnum.PASSWORD_NULL.getCode(),ResultEnum.PASSWORD_NULL.getMessage());
        }
        User user1 = new User();
        user1.setUsername(username);

        User user = userService.queryUser(user1);
        //判断用户类型是否是维保工作人员
        if (user.getUserType() != UserTypeEnum.WEIBAO.getCode()){
            return ResultVOUtil.error(ResultEnum.USERTYPE_ERROR.getCode(), ResultEnum.USERTYPE_ERROR.getMessage());
        }
        if (user!=null&&user.getPassword().equals(password)){
            //如果登录成功，将用户信息存在session中
            request.getSession().setAttribute("user", user);
            User user2 = (User) request.getSession().getAttribute("user");
            System.out.println("user.getRealname--"+user2.getRealname());
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error(ResultEnum.USERORPASSWORD_ERROR.getCode(), ResultEnum.USERORPASSWORD_ERROR.getMessage());
        }
    }

}
