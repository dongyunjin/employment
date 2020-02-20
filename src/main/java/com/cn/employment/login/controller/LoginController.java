package com.cn.employment.login.controller;

import com.cn.employment.login.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("")
    public String login() {
        return "login/login";
    }

    /**
    * @Description: 验证用户
    * @Date: 2020/2/19 21:14
    */
    @ResponseBody
    @PostMapping("login")
    public Long login(@RequestParam Map<String, String> map) {
        return this.usersService.queryUserId(map);
    }


    @GetMapping("main")
    public String main(Long userId) {
        Long roleId = this.usersService.queryRoleId(userId);

        if (roleId != null) {
			return "front/main";
		} else {
			return "backend/main";
		}
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("d", "aaa");
        return "/backend/index";
    }

    @GetMapping("forgotPasswordUI")
    public String forgotPassword() {
        return "login/forgot-password";
    }

    @GetMapping("registerUI")
    public String register() {
        return "login/register";
    }

}
