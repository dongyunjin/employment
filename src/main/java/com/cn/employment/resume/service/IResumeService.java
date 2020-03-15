package com.cn.employment.resume.service;

import com.cn.employment.resume.entity.ResumeEntity;
import com.cn.employment.base.service.IBaseService;

import java.util.Map;

/**
 * <p>
 * 简历 服务类
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
public interface IResumeService extends IBaseService<ResumeEntity> {

    /**
    * @Description: 获取个人简历信息
    * @Date: 2020/3/14 14:55
    * @Author: dyj
    */
    Map<String, Object> getResume(Integer id);


    void updateResume(ResumeEntity resumeEntity);
}
