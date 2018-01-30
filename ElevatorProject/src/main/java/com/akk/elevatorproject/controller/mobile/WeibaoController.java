package com.akk.elevatorproject.controller.mobile;

import com.akk.elevatorproject.dto.WeibaoDTO;
import com.akk.elevatorproject.entity.*;
import com.akk.elevatorproject.enums.ElevatorStatusEnum;
import com.akk.elevatorproject.enums.ResultEnum;
import com.akk.elevatorproject.enums.WeibaoTypeEnum;
import com.akk.elevatorproject.service.*;
import com.akk.elevatorproject.util.FileUploadUtil;
import com.akk.elevatorproject.util.KeyUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.util.StringUtil;
import com.akk.elevatorproject.vo.ResultVO;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Controller
@RequestMapping("/mobile/weibao")
public class WeibaoController {

    //加载绝对路径
    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Autowired
    private WeibaoService weibaoService;

    @Autowired
    private QRService qrService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private ImgService imgService;

    @Autowired
    private  ComplaintService complaintService;

    /**
     * 查询维保信息
     * @param id 电梯id
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam(value = "id")String id){
        List<WeibaoDTO> weibaoDTOList=weibaoService.queryWeibaoList(id);
        System.out.println("---"+weibaoDTOList);
        System.out.println("---"+weibaoDTOList.size());
        if (weibaoDTOList.size()==0){
            return ResultVOUtil.error(ResultEnum.WEIBAO_NOT_EXIST.getCode(), ResultEnum.WEIBAO_NOT_EXIST.getMessage());
        }else {
            return ResultVOUtil.success(weibaoDTOList);
        }
    }


    /**
     * 录入维修维保信息
     * @param request
     * @param id
     * @param weibaoType
     * @param weibaoDesc
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO list(HttpServletRequest request,
                         @RequestParam(value = "id", required = false)String id,
                         @RequestParam(value = "weibaoType", required = false, defaultValue = "1")String weibaoType,
                         @RequestParam(value = "weibaoDesc", required = false, defaultValue = "无")String weibaoDesc){
        //判断用户输入数据是否合法
        if (StringUtil.isNull(id)){
            return ResultVOUtil.error(ResultEnum.QRID_NULL.getCode(), ResultEnum.QRID_NULL.getMessage());
        }
        if ( StringUtil.isNull(weibaoType)){
            return ResultVOUtil.error(ResultEnum.WEIBAOTYPE_ERROR.getCode(), ResultEnum.WEIBAOTYPE_ERROR.getMessage());
        }
        //检查用户是否登录

        User user =  (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultVOUtil.error(ResultEnum.WEIBAO_LOGIN_ERROR.getCode(), ResultEnum.WEIBAO_LOGIN_ERROR.getMessage());
        }

        Integer qr_id;
        try{
            qr_id = Integer.parseInt(id);
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.QR_ERROR.getCode(),ResultEnum.QR_ERROR.getMessage());
        }
        QR qr = qrService.selectOne(qr_id);
        //判断系统中是否有该二维码
        if (qr == null || qr.equals("")){
            return ResultVOUtil.error(ResultEnum.QR_NOT_EXIST.getCode(),ResultEnum.QR_NOT_EXIST.getMessage());
        }

        List<Img> imgList = FileUploadUtil.getImgList(request, qr.getElevatorId(), adImageSavePath);
        if (imgList == null){
            return ResultVOUtil.error(ResultEnum.WEIBAOIMG_ERROR.getCode(), ResultEnum.WEIBAOIMG_ERROR.getMessage());
        }

        try{

            //存储数据
            Weibao weibao = new Weibao();
            weibao.setWeibaoId(KeyUtil.genUniqueKey());
            weibao.setElevatorId(qr.getElevatorId());
            weibao.setUserId(user.getUserId());
            weibao.setUserId(user.getUserId());

            weibao.setWeibaoType(weibaoType);
            weibao.setWeibaoDesc(weibaoDesc);
            weibao.setCreateTime(new Timestamp(System.currentTimeMillis()));

            //查询上次维保时间
            List<WeibaoDTO> weibaoLast = weibaoService.queryWeibaoList(qr.getElevatorId());
            WeibaoDTO weibaoDTO = null;
            //如果是第一次添加维保，上次维保时间和创建时间相同
            if (weibaoLast.size() == 0){
                weibao.setLastEditTime(weibao.getCreateTime());
                weibao.setElevatorStatus(0);

            }else {
                weibaoDTO = weibaoLast.get(0);
                //设置电梯状态(已维修、未维修)
                int state = weibaoDTO.getCreateTime().getTime()-weibao.getCreateTime().getTime()>15 * 1000 * 60 * 60 * 24?1 : 0;
                weibao.setElevatorStatus(state);
                weibao.setLastEditTime(weibaoDTO.getCreateTime());
            }

            //修改电梯状态
            Elevator elevator = new Elevator();
            elevator.setElevatorId(qr.getElevatorId());
            elevator.setElevatorStatus(ElevatorStatusEnum.Normal.getId());

            int elelevatorServiceresult =  elevatorService.updateElevator(elevator);

            if(elelevatorServiceresult!=1){

            }

            //插入数据
            int  result =  weibaoService.insertWeibao(weibao);
            int imgSize= imgList.size();
            int imgResult =imgService.insertImg(imgList);
            if (result != 1){
                return ResultVOUtil.error(ResultEnum.WEIBAO_ERROR.getCode(), ResultEnum.WEIBAO_ERROR.getMessage());
            }
            if (imgSize != imgResult){
                return ResultVOUtil.error(ResultEnum.UPLOADFILE_ERROR.getCode(), ResultEnum.UPLOADFILE_ERROR.getMessage());
            }


            //修改投诉单

            Complaint complaint = new Complaint();
            //根据电梯编号查询最后一条投诉单
            List<Complaint> complaints = complaintService.selectComplaintByElevatorId(qr.getElevatorId());
            if (complaints != null){
                //获取第一条数据
                complaint = complaints.get(0);
                //如果投诉电梯当前状态为0(维保单没有被处理)
                if (complaint.getComplaintStatus() == 0){
                    complaint.setComplaintStatus(1);
                    complaint.setResultInfo(weibaoDesc);
                    complaint.setLastEditTime(new Timestamp(System.currentTimeMillis()));
                }
                //更新投诉单
                int complaintResult = complaintService.updateComplaint(complaint);
                if (complaintResult != 1){
                    return ResultVOUtil.error(ResultEnum.WEIBAO_ERROR.getCode(), ResultEnum.WEIBAO_ERROR.getMessage());
                }

            }
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.WEIBAO_ERROR.getCode(), ResultEnum.WEIBAO_ERROR.getMessage());
        }
        return ResultVOUtil.success();
    }


}
