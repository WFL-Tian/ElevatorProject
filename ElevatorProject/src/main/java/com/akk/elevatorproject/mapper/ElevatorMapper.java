package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Elevator;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ElevatorMapper extends Mapper<Elevator> {

    /**
     * 添加电梯信息
     * @param elevator
     * @return 返回受影响的行数
     */
    int add(Elevator elevator);


    /**
     * 修改电梯信息
     * @param elevator
     * @return 返回收到影响的值
     */
    int modify(Elevator elevator);




   /* List<Elevator> search(@Param("pageIndex") int pageIndex,
                          @Param("pageSize") ,
                          @Param("elevatorType") ,
                          @Param("elevatorStatus") )*/


}