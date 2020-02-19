package com.cn.employment.login.service.impl;

import com.cn.employment.base.service.impl.BaseServiceImpl;
import com.cn.employment.login.dao.UsersMapper;
import com.cn.employment.login.entity.Users;
import com.cn.employment.login.service.IUsersService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-02-19
 */
@Service
public class UsersServiceImpl extends BaseServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public Long queryUserId(Map<String, String> map) {
        return this.baseMapper.queryUserId(map);
    }

    @Override
    public Long queryRoleId(Long userId) {
        return this.baseMapper.queryRoleId(userId);
    }
}
