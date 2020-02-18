package com.cn.employment.mapper;

import com.cn.employment.entity.Fitnessrecord;
import java.util.List;

public interface FitnessrecordMapper {

    List<Fitnessrecord> selectRecordByMemberId(Integer memberid);

}