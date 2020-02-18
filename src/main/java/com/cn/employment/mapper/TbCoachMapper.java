package com.cn.employment.mapper;

import com.cn.employment.entity.TbCoach;
import java.util.List;

public interface TbCoachMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCoach record);

    TbCoach selectByPrimaryKey(Integer id);

    List<TbCoach> selectAll();

    int updateByPrimaryKey(TbCoach record);
}