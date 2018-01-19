package com.akk.elevatorproject.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import javax.persistence.*;

@DynamicUpdate
@Table(name = "tb_company")
public class Company {
    /**
     * 公司编号
     */
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 单位名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 单位固定电话
     */
    @Column(name = "company_phone")
    private String companyPhone;

    /**
     * 企业邮箱
     */
    @Column(name = "company_email")
    private String companyEmail;

    /**
     * 审核状态,默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    @Column(name = "company_sh_status")
    private Integer companyShStatus;

    /**
     * 单位类型（开发商/维保/物业公司）
     */
    @Column(name = "company_type")
    private Integer companyType;

    /**
     * 企业传真
     */
    private String enterprisefax;

    /**
     * 单位地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 法定代表人
     */
    private String legalrepresentative;

    /**
     * 法定代表人手机
     */
    @Column(name = "legalrepresentative_phone")
    private String legalrepresentativePhone;

    /**
     * 组织机构代码
     */
    @Column(name = "organization_code")
    private String organizationCode;

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
     * 获取公司编号
     *
     * @return company_id - 公司编号
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司编号
     *
     * @param companyId 公司编号
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取单位名称
     *
     * @return company_name - 单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置单位名称
     *
     * @param companyName 单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取单位固定电话
     *
     * @return company_phone - 单位固定电话
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置单位固定电话
     *
     * @param companyPhone 单位固定电话
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * 获取企业邮箱
     *
     * @return company_email - 企业邮箱
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * 设置企业邮箱
     *
     * @param companyEmail 企业邮箱
     */
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    /**
     * 获取审核状态,默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     *
     * @return company_sh_status - 审核状态,默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    public Integer getCompanyShStatus() {
        return companyShStatus;
    }

    /**
     * 设置审核状态,默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     *
     * @param companyShStatus 审核状态,默认为未审核,值为0,通过审核后值改为1,如果未通过审核,改值为2.
     */
    public void setCompanyShStatus(Integer companyShStatus) {
        this.companyShStatus = companyShStatus;
    }

    /**
     * 获取单位类型（开发商/维保/物业公司）
     *
     * @return company_type - 单位类型（开发商/维保/物业公司）
     */
    public Integer getCompanyType() {
        return companyType;
    }

    /**
     * 设置单位类型（开发商/维保/物业公司）
     *
     * @param companyType 单位类型（开发商/维保/物业公司）
     */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /**
     * 获取企业传真
     *
     * @return enterprisefax - 企业传真
     */
    public String getEnterprisefax() {
        return enterprisefax;
    }

    /**
     * 设置企业传真
     *
     * @param enterprisefax 企业传真
     */
    public void setEnterprisefax(String enterprisefax) {
        this.enterprisefax = enterprisefax;
    }

    /**
     * 获取单位地址
     *
     * @return company_address - 单位地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置单位地址
     *
     * @param companyAddress 单位地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取法定代表人
     *
     * @return legalrepresentative - 法定代表人
     */
    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    /**
     * 设置法定代表人
     *
     * @param legalrepresentative 法定代表人
     */
    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative;
    }

    /**
     * 获取法定代表人手机
     *
     * @return legalrepresentative_phone - 法定代表人手机
     */
    public String getLegalrepresentativePhone() {
        return legalrepresentativePhone;
    }

    /**
     * 设置法定代表人手机
     *
     * @param legalrepresentativePhone 法定代表人手机
     */
    public void setLegalrepresentativePhone(String legalrepresentativePhone) {
        this.legalrepresentativePhone = legalrepresentativePhone;
    }

    /**
     * 获取组织机构代码
     *
     * @return organization_code - 组织机构代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizationCode 组织机构代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
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