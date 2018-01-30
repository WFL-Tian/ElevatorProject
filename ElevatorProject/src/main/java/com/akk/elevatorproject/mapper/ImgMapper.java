package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Img;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ImgMapper extends Mapper<Img> {
    /**
     * �������ͼƬ
     * @param imgList
     * @return
     */
    int batchInsertImg(List<Img> imgList);
}