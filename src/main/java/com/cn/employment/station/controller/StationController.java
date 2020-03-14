package com.cn.employment.station.controller;


import com.cn.employment.station.entity.StationEntity;
import com.cn.employment.station.service.IStationService;
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
 * 岗位表 前端控制器
 * </p>
 *
 * @author employment
 * @since 2020-02-25
 */
@Controller
@RequestMapping("")
public class StationController extends BaseController {

    @Value("${sys.upload}")
    private String upload;

    @Autowired
    private IStationService stationService;


    /**
     * @Description: 课程列表页
     * @Date: 2020/2/20 21:14
     */
    @GetMapping("stationUI")
    public String courseUI(Model model) {
        model.addAttribute("g", "eee");
        return "backend/station";
    }


    @PostMapping("station/pList")
    @ResponseBody
    public Map<String,Object> pList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", stationService.selectParentStation());
        return map;
    }


    @PostMapping("station/sList")
    @ResponseBody
    public Map<String,Object> sList() {
        Map<String,Object> map = new HashMap<>();
        map.put("data", stationService.selectSonStation());
        return map;
    }


    @PostMapping("station/sList/{id}")
    @ResponseBody
    public Map<String,Object> sList(@PathVariable Long id) {
        Map<String,Object> map = new HashMap<>();
        map.put("data", stationService.selectSonStationByPid(id));
        return map;
    }

    @PostMapping("station/pAdd")
    @ResponseBody
    public Map<String,Object> pAdd(StationEntity station) {
        Map<String,Object> map = new HashMap<>();
        stationService.pAdd(station);
        map.put("success", 1);
        return map;
    }

    @PostMapping("station/sAdd")
    @ResponseBody
    public Map<String, Object> sAdd(@RequestParam(value = "file", required=false) MultipartFile file,
                                    @RequestParam("name") String name, @RequestParam("description") String description,
                                    @RequestParam("pid") int pid) {
        Map<String, Object> result = new HashMap<>();
        StationEntity station = new StationEntity();
        station.setPid(pid);
        station.setName(name);
        station.setDescription(description);

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
                station.setType(type);
                station.setFiletype(filetype);
                station.setCaption(fileName);
                station.setSize(size + "");
                station.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        stationService.sAdd(station);
        result.put("success", 1);
        return result;
    }

    @PostMapping("station/pEdit")
    @ResponseBody
    public Map<String,Object> pEdit(StationEntity station) {
        Map<String,Object> map = new HashMap<>();
        stationService.pEdit(station);
        map.put("success", 1);
        return map;
    }

    @PostMapping("station/sEdit")
    @ResponseBody
    public Map<String, Object> sEdit(@RequestParam(value = "file", required=false) MultipartFile file,
                                     @RequestParam("name") String name, @RequestParam("description") String description,
                                     @RequestParam("id") long id,@RequestParam("pid") int pid,@RequestParam("url") String url) {
        Map<String, Object> result = new HashMap<>();
        StationEntity station = new StationEntity();
        station.setId(id);
        station.setPid(pid);
        station.setName(name);
        station.setDescription(description);
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
                station.setType(type);
                station.setFiletype(filetype);
                station.setCaption(fileName);
                station.setSize(size + "");
                station.setUrl(newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stationService.sEdit(station);
        result.put("success", 1);
        return result;
    }

    @PostMapping("station/pDel/{id}")
    @ResponseBody
    public Map<String,Object> pDel(@PathVariable Long id) {
        Map<String,Object> map = new HashMap<>();
        List<StationEntity> list = stationService.selectSonStationByPid(id);
        for (StationEntity station : list) {
            File delDir = new File(upload + station.getUrl());
            //若文件夹不存在 创建文件夹
            if (delDir.exists()) {
                delDir.delete();
            }
        }
        stationService.pDel(id);
        map.put("success", 1);
        return map;
    }

    @PostMapping("station/sDel/{id}")
    @ResponseBody
    public Map<String,Object> sDel(@PathVariable Long id, @RequestParam("url") String url) {
        Map<String,Object> map = new HashMap<>();

        File delDir = new File(upload + url);
        //若文件夹不存在 创建文件夹
        if (delDir.exists()) {
            delDir.delete();
        }
        stationService.sDel(id);
        map.put("success", 1);
        return map;
    }


    @RequestMapping("stationTreeList")
    @ResponseBody
    public Object stationTreeList(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.getTreeNode(0, stationService.selectAllStation()));
        return map;
    }

    @RequestMapping("recruitTreeList")
    @ResponseBody
    public Object recruitTreeList(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.getTreeNode(0, stationService.selectAllStationRecruit()));
        return map;
    }

    public TreeNode getTreeNode(Integer id, List<StationEntity> list) {

        List<TreeNode> treeNodeList = new ArrayList<>();

        //当前节点
        TreeNode treeNode = new TreeNode();
        StationEntity node = this.getThisNodeByID(id, list);
        //treeNode.setIcon("fa fa-flask");
        if (node != null) {
            treeNode.setId(node.getId());
            treeNode.setName(node.getName());
            treeNode.setUrl(node.getUrl());
        } else if (id == 0) {
            treeNode.setId((long) 0);
            treeNode.setName("岗位分类");
        }

        //treeNode.setState();
        //获取所有子节点
        List<StationEntity> childList = this.getChildListByPID(id, list);
        //遍历子节点
        for (StationEntity child : childList) {
            TreeNode childNode = this.getTreeNode((int) child.getId().longValue(), list); //递归
            treeNodeList.add(childNode);
        }
        treeNode.setChildren(treeNodeList);
        return treeNode;
    }

    private StationEntity getThisNodeByID(Integer id, List<StationEntity> list) {
        for (StationEntity train : list) {
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
    private List<StationEntity> getChildListByPID(Integer pid, List<StationEntity> list) {
        List<StationEntity> childList = new ArrayList<>();
        for (StationEntity node : list) {
            if (pid.equals(node.getPid())) {
                childList.add(node);
            }
        }
        return childList;
    }
}
