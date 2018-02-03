package com.akk.elevatorproject.controller;

import com.akk.elevatorproject.constant.SessionKeyConst;
import com.akk.elevatorproject.dto.ShenpiDto;
import com.akk.elevatorproject.entity.*;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.ImgService;
import com.akk.elevatorproject.service.LoupanService;
import com.akk.elevatorproject.service.ShenpiService;
import com.akk.elevatorproject.util.KeyUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.util.SavePicture;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.akk.elevatorproject.constant.PageCodeEnum.*;
import static com.akk.elevatorproject.constant.ShStatusEnum.NOTSH;
import static com.akk.elevatorproject.constant.UserTypeEnum.DEVELOP;
import static com.akk.elevatorproject.util.CommonUtil.isEmpty;

/**
 * @author gchiaway
 *         日期: 2018-01-26
 *         时间: 20:21
 */
@Controller
@RequestMapping("/company/develop")
public class DevelopController {

    @Autowired
    private ShenpiService shenpiService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private ImgService imgService;

    @Autowired
    private LoupanService loupanService;

    @Autowired
    private HttpSession session;

    @Value("#{configProperties['system.articlepictures']}")
    private String shenpiPicturesUrl;

    /**
     * 添加楼盘
     * @return
     */
    @RequestMapping("/addLoupan")
    public @ResponseBody
    ResultVO addLoupan(Loupan loupan) {

        User user = (User) session.getAttribute(SessionKeyConst.USER_INFO);

        System.out.println(user.getUserType());
        if (DEVELOP.getCode().equals(user.getUserType())){

            loupan.setDevelopId(user.getCompanyId());
        } else {
            return ResultVOUtil.error(NO_AUTH.getCode(), NO_AUTH.getMsg());
        }

        if (loupanService.insert(loupan) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(ADD_FAIL.getCode(), ADD_FAIL.getMsg());
        }
    }

    /**
     * 修改楼盘
     * @return
     */
    @RequestMapping("/modifyLoupan")
    public @ResponseBody
    ResultVO modifyLoupan(Loupan loupan) {
        User user = (User) session.getAttribute(SessionKeyConst.USER_INFO);

        loupan.setDevelopId(user.getCompanyId());
        if (loupanService.update(loupan) == 1) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(MODIFY_FAIL.getCode(), MODIFY_FAIL.getMsg());
        }
    }


    /**
     * 提交审批
     * @return
     */
    @RequestMapping("/addShenpi")
    public @ResponseBody
    ResultVO addShenpi(ShenpiDto shenpiDto) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        String picturesUrl = SavePicture.saveFile(shenpiDto.getFile(),shenpiPicturesUrl);

        if(isEmpty(picturesUrl)){
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }else {
            Shenpi shenpi =new Shenpi();
            BeanUtils.copyProperties(shenpiDto, shenpi);

            shenpi.setCompanyId(user.getCompanyId());
            shenpi.setShenpiStatus(NOTSH.getCode());
            shenpi.setShenpiId(KeyUtil.genUniqueKey());

            if(shenpiService.insert(shenpi)==1){

                Img img = new Img();
                img.setImgId(KeyUtil.genUniqueKey());
                img.setImgDesc(shenpiDto.getImgDesc());
                img.setImgName(picturesUrl);
                img.setGroupId(shenpi.getShenpiId());

                if(imgService.insert(img)==1){
                    return ResultVOUtil.success();
                }else {
                    return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
                }
            }
            return ResultVOUtil.error(ADD_FAIL.getCode(),ADD_FAIL.getMsg());
        }
    }


    /**
     * 查找审批
     * @return
     */
    @RequestMapping("/showShenpi")
    public @ResponseBody
    ResultVO showShenpi(Shenpi shenpi) {
        User user = (User)session.getAttribute(SessionKeyConst.USER_INFO);

        shenpi.setCompanyId(user.getCompanyId());
        List<Shenpi> list = shenpiService.selectShenpi(shenpi);

        return ResultVOUtil.success(list);
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

        newElevator.setDevelopId(user.getCompanyId());

        List<Elevator> list = elevatorService.selectElevator(newElevator);

        return ResultVOUtil.success(list);
    }


}
