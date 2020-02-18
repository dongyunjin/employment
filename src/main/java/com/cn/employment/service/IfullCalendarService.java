package com.cn.employment.service;

import java.util.List;

import com.cn.employment.entity.Calendar;
import com.cn.employment.util.BaseResult;

public interface IfullCalendarService {

    BaseResult<Boolean> deleteByPrimaryKey(Integer id);

    BaseResult<Boolean> insert(Calendar record);

    BaseResult<Calendar> selectByPrimaryKey(Integer id);

    List<Calendar> selectAll();

    BaseResult<Boolean> updateByPrimaryKey(Calendar record);
}
