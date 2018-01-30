package com.akk.elevatorproject.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tianjun on 2018/1/20.
 */
@Data
public class ElevatorDTO {

     //���ݱ��
    private String elevatorId;

    //��������
    private Integer elevatorType;

    //����״̬������ʹ��/ͣ��/�����쳣/���ع���/�������ϣ�
    private Integer elevatorStatus;
    //�������
    private String factoryNumber;

    //��װ��λ
    private String installCompany;

//    //��������ϵ�绰
//    private String phone;
    //�����̵绰(����ݿ����̹�˾id)
    //private String phone;

    //��/վ
    private Integer floorLevels;

    //��ȫ����Ա����
    private String adminName;

    //���쵥λ
    private String madeCompany;

    //��������
    private Date productionDate;

     //�豸ע�����
    private String registrationCode;

    //�豸�ͺ�
    private String equipmentModel;

//     //ʹ�þ����ַid,��¥��id
//    private Integer loupanId;
    //¥�̾����ַ
    private String loupanAddr;

    //�����ַ��ĳ��С������Ԫ�����̳��Ķ���
    private String detailAddr;

//    //������id
//    private Integer developId;
    //�����̹�˾����
    private String developName;

//    //ʹ�õ�λid(��˾id),����ҵid
//    private Integer wuyeId;
    //��ҵ��˾����(�������ҵ��˾id��ѯ)
    private String wuyeName;

    private String phone;

//     //ά����λid
//    private String weibaoId;
    //ά����˾��(����ݹ�˾id��ѯ��Ӧ�Ĺ�˾����)
    private String weibaoCompanyName;

     //����ʱ��
    private Date createTime;

     // �޸�ʱ��
    private Date lastEditTime;

}
