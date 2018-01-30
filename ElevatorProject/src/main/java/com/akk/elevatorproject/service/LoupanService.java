package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Loupan;

/**
 * Created by tianjun on 2018/1/23.
 */
public interface LoupanService {
    /**
     * 通过楼盘id查询楼盘信息
     * @param loupanId
     * @return
     */
    Loupan selectOne(Integer loupanId);
}
