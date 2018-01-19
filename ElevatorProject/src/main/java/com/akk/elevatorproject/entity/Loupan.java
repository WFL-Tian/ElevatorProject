package com.akk.elevatorproject.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_loupan")
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
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取楼盘id
     *
     * @return loupan_id - 楼盘id
     */
    public Integer getLoupanId() {
        return loupanId;
    }

    /**
     * 设置楼盘id
     *
     * @param loupanId 楼盘id
     */
    public void setLoupanId(Integer loupanId) {
        this.loupanId = loupanId;
    }

    /**
     * 获取楼盘具体地址
     *
     * @return loupan_addr - 楼盘具体地址
     */
    public String getLoupanAddr() {
        return loupanAddr;
    }

    /**
     * 设置楼盘具体地址
     *
     * @param loupanAddr 楼盘具体地址
     */
    public void setLoupanAddr(String loupanAddr) {
        this.loupanAddr = loupanAddr;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}