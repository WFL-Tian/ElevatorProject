package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Img;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianjun on 2018/1/25.
 */
public interface ImgService {
    /**
     *
     * @param imgList
     * @return
     */
    @Transactional
    int insertImg(List<Img> imgList);
}
