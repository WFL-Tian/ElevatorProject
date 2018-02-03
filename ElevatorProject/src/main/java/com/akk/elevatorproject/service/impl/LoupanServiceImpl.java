package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.entity.Loupan;
import com.akk.elevatorproject.mapper.LoupanMapper;
import com.akk.elevatorproject.mapper.ShenpiMapper;
import com.akk.elevatorproject.service.LoupanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gchiaway
 *         日期: 2018-01-20
 *         时间: 11:40
 */
@Service
public class LoupanServiceImpl implements LoupanService {
    @Autowired
    private LoupanMapper mapper;

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
     * 根据id查询楼盘实体
     *
     * @param id
     * @return 返回查到的审批对象
     */
    @Override
    public Loupan selectLoupan(int id) {
        return mapper.selectByPrimaryKey(id);
    }


    /**
     * 根据companyId查询楼盘实体
     * @param loupan
     * @return
     */
    @Override
    public List<Loupan> selectLoupan(Loupan loupan) {
        return mapper.selectLoupan(loupan);
    }

    /**
     * 添加楼盘信息
     *
     * @param loupan
     * @return 返回1 或者 0 确认添加成功与否
     */
    @Override
    public int insert(Loupan loupan) {
        return mapper.insert(loupan);
    }

    /**
     * 修改楼盘信息
     *
     * @param loupan
     * @return 返回受到影响的行数
     */
    @Override
    public int update(Loupan loupan) {
        return mapper.updateByPrimaryKey(loupan);
    }

    /**
     * 删除楼盘信息
     *
     * @param loupan
     * @return
     */
    @Override
    public int delete(Loupan loupan) {
        return mapper.deleteByPrimaryKey(loupan);
    }
}
