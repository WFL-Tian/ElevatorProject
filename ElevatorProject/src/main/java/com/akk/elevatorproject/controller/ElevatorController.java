package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.CompanyTypeEnum;
import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.dto.ElevatorDto;
import com.akk.elevatorproject.dto.IndexDto;
import com.akk.elevatorproject.entity.*;
import com.akk.elevatorproject.service.CompanyService;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.LoupanService;
import com.akk.elevatorproject.service.ShenpiService;
import com.akk.elevatorproject.util.EnumToList;
import com.akk.elevatorproject.util.KeyUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.akk.elevatorproject.constant.ElevatorStatusEnum.Normal;
import static com.akk.elevatorproject.constant.PageCodeEnum.ADD_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.MODIFY_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.REMOVE_FAIL;
import static com.akk.elevatorproject.constant.ShStatusEnum.SH_SUCCESS;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMIN;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMINISTRATOR;
import static com.akk.elevatorproject.constant.UserTypeEnum.DEVELOP;
import static com.akk.elevatorproject.constant.ElevatorTypeEnum.SHOUFU;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 21:00
 */
@Controller
@RequestMapping("/elevator")
public class ElevatorController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private ShenpiService shenpiService;

    @Autowired
    private LoupanService loupanService;

    @Autowired
    private HttpSession session;


    /**
     *
     * @return
     */
    @RequestMapping("/index")
    public @ResponseBody
    ResultVO index() {
        IndexDto indexDto = new IndexDto();

        Elevator elevator = new Elevator();
        List<Elevator> list = elevatorService.selectElevatorByStatus(elevator);

        elevator.setElevatorStatus(Normal.getId());
        List<Elevator> goodList = elevatorService.selectElevatorByStatus(elevator);

        indexDto.setGoodElevator(goodList.size());

        indexDto.setBadElevator(list.size()-goodList.size());

        return ResultVOUtil.success(indexDto);
    }


    /**
     * 增添初始化
     * @return
     */
    @RequestMapping("/addInit")
    public @ResponseBody
    ResultVO addInit() {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        ElevatorDto elevatorDto = new ElevatorDto();
        elevatorDto.setElevatorTypeList(EnumToList.ElevatorType());
        elevatorDto.setElevatorStatusList(EnumToList.ElevatorStatus());

        Loupan loupan = new Loupan();
        loupan.setDevelopId(user.getCompanyId());
        elevatorDto.setLoupanList(loupanService.selectLoupan(loupan));

        //判断添加什么类型的用户
        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){

            Loupan loupan1 = new Loupan();
            elevatorDto.setLoupanList(loupanService.selectLoupan(loupan1));

            //超级管理员,管理员添加电梯
            Company company = new Company();
            company.setCompanyShStatus(1);

            company.setCompanyType(CompanyTypeEnum.DEVELOP.getCode());
            elevatorDto.setWuyeList(companyService.selectCompany(company));

            company.setCompanyType(CompanyTypeEnum.WUYE.getCode());
            elevatorDto.setWuyeList(companyService.selectCompany(company));

            company.setCompanyType(CompanyTypeEnum.WEIBAO.getCode());
            elevatorDto.setWeibaoList(companyService.selectCompany(company));
        }

        return ResultVOUtil.success(elevatorDto);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * 添加电梯
     * 开发商只能通过了审批才可以添加电梯
     * @return
     */
    @RequestMapping("/addElevator")
    public @ResponseBody
    ResultVO addElevator(Elevator newElevator) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        Shenpi shenpi = new Shenpi();
        shenpi.setLoupanId(newElevator.getLoupanId());
        List<Shenpi> shenpiList = shenpiService.selectShenpi(shenpi);
        Shenpi shenpi1 = shenpiList.get(0);
        for (int i = 1;i<shenpiList.size();i++){
            Shenpi shenpi2 = shenpiList.get(i);
            if (SH_SUCCESS.getCode().equals(shenpi2.getShenpiStatus())){
                shenpi1 = shenpi2;
                break;
            }
        }

        //判断添加什么类型的用户
        if (SH_SUCCESS.getCode().equals(shenpi1.getShenpiStatus())
                &&DEVELOP.getCode().equals(user.getUserType())){
            //开发商管理员,管理员添加电梯
            newElevator.setDevelopId(user.getCompanyId());
            newElevator.setLoupanId(shenpi1.getLoupanId());
            newElevator.setElevatorId(KeyUtil.genUniqueKey());
        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (elevatorService.insert(newElevator)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }

    /**
     * 添加电梯
     * 管理员可以随意添加电梯信息
     * @return
     */
    @RequestMapping("/adminAdd")
    public @ResponseBody
    ResultVO add(Elevator newElevator) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        //判断添加什么类型的用户
        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //超级管理员,管理员添加电梯

        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (elevatorService.insert(newElevator)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }

    /**
     * 删除电梯
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    ResultVO delete(Elevator newElevator) {
        if (elevatorService.delete(newElevator)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(REMOVE_FAIL.getCode(),REMOVE_FAIL.getMsg());
        }
    }


    /**
     * 修改电梯
     * @return
     */
    @RequestMapping("/modify")
    public @ResponseBody
    ResultVO change(Elevator newElevator) {
        if (elevatorService.update(newElevator)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(MODIFY_FAIL.getCode(),MODIFY_FAIL.getMsg());
        }
    }

    /**
     * 查找电梯
     * @return
     */
    @RequestMapping("/search")
    public @ResponseBody
    ResultVO search(Elevator newElevator) {

        List<Elevator> list = elevatorService.selectElevator(newElevator);

        return ResultVOUtil.success(list);
    }

}
