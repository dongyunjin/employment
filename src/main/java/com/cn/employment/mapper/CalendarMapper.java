package com.cn.employment.mapper;

import com.cn.employment.entity.Calendar;
import java.util.List;

public interface CalendarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Calendar record);

    Calendar selectByPrimaryKey(Integer id);

    List<Calendar> selectAll();
    
    List<Calendar> selectByMemberId(Integer memberid);
    
    List<Calendar> selectRecordByMemberId(Integer memberid);

    int updateByPrimaryKey(Calendar record);
}