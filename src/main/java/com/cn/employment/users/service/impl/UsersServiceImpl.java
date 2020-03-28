package com.cn.employment.users.service.impl;

import com.cn.employment.users.entity.UsersEntity;
import com.cn.employment.users.dao.UsersMapper;
import com.cn.employment.users.service.IUsersService;
import com.cn.employment.framework.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-03-07
 */
@Service
public class UsersServiceImpl extends BaseServiceImpl<UsersMapper, UsersEntity> implements IUsersService {

    @Override
    public List<UsersEntity> userList() {
        return this.baseMapper.userList();
    }

    @Override
    public List<UsersEntity> userList(Long id) {
        return this.baseMapper.userList(id);
    }

    @Override
    public void add(UsersEntity usersEntity) {
        usersEntity.insert();
    }

    @Override
    public void edit(UsersEntity usersEntity) {
        this.baseMapper.updateById(usersEntity);
    }

    @Override
    public void del(Long id) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.deleteById(id);
    }
}
