package com.cn.employment.front.solomon.controller;

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
    public String solomonUI() {
        return "front/solomonTest";
    }
}
