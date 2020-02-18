package com.cn.employment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

	@GetMapping("echartsUI")
	public String echartsUI() {
		return "echartsPop";
	}
	
	@GetMapping("questionUI")
	public String questionUI() {
		return "question";
	}
}
