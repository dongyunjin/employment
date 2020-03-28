package com.cn.employment.front.solomon.controller;

import com.cn.employment.framework.annotion.BussinessLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Date: $ $
 * @Author: dyj
 */
@Controller
public class SolomonController {

    @RequestMapping("solomonUI")
    @BussinessLog("所罗门测试")
    public String solomonUI() {
        return "front/solomonTest";
    }
}
