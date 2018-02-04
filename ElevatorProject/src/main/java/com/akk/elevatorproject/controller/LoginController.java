package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.dto.CompanyAdminDto;
import com.akk.elevatorproject.entity.Company;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.service.CompanyService;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.util.CodeUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.vo.ResultVO;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;

import static com.akk.elevatorproject.constant.PageCodeEnum.LOGIN_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.REMOVE_FAIL;
import static com.akk.elevatorproject.constant.PageCodeEnum.VerifyCode_FAIL;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMIN;
import static com.akk.elevatorproject.constant.UserTypeEnum.ADMINISTRATOR;


/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 17:11
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    /**
     * 登录入口
     */
    @RequestMapping
    public @ResponseBody
    ResultVO login(@RequestParam("username") String username,
                   @RequestParam("password") String password,
                   @RequestParam("verifycode") String VerifyCode,
                   HttpServletRequest request) {

        if (!CodeUtil.checkVerifyCode(request,VerifyCode)){
            return ResultVOUtil.error(VerifyCode_FAIL.getCode(),VerifyCode_FAIL.getMsg());
        }

        User user =new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.validate(user)&&session!=null){
            session.setAttribute(SessionKeyConst.USER_INFO, user);
            
			//返回 公司信息与账户信息
            CompanyAdminDto companyAdminDto = new CompanyAdminDto();
            companyAdminDto.setUser(user);

            if (ADMINISTRATOR.getCode().equals(user.getUserType())
                    ||ADMIN.getCode().equals(user.getUserType())){
                //管理员没有公司信息
            }else {
                Company company = new Company();
                company.setCompanyId(user.getCompanyId());
                companyAdminDto.setCompany(companyService.selectCompany(company).get(0));
            }

            return ResultVOUtil.success(companyAdminDto);
        }else{
            //密码错误
            return ResultVOUtil.error(LOGIN_FAIL.getCode(),LOGIN_FAIL.getMsg());
        }
    }


    /**
     *  登出
     */
    @RequestMapping("/loginOut")
    public @ResponseBody
    ResultVO loginOut() {
        session.invalidate();
        return ResultVOUtil.success();
    }

    @Autowired
    private Producer captchaProducer;

	/**
     *  验证码
     */
    @RequestMapping("/verifycode")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        response.setDateHeader("Expires", 0);
        
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        
        response.setHeader("Pragma", "no-cache");
        
        response.setContentType("image/jpeg");
        
        String capText = captchaProducer.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

		//控制台显示验证码
        System.out.println("Session 验证码是:" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
        return null;
    }

}
