package com.akk.elevatorproject.dto;

import com.akk.elevatorproject.entity.Shenpi;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gchiaway
 *         日期: 2018-01-31
 *         时间: 16:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ShenpiDto extends Shenpi {
    /**
     * SpringMvc提供的接收文件的属性，用来接收前端的文件
     */
    private MultipartFile file;

    /**
     * 文件描述
     */
    private String imgDesc;
}
