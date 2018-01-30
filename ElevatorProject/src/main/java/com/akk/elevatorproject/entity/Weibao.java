package com.akk.elevatorproject.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@Data
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
     * 电梯维修状态(已维保、未维保)
     */
    @Column(name = "elevator_status")
    private Integer elevatorStatus;


    /**
     * 维保类型
     */
    @Column(name = "weibao_type")
    private String weibaoType;

    /**
     * 维保描述
     */
    @Column(name = "weibao_desc")
    private String weibaoDesc;



    /**
     * 维保时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 上次维保时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;




}