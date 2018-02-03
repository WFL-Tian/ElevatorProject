package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.mapper.CompanyMapper;
import com.akk.elevatorproject.mapper.ImgMapper;
import com.akk.elevatorproject.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-31
 *         时间: 16:29
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper mapper;

    /**
     * 添加信息
     *
     * @param img
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(Img img) {
        return mapper.insert(img);
    }

    /**
     * 修改信息
     *
     * @param img
     * @return 返回收到影响的值
     */
    @Override
    public int update(Img img) {
        return mapper.updateByPrimaryKey(img);
    }

    /**
     * 删除信息
     *
     * @param img
     * @return
     */
    @Override
    public int delete(Img img) {
        return mapper.updateByPrimaryKey(img);
    }

    /**
     * 根据groupId查询,没有则根据imgId查询
     *
     * @param img
     * @return
     */
    @Override
    public List<Img> selectImg(Img img) {
        return mapper.selectImg(img);
    }
}
