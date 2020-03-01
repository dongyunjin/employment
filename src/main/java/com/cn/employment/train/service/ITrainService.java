package com.cn.employment.train.service;

import com.cn.employment.base.service.IBaseService;
import com.cn.employment.train.entity.TrainEntity;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author employment
 * @since 2020-02-23
 */
public interface ITrainService extends IBaseService<TrainEntity> {

    /**
    * @Description: 所有课程
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
    List<TrainEntity> selectSonCourseByPid(Long id);

    void pAdd(TrainEntity course);
    void sAdd(TrainEntity course);
    void pEdit(TrainEntity course);
    void sEdit(TrainEntity course);
    void pDel(Long id);
    void sDel(Long id);

}
