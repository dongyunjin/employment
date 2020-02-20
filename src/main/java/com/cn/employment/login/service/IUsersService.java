package com.cn.employment.login.service;

import com.cn.employment.base.service.IBaseService;
import com.cn.employment.login.entity.Users;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author employment
 */
public interface IUsersService extends IBaseService<Users> {

    /**User
    * @Description: 查询用户
    * @Date: 2020/2/19 21:16
    */
    Integer queryUserId(Map<String, String> map);

    /**
     * @Description: 查询用户角色
     */
    Integer queryRoleId(Long userId);

    /**
    * @Description: 查询用户是否存在
    * @Date: 2020/2/20 21:55
    */
    Integer queryUserName(String userName);
}
