package com.akk.elevatorproject.util;

import com.akk.elevatorproject.entity.Img;
import com.akk.elevatorproject.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjun on 2018/1/27.
 */
public class FileUploadUtil {



    /**
     * 文件上传服务器绝对路径
     */
    //private String serverPath = adImageSavePath;
    //private static String serverPath = "D:/nginx-1.11.9/html/upload/images/";

    public static List<Img> getImgList(HttpServletRequest request, String groupId, String adImageSavePath){

        List<Img> imgList = new ArrayList<>();

        //遍历
        List<MultipartFile> files =
                ((MultipartHttpServletRequest)request).getFiles("file");
        if (!files.isEmpty()){
            //逐个遍历文件
            for(MultipartFile file : files) {
                //获得到上传时的文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                String temp = System.currentTimeMillis() + "_" + fileName;
                //对文件名进行重命名
                File dest = new File(adImageSavePath + "/" + temp /* + "." + prefix*/);
                if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                    dest.getParentFile().mkdirs();
                    System.out.println("dest.getParentFile()"+dest.getParentFile());
                }
                try {
                    file.transferTo(dest);  //保存文件

                    Img img = new Img(KeyUtil.genUniqueKey(), temp, "维修维保图片", 1, groupId, new Timestamp(System.currentTimeMillis()));
                    imgList.add(img);
                } catch (Exception e) {
                    throw new RuntimeException("图片上传失败：" + e.toString());
                }
            }
            return imgList;

        }else {
            return null;
        }
    }
}
