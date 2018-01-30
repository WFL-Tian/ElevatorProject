package com.akk.elevatorproject.enums;

import lombok.Getter;

/**
 * Created by tianjun on 2018/1/23.
 */
@Getter
public enum  ResultEnum {
    UPLOADFILE_ERROR(20001, "文件上传失败，请重新上传"),
    COMPLAINT_ERROR(20002, "提交投诉失败，请重新提交信息"),
    WEIBAOIMG_ERROR(20003, "提交维修维保必须上传维修现场照片作为凭证"),
    WEIBAO_ERROR(20004, "提交投诉失败，请重新提交信息"),


    WEIBAO_LOGIN_ERROR(40000, "用户未登录，请登录"),
    QR_NOT_EXIST(40001, "二维码不存在"),
    ELEVATOR_NOT_EXIST(40002, "电梯不存在"),
    WEIBAO_NOT_EXIST(40003, "维保记录不存在"),
    USERTYPE_ERROR(40004, "你登录用户类型错误"),
    USER_NULL(40006, "用户名不能为空"),
    PASSWORD_NULL(40007, "密码不能为空"),
    USERORPASSWORD_ERROR(40008, "用户名或者密码出现错误"),

    QRID_NULL(40009, "未获取到二维码数据，请重新扫码"),
    REASON_NULL(400010, "请输入投诉理由，以便我们更好处理投诉"),
    PHONE_NULL(400011, "请输入联系电话，以便我们处理完成后通知你"),
    WEIBAOTYPE_ERROR(400012, "维保类型不能为空"),
    VERIFYCODE_ERROR(400013, "输入了错误的验证码"),
    QR_ERROR(400014, "你扫的二维码系统未能识别，请扫描电梯门口二维码")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
