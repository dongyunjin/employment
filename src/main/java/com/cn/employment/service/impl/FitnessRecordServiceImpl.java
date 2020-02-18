package com.cn.employment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.employment.entity.Calendar;
import com.cn.employment.entity.Fitnessrecord;
import com.cn.employment.mapper.CalendarMapper;
import com.cn.employment.mapper.FitnessrecordMapper;
import com.cn.employment.service.IFitnessRecordService;
import com.cn.employment.util.BaseResult;

@Service
public class FitnessRecordServiceImpl implements IFitnessRecordService{

	@Autowired
	private FitnessrecordMapper fitnessrecordMapper;

	
	@Override
	public List<Fitnessrecord> selectRecordByMemberId(Integer memberid) {
		List<Fitnessrecord> count = null;
		try {
			count = fitnessrecordMapper.selectRecordByMemberId(memberid);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return count;
	}
}
