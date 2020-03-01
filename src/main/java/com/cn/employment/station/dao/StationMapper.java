package com.cn.employment.station.dao;

import com.cn.employment.station.entity.StationEntity;
import com.cn.employment.base.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 岗位表 Mapper 接口
 * </p>
 *
 * @author employment
 * @since 2020-02-25
 */
public interface StationMapper extends BaseMapper<StationEntity> {

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
    List<StationEntity> selectSonStationByPid(@Param("id") Long id);

    void delByPId(@Param("id") Long id);
}
