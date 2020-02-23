package com.cn.employment.course.controller;


import com.cn.employment.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.cn.employment.base.controller.BaseController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Controller
@RequestMapping("")
public class CourseController extends BaseController {

    @Autowired
    private ICourseService courseService;


    /**
     * @Description: 课程列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("courseUI")
    public String courseUI(Model model) {
        model.addAttribute("g", "eee");
        return "backend/course";
    }


    @PostMapping("course/pList")
    @ResponseBody
    public Map<String,Object> pList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectParentCourse());
        return map;
    }


    @PostMapping("course/sList")
    @ResponseBody
    public Map<String,Object> sList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectSonCourse());
        return map;
    }


    @PostMapping("course/sList/{id}")
    @ResponseBody
    public Map<String,Object> sList(@PathVariable int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectSonCourseByPid(id));
        return map;
    }



}
