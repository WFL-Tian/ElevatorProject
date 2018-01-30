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

    //ά������
    @Id
    private String weibaoId;

    //���ݱ��
    private String elevatorId;

//    /**
//     * ά����Ա
//     */
//    @Column(name = "user_id")
//    private Integer userId;


    //����ά����Աid��ѯά��������Ա��
    private String weibaoUsername;

    //����ά��״̬(��ά����δά��)
    private Integer elevatorStatus;

    //ά������
    private String weibaoType;

    //ά������
    private String weibaoDesc;

    //ά��ʱ��
    private Date createTime;

    //�ϴ�ά��ʱ��
    private Date lastEditTime;

}
