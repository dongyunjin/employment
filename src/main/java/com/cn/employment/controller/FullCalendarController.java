package com.cn.employment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.employment.entity.Calendar;
import com.cn.employment.service.IfullCalendarService;
import com.cn.employment.util.BaseResult;
@Controller
public class FullCalendarController {
	
	@Autowired
	private IfullCalendarService ifullCalendarService;
	
	@GetMapping("classScheduleUI")
	public String fullCalendar() {
		return "class-schedule";
	}
	
	@GetMapping("classScheduleList")
	@ResponseBody
	public List<Calendar> classScheduleList() {
		return ifullCalendarService.selectAll();
	}
	
	@GetMapping("classScheduleAdd")
	@ResponseBody
	public BaseResult<Boolean> classScheduleAdd(Calendar calendar) {
		return ifullCalendarService.insert(calendar);
	}
	
	@GetMapping("classScheduleDel")
	@ResponseBody
	public BaseResult<Boolean> classScheduleDel(int id) {
		return ifullCalendarService.deleteByPrimaryKey(id);
	}
}
