package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.dto.ElevatorStatusDto;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.ShenpiService;
import com.akk.elevatorproject.util.EnumToList;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-26
 *         时间: 20:38
 */
@Controller
@RequestMapping("/company/weibao")
public class WeibaoController {

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private HttpSession session;

    @RequestMapping("/elevatorStatus")
    public @ResponseBody
    ResultVO elevatorStatus(){
        List<ElevatorStatusDto> elevatorStatusList = EnumToList.ElevatorStatus();

        return ResultVOUtil.success(elevatorStatusList);
    }

    /**
     * 根据物业id
     * 查找电梯
     * @return
     */
    @RequestMapping("/showElevator")
    public @ResponseBody
    ResultVO showElevator(Elevator newElevator) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        newElevator.setWeibaoId(user.getCompanyId()+"");

        List<Elevator> list = elevatorService.selectElevator(newElevator);

        return ResultVOUtil.success(list);
    }



}
