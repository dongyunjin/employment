package com.cn.employment.users.service;

import com.cn.employment.users.entity.UsersEntity;
import com.cn.employment.framework.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author employment
 * @since 2020-03-07
 */
public interface IUsersService extends IBaseService<UsersEntity> {

    /**
     * @Description: 获取所有招聘信息
     * @Date: 2020/3/4 23:17
     */
    List<UsersEntity> userList();

    /**
     * @Description: 根据id 查询岗位
     * @Date: 2020/2/23 18:21
     */
    List<UsersEntity> userList(Long id);

    /**
     * @Description: 增加
     * @Date: 2020/3/7 17:17
     */
    void add(UsersEntity usersEntity);

    /**
     * @Description: 修改
     * @Date: 2020/3/7 17:17
     */
    void edit(UsersEntity usersEntity);

    /**
     * @Description: 删除
     * @Date: 2020/3/7 17:17
     */
    void del(Long id);
}
