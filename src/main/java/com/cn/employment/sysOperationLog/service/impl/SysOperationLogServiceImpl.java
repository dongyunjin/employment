package com.cn.employment.sysOperationLog.service.impl;

import com.cn.employment.sysOperationLog.entity.SysOperationLog;
import com.cn.employment.sysOperationLog.dao.SysOperationLogMapper;
import com.cn.employment.sysOperationLog.service.ISysOperationLogService;
import com.cn.employment.framework.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统操作日志 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-03-28
 */
@Service
public class SysOperationLogServiceImpl extends BaseServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

    @Override
    public List<SysOperationLog> queryOperationLog(Integer userId) {
        return this.baseMapper.queryOperationLog(userId);
    }
}
