package com.cn.employment.framework.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.employment.framework.base.dao.BaseMapper;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
}