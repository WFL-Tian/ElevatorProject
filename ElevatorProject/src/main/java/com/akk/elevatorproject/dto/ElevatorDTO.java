package com.akk.elevatorproject.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tianjun on 2018/1/20.
 */
@Data
public class ElevatorDTO {

     //电梯编号
    private String elevatorId;

    //电梯类型
    private Integer elevatorType;

    //电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
    private Integer elevatorStatus;
    //出厂编号
    private String factoryNumber;

    //安装单位
    private String installCompany;

//    //开发商联系电话
//    private String phone;
    //开发商电话(需根据开发商公司id)
    //private String phone;

    //层/站
    private Integer floorLevels;

    //安全管理员姓名
    private String adminName;

    //制造单位
    private String madeCompany;

    //生产日期
    private Date productionDate;

     //设备注册代码
    private String registrationCode;

    //设备型号
    private String equipmentModel;

//     //使用具体地址id,即楼盘id
//    private Integer loupanId;
    //楼盘具体地址
    private String loupanAddr;

    //具体地址，某个小区几单元或者商场的东侧
    private String detailAddr;

//    //开发商id
//    private Integer developId;
    //开发商公司名称
    private String developName;

//    //使用单位id(公司id),即物业id
//    private Integer wuyeId;
    //物业公司名字(需根据物业公司id查询)
    private String wuyeName;

    private String phone;

//     //维保单位id
//    private String weibaoId;
    //维保公司名(需根据公司id查询对应的公司名称)
    private String weibaoCompanyName;

     //创建时间
    private Date createTime;

     // 修改时间
    private Date lastEditTime;

}
