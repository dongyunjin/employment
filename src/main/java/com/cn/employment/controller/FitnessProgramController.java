package com.cn.employment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.employment.entity.Calendar;
import com.cn.employment.service.IFitnessProgramService;
import com.cn.employment.service.IfullCalendarService;
import com.cn.employment.util.BaseResult;

@Controller
public class FitnessProgramController {

	@Autowired
	private IFitnessProgramService iFitnessProgramService;
	
	@GetMapping("fitnessProgramUI")
	public String fitnessProgramUI() {
		return "fitness-program";
	}
	
	@GetMapping("selectByMemberId/{memberid}")
	@ResponseBody
	public List<Calendar> selectByMemberId(@PathVariable("memberid") Integer memberid) {
		return iFitnessProgramService.selectByMemberId(memberid);
	}
	
	@GetMapping("fitnessProgramAdd")
	@ResponseBody
	public BaseResult<Boolean> fitnessProgramAdd(Calendar calendar) {
		return iFitnessProgramService.insert(calendar);
	}
	
	@GetMapping("fitnessProgramEdit")
	@ResponseBody
	public BaseResult<Boolean> fitnessProgramEdit(Calendar calendar) {
		return iFitnessProgramService.updateByPrimaryKey(calendar);
	}
	
	@GetMapping("fitnessProgramDel")
	@ResponseBody
	public BaseResult<Boolean> fitnessProgramDel(Integer id) {
		return iFitnessProgramService.deleteByPrimaryKey(id);
	}
}
