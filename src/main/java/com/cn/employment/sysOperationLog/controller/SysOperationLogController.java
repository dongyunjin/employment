package com.cn.employment.sysOperationLog.controller;


import com.cn.employment.sysOperationLog.service.ISysOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import com.cn.employment.framework.annotion.BussinessLog;
import com.cn.employment.framework.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 系统操作日志 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-03-28
 */
@Controller
@RequestMapping("sysOperationLog")
public class SysOperationLogController extends BaseController {

    @Autowired
    private ISysOperationLogService sysOperationLogService;

    @RequestMapping("")
    @ResponseBody
    public Map<String, Object> sysOperationLog(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("data", this.sysOperationLogService.queryOperationLog(userId));
        map.put("success", 1);
        return map;
    }


/**
 * @Description: learnning_process
 * @Date: 2020/2/20 21:13
 */
@GetMapping("learnning_process")
@BussinessLog("登录")
public String login() {
    return "front/learnning_process";
}
}