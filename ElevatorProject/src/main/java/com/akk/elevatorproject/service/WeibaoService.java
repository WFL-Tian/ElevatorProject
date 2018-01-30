package com.akk.elevatorproject.service;

import com.akk.elevatorproject.dto.WeibaoDTO;
import com.akk.elevatorproject.entity.Complaint;
import com.akk.elevatorproject.entity.Weibao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
public interface WeibaoService {


    /**
     *  根据相关信息(电梯编号)查询对应的维保信息
     * @return
     */
    List<WeibaoDTO> queryWeibaoList(String id);

    /**
     * 插入维保记录
     * @param weibao
     * @return
     */
    @Transactional
    int insertWeibao(Weibao weibao);

}
