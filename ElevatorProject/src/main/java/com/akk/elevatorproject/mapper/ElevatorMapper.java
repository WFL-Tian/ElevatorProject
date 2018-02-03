package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Elevator;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ElevatorMapper extends Mapper<Elevator> {

//    /**
//     * 添加电梯信息
//     * @param elevator
//     * @return 返回1 或者 0 确认添加成功与否
//     */
//    @Override
//    int insert(Elevator elevator);
//
//
//    /**
//     * 修改电梯信息
//     * @param elevator
//     * @return 返回收到影响的值
//     */
//    int update(Elevator elevator);



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
     * 根据楼盘id查询电梯
     * @param loupanId
     * @return
     */
    List<Elevator> selectElevatorByLoupan(int loupanId);

    /**
     *
     * @param elevator 电梯类型 elevatorStatus 如果传递了就专门查询此条件的数据
     * @return 返回查询到的电梯信息
     */
    List<Elevator> selectElevator(/*@Param("rowIndex") int rowIndex,
                                  @Param("pageSize") int pageSize,*/
                                  @Param("elevator") Elevator elevator);

    /**
     * 根据状态查询
     * @param elevator
     * @return
     */
    List<Elevator> selectElevatorByStatus(@Param("elevator") Elevator elevator);

}