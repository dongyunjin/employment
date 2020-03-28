package com.cn.employment.users.controller;


import com.cn.employment.users.entity.UsersEntity;
import com.cn.employment.users.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.cn.employment.framework.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  管理员管理用户模块
 * </p>
 *
 * @author employment
 * @since 2020-03-07
 */
@Controller
public class UsersController extends BaseController {

    @Autowired
    private IUsersService usersService;

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
     * @Description: 获取岗位信息
     * @Date: 2020/3/7 17:14
     */
    @RequestMapping("user_mgmt/list")
    @ResponseBody
    public Map<String,Object> recruitList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", this.usersService.userList());
        return map;
    }

    @PostMapping("user_mgmt/add")
    @ResponseBody
    public Map<String,Object> add(UsersEntity usersEntity) {
        Map<String,Object> map = new HashMap<>();
        this.usersService.add(usersEntity);
        map.put("success", 1);
        return map;
    }

    @PostMapping("user_mgmt/edit")
    @ResponseBody
    public Map<String,Object> edit(UsersEntity usersEntity) {
        Map<String,Object> map = new HashMap<>();
        this.usersService.edit(usersEntity);
        map.put("success", 1);
        return map;
    }

    @PostMapping("user_mgmt/del")
    @ResponseBody
    public Map<String,Object> pDel(Long id) {
        Map<String,Object> map = new HashMap<>();
        this.usersService.del(id);
        map.put("success", 1);
        return map;
    }
}
