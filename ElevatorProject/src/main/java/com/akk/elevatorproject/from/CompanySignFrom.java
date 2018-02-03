package com.akk.elevatorproject.from;

import lombok.Data;

/**
 * @author gchiaway
 *         日期: 2018-01-30
 *         时间: 15:08
 */
@Data
public class CompanySignFrom {

    /**
     * 单位名称
     */
    private String companyName;

    /**
     * 单位固定电话
     */
    private String companyPhone;

    /**
     * 企业邮箱
     */
    private String companyEmail;

    /**
     * 单位类型（开发商/维保/物业公司）
     */
    private Integer companyType;

    /**
     * 企业传真
     */
    private String enterprisefax;

    /**
     * 单位地址
     */
    private String companyAddress;

    /**
     * 法定代表人
     */
    private String legalrepresentative;

    /**
     * 法定代表人手机
     */
    private String legalrepresentativePhone;

    /**
     * 组织机构代码
     */
    private String organizationCode;


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
    private String phoneNumber;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * qq号
     */
    private String qq;



}
