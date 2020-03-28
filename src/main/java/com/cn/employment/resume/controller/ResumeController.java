package com.cn.employment.resume.controller;


import com.cn.employment.framework.annotion.BussinessLog;
import com.cn.employment.resume.entity.ResumeEntity;
import com.cn.employment.resume.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.cn.employment.framework.base.controller.BaseController;
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
    @RequestMapping("personalUI")
    @BussinessLog("简历信息页面")
    public String resumeUI() {
        return "front/personal";
    }

    //查询个人简历信息
    @RequestMapping("resume")
    @ResponseBody
    @BussinessLog("个人简历")
    public Map<String, Object> getResume(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        map.put("data", this.resumeService.getResume(userId));
        return map;
    }

    //查询个人简历信息
    @RequestMapping("updateResume")
    @ResponseBody
    @BussinessLog("更新个人简历")
    public Map<String, Object> updateResume(ResumeEntity resumeEntity) {
        Map<String,Object> map = new HashMap<>();
        this.resumeService.updateResume(resumeEntity);
        map.put("success", 1);
        return map;
    }
}
