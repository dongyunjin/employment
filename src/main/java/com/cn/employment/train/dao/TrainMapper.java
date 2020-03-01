package com.cn.employment.train.dao;

import com.cn.employment.base.dao.BaseMapper;
import com.cn.employment.train.entity.TrainEntity;
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
public interface TrainMapper extends BaseMapper<TrainEntity> {


    /**
     * @Description: 所有一级课程
     * @Date: 2020/2/23 18:15
     */
    List<TrainEntity> selectAllCourse();


    /**
     * @Description: 二级课程
     * @Date: 2020/2/23 18:16
     */
    List<TrainEntity> selectSonCourse();


    /**
     * @Description: 根据pid 查询子课程
     * @Date: 2020/2/23 18:21
     */
    List<TrainEntity> selectSonCourseByPid(@Param("id") Long id);

    void delByPId(@Param("id") Long id);
}
