package com.cn.employment.course.dao;

import com.cn.employment.course.entity.Course;
import com.cn.employment.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
public interface CourseMapper extends BaseMapper<Course> {


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
    List<Course> selectSonCourseByPid(@Param("id") Long id);

    void delByPId(@Param("id") Long id);
}
