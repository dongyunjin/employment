package com.cn.employment.course.service.impl;

import com.cn.employment.course.entity.Course;
import com.cn.employment.course.dao.CourseMapper;
import com.cn.employment.course.service.ICourseService;
import com.cn.employment.framework.base.service.impl.BaseServiceImpl;
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
public class CourseServiceImpl extends BaseServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public List<Course> selectParentCourse() {
        return this.baseMapper.selectParentCourse();
    }

    @Override
    public List<Course> selectSonCourse() {
        return this.baseMapper.selectSonCourse();
    }

    @Override
    public List<Course> selectSonCourseByPid(Long id) {
        return this.baseMapper.selectSonCourseByPid(id);
    }

    @Override
    public void pAdd(Course course) {
        course.setPid(0);
        course.insert();
    }

    @Override
    public void sAdd(Course course) {
        course.insert();
    }

    @Override
    public void pEdit(Course course) {
        this.baseMapper.updateById(course);
    }

    @Override
    public void sEdit(Course course) {
        this.baseMapper.updateById(course);
    }

    @Override
    public void pDel(Long id) {
        Course course = new Course();
        course.deleteById(id);
        this.baseMapper.delByPId(id);
    }

    @Override
    public void sDel(Long id) {
        Course course = new Course();
        course.deleteById(id);
    }
}
