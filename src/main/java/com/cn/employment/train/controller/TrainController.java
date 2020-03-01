package com.cn.employment.train.controller;


import com.cn.employment.train.entity.TrainEntity;
import com.cn.employment.train.service.ITrainService;
import com.cn.employment.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.cn.employment.base.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Controller
public class TrainController extends BaseController {

    @Value("${sys.upload}")
    private String upload;

    @Autowired
    private ITrainService trainService;


    /**
     * @Description: 课程列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("trainUI")
    public String trainUI(Model model) {
        model.addAttribute("g", "eee");
        return "front/course";
    }


    @RequestMapping("trainTreeList")
    @ResponseBody
    public Object treeList(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.getTreeNode(0, trainService.selectAllCourse()));
        return map;
    }

    public TreeNode getTreeNode(Integer id, List<TrainEntity> list) {

        List<TreeNode> treeNodeList = new ArrayList<>();

        //当前节点
        TreeNode treeNode = new TreeNode();
        TrainEntity node = this.getThisNodeByID(id, list);
        //treeNode.setIcon("fa fa-flask");
        if (node != null) {
            treeNode.setId(node.getId());
            treeNode.setName(node.getName());
            treeNode.setUrl(node.getUrl());
        } else if (id == 0) {
            treeNode.setId((long) 0);
            treeNode.setName("课程分类");
        }

        //treeNode.setState();
        //获取所有子节点
        List<TrainEntity> childList = this.getChildListByPID(id, list);
        //遍历子节点
        for (TrainEntity child : childList) {
            TreeNode childNode = this.getTreeNode((int) child.getId().longValue(), list); //递归
            treeNodeList.add(childNode);
        }
        treeNode.setChildren(treeNodeList);
        return treeNode;
    }

    private TrainEntity getThisNodeByID(Integer id, List<TrainEntity> list) {
        for (TrainEntity train : list) {
            if (train.getId().intValue() == id) {
                return train;
            }
        }
        return null;
    }

    /**
     * @param list
     * @return
     */
    private List<TrainEntity> getChildListByPID(Integer pid, List<TrainEntity> list) {
        List<TrainEntity> childList = new ArrayList<>();
        for (TrainEntity node : list) {
            if (pid.equals(node.getPid())) {
                childList.add(node);
            }
        }
        return childList;
    }

    @PostMapping("train/sList")
    @ResponseBody
    public Map<String, Object> sList() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", trainService.selectSonCourse());
        return map;
    }


    @PostMapping("train/sList/{id}")
    @ResponseBody
    public Map<String, Object> sList(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", trainService.selectSonCourseByPid(id));
        return map;
    }

    @PostMapping("train/pAdd")
    @ResponseBody
    public Map<String, Object> pAdd(TrainEntity train) {
        Map<String, Object> map = new HashMap<>();
        trainService.pAdd(train);
        map.put("success", 1);
        return map;
    }

    @PostMapping("train/sAdd")
    @ResponseBody
    public Map<String, Object> sAdd(@RequestParam(value = "file", required = false) MultipartFile file,
                                    @RequestParam("name") String name, @RequestParam("description") String description,
                                    @RequestParam("pid") int pid) {
        Map<String, Object> result = new HashMap<>();
        TrainEntity train = new TrainEntity();
        train.setPid(pid);
        train.setName(name);
        train.setDescription(description);

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
                train.setType(type);
                train.setFiletype(filetype);
                train.setCaption(fileName);
                train.setSize(size + "");
                train.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        trainService.sAdd(train);
        result.put("success", 1);
        return result;
    }

    @PostMapping("train/pEdit")
    @ResponseBody
    public Map<String, Object> pEdit(TrainEntity train) {
        Map<String, Object> map = new HashMap<>();
        trainService.pEdit(train);
        map.put("success", 1);
        return map;
    }

    @PostMapping("train/sEdit")
    @ResponseBody
    public Map<String, Object> sEdit(@RequestParam(value = "file", required = false) MultipartFile file,
                                     @RequestParam("name") String name, @RequestParam("description") String description,
                                     @RequestParam("id") long id, @RequestParam("pid") int pid, @RequestParam("url") String url) {
        Map<String, Object> result = new HashMap<>();
        TrainEntity train = new TrainEntity();
        train.setId(id);
        train.setPid(pid);
        train.setName(name);
        train.setDescription(description);
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
                train.setType(type);
                train.setFiletype(filetype);
                train.setCaption(fileName);
                train.setSize(size + "");
                train.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        trainService.sEdit(train);
        result.put("success", 1);
        return result;
    }

    @PostMapping("train/pDel/{id}")
    @ResponseBody
    public Map<String, Object> pDel(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        List<TrainEntity> list = trainService.selectSonCourseByPid(id);
        for (TrainEntity train : list) {
            File delDir = new File(upload + train.getUrl());
            //若文件夹不存在 创建文件夹
            if (delDir.exists()) {
                delDir.delete();
            }
        }
        trainService.pDel(id);
        map.put("success", 1);
        return map;
    }

    @PostMapping("train/sDel/{id}")
    @ResponseBody
    public Map<String, Object> sDel(@PathVariable Long id, @RequestParam("url") String url) {
        Map<String, Object> map = new HashMap<>();

        File delDir = new File(upload + url);
        //若文件夹不存在 创建文件夹
        if (delDir.exists()) {
            delDir.delete();
        }
        trainService.sDel(id);
        map.put("success", 1);
        return map;
    }

}
