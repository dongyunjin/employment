package com.cn.employment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("")
	public String login() {
		return "login";
	}
	
	@GetMapping("main")
	public String main() {
		return "main";
	}
	
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("d","aaa");
		return "index";
	}
	
	@GetMapping("forgotPasswordUI")
	public String forgotPassword() {
		return "forgot-password";
	}
	
	@GetMapping("registerUI")
	public String register() {
		return "register";
	}
}
