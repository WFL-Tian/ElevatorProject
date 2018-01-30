package com.akk.elevatorproject.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_user")
public class User {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * qq号
     */
    private String qq;

    /**
     * 账户状态,非管理员账户只有通过了审核才能使用.默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    @Column(name = "sh_status")
    private Integer shStatus;

    /**
     * 所属公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 是否是审批人员
     */
    @Column(name = "if_sp_user")
    private Integer ifSpUser;

    /**
     * 是否是公司管理人员
     */
    @Column(name = "if_c_admin")
    private Integer if_c_admin;

    public Integer getIf_c_admin() {
        return if_c_admin;
    }

    public void setIf_c_admin(Integer if_c_admin) {
        this.if_c_admin = if_c_admin;
    }

    /**

     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "last_edit_time")
    private Date lastEditTime;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取登录名
     *
     * @return username - 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录名
     *
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取真实姓名
     *
     * @return realname - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取qq号
     *
     * @return qq - qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号
     *
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取账户状态,非管理员账户只有通过了审核才能使用.默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     *
     * @return sh_status - 账户状态,非管理员账户只有通过了审核才能使用.默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    public Integer getShStatus() {
        return shStatus;
    }

    /**
     * 设置账户状态,非管理员账户只有通过了审核才能使用.默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     *
     * @param shStatus 账户状态,非管理员账户只有通过了审核才能使用.默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    public void setShStatus(Integer shStatus) {
        this.shStatus = shStatus;
    }

    /**
     * 获取所属公司id
     *
     * @return company_id - 所属公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司id
     *
     * @param companyId 所属公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取是否是审批人员
     *
     * @return if_sp_user - 是否是审批人员
     */
    public Integer getIfSpUser() {
        return ifSpUser;
    }

    /**
     * 设置是否是审批人员
     *
     * @param ifSpUser 是否是审批人员
     */
    public void setIfSpUser(Integer ifSpUser) {
        this.ifSpUser = ifSpUser;
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