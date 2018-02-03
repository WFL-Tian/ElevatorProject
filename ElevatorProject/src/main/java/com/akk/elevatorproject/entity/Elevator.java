package com.akk.elevatorproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_elevator")
public class Elevator {
    /**
     * 电梯编号
     */
    @Id
    @Column(name = "elevator_id")
    private String elevatorId;

    /**
     * 电梯类型
     */
    @Column(name = "elevator_type")
    private Integer elevatorType;

    /**
     * 电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     */
    @Column(name = "elevator_status")
    private Integer elevatorStatus;

    /**
     * 出厂编号
     */
    @Column(name = "factory_number")
    private String factoryNumber;

    /**
     * 安装单位
     */
    @Column(name = "Install_company")
    private String installCompany;

    /**
     * 层/站
     */
    @Column(name = "floor_levels")
    private Integer floorLevels;

    /**
     * 安全管理员姓名
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 制造单位
     */
    @Column(name = "made_company")
    private String madeCompany;

    /**
     * 生产日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "production_date")
    private Date productionDate;

    /**
     * 设备注册代码
     */
    @Column(name = "registration_code")
    private String registrationCode;

    /**
     * 设备型号
     */
    @Column(name = "equipment_model")
    private String equipmentModel;

    /**
     * 使用具体地址id,即楼盘id
     */
    @Column(name = "loupan_id")
    private Integer loupanId;

    /**
     * 具体地址，某个小区几单元或者商场的东侧
     */
    @Column(name = "detail_addr")
    private String detailAddr;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "last_edit_time")
    private Date lastEditTime;

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
     * 获取电梯类型
     *
     * @return elevator_type - 电梯类型
     */
    public Integer getElevatorType() {
        return elevatorType;
    }

    /**
     * 设置电梯类型
     *
     * @param elevatorType 电梯类型
     */
    public void setElevatorType(Integer elevatorType) {
        this.elevatorType = elevatorType;
    }

    /**
     * 获取电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     *
     * @return elevator_state - 电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     */
    public Integer getElevatorStatus() {
        return elevatorStatus;
    }

    /**
     * 设置电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     *
     * @param elevatorStatus 电梯状态（正常使用/停用/运行异常/严重故障/紧急故障）
     */
    public void setElevatorStatus(Integer elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    /**
     * 获取出厂编号
     *
     * @return factory_number - 出厂编号
     */
    public String getFactoryNumber() {
        return factoryNumber;
    }

    /**
     * 设置出厂编号
     *
     * @param factoryNumber 出厂编号
     */
    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    /**
     * 获取安装单位
     *
     * @return Install_company - 安装单位
     */
    public String getInstallCompany() {
        return installCompany;
    }

    /**
     * 设置安装单位
     *
     * @param installCompany 安装单位
     */
    public void setInstallCompany(String installCompany) {
        this.installCompany = installCompany;
    }

    /**
     * 获取层/站
     *
     * @return floor_levels - 层/站
     */
    public Integer getFloorLevels() {
        return floorLevels;
    }

    /**
     * 设置层/站
     *
     * @param floorLevels 层/站
     */
    public void setFloorLevels(Integer floorLevels) {
        this.floorLevels = floorLevels;
    }

    /**
     * 获取安全管理员姓名
     *
     * @return admin_name - 安全管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置安全管理员姓名
     *
     * @param adminName 安全管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取制造单位
     *
     * @return made_company - 制造单位
     */
    public String getMadeCompany() {
        return madeCompany;
    }

    /**
     * 设置制造单位
     *
     * @param madeCompany 制造单位
     */
    public void setMadeCompany(String madeCompany) {
        this.madeCompany = madeCompany;
    }

    /**
     * 获取生产日期
     *
     * @return production_date - 生产日期
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * 设置生产日期
     *
     * @param productionDate 生产日期
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * 获取设备注册代码
     *
     * @return registration_code - 设备注册代码
     */
    public String getRegistrationCode() {
        return registrationCode;
    }

    /**
     * 设置设备注册代码
     *
     * @param registrationCode 设备注册代码
     */
    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    /**
     * 获取设备型号
     *
     * @return equipment_model - 设备型号
     */
    public String getEquipmentModel() {
        return equipmentModel;
    }

    /**
     * 设置设备型号
     *
     * @param equipmentModel 设备型号
     */
    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    /**
     * 获取使用具体地址id,即楼盘id
     *
     * @return loupan_id - 使用具体地址id,即楼盘id
     */
    public Integer getLoupanId() {
        return loupanId;
    }

    /**
     * 设置使用具体地址id,即楼盘id
     *
     * @param loupanId 使用具体地址id,即楼盘id
     */
    public void setLoupanId(Integer loupanId) {
        this.loupanId = loupanId;
    }

    /**
     * 获取具体地址，某个小区几单元或者商场的东侧
     *
     * @return detail_addr - 具体地址，某个小区几单元或者商场的东侧
     */
    public String getDetailAddr() {
        return detailAddr;
    }

    /**
     * 设置具体地址，某个小区几单元或者商场的东侧
     *
     * @param detailAddr 具体地址，某个小区几单元或者商场的东侧
     */
    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    /**
     * 获取开发商id
     *
     * @return develop_id - 开发商id
     */
    public Integer getDevelopId() {
        return developId;
    }

    /**
     * 设置开发商id
     *
     * @param developId 开发商id
     */
    public void setDevelopId(Integer developId) {
        this.developId = developId;
    }

    /**
     * 获取使用单位id,即物业id
     *
     * @return wuye_id - 使用单位id,即物业id
     */
    public Integer getWuyeId() {
        return wuyeId;
    }

    /**
     * 设置使用单位id,即物业id
     *
     * @param wuyeId 使用单位id,即物业id
     */
    public void setWuyeId(Integer wuyeId) {
        this.wuyeId = wuyeId;
    }

    /**
     * 获取维保单位id
     *
     * @return weibao_id - 维保单位id
     */
    public String getWeibaoId() {
        return weibaoId;
    }

    /**
     * 设置维保单位id
     *
     * @param weibaoId 维保单位id
     */
    public void setWeibaoId(String weibaoId) {
        this.weibaoId = weibaoId;
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
     * 获取修改时间
     *
     * @return last_edit_time - 修改时间
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * 设置修改时间
     *
     * @param lastEditTime 修改时间
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}