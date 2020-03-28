package com.cn.employment.train.service.impl;

import com.cn.employment.framework.base.service.impl.BaseServiceImpl;
import com.cn.employment.train.dao.TrainMapper;
import com.cn.employment.train.entity.TrainEntity;
import com.cn.employment.train.service.ITrainService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
@Service
public class TrainServiceImpl extends BaseServiceImpl<TrainMapper, TrainEntity> implements ITrainService {

    @Override
    public List<TrainEntity> selectAllCourse() {
        return this.baseMapper.selectAllCourse();
    }

    @Override
    public List<TrainEntity> selectSonCourse() {
        return this.baseMapper.selectSonCourse();
    }

    @Override
    public List<TrainEntity> selectSonCourseByPid(Long id) {
        return this.baseMapper.selectSonCourseByPid(id);
    }

    @Override
    public void pAdd(TrainEntity course) {
        course.setPid(0);
        course.insert();
    }

    @Override
    public void sAdd(TrainEntity course) {
        course.insert();
    }

    @Override
    public void pEdit(TrainEntity course) {
        this.baseMapper.updateById(course);
    }

    @Override
    public void sEdit(TrainEntity course) {
        this.baseMapper.updateById(course);
    }

    @Override
    public void pDel(Long id) {
        TrainEntity course = new TrainEntity();
        course.deleteById(id);
        this.baseMapper.delByPId(id);
    }

    @Override
    public void sDel(Long id) {
        TrainEntity course = new TrainEntity();
        course.deleteById(id);
    }
}
