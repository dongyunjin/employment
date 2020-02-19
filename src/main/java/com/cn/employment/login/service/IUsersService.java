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
    Long queryId(Map<String, String> map);

    /**
     * @Description: 查询用户角色
     */
    Long queryRoleId(Map<String, String> map);
}
