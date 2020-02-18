package com.cn.employment.service;

import java.util.List;

import com.cn.employment.entity.TbCoach;
import com.cn.employment.util.BaseResult;

public interface ICoachService {

	BaseResult<Boolean> deleteByPrimaryKey(Integer id);

	BaseResult<Boolean> insert(TbCoach record);

	TbCoach selectByPrimaryKey(Integer id);

    List<TbCoach> selectAll();

    BaseResult<Boolean> updateByPrimaryKey(TbCoach record);
}
