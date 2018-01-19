package com.akk.elevatorproject.entity;

import java.util.Date;
import javax.persistence.*;

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
    private String reason;

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
     * 获取投诉单号
     *
     * @return complaint_number - 投诉单号
     */
    public String getComplaintNumber() {
        return complaintNumber;
    }

    /**
     * 设置投诉单号
     *
     * @param complaintNumber 投诉单号
     */
    public void setComplaintNumber(String complaintNumber) {
        this.complaintNumber = complaintNumber;
    }

    /**
     * 获取电梯编号
     *
     * @return elevator_id - 电梯编号
     */
    public String getElevatorId() {
        return elevatorId;
    }

    /**
     * 设置电梯编号
     *
     * @param elevatorId 电梯编号
     */
    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    /**
     * 获取被困人生
     *
     * @return help_people - 被困人生
     */
    public Integer getHelpPeople() {
        return helpPeople;
    }

    /**
     * 设置被困人生
     *
     * @param helpPeople 被困人生
     */
    public void setHelpPeople(Integer helpPeople) {
        this.helpPeople = helpPeople;
    }

    /**
     * 获取投诉原因
     *
     * @return reason - 投诉原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置投诉原因
     *
     * @param reason 投诉原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取投诉类型，给用户选择事故严重程度
     *
     * @return complaint_type - 投诉类型，给用户选择事故严重程度
     */
    public Integer getComplaintType() {
        return complaintType;
    }

    /**
     * 设置投诉类型，给用户选择事故严重程度
     *
     * @param complaintType 投诉类型，给用户选择事故严重程度
     */
    public void setComplaintType(Integer complaintType) {
        this.complaintType = complaintType;
    }

    /**
     * 获取处理状态,默认为未处理,值为0,通过处理后值改为1.
     *
     * @return complaint_status - 处理状态,默认为未处理,值为0,通过处理后值改为1.
     */
    public Integer getComplaintStatus() {
        return complaintStatus;
    }

    /**
     * 设置处理状态,默认为未处理,值为0,通过处理后值改为1.
     *
     * @param complaintStatus 处理状态,默认为未处理,值为0,通过处理后值改为1.
     */
    public void setComplaintStatus(Integer complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    /**
     * 获取处理结果报告
     *
     * @return result_info - 处理结果报告
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * 设置处理结果报告
     *
     * @param resultInfo 处理结果报告
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    /**
     * 获取投诉时间 
     *
     * @return create_time - 投诉时间 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置投诉时间 
     *
     * @param createTime 投诉时间 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}