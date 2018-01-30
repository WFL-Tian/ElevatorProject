package com.akk.elevatorproject.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_qr")
public class QR {
    /**
     * 二维码编号
     */
    @Id
    @Column(name = "qr_id")
    private Integer qrId;

    /**
     * 电梯编号
     */
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * 创建二维码的人编号
     */
    @Column(name = "creater_id")
    private Integer createrId;

    /**
     * 二维码描述
     */
    @Column(name = "qr_desc")
    private String qrDesc;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;
}