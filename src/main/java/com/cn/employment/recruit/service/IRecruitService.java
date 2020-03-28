package com.cn.employment.recruit.service;

import com.cn.employment.recruit.entity.RecruitEntity;
import com.cn.employment.framework.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 招聘信息 服务类
 * </p>
 *
 * @author employment
 * @since 2020-03-04
 */
public interface IRecruitService extends IBaseService<RecruitEntity> {

    /**
    * @Description: 获取所有招聘信息
    * @Date: 2020/3/4 23:17
    */
    List<RecruitEntity> recruitList();

    /**
     * @Description: 根据id 查询岗位
     * @Date: 2020/2/23 18:21
     */
    List<RecruitEntity> recruitList(Long id);

    /**
    * @Description: 增加
    * @Date: 2020/3/7 17:17
    */
    void add(RecruitEntity recruit);

    /**
    * @Description: 修改
    * @Date: 2020/3/7 17:17
    */
    void edit(RecruitEntity recruit);

    /**
     * @Description: 删除
     * @Date: 2020/3/7 17:17
     */
    void del(Long id);
}
