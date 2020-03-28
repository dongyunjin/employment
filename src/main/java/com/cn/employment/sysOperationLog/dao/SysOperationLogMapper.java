package com.cn.employment.sysOperationLog.dao;

import com.cn.employment.sysOperationLog.entity.SysOperationLog;
import com.cn.employment.framework.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统操作日志 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-03-28
 */
public interface SysOperationLogMapper extends BaseMapper<SysOperationLog> {

    List<SysOperationLog> queryOperationLog(@Param("userId") Integer userId);
}
