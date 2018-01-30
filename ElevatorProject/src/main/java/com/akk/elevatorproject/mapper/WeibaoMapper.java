package com.akk.elevatorproject.mapper;


import com.akk.elevatorproject.entity.Weibao;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WeibaoMapper extends Mapper<Weibao> {

    /**
     * 根据相关信息(电梯编号)查询对应的维保信息
     * @param weibaoCondition
     * @return
     */
    List<Weibao> queryWeibaoList(@Param("weibaoCondition") Weibao weibaoCondition);


    /**
     * 插入维保记录
     * @param weibao
     * @return
     */
    int insertWeibao(Weibao weibao);





}