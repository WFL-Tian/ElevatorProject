package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Img;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ImgMapper extends Mapper<Img> {
    /**
     * 根据groupId查询,没有则根据imgId查询
     * @param img
     * @return
     */
    List<Img> selectImg(@Param("img") Img img);
}