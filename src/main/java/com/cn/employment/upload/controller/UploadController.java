package com.cn.employment.upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Date: $ $
 * @Author: dyj
 */
@Controller
public class UploadController {

    @Value("${sys.upload}")
    private String upload;

    @PostMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadSingle(@RequestParam(value = "file", required=false) MultipartFile file,
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

                System.err.println(name);
                System.err.println(desc);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        result.put("success", 1);
        return result;
    }
}
