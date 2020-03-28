package com.cn.employment.login.dao;

import com.cn.employment.framework.base.dao.BaseMapper;
import com.cn.employment.login.entity.Login;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginMapper extends BaseMapper<Login> {

    /**
    * @Description: 查询用户id
    * @Date: 2020/2/19 19:57
    */
    Integer queryUserId(@Param("map") Map<String, String> map);

    /**
    * @Description: 根据用户id查询用户角色
    * @Date: 2020/2/19 19:58
    */
    Integer queryRoleId(@Param("userId") Long userId);

    /**
     * @Description: 查询用户是否存在
     * @Date: 2020/2/19 19:58
     */
    Integer queryUserName(@Param("userName") String userName);

}