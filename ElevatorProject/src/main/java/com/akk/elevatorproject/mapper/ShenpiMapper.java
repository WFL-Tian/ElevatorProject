package com.akk.elevatorproject.mapper;

import com.akk.elevatorproject.entity.Shenpi;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShenpiMapper extends Mapper<Shenpi> {

//    /**
//     * 开发商 申请 开发 某个楼盘的电梯
//     * @param developId 开发商id
//     * @param loupanId 楼盘id
//     * @return 返回1 或者 0 确认添加成功与否
//     */
//    int insert(@Param("developId") int developId,
//            @Param("loupanId") String loupanId);
//
//
//    /**
//     * 通过shenpiId查找到审批对象,修改审批状态为shenpiStatus
//     * @param shenpiId 审批id
//     * @param shenpiStatus 审批状态
//     * @param shenpiResult 审批结果说明
//     * @return
//     */
//    int update(@Param("shenpiId") String shenpiId,
//               @Param("shenpiStatus") int shenpiStatus,
//               @Param("shenpiResult") String shenpiResult);

    /**
     * 传入一个审批实体 通过实体中shenpiId查找
     * 否则通过shenpiStatus按照状态查询
     * 如果二者皆不传 则查询全部
     * @param shenpi
     * @return 返回查到的审批对象
     */
    List<Shenpi> selectShenpi(Shenpi shenpi);

}