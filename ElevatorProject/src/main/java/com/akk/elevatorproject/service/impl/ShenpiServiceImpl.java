package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Shenpi;
import com.akk.elevatorproject.mapper.ShenpiMapper;
import com.akk.elevatorproject.service.ShenpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 10:32
 */
@Service
public class ShenpiServiceImpl implements ShenpiService {
    @Autowired
    private ShenpiMapper mapper;

    /**
     * 添加审批信息
     *
     * @param shenpi
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(Shenpi shenpi) {
        return mapper.insert(shenpi);
    }

    /**
     * 修改审批信息
     *
     * @param shenpi
     * @return 返回受到影响的行数
     */
    @Override
    public int update(Shenpi shenpi) {
        return mapper.updateByPrimaryKey(shenpi);
    }

    /**
     * 删除审批信息
     *
     * @param shenpi
     * @return
     */
    @Override
    public int delete(Shenpi shenpi) {
        return mapper.deleteByPrimaryKey(shenpi);
    }

    /**
     * 传入一个审批实体 通过实体中shenpiId查找
     * 否则通过shenpiStatus按照状态查询
     * 如果二者皆不传 则查询全部
     * @param shenpi
     * @return 返回查到的审批对象
     */
    @Override
    public List<Shenpi> selectShenpi(Shenpi shenpi) {
        return mapper.selectShenpi(shenpi);
    }
}
