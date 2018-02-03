package com.akk.elevatorproject.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author gchiaway
 */
public class SavePicture {


    /**
     * 保存图片
     * @param file
     * @return
     */
    public static String saveFile(MultipartFile file, String savePath) {
        String picture = new String("");
        if (!file.isEmpty()) {
            try {
                String fileName = fileName()+".jpg";
                // getRealPath() 取得 WEB-INF 所在文件夹路径
                // 如果参数是 "/temp", 当 temp 存在时返回 temp 的本地路径, 不存在时返回 null/temp (无效路径)
                String path = savePath + File.separator + fileName;
System.out.println(path);
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
                return fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  picture;
    }

    /**
     * 为上传的图片用时间戳和随机数进行命名,避免重名
     * @return
     */
    public static String fileName(){

        Random rand = new Random();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        String time = df.format(new Date());
        int randNum1 = rand.nextInt(900)+100;
        time=time.concat(String.valueOf(randNum1));
        int randNum2 = rand.nextInt(90)+10;
        time=time.concat(String.valueOf(randNum2));

        return  time;
    }
}
