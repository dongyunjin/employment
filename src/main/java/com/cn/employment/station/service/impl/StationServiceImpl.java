package com.cn.employment.station.service.impl;

import com.cn.employment.station.entity.StationEntity;
import com.cn.employment.station.dao.StationMapper;
import com.cn.employment.station.service.IStationService;
import com.cn.employment.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author employment
 * @since 2020-02-25
 */
@Service
public class StationServiceImpl extends BaseServiceImpl<StationMapper, StationEntity> implements IStationService {

    @Override
    public List<StationEntity> selectParentStation() {
        return this.baseMapper.selectParentStation();
    }

    @Override
    public List<StationEntity> selectSonStation() {
        return this.baseMapper.selectSonStation();
    }

    @Override
    public List<StationEntity> selectSonStationByPid(Long id) {
        return this.baseMapper.selectSonStationByPid(id);
    }

    @Override
    public void pAdd(StationEntity station) {
        station.setPid(0);
        station.insert();
    }

    @Override
    public void sAdd(StationEntity station) {
        station.insert();
    }

    @Override
    public void pEdit(StationEntity station) {
        this.baseMapper.updateById(station);
    }

    @Override
    public void sEdit(StationEntity course) {
        this.baseMapper.updateById(course);
    }

    @Override
    public void pDel(Long id) {
        StationEntity course = new StationEntity();
        course.deleteById(id);
        this.baseMapper.delByPId(id);
    }

    @Override
    public void sDel(Long id) {
        StationEntity course = new StationEntity();
        course.deleteById(id);
    }
}
