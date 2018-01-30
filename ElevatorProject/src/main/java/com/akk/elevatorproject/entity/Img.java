package com.akk.elevatorproject.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "tb_img")
public class Img {
    /**
     * 图片id
     */
    @Id
    @Column(name = "img_id")
    private String imgId;

    /**
     * 描述
     */
    @Column(name = "img_desc")
    private String imgDesc;

    /**
     * 图片name
     */
    @Column(name = "img_name")
    private String imgName;

    /**
     * 权值
     */
    private Integer priority;

    /**
     * 分组id
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;


    public Img(String imgId, String imgName, String imgDesc, Integer priority, String groupId, Date createTime) {
        this.imgId = imgId;
        this.imgDesc = imgDesc;
        this.imgName = imgName;
        this.priority = priority;
        this.groupId = groupId;
        this.createTime = createTime;
    }
}