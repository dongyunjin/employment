package com.cn.employment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrController implements ErrorController{

	/**
     * 异常的分别处理--------------------------------
     *
     * @param request
     * @return
     */
    @RequestMapping("error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        switch (statusCode) {
            case 404:
                return "404";
            case 500:
                return "500";
            default:
                return "500";
        }
 
    }

	@Override
	public String getErrorPath() {
		return "error";
	}
}
