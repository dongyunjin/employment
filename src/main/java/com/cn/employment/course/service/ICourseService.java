package com.cn.employment.course.service;

import com.cn.employment.course.entity.Course;
import com.cn.employment.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
public interface ICourseService extends IBaseService<Course> {

    /**
    * @Description: 所有一级课程
    * @Date: 2020/2/23 18:15
    */
    List<Course> selectParentCourse();


    /**
    * @Description: 二级课程
    * @Date: 2020/2/23 18:16
    */
    List<Course> selectSonCourse();


    /**
    * @Description: 根据pid 查询子课程
    * @Date: 2020/2/23 18:21
    */
    List<Course> selectSonCourseByPid(Long id);

    void pAdd(Course course);
    void sAdd(Course course);
    void pEdit(Course course);
    void sEdit(Course course);
    void pDel(Long id);
    void sDel(Long id);

}
