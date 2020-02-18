package com.cn.employment.service;

import java.util.List;

import com.cn.employment.entity.Calendar;
import com.cn.employment.entity.Fitnessrecord;
import com.cn.employment.util.BaseResult;

public interface IFitnessRecordService {
    
    List<Fitnessrecord> selectRecordByMemberId(Integer memberid);

}
