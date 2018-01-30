package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.BaseTest;
import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjun on 2018/1/25.
 */
public class ImgDaoTest extends BaseTest {

    @Autowired
    private ImgMapper imgMapper;

    @Test
    public void testABathchInsertProductImg(){
//        Img img = new Img();
//        img.setImgId(KeyUtil.genUniqueKey());
//        img.setImgName("图片1");
//        img.setImgDesc("测试图片1");
//        img.setPriority(1);
//        img.setGroupId("22222");
//        img.setCreateTime(new Timestamp(System.currentTimeMillis()));
//
//
//        Img img2 = new Img();
//        img2.setImgId(KeyUtil.genUniqueKey());
//        img2.setImgName("图片2");
//        img2.setImgDesc("测试图片2");
//        img2.setPriority(1);
//        img2.setGroupId("22222");
//        img2.setCreateTime(new Timestamp(System.currentTimeMillis()));
//
//        List<Img> imgList= new ArrayList<>();
//        imgList.add(img);
//        imgList.add(img2);
//        int effectNum = imgMapper.batchInsertImg(imgList);
//        Assert.assertEquals(2, effectNum);
    }

}
