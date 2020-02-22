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
     * @Description: 用户列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("user_mgmt")
    public String user_mgmt(Model model) {
        model.addAttribute("e", "bbb");
        return "/backend/user_mgmt";
    }
    
    /**
     * @Description: 岗位列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("job")
    public String job(Model model) {
        model.addAttribute("f", "ccc");
        return "/backend/job";
    }
    
    /**
     * @Description: 课程列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("_class")
    public String _class(Model model) {
        model.addAttribute("g", "eee");
        return "/backend/class";
    }
    
    /**
     * @Description: 教材列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("video")
    public String video(Model model) {
        model.addAttribute("h", "fff");
        return "/backend/video";
    }
    
    /**
     * @Description: admin修改密码页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("admin_pwd")
    public String admin_pwd(Model model) {
        model.addAttribute("i", "ggg");
        return "/backend/admin_pwd";
    }
    
    /**
     * @Description: admin操作记录页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("admin_log")
    public String admin_log(Model model) {
        model.addAttribute("j", "hhh");
        return "/backend/admin_log";
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
    @ResponseBody
    @PostMapping("register")
    public Map<String, Object> register(Users users) {
        //key :email  username   pwd    phonenum
        Map<String, Object> result = new HashMap<>();
        users.insert();

        Integer id = this.usersService.queryUserName(users.getUsername());

        if (id == null) {
            UsersRole usersRole = new UsersRole();
            usersRole.setUserId(id);
            usersRole.setRoleId(2);
            usersRole.insert();
            result.put("success", 1);
        } else {
            result.put("success", 0);
            result.put("msg", "此用户已存在");
        }

        return result;
    }

}
