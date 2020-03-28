package com.cn.employment.question.controller;


import com.cn.employment.framework.annotion.BussinessLog;
import com.cn.employment.question.entity.Question;
import com.cn.employment.question.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.cn.employment.framework.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 题库 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-03-22
 */
@Controller
public class QuestionController extends BaseController {

    @Autowired
    private IQuestionService questionService;

    @RequestMapping("questionLevelUI")
    @BussinessLog("水平测试页面")
    public String questionLevelUI() {
        return "backend/question_level";
    }

    @RequestMapping("questionAfterUI")
    @BussinessLog("测试题页面")
    public String questionAfterUI() {
        return "backend/question_after";
    }


    //获取测试题
    /**
     * @Description: 获取岗位信息
     * @Date: 2020/3/7 17:14
     */
    @RequestMapping("questionListByBusId")
    @ResponseBody
    @BussinessLog("获取测试题")
    public Map<String,Object> questionListByBusId(String type, Integer busId) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", this.questionService.questionList(type, busId));
        return map;
    }

    /**
     * @Description: 获取岗位信息
     * @Date: 2020/3/7 17:14
     */
    @RequestMapping("questionList")
    @ResponseBody
    @BussinessLog("获取测试题")
    public Map<String,Object> questionList(String type) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", this.questionService.questionList(type));
        return map;
    }

    @PostMapping("question/add")
    @ResponseBody
    @BussinessLog("添加测试题")
    public Map<String,Object> add(Question question) {
        Map<String,Object> map = new HashMap<>();
        this.questionService.add(question);
        map.put("success", 1);
        return map;
    }

    @PostMapping("question/edit")
    @ResponseBody
    @BussinessLog("修改测试题")
    public Map<String,Object> edit(Question question) {
        Map<String,Object> map = new HashMap<>();
        this.questionService.edit(question);
        map.put("success", 1);
        return map;
    }

    @PostMapping("question/del")
    @ResponseBody
    @BussinessLog("删除测试题")
    public Map<String,Object> pDel(Long id) {
        Map<String,Object> map = new HashMap<>();
        this.questionService.del(id);
        map.put("success", 1);
        return map;
    }
}
