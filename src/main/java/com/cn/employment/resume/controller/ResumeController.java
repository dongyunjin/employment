package com.cn.employment.resume.controller;


import com.cn.employment.resume.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.cn.employment.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 简历 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Controller
public class ResumeController extends BaseController {


    @Autowired
    private IResumeService resumeService;
    //
    @RequestMapping("")
    public String resumeUI() {
        return "";
    }

    //查询个人简历信息
    @RequestMapping("resume")
    @ResponseBody
    public Map<String, Object> getResume(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("data", this.resumeService.getResume(userId));
        return map;
    }
}
