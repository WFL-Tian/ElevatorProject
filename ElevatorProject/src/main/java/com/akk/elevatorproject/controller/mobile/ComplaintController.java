package com.akk.elevatorproject.controller.mobile;

import com.akk.elevatorproject.entity.Complaint;
import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.entity.QR;
import com.akk.elevatorproject.enums.ElevatorStatusEnum;
import com.akk.elevatorproject.enums.ResultEnum;
import com.akk.elevatorproject.service.ComplaintService;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.ImgService;
import com.akk.elevatorproject.service.QRService;
import com.akk.elevatorproject.util.FileUploadUtil;
import com.akk.elevatorproject.util.KeyUtil;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.util.StringUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Controller
@RequestMapping("/mobile/complaint")
public class ComplaintController {


    //加载绝对路径
    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Autowired
    private QRService qrService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private ImgService imgService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO list(HttpServletRequest request,
                         @RequestParam(value = "id", required = false)String id,
                         @RequestParam(value = "helpPeople", required = false, defaultValue = "0")String helpPeople,
                         @RequestParam(value = "complaintType", required = false, defaultValue = "1")String complaintType,
                         @RequestParam(value = "reason", required = false) String reason,
                         @RequestParam(value = "phone", required = false)String phone
                        ){
        //判断用户输入数据是否合法
        if (StringUtil.isNull(id)){
            return ResultVOUtil.error(ResultEnum.QRID_NULL.getCode(), ResultEnum.QRID_NULL.getMessage());
        }
        Integer qr_id;
        try {
            qr_id = Integer.parseInt(id);
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.QR_ERROR.getCode(), ResultEnum.QR_ERROR.getMessage());
        }
        QR qr = qrService.selectOne(qr_id);
        if (qr == null || qr.equals("")){
            return ResultVOUtil.error(ResultEnum.QR_NOT_EXIST.getCode(),ResultEnum.QR_NOT_EXIST.getMessage());
        }

        if (StringUtil.isNull(reason)){
            return ResultVOUtil.error(ResultEnum.REASON_NULL.getCode(),ResultEnum.REASON_NULL.getMessage());
        }
        if ( StringUtil.isNull(phone)){
            return ResultVOUtil.error(ResultEnum.PHONE_NULL.getCode(),ResultEnum.PHONE_NULL.getMessage());
        }

        //接收前端参数的初始化，包括电梯编号id、被困人数、投诉类型、投诉原因、电话号码、图片(可能多个)
        //用用于判断用户是否上传图片。
        //qr.getElevatorId()根据id获取电梯id
        List<Img> imgList = FileUploadUtil.getImgList(request, qr.getElevatorId(),adImageSavePath);
        boolean flag = true;
        if (imgList == null){
            flag = false;
        }

        try{
            //如果用户上传照片，则存储数据，负责不存储
            if (flag){
                System.out.println("imgList.size----"+imgList.size());
                Complaint complaint = new Complaint();
                complaint.setComplaintNumber(KeyUtil.genUniqueKey());
                complaint.setElevatorId(qr.getElevatorId());
                complaint.setHelpPeople(Integer.parseInt(helpPeople));
                complaint.setComplaintType(Integer.parseInt(complaintType));
                complaint.setReason(reason);
                complaint.setPhone(phone);
                complaint.setComplaintStatus(0);
                complaint.setResultInfo("未处理");
                complaint.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //修改电梯状态
                Elevator elevator = new Elevator();
                elevator.setElevatorId(qr.getElevatorId());
                elevator.setElevatorStatus(Integer.parseInt(complaintType)+2);
                elevatorService.updateElevator(elevator);
                //插入数据
                complaintService.insertComplaint(complaint);
                imgService.insertImg(imgList);
            }else {
                Complaint complaint = new Complaint();
                complaint.setComplaintNumber(KeyUtil.genUniqueKey());
                complaint.setElevatorId(qr.getElevatorId());
                complaint.setHelpPeople(Integer.parseInt(helpPeople));
                complaint.setComplaintType(Integer.parseInt(complaintType));
                complaint.setReason(reason);
                complaint.setPhone(phone);
                complaint.setComplaintStatus(0);
                complaint.setResultInfo("未处理");
                complaint.setCreateTime(new Timestamp(System.currentTimeMillis()));
                //修改电梯状态
                Elevator elevator = new Elevator();
                elevator.setElevatorId(qr.getElevatorId());
                //查询电梯状态
                Elevator elevator1 = elevatorService.selectElevatorById(qr.getElevatorId());
                if (elevator1.getElevatorStatus() == ElevatorStatusEnum.Normal.getId()){
                    elevator.setElevatorStatus(Integer.parseInt(complaintType)+2);
                    elevatorService.updateElevator(elevator);
                }

                //插入数据
                complaintService.insertComplaint(complaint);
            }
        }catch (Exception e){
            return ResultVOUtil.error(ResultEnum.COMPLAINT_ERROR.getCode(), ResultEnum.COMPLAINT_ERROR.getMessage());
        }
        return ResultVOUtil.success();
    }
}
