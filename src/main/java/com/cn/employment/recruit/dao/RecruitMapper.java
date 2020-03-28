package com.cn.employment.recruit.dao;

import com.cn.employment.recruit.entity.RecruitEntity;
import com.cn.employment.framework.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 招聘信息 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-03-04
 */
public interface RecruitMapper extends BaseMapper<RecruitEntity> {


    /**
    * @Description: 获取所有招聘信息
    * @Date: 2020/3/4 23:17
    */
    List<RecruitEntity> recruitList();

    /**
     * @Description: 根据id查询招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<RecruitEntity> recruitList(@Param("id") Long id);
}
