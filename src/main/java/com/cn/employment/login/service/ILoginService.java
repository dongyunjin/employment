package com.cn.employment.login.service;

import com.cn.employment.framework.base.service.IBaseService;
import com.cn.employment.login.entity.Login;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author employment
 */
public interface ILoginService extends IBaseService<Login> {

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
