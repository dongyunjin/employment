package com.cn.employment.users.dao;

import com.cn.employment.recruit.entity.RecruitEntity;
import com.cn.employment.users.entity.UsersEntity;
import com.cn.employment.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-03-07
 */
public interface UsersMapper extends BaseMapper<UsersEntity> {

    /**
     * @Description: 获取所有招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<UsersEntity> userList();

    /**
     * @Description: 根据id查询招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<UsersEntity> userList(@Param("id") Long id);
}
