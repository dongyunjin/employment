package com.cn.employment.station.service;

import com.cn.employment.station.entity.StationEntity;
import com.cn.employment.framework.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 岗位表 服务类
 * </p>
 *
 * @author employment
 * @since 2020-02-25
 */
public interface IStationService extends IBaseService<StationEntity> {

    /**
     * @Description: 所有一级课程
     * @Date: 2020/2/23 18:15
     */
    List<StationEntity> selectParentStation();


    /**
     * @Description: 二级课程
     * @Date: 2020/2/23 18:16
     */
    List<StationEntity> selectSonStation();


    /**
     * @Description: 根据pid 查询子课程
     * @Date: 2020/2/23 18:21
     */
    List<StationEntity> selectSonStationByPid(Long id);

    void pAdd(StationEntity course);
    void sAdd(StationEntity course);
    void pEdit(StationEntity course);
    void sEdit(StationEntity course);
    void pDel(Long id);
    void sDel(Long id);



    List<StationEntity> selectAllStation();

    List<StationEntity>  selectAllStationRecruit();
}
