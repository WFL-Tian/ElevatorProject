package com.akk.elevatorproject.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_weibao")
public class Weibao {
    /**
     * 维保单号
     */
    @Id
    @Column(name = "weibao_id")
    private String weibaoId;

    /**
     * 电梯编号
     */
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * 维保人员
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 电梯维修状态(正在维保、已维保、未维保)
     */
    @Column(name = "elevator_status")
    private Integer elevatorStatus;

    /**
     * 维保描述
     */
    @Column(name = "weibao_desc")
    private String weibaoDesc;

    /**
     * 上次维保时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;

    /**
     * 获取维保单号
     *
     * @return weibao_id - 维保单号
     */
    public String getWeibaoId() {
        return weibaoId;
    }

    /**
     * 设置维保单号
     *
     * @param weibaoId 维保单号
     */
    public void setWeibaoId(String weibaoId) {
        this.weibaoId = weibaoId;
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
     * 获取维保人员
     *
     * @return user_id - 维保人员
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置维保人员
     *
     * @param userId 维保人员
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取电梯维修状态(正在维保、已维保、未维保)
     *
     * @return elevator_status - 电梯维修状态(正在维保、已维保、未维保)
     */
    public Integer getElevatorStatus() {
        return elevatorStatus;
    }

    /**
     * 设置电梯维修状态(正在维保、已维保、未维保)
     *
     * @param elevatorStatus 电梯维修状态(正在维保、已维保、未维保)
     */
    public void setElevatorStatus(Integer elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    /**
     * 获取维保描述
     *
     * @return weibao_desc - 维保描述
     */
    public String getWeibaoDesc() {
        return weibaoDesc;
    }

    /**
     * 设置维保描述
     *
     * @param weibaoDesc 维保描述
     */
    public void setWeibaoDesc(String weibaoDesc) {
        this.weibaoDesc = weibaoDesc;
    }

    /**
     * 获取上次维保时间
     *
     * @return last_edit_time - 上次维保时间
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * 设置上次维保时间
     *
     * @param lastEditTime 上次维保时间
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}