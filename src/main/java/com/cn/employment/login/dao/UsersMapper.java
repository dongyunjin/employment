package com.cn.employment.login.dao;

import com.cn.employment.base.dao.BaseMapper;
import com.cn.employment.login.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UsersMapper extends BaseMapper<Users> {

    /**
    * @Description: 查询用户id
    * @Date: 2020/2/19 19:57
    */
    Long queryUserId(@Param("map") Map<String, String> map);

    /**
    * @Description: 根据用户id查询用户角色
    * @Date: 2020/2/19 19:58
    */
    Long queryRoleId(@Param("userId") Long userId);
}