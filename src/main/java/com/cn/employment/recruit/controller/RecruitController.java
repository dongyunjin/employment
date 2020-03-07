package com.cn.employment.recruit.controller;


import com.cn.employment.course.entity.Course;
import com.cn.employment.recruit.entity.RecruitEntity;
import com.cn.employment.recruit.service.IRecruitService;
import com.cn.employment.station.entity.StationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.cn.employment.base.controller.BaseController;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招聘信息 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-03-04
 */
@Controller
public class RecruitController extends BaseController {

    @Autowired
    private IRecruitService recruitService;

    @RequestMapping("recruitUI")
    public String recruitUI() {
        return "backend/recruit";
    }

    /**
    * @Description: 获取岗位信息
    * @Date: 2020/3/7 17:14
    */
    @RequestMapping("recruitList")
    @ResponseBody
    public Map<String,Object> recruitList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", this.recruitService.recruitList());
        return map;
    }

    @PostMapping("recruit/add")
    @ResponseBody
    public Map<String,Object> add(RecruitEntity recruitEntity) {
        Map<String,Object> map = new HashMap<>();
        this.recruitService.add(recruitEntity);
        map.put("success", 1);
        return map;
    }

    @PostMapping("recruit/edit")
    @ResponseBody
    public Map<String,Object> edit(RecruitEntity recruitEntity) {
        Map<String,Object> map = new HashMap<>();
        this.recruitService.edit(recruitEntity);
        map.put("success", 1);
        return map;
    }

    @PostMapping("recruit/del")
    @ResponseBody
    public Map<String,Object> pDel(Long id) {
        Map<String,Object> map = new HashMap<>();
        this.recruitService.del(id);
        map.put("success", 1);
        return map;
    }
}
