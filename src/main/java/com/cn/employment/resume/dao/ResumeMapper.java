package com.cn.employment.resume.dao;

import com.cn.employment.resume.entity.ResumeEntity;
import com.cn.employment.framework.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 简历 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
public interface ResumeMapper extends BaseMapper<ResumeEntity> {

    Map<String, Object> getResume(@Param("id") Integer id);
}
