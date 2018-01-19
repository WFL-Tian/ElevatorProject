package com.akk.elevatorproject.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_shenpi")
public class Shenpi {
    /**
     * 申请编号
     */
    @Id
    @Column(name = "shenpi_id")
    private String shenpiId;

    /**
     * 开发商编号
     */
    @Column(name = "develop_id")
    private Integer developId;

    /**
     * 电梯编号
     */
    @Column(name = "loupan_id")
    private Integer loupanId;

    /**
     * 申请时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 审批时间
     */
    @Column(name = "shenpi_time")
    private Date shenpiTime;

    /**
     * 审批状态,默认为未审批,值为0,通过审批后值改为1,如果未通过审批,改值为2.
     */
    @Column(name = "shenpi_status")
    private Integer shenpiStatus;

    /**
     * 审批结果说明
     */
    @Column(name = "shenpi_result")
    private String shenpiResult;

}