package com.akk.elevatorproject.service;


import com.akk.elevatorproject.entity.QR;

/**
 * Created by tianjun on 2018/1/23.
 */
public interface QRService {

    /**
     * 通过二维码查询对应二维码信息
     * @param qrId
     * @return
     */
    public QR selectOne(Integer qrId);
}
