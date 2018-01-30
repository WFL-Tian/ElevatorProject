package com.akk.elevatorproject.service.impl;

import com.akk.elevatorproject.dto.WeibaoDTO;
import com.akk.elevatorproject.entity.User;
import com.akk.elevatorproject.entity.Weibao;
import com.akk.elevatorproject.mapper.WeibaoMapper;
import com.akk.elevatorproject.service.UserService;
import com.akk.elevatorproject.service.WeibaoService;
import com.akk.elevatorproject.util.PageCalculator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianjun on 2018/1/20.
 */
@Service
public class WeibaoServiceImpl implements WeibaoService {

    @Autowired
    private WeibaoMapper weibaoMapper;

    @Autowired
    private UserService userService;


    @Override
    public List<WeibaoDTO> queryWeibaoList(String id) {
        Weibao weibaoCondition = new Weibao();
        weibaoCondition.setElevatorId(id);

        List<WeibaoDTO> weibaoDTOList = new ArrayList<>();
        List<Weibao> weibaoList = weibaoMapper.queryWeibaoList(weibaoCondition);

        for (Weibao weibao: weibaoList) {
            WeibaoDTO wd = new WeibaoDTO();
            BeanUtils.copyProperties(weibao,wd);
            weibao.getUserId();

            User user = new User();
            user.setUserId(weibao.getUserId());
            User u = userService.queryUser(user);
            wd.setWeibaoUsername(u.getRealname());
            weibaoDTOList.add(wd);
        }
        return weibaoDTOList;
    }

    @Override
    @Transactional
    public int insertWeibao(Weibao weibao) {
        return weibaoMapper.insert(weibao);
    }
}
