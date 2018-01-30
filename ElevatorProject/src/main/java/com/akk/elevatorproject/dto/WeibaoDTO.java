package com.akk.elevatorproject.dto;

import com.akk.elevatorproject.entity.Img;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Data
public class WeibaoDTO {

    //维保单号
    @Id
    private String weibaoId;

    //电梯编号
    private String elevatorId;

//    /**
//     * 维保人员
//     */
//    @Column(name = "user_id")
//    private Integer userId;


    //根据维保人员id查询维保工作人员名
    private String weibaoUsername;

    //电梯维修状态(已维保、未维保)
    private Integer elevatorStatus;

    //维保类型
    private String weibaoType;

    //维保描述
    private String weibaoDesc;

    //维保时间
    private Date createTime;

    //上次维保时间
    private Date lastEditTime;

}
