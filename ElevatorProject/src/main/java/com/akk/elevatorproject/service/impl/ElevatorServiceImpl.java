package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Elevator;
import com.akk.elevatorproject.mapper.ElevatorMapper;
import com.akk.elevatorproject.service.ElevatorService;
import com.akk.elevatorproject.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:27
 */
@Service
public class ElevatorServiceImpl implements ElevatorService {

    @Autowired
    private ElevatorMapper mapper;
    /**
     * 添加电梯信息
     * @param elevator
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(Elevator elevator) {
        return mapper.insert(elevator);
    }

    /**
     * 修改电梯信息
     * @param elevator
     * @return 返回收到影响的值
     */
    @Override
    public int update(Elevator elevator) {
        return mapper.updateByPrimaryKey(elevator);
    }

    /**
     * 删除电梯信息
     * @param elevator
     * @return
     */
    @Override
    public int delete(Elevator elevator) {
        return mapper.deleteByPrimaryKey(elevator);
    }

    /**
     * 开发商给物业公司分配楼盘
     *
     * @param developId
     * @param wuyeId
     * @param loupanId
     * @return
     */
    @Override
    public int developAllot(int developId, int wuyeId, int loupanId) {
        return  mapper.developAllot(developId, wuyeId, loupanId);
    }

    /**
     * 物业公司给维保公司分配楼盘
     *
     * @param wuyeId
     * @param weibaoId
     * @param loupanId
     * @return
     */
    @Override
    public int wuyeAllot(int wuyeId, String weibaoId, int loupanId) {
        return mapper.wuyeAllot(wuyeId, weibaoId, loupanId);
    }

    /**
     * @param pageIndex       页码
     * @param pageSize       本页数据量
     * @param elevator elevatorType   电梯类型  elevatorStatus 如果传递了就专门查询此条件的数据
     * @return 返回查询到的电梯信息
     */
    @Override
    public List<Elevator> selectElevator(/*int pageIndex, int pageSize,*/ Elevator elevator) {
        //int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);

        return mapper.selectElevator(/*rowIndex,pageSize,*/elevator);
    }

    /**
     * 根据状态查询
     *
     * @param elevator
     * @return
     */
    @Override
    public List<Elevator> selectElevatorByStatus(Elevator elevator) {
        return mapper.selectElevatorByStatus(elevator);
    }

}
