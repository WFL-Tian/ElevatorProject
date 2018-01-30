package com.akk.elevatorproject.mapper;


import com.akk.elevatorproject.entity.Weibao;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WeibaoMapper extends Mapper<Weibao> {

    /**
     * ���������Ϣ(���ݱ��)��ѯ��Ӧ��ά����Ϣ
     * @param weibaoCondition
     * @return
     */
    List<Weibao> queryWeibaoList(@Param("weibaoCondition") Weibao weibaoCondition);


    /**
     * ����ά����¼
     * @param weibao
     * @return
     */
    int insertWeibao(Weibao weibao);





}