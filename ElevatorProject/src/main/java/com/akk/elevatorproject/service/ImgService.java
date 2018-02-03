package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Img;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-31
 *         时间: 16:25
 */
public interface ImgService {

    /**
     * 添加信息
     * @param img
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(Img img);

    /**
     * 修改信息
     * @param img
     * @return 返回收到影响的值
     */
    int update(Img img);


    /**
     * 删除信息
     * @param img
     * @return
     */
    int delete(Img img);

    /**
     * 根据groupId查询,没有则根据imgId查询
     * @param img
     * @return
     */
    List<Img> selectImg(Img img);

}
