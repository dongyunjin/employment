package com.cn.employment.login.controller;

import com.cn.employment.login.entity.Users;
import com.cn.employment.login.service.IUsersService;
import com.cn.employment.usersRole.entity.UsersRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IUsersService usersService;

    /**
     * @Description: 请求登录页面
     * @Date: 2020/2/20 21:13
     */
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
    public Map<String, Object> login(@RequestParam Map<String, String> map) {
        Map<String, Object> result = new HashMap<>();
        Integer userId = this.usersService.queryUserId(map);
        result.put("userId", userId);
        return result;
    }


    /**
     * @Description: 登录成功后请求主页
     * @Date: 2020/2/20 21:13
     */
    @GetMapping("main")
    public String main(Long userId) {
        Integer roleId = this.usersService.queryRoleId(userId);

        if (roleId != null) {
            return "front/solomonTest";
        } else {
            return "backend/main";
        }
    }

    /**
     * @Description: 后台管理员首页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("d", "aaa");
        return "/backend/index";
    }

    /**
     * @Description: 忘记密码页面
     * @Date: 2020/2/20 21:17
     */
    @GetMapping("forgotPasswordUI")
    public String forgotPasswordUI() {
        return "login/forgot-password";
    }

    /**
     * @Description: 注册页面
     * @Date: 2020/2/20 21:17
     */
    @GetMapping("registerUI")
    public String registerUI() {
        return "login/register";
    }

    /**
    * @Description: 验证用户名是否存在
    * @Date: 2020/2/20 21:48
    */
    @ResponseBody
    @PostMapping("isExistUserName")
    public Map<String, Object> isExistUserName(@RequestParam String userName) {
        Map<String, Object> result = new HashMap<>();
        Integer id = this.usersService.queryUserName(userName);
        if (id == null) {
            result.put("isExist", 0);
        } else {
            result.put("isExist", 1);
        }

        return result;
    }

    /**
     * @Description: 注册
     * @Date: 2020/2/20 21:17
     */
    @PostMapping("register")
    public String register(Users users) {
        //key :email  username   pwd    phonenum

        users.insert();

        Integer id = this.usersService.queryUserName(users.getUsername());

        UsersRole usersRole = new UsersRole();
        usersRole.setUserId(id);
        usersRole.setRoleId(2);
        usersRole.insert();

        return "login/login";
    }

}
