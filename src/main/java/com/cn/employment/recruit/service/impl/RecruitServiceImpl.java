package com.cn.employment.recruit.service.impl;

import com.cn.employment.recruit.entity.RecruitEntity;
import com.cn.employment.recruit.dao.RecruitMapper;
import com.cn.employment.recruit.service.IRecruitService;
import com.cn.employment.framework.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 招聘信息 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-03-04
 */
@Service
public class RecruitServiceImpl extends BaseServiceImpl<RecruitMapper, RecruitEntity> implements IRecruitService {

    @Override
    public List<RecruitEntity> recruitList() {
        return this.baseMapper.recruitList();
    }

    @Override
    public List<RecruitEntity> recruitList(Long id) {
        return this.baseMapper.recruitList(id);
    }

    @Override
    public void add(RecruitEntity recruit) {
        recruit.insert();
    }

    @Override
    public void edit(RecruitEntity recruit) {
        this.baseMapper.updateById(recruit);
    }

    @Override
    public void del(Long id) {
        RecruitEntity recruit = new RecruitEntity();
        recruit.deleteById(id);
    }
}
