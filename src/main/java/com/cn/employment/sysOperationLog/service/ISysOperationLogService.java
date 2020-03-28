package com.cn.employment.sysOperationLog.service;

import com.cn.employment.sysOperationLog.entity.SysOperationLog;
import com.cn.employment.framework.base.service.IBaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统操作日志 服务类
 * </p>
 *
 * @author employment
 * @since 2020-03-28
 */
public interface ISysOperationLogService extends IBaseService<SysOperationLog> {

    List<SysOperationLog> queryOperationLog(Integer userId);
}
