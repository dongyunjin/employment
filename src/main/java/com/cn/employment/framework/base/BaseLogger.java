package com.cn.employment.framework.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log基类,所有的类默认继承此类,可以直接使用 logger 记录日志,例如 logger.error("error");
 * @ClassName: BaseLogger 
 * @Description: TODO
 * @author: cyf
 * @date: 2016年4月1日 上午9:27:54
 */
public class BaseLogger {   
	public Logger logger = LoggerFactory.getLogger(getClass());
}
