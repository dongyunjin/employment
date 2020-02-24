package com.cn.employment.course.controller;


import com.cn.employment.course.entity.Course;
import com.cn.employment.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.cn.employment.base.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    @Value("${sys.upload}")
    private String upload;

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

    @PostMapping("course/pAdd")
    @ResponseBody
    public Map<String,Object> pAdd(Course course) {
        Map<String,Object> map = new HashMap<>();
        courseService.pAdd(course);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sAdd")
    @ResponseBody
    public Map<String, Object> sAdd(@RequestParam(value = "file", required=false) MultipartFile file,
                                            @RequestParam("name") String name, @RequestParam("desc") String desc) {
        Map<String, Object> result = new HashMap<>();
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();

                String uuid = UUID.randomUUID().toString().replaceAll("-", "");

                String newFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                String dir = upload;
                File fileDir = new File(dir);
                //若文件夹不存在 创建文件夹
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                //新图片
                File newFile = new File(dir, newFileName);

                //将内存中的数据写入磁盘
                file.transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Course course = new Course();
        courseService.sAdd(course);
        result.put("success", 1);
        return result;
    }

    @PostMapping("course/pEdit")
    @ResponseBody
    public Map<String,Object> pEdit(Course course) {
        Map<String,Object> map = new HashMap<>();
        courseService.pEdit(course);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sEdit")
    @ResponseBody
    public Map<String, Object> sEdit(@RequestParam(value = "file", required=false) MultipartFile file,
                                    @RequestParam("name") String name, @RequestParam("desc") String desc) {
        Map<String, Object> result = new HashMap<>();
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();

                String uuid = UUID.randomUUID().toString().replaceAll("-", "");

                String newFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                String dir = upload;
                File fileDir = new File(dir);
                //若文件夹不存在 创建文件夹
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                //新图片
                File newFile = new File(dir, newFileName);

                //将内存中的数据写入磁盘
                file.transferTo(newFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Course course = new Course();
        courseService.sEdit(course);
        result.put("success", 1);
        return result;
    }

    @PostMapping("course/pDel/{id}")
    @ResponseBody
    public Map<String,Object> pDel(@PathVariable int id) {
        Map<String,Object> map = new HashMap<>();
        courseService.pDel(id);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sDel/{id}")
    @ResponseBody
    public Map<String,Object> sDel(@PathVariable int id) {
        Map<String,Object> map = new HashMap<>();
        courseService.sDel(id);
        map.put("success", 1);
        return map;
    }

}
