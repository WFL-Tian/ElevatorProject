package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.entity.Shenpi;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.service.ShenpiService;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.akk.elevatorproject.constant.PageCodeEnum.ADD_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.MODIFY_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.REMOVE_FAIL;
import static com.akk.elevatorproject.constant.ShStatusEnum.NOTSH;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMIN;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMINISTRATOR;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 20:48
 */
@Controller
@RequestMapping("/Shenpi")
public class ShenpiController {


    @Autowired
    private ShenpiService shenpiService;

    @Autowired
    private HttpSession session;

    /**
     * 添加审批
     * @return
     */
    @RequestMapping("/add")
    public @ResponseBody
    ResultVO addShenpi(Shenpi shenpi) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //只有管理员或者超级管理员才可以直接添加审批
            shenpi.setCompanyId(user.getCompanyId());
            shenpi.setShenpiStatus(NOTSH.getCode());
        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (shenpiService.insert(shenpi)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }

    /**
     * 删除审批
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    ResultVO delete(Shenpi shenpi) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //只要管理员或者超级管理员才可以修改审批
        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (shenpiService.delete(shenpi)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(REMOVE_FAIL.getCode(),REMOVE_FAIL.getMsg());
        }
    }

    /**
     * 修改审批
     * @return
     */
    @RequestMapping("/modify")
    public @ResponseBody
    ResultVO change(Shenpi shenpi) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //只要管理员或者超级管理员才可以修改审批
            shenpi.setShenpiTime(new Date());
        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (shenpiService.update(shenpi)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(MODIFY_FAIL.getCode(),MODIFY_FAIL.getMsg());
        }
    }


    /**
     * 查找审批
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    ResultVO search(Shenpi shenpi) {
        List<Shenpi> list = shenpiService.selectShenpi(shenpi);

        return ResultVOUtil.success(list);
    }


}
