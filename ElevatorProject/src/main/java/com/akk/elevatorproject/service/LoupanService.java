package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Loupan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:59
 */
public interface LoupanService {

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
     * 根据id查询楼盘实体
     * @param id
     * @return 返回查到的审批对象
     */
    Loupan selectLoupan(int id);


    /**
     * 根据companyId查询楼盘实体
     * @param loupan
     * @return
     */
    List<Loupan> selectLoupan(Loupan loupan);


    /**
     * 添加楼盘信息
     * @param loupan
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(Loupan loupan);


    /**
     * 修改楼盘信息
     * @param loupan
     * @return 返回受到影响的行数
     */
    int update(Loupan loupan);

    /**
     * 删除楼盘信息
     * @param loupan
     * @return
     */
    int delete(Loupan loupan);
}
