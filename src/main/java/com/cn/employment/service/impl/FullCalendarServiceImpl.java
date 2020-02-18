package com.cn.employment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.employment.entity.Calendar;
import com.cn.employment.mapper.CalendarMapper;
import com.cn.employment.service.IfullCalendarService;
import com.cn.employment.util.BaseResult;

@Service
public class FullCalendarServiceImpl implements IfullCalendarService{

	@Autowired
	private CalendarMapper calendarMapper;
	
	@Override
	public BaseResult<Boolean> deleteByPrimaryKey(Integer id) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = calendarMapper.deleteByPrimaryKey(id);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("事件删除成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("事件删除失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("事件删除失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public BaseResult<Boolean> insert(Calendar record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = calendarMapper.insert(record);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("事件添加成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("事件添加失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("事件添加失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public BaseResult<Calendar> selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public List<Calendar> selectAll() {
		List<Calendar> count = null;
		try {
			count = calendarMapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return count;
	}

	@Override
	public BaseResult<Boolean> updateByPrimaryKey(Calendar record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = calendarMapper.updateByPrimaryKey(record);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("事件修改成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("事件修改失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("事件修改失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

}
