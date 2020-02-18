package com.cn.employment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.employment.entity.TbMembership;
import com.cn.employment.entity.User;
import com.cn.employment.mapper.UserMapper;
import com.cn.employment.service.IMemberService;
import com.cn.employment.util.BaseResult;

@Controller
public class MembersController {
	
	@Autowired
	private IMemberService iMemberService;
	
	@GetMapping("membersUI")
	public String members() {
		return "membersprofile";
	}
	
	@GetMapping("membersList")
	@ResponseBody
	public Map<String,List<TbMembership>> membersList() {
		Map<String,List<TbMembership>> map = new HashMap<>();
		map.put("data", iMemberService.selectAll());
		return map;
	}
	
	@GetMapping("membersAdd")
	@ResponseBody
	public BaseResult<Boolean> membersAdd(TbMembership record) {
		return iMemberService.insert(record);
	}
	
	@GetMapping("membersEdit")
	@ResponseBody
	public BaseResult<Boolean> membersEdit(TbMembership record) {
		return iMemberService.updateByPrimaryKey(record);
	}
	
	@GetMapping("membersDel")
	@ResponseBody
	public BaseResult<Boolean> membersDel(int id) {
		return iMemberService.deleteByPrimaryKey(id);
	}
}
