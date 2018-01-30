package com.akk.elevatorproject.controller.mobile;

import com.akk.elevatorproject.dto.ElevatorDTO;
import com.akk.elevatorproject.entity.QR;
import com.akk.elevatorproject.enums.ResultEnum;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.service.QRService;
import com.akk.elevatorproject.util.ResultVOUtil;
import com.akk.elevatorproject.util.StringUtil;
import com.akk.elevatorproject.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianjun on 2018/1/23.
 */
@Controller
@RequestMapping("/mobile/elevator")
public class ElevatorController {

    @Autowired
    private QRService qrService;

    @Autowired
    private ElevatorService  elevatorService;

    /**
     * 这里给的是二维码编号
     * @param id
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public ResultVO<ElevatorDTO> getElevator(@RequestParam("id")String id){
        //1.由于传递过来是二维码的id，所以需要先根据qr_id查询出电梯id
        //将id转换成整形
        if (StringUtil.isNull(id)){
            return ResultVOUtil.error(ResultEnum.QRID_NULL.getCode(), ResultEnum.QRID_NULL.getMessage());
        }

        Integer qr_id = Integer.parseInt(id);
        QR qr = qrService.selectOne(qr_id);
        if (qr == null){
            return ResultVOUtil.error(ResultEnum.QR_NOT_EXIST.getCode(),ResultEnum.QR_NOT_EXIST.getMessage());
        }
        //2.根据电梯id,查询出电梯信息
        ElevatorDTO elevatorDTO = elevatorService.selectOne(qr.getElevatorId());
        if (elevatorDTO == null){
            return ResultVOUtil.error(ResultEnum.QR_NOT_EXIST.getCode(),ResultEnum.QR_NOT_EXIST.getMessage());
        }
        return ResultVOUtil.success(elevatorDTO);
    }
}
