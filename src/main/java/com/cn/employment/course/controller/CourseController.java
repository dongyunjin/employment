package com.cn.employment.course.controller;


import com.cn.employment.course.entity.Course;
import com.cn.employment.course.service.ICourseService;
import com.cn.employment.framework.annotion.BussinessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.cn.employment.framework.base.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
    @BussinessLog("课程页面")
    public String courseUI(Model model) {
        model.addAttribute("g", "eee");
        return "backend/course";
    }


    @PostMapping("course/pList")
    @ResponseBody
    @BussinessLog("课程分类")
    public Map<String,Object> pList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectParentCourse());
        return map;
    }


    @PostMapping("course/sList")
    @ResponseBody
    @BussinessLog("课程列表")
    public Map<String,Object> sList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectSonCourse());
        return map;
    }


    @PostMapping("course/sList/{id}")
    @ResponseBody
    @BussinessLog("课程列表")
    public Map<String,Object> sList(@PathVariable Long id) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", courseService.selectSonCourseByPid(id));
        return map;
    }

    @PostMapping("course/pAdd")
    @ResponseBody
    @BussinessLog("添加课程分类")
    public Map<String,Object> pAdd(Course course) {
        Map<String,Object> map = new HashMap<>();
        courseService.pAdd(course);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sAdd")
    @ResponseBody
    @BussinessLog("添加课程")
    public Map<String, Object> sAdd(@RequestParam(value = "file", required=false) MultipartFile file,
                                            @RequestParam("name") String name, @RequestParam("description") String description,
                                    @RequestParam("pid") int pid) {
        Map<String, Object> result = new HashMap<>();
        Course course = new Course();
        course.setPid(pid);
        course.setName(name);
        course.setDescription(description);

        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                Long size = file.getSize();
                String filetype = file.getContentType();
                String type = file.getContentType().split("/")[0];

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
                course.setType(type);
                course.setFiletype(filetype);
                course.setCaption(fileName);
                course.setSize(size + "");
                course.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        courseService.sAdd(course);
        result.put("success", 1);
        return result;
    }

    @PostMapping("course/pEdit")
    @ResponseBody
    @BussinessLog("编辑课程分类")
    public Map<String,Object> pEdit(Course course) {
        Map<String,Object> map = new HashMap<>();
        courseService.pEdit(course);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sEdit")
    @ResponseBody
    @BussinessLog("编辑课程")
    public Map<String, Object> sEdit(@RequestParam(value = "file", required=false) MultipartFile file,
                                    @RequestParam("name") String name, @RequestParam("description") String description,
                                     @RequestParam("id") long id,@RequestParam("pid") int pid,@RequestParam("url") String url) {
        Map<String, Object> result = new HashMap<>();
        Course course = new Course();
        course.setId(id);
        course.setPid(pid);
        course.setName(name);
        course.setDescription(description);
        if (file != null && !file.isEmpty()) {
            try {
                String dir = upload;

                File delDir = new File(dir + url);
                //若文件夹不存在 创建文件夹
                if (delDir.exists()) {
                    delDir.delete();
                }

                String fileName = file.getOriginalFilename();
                Long size = file.getSize();
                String filetype = file.getContentType();
                String type = file.getContentType().split("/")[0];

                String uuid = UUID.randomUUID().toString().replaceAll("-", "");

                String newFileName = uuid + fileName.substring(fileName.lastIndexOf("."));
                File fileDir = new File(dir);
                //若文件夹不存在 创建文件夹
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                //新图片
                File newFile = new File(dir, newFileName);

                //将内存中的数据写入磁盘
                file.transferTo(newFile);
                course.setType(type);
                course.setFiletype(filetype);
                course.setCaption(fileName);
                course.setSize(size + "");
                course.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        courseService.sEdit(course);
        result.put("success", 1);
        return result;
    }

    @PostMapping("course/pDel/{id}")
    @ResponseBody
    @BussinessLog("删除课程分类")
    public Map<String,Object> pDel(@PathVariable Long id) {
        Map<String,Object> map = new HashMap<>();
        List<Course> list = courseService.selectSonCourseByPid(id);
        for (Course course : list) {
            File delDir = new File(upload + course.getUrl());
            //若文件夹不存在 创建文件夹
            if (delDir.exists()) {
                delDir.delete();
            }
        }
        courseService.pDel(id);
        map.put("success", 1);
        return map;
    }

    @PostMapping("course/sDel/{id}")
    @ResponseBody
    @BussinessLog("删除课程")
    public Map<String,Object> sDel(@PathVariable Long id, @RequestParam("url") String url) {
        Map<String,Object> map = new HashMap<>();

        File delDir = new File(upload + url);
        //若文件夹不存在 创建文件夹
        if (delDir.exists()) {
            delDir.delete();
        }
        courseService.sDel(id);
        map.put("success", 1);
        return map;
    }
    

}
