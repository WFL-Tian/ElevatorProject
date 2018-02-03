package com.akk.elevatorproject.service;

import com.akk.elevatorproject.entity.Shenpi;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:32
 */
public interface ShenpiService {

    /**
     * 添加审批信息
     * @param shenpi
     * @return 返回1 或者 0 确认添加成功与否
     */
    int insert(Shenpi shenpi);

    /**
     * 修改审批信息
     * @param shenpi
     * @return 返回受到影响的行数
     */
    int update(Shenpi shenpi);

    /**
     * 删除审批信息
     * @param shenpi
     * @return
     */
    int delete(Shenpi shenpi);

    /**
     * 传入一个审批实体 通过实体中shenpiId查找
     * 否则通过shenpiStatus按照状态查询
     * 如果二者皆不传 则查询全部
     * @param shenpi
     * @return 返回查到的审批对象
     */
    List<Shenpi> selectShenpi(Shenpi shenpi);
}
