package com.akk.elevatorproject.entity;

import java.util.Date;
import javax.persistence.*;

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

    /**
     * 获取图片id
     *
     * @return img_id - 图片id
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * 设置图片id
     *
     * @param imgId 图片id
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取描述
     *
     * @return img_desc - 描述
     */
    public String getImgDesc() {
        return imgDesc;
    }

    /**
     * 设置描述
     *
     * @param imgDesc 描述
     */
    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    /**
     * 获取图片name
     *
     * @return img_name - 图片name
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置图片name
     *
     * @param imgName 图片name
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * 获取权值
     *
     * @return priority - 权值
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置权值
     *
     * @param priority 权值
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取分组id
     *
     * @return group_id - 分组id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置分组id
     *
     * @param groupId 分组id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}