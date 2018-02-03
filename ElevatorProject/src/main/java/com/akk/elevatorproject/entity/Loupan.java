package com.akk.elevatorproject.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_loupan")
@Data
public class Loupan {
    /**
     * 楼盘id
     */
    @Id
    @Column(name = "loupan_id")
    private Integer loupanId;

    /**
     * 楼盘具体地址
     */
    @Column(name = "loupan_addr")
    private String loupanAddr;

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
    private String weibaoId;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}