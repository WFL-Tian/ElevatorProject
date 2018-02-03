package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Elevator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:26
 */
public interface ElevatorService {

    /**
     * 添加电梯信息
     * @param elevator
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(Elevator elevator);

    /**
     * 修改电梯信息
     * @param elevator
     * @return 返回收到影响的值
     */
    int update(Elevator elevator);

    /**
     * 删除电梯信息
     * @param elevator
     * @return
     */
    int delete(Elevator elevator);

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
     *
     * @param newElevator elevatorType 电梯类型 elevatorStatus 如果传递了就专门查询此条件的数据
     * @return 返回查询到的电梯信息
     */
    List<Elevator> selectElevator(/*@Param("pageIndex") int pageIndex,
                                  @Param("pageSize") int pageSize,*/
                                  Elevator newElevator);

    /**
     * 根据状态查询
     * @param elevator
     * @return
     */
    List<Elevator> selectElevatorByStatus(@Param("elevator") Elevator elevator);

}
