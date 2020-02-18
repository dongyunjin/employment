package com.cn.employment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.employment.entity.TbCoach;
import com.cn.employment.entity.TbMembership;
import com.cn.employment.mapper.TbCoachMapper;
import com.cn.employment.mapper.TbMembershipMapper;
import com.cn.employment.service.ICoachService;
import com.cn.employment.util.BaseResult;

@Service
public class CoachServiceImpl implements ICoachService{

	@Autowired
	private TbCoachMapper tbCoachMapper;
	
	@Override
	public BaseResult<Boolean> deleteByPrimaryKey(Integer id) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbCoachMapper.deleteByPrimaryKey(id);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("教练信息删除成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("教练信息删除失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("教练信息删除失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public BaseResult<Boolean> insert(TbCoach record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbCoachMapper.insert(record);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("教练信息添加成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("教练信息添加失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("教练信息添加失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public TbCoach selectByPrimaryKey(Integer id) {
		TbCoach count = null;
		try {
			count = tbCoachMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<TbCoach> selectAll() {
		List<TbCoach> count = null;
		try {
			count = tbCoachMapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public BaseResult<Boolean> updateByPrimaryKey(TbCoach record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbCoachMapper.updateByPrimaryKey(record);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("会员信息修改成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("会员信息修改失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("会员信息修改失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}
}
