package com.cn.employment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.employment.entity.TbCoach;
import com.cn.employment.entity.TbMembership;
import com.cn.employment.service.ICoachService;
import com.cn.employment.service.IMemberService;
import com.cn.employment.util.BaseResult;

@Controller
public class CoachsController {

	@Autowired
	private  ICoachService iCoachService;
	
	@GetMapping("coachsUI")
	public String coachsUI() {
		return "coachsprofile";
	}
	
	@GetMapping("coachsList")
	@ResponseBody
	public Map<String,List<TbCoach>> coachsList() {
		Map<String,List<TbCoach>> map = new HashMap<>();
		map.put("data", iCoachService.selectAll());
		return map;
	}
	
	@GetMapping("coachsAdd")
	@ResponseBody
	public BaseResult<Boolean> coachsAdd(TbCoach record) {
		return iCoachService.insert(record);
	}
	
	@GetMapping("coachsEdit")
	@ResponseBody
	public BaseResult<Boolean> coachsEdit(TbCoach record) {
		return iCoachService.updateByPrimaryKey(record);
	}
	
	@GetMapping("coachsDel")
	@ResponseBody
	public BaseResult<Boolean> coachsDel(int id) {
		return iCoachService.deleteByPrimaryKey(id);
	}
}
