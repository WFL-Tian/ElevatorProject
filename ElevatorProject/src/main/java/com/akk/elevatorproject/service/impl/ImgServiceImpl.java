package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.mapper.ImgMapper;
import com.akk.elevatorproject.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianjun on 2018/1/25.
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public int insertImg(List<Img> imgList) {
        return imgMapper.batchInsertImg(imgList);
    }
}
