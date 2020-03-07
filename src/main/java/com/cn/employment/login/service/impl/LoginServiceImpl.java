package com.cn.employment.login.service.impl;

import com.cn.employment.base.service.impl.BaseServiceImpl;
import com.cn.employment.login.dao.LoginMapper;
import com.cn.employment.login.entity.Login;
import com.cn.employment.login.service.ILoginService;
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
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, Login> implements ILoginService {

    @Override
    public Integer queryUserId(Map<String, String> map) {
        return this.baseMapper.queryUserId(map);
    }

    @Override
    public Integer queryRoleId(Long userId) {
        return this.baseMapper.queryRoleId(userId);
    }

    @Override
    public Integer queryUserName(String userName) {
        return this.baseMapper.queryUserName(userName);
    }
}
