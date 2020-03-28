package com.cn.employment.framework.log.factory;

import com.cn.employment.framework.constant.state.LogSucceed;
import com.cn.employment.framework.constant.state.LogType;
import com.cn.employment.sysOperationLog.entity.SysOperationLog;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 日志对象创建工厂
 * 
 * @ClassName: LogFactory
 */
public class LogFactory {

    /**
     * 创建操作日志
     */
    public static SysOperationLog createSysOperationLog(LogType logType, Integer userId, String bussinessName,
                                                        String clazzName, String methodName, String msg, LogSucceed succeed) {
        SysOperationLog operationLog = new SysOperationLog();
        operationLog.setLogType(logType.getMessage());
        operationLog.setLogName(bussinessName);
        operationLog.setUserId(userId);
        operationLog.setClassName(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        operationLog.setCreateDate(new Date());
        return operationLog;
    }
//
//    /**
//     * 创建登录日志
//     */
//    public static LoginLog createLoginLog(LogType logType, Long userId, String msg, String ip) {
//        LoginLog loginLog = new LoginLog();
//        loginLog.setLogName(logType.getMessage());
//        loginLog.setUserId(userId);
//        loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
//        loginLog.setIp(ip);
//        loginLog.setMessage(msg);
//        return loginLog;
//    }
}
