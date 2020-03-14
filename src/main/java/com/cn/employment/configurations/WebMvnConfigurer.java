package com.cn.employment.configurations;

/**
 * @Description:
 * @Date: $ $
 * @Author: dyj
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 拦截器配置类
 */
@Configuration
public class WebMvnConfigurer implements WebMvcConfigurer {
    @Autowired
    private WebInterceptor webInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/");
        list.add("/login");
        list.add("/ftl/**");
        list.add("/static/**");
        list.add("/css/**");
        list.add("/js/**");
        list.add("/file-input/**");
        list.add("/img/**");
        list.add("/packages/**");
        list.add("/scss/**");
        list.add("/vendor/**");
        list.add("/video-js.swf/**");
        registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}