package com.cn.employment.resume.service.impl;

import com.cn.employment.resume.entity.ResumeEntity;
import com.cn.employment.resume.dao.ResumeMapper;
import com.cn.employment.resume.service.IResumeService;
import com.cn.employment.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 简历 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Service
public class ResumeServiceImpl extends BaseServiceImpl<ResumeMapper, ResumeEntity> implements IResumeService {

    @Override
    public Map<String, Object> getResume(Integer id) {
        return this.baseMapper.getResume(id);
    }
}
