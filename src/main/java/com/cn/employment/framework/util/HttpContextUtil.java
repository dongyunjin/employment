package com.cn.employment.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http工具
 * 
 * @ClassName: HttpContextUtil
 * @Description: TODO
 * @author: cyf
 * @date: 2018年1月2日 上午9:35:07
 */
public class HttpContextUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpContextUtil.class);

    /**
     * 获取 HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取 HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        return response;
    }
}
