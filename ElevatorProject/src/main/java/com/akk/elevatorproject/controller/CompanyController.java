package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.CompanyTypeEnum;
import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.dto.AllotDto;
import com.akk.elevatorproject.dto.CompanyTypeDto;
import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.Loupan;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.from.CompanySignFrom;
import com.akk.elevatorproject.service.CompanyService;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.LoupanService;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.EnumToList;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.akk.elevatorproject.constant.PageCodeEnum.*;
import static com.akk.elevatorproject.constant.ShStatusEnum.NOTSH;
import static com.akk.elevatorproject.constant.ShStatusEnum.SH_SUCCESS;
import static com.akk.elevatorproject.constant.UserTypeEnum.*;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;
import static com.akk.elevatorproject.util.CommonUtil.isNotEmpty;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 20:33
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoupanService loupanService;

    @Autowired
    private HttpSession session;


    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/addUser")
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
            newUser.setUserType(ADMIN.getCode());
            newUser.setShStatus(1);
        }else {
            if (user.getIfCAdmin()==1){
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
    @RequestMapping("/deleteUser")
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
    @RequestMapping("/modifyUser")
    public @ResponseBody
    ResultVO change(User newUser) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        newUser.setCompanyId(user.getCompanyId());
        newUser.setUserType(user.getUserType());
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
    @RequestMapping("/searchUser")
    public @ResponseBody
    ResultVO search(User newUser) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        newUser.setCompanyId(user.getCompanyId());

        List<User> list = userService.selectUser(newUser);

        return ResultVOUtil.success(list);
    }

    /**
     * 查看所管理楼盘
     * @return
     */
    @RequestMapping("/showLoupan")
    public @ResponseBody
    ResultVO showLoupan() {

        return ResultVOUtil.success(getLoupanService());
    }


    /**
     * 获取管理的全部楼盘
     * @return
     */
    public List<Loupan> getLoupanService() {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        Loupan loupan = new Loupan();

        switch (user.getUserType()){
            case 3:{
                loupan.setDevelopId(user.getCompanyId());
                break;
            }
            case 4:{
                loupan.setWuyeId(user.getCompanyId());
                break;
            }
            case 5:{
                loupan.setWeibaoId(user.getCompanyId()+"");
                break;
            }
            default:{
                break;
            }
        }

        return loupanService.selectLoupan(loupan);
    }

    /**
     * 分配初始化
     * @return
     */
    @RequestMapping("/allotInit")
    public @ResponseBody
    ResultVO allotInit(){

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        Company company = new Company();
        company.setCompanyShStatus(1);

        if (DEVELOP.getCode().equals(user.getUserType())){
            company.setCompanyType(CompanyTypeEnum.WUYE.getCode());
            List<Company> wuyeList = companyService.selectCompany(company);
            return ResultVOUtil.success(wuyeList);
        }

        if (WUYE.getCode().equals(user.getUserType())){
            company.setCompanyType(CompanyTypeEnum.WEIBAO.getCode());
            List<Company> weibaoList = companyService.selectCompany(company);
            return ResultVOUtil.success(weibaoList);
        }

        if (WEIBAO.getCode().equals(user.getUserType())){
            return ResultVOUtil.error(NO_AUTH.getCode(),NO_AUTH.getMsg());
        }

        return ResultVOUtil.error(REQUEST_FAIL.getCode(),REQUEST_FAIL.getMsg());
    }


    /**
     *根据 User 的公司类型决定是
     *开发商给物业公司分配楼盘
     *还是
     *物业公司给维保公司分配楼盘
     * @param companyId1
     * @param loupanId1
     * @return
     */
    @RequestMapping("/allot")
    public @ResponseBody
    ResultVO allot(@RequestParam("companyId") String companyId1,
                   @RequestParam("loupanId") String loupanId1){

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        int companyId = Integer.parseInt(companyId1);
        int loupanId = Integer.parseInt(loupanId1);

        if (DEVELOP.getCode().equals(user.getUserType())){

            if (elevatorService.developAllot(user.getCompanyId(),companyId,loupanId)!=0
                    &&loupanService.developAllot(user.getCompanyId(),companyId,loupanId)!=0){
                return ResultVOUtil.success();
            }else{
                return ResultVOUtil.error(ASSIGN_FAIL.getCode(),ASSIGN_FAIL.getMsg());
            }
        }

        if (WUYE.getCode().equals(user.getUserType())){

            if (elevatorService.wuyeAllot(user.getCompanyId(),companyId+"",loupanId)!=0
                    &&loupanService.wuyeAllot(user.getCompanyId(),companyId+"",loupanId)!=0){
                return ResultVOUtil.success();
            }else{
                return ResultVOUtil.error(ASSIGN_FAIL.getCode(),ASSIGN_FAIL.getMsg());
            }
        }

        if (WEIBAO.getCode().equals(user.getUserType())){
            return ResultVOUtil.error(NO_AUTH.getCode(),NO_AUTH.getMsg());
        }


        return ResultVOUtil.error(ASSIGN_FAIL.getCode(),ASSIGN_FAIL.getMsg());
    }

    @RequestMapping("/checkShStatus")
    public @ResponseBody
    ResultVO check() {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);
        Company newCompany = new Company();

        newCompany.setCompanyId(user.getCompanyId());

        return ResultVOUtil.success(companyService.selectCompany(newCompany));
    }

    /**
     * 新公司注册
     * @return
     */
    @RequestMapping("/sign")
    public @ResponseBody
    ResultVO sign(CompanySignFrom companySignFrom) {
        Company newCompany = new Company();

        BeanUtils.copyProperties(companySignFrom,newCompany);
        newCompany.setCompanyShStatus(NOTSH.getCode());
        User newUser = new User();
        BeanUtils.copyProperties(companySignFrom,newUser);

        //通过在数据库中查询添加账户的用户名得到的user对象来判断用户名是否重名

        if (isNotEmpty(userService.selectByUsername(newUser.getUsername()))){
System.out.println("重名");
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }

        if (companyService.insert(newCompany)==1){
            newUser.setCompanyId(newCompany.getCompanyId());
            newUser.setUserType(newCompany.getCompanyType());
            newUser.setIfCAdmin(1);
            //TODO: user 都是直接通过审核的
            newUser.setShStatus(SH_SUCCESS.getCode());

            if (userService.insert(newUser)==1){
                return ResultVOUtil.success();
            }else{
System.out.println("账户添加失败");
                return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
            }
        }else{
System.out.println("公司添加失败");
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }


    }

    /**
     * 添加公司初始化
     * @return
     */
    @RequestMapping("/addCompanyInit")
    public @ResponseBody
    ResultVO addCompanyInit() {
        List<CompanyTypeDto> companyTypeList = EnumToList.CompanyType();

        return ResultVOUtil.success(companyTypeList);
    }

    /**
     * 只有管理员可以添加公司
     * 添加新公司
     * @return
     */
    @RequestMapping("/addCompany")
    public @ResponseBody
    ResultVO add(CompanySignFrom companySignFrom) {

        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //管理员添加公司
            Company newCompany = new Company();
            //后赋前
            BeanUtils.copyProperties(companySignFrom,newCompany);
            newCompany.setCompanyShStatus(SH_SUCCESS.getCode());
            User newUser = new User();
            BeanUtils.copyProperties(companySignFrom,newUser);

            //通过在数据库中查询添加账户的用户名得到的user对象来判断用户名是否重名

            if (isNotEmpty(userService.selectByUsername(newUser.getUsername()))){
                System.out.println("重名");
                return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
            }

            if (companyService.insert(newCompany)==1){
                newUser.setCompanyId(newCompany.getCompanyId());
                newUser.setUserType(newCompany.getCompanyType());
                newUser.setIfCAdmin(1);
                //TODO: user 都是直接通过审核的
                newUser.setShStatus(SH_SUCCESS.getCode());

                if (userService.insert(newUser)==1){
                    return ResultVOUtil.success();
                }else{
                    System.out.println("账户添加失败");
                    return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
                }
            }else{
                System.out.println("公司添加失败");
                return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
            }
        }else {
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }


    /**
     * 只要管理员可以删除公司
     * 删除公司
     * @return
     */
    @RequestMapping("/deleteCompany")
    public @ResponseBody
    ResultVO delete(Company newCompany) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())){
            //管理员删除公司
        }else {
            return ResultVOUtil.error(REMOVE_FAIL.getCode(),REMOVE_FAIL.getMsg());
        }

        if (companyService.delete(newCompany)==1){

            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(REMOVE_FAIL.getCode(),REMOVE_FAIL.getMsg());
        }
    }

    /**
     * 只有管理员
     * 或者公司的管理员
     * 才可以
     * 修改公司信息
     * @return
     */
    @RequestMapping("/modifyCompany")
    public @ResponseBody
    ResultVO change(Company newCompany) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        //管理员修改公司信息 或者公司的管理员修改公司信息
        if (ADMINISTRATOR.getCode().equals(user.getUserType())
                ||ADMIN.getCode().equals(user.getUserType())
                ||user.getIfCAdmin()==1){
            newCompany.setCompanyShStatus(SH_SUCCESS.getCode());
        }else {
            return ResultVOUtil.error(MODIFY_FAIL.getCode(),MODIFY_FAIL.getMsg());
        }

        if (companyService.update(newCompany)==1){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(MODIFY_FAIL.getCode(),MODIFY_FAIL.getMsg());
        }
    }

    /**
     * 查找公司
     * @return
     */
    @RequestMapping("/searchCompany")
    public @ResponseBody
    ResultVO searchCompany(Company newCompany) {
        System.out.println(newCompany.getCompanyType());
        List<Company> list = companyService.selectCompany(newCompany);

        return ResultVOUtil.success(list);
    }


    /**
     * 查找公司
     * @return
     */
    @RequestMapping(value="/searchCompany/{companyType}")
    public @ResponseBody
    ResultVO search(@PathVariable("companyType") String companyType,
                           Company newCompany) {

        //判断companyType
        switch (companyType){
            case "develop":{
                newCompany.setCompanyType(CompanyTypeEnum.DEVELOP.getCode());
                break;
            }
            case "wuye":{
                newCompany.setCompanyType(CompanyTypeEnum.WUYE.getCode());
                break;
            }
            case "weibao":{
                newCompany.setCompanyType(CompanyTypeEnum.WEIBAO.getCode());
                break;
            }
            default:{
                break;
            }
        }

        List<Company> list = companyService.selectCompany(newCompany);

        return ResultVOUtil.success(list);
    }


}
