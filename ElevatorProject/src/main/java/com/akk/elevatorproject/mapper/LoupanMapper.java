package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Loupan;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LoupanMapper extends Mapper<Loupan> {


    /**
     * 开发商给物业公司分配楼盘
     * @param developId
     * @param wuyeId
     * @param loupanId
     * @return
     */
    int developAllot(@Param("developId") int developId,
                     @Param("wuyeId") int wuyeId,
                     @Param("loupanId") int loupanId);


    /**
     * 物业公司给维保公司分配楼盘
     * @param wuyeId
     * @param weibaoId
     * @param loupanId
     * @return
     */
    int wuyeAllot(@Param("wuyeId") int wuyeId,
                  @Param("weibaoId") String weibaoId,
                  @Param("loupanId") int loupanId);

    /**
     * 根据companyId查询楼盘实体
     * @param loupan
     * @return
     */
    List<Loupan> selectLoupan(@Param("loupan")Loupan loupan);

}