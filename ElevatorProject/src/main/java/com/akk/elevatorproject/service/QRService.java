package com.akk.elevatorproject.service;


import com.akk.elevatorproject.entity.QR;

/**
 * Created by tianjun on 2018/1/23.
 */
public interface QRService {

    /**
     * ͨ����ά���ѯ��Ӧ��ά����Ϣ
     * @param qrId
     * @return
     */
    public QR selectOne(Integer qrId);
}
