package com.cn.employment.upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @PostMapping("/upload")
    public void uploadSingle(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
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
    }
}
