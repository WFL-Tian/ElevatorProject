package com.akk.elevatorproject.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_qr")
public class QR {
    /**
     * ��ά����
     */
    @Id
    @Column(name = "qr_id")
    private Integer qrId;

    /**
     * ���ݱ��
     */
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * ������ά����˱��
     */
    @Column(name = "creater_id")
    private Integer createrId;

    /**
     * ��ά������
     */
    @Column(name = "qr_desc")
    private String qrDesc;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ����޸�ʱ��
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;
}