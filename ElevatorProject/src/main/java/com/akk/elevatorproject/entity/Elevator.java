package com.akk.elevatorproject.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@Data
@DynamicUpdate
@Table(name = "tb_elevator")
public class Elevator {
    /**
     * 电梯编号
     */
    @Id
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * 电梯类型
     */
    @Column(name = "elevator_type")
    private Integer elevatorType;

    /**
     * 电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     */
    @Column(name = "elevator_status")
    private Integer elevatorStatus;

    /**
     * 出厂编号
     */
    @Column(name = "factory_number")
    private String factoryNumber;

    /**
     * 安装单位
     */
    @Column(name = "Install_company")
    private String installCompany;


    /**
     * 层/站
     */
    @Column(name = "floor_levels")
    private Integer floorLevels;

    /**
     * 安全管理员姓名
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 制造单位
     */
    @Column(name = "made_company")
    private String madeCompany;

    /**
     * 生产日期
     */
    @Column(name = "production_date")
    private Date productionDate;

    /**
     * 设备注册代码
     */
    @Column(name = "registration_code")
    private String registrationCode;

    /**
     * 设备型号
     */
    @Column(name = "equipment_model")
    private String equipmentModel;

    /**
     * 使用具体地址id,即楼盘id
     */
    @Column(name = "loupan_id")
    private Integer loupanId;

    /**
     * 具体地址，某个小区几单元或者商场的东侧
     */
    @Column(name = "detail_addr")
    private String detailAddr;

    /**
     * 开发商id
     */
    @Column(name = "develop_id")
    private Integer developId;

    /**
     * 使用单位id,即物业id
     */
    @Column(name = "wuye_id")
    private Integer wuyeId;

    /**
     * 维保单位id
     */
    @Column(name = "weibao_id")
    private Integer weibaoId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;


}