package com.cn.employment.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/*
@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurationSupport {

    @Value("${sys.upload}")
    private String upload;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Path/**").addResourceLocations("file:" + upload);
        super.addResourceHandlers(registry);
    }
}*/
