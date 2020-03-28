package com.cn.employment.framework.log.factory;

import com.cn.employment.framework.constant.state.LogSucceed;
import com.cn.employment.framework.constant.state.LogType;
import com.cn.employment.framework.log.LogManager;
import com.cn.employment.framework.util.SpringContextHolder;
import com.cn.employment.sysOperationLog.dao.SysOperationLogMapper;
import com.cn.employment.sysOperationLog.entity.SysOperationLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 */
public class LogTaskFactory {

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName,
            final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                SysOperationLog operationLog = LogFactory.createSysOperationLog(LogType.BUSSINESS, userId, bussinessName,
                        clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    SysOperationLogMapper operationLogMapper = SpringContextHolder.getBean(SysOperationLogMapper.class);
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

//    public static TimerTask exceptionLog(final Long userId, final Exception exception) {
//        return new TimerTask() {
//            @Override
//            public void run() {
//                String msg = getExceptionMsg(exception);
//                SysOperationLog operationLog = LogFactory.createSysOperationLog(LogType.EXCEPTION, userId, "", null, null,
//                        msg, LogSucceed.FAIL);
//                try {
//                    SysOperationLogMapper operationLogMapper = SpringContextHolder.getBean(SysOperationLogMapper.class);
//                    operationLogMapper.insert(operationLog);
//                } catch (Exception e) {
//                    logger.error("创建异常日志异常!", e);
//                }
//            }
//        };
//    }

    /**
     * 获取异常的具体信息
     */
    public static String getExceptionMsg(Exception e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.getBuffer().toString().replaceAll("\\$", "T");
    }
}
