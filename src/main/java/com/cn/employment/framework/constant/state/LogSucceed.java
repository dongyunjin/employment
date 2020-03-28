package com.cn.employment.framework.constant.state;

/**
 * 业务是否成功的日志记录
 * 
 * @ClassName: LogSucceed
 * @Description: TODO
 * @author: cyf
 * @date: 2018年1月2日 上午9:10:24
 */
public enum LogSucceed {

    // 成功
    SUCCESS("成功"),
    // 失败
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
