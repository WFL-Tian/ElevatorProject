package com.akk.elevatorproject.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_complaint")
public class Complaint {
    /**
     * 投诉单号
     */
    @Id
    @Column(name = "complaint_number")
    private String complaintNumber;

    /**
     * 电梯编号
     */
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * 被困人生
     */
    @Column(name = "help_people")
    private Integer helpPeople;

    /**
     * 投诉原因
     */
    @Column(name = "reason")
    private String reason;

    /**
     * 投诉电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 投诉类型，给用户选择事故严重程度
     */
    @Column(name = "complaint_type")
    private Integer complaintType;

    /**
     * 处理状态,默认为未处理,值为0,通过处理后值改为1.
     */
    @Column(name = "complaint_status")
    private Integer complaintStatus;

    /**
     * 处理结果报告
     */
    @Column(name = "result_info")
    private String resultInfo;

    /**
     * 投诉时间 
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 处理投诉时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;

}