package com.cn.employment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.employment.entity.TbMembership;
import com.cn.employment.mapper.TbMembershipMapper;
import com.cn.employment.service.IMemberService;
import com.cn.employment.util.BaseResult;

@Service
public class MemberServiceImpl implements IMemberService{

	@Autowired
	private TbMembershipMapper tbMembershipMapper;
	
	@Override
	public BaseResult<Boolean> deleteByPrimaryKey(Integer id) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbMembershipMapper.deleteByPrimaryKey(id);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("会员信息删除成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("会员信息删除失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("会员信息删除失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public BaseResult<Boolean> insert(TbMembership record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbMembershipMapper.insert(record);
			if(count>0) {
				baseResult.setSuccess(true);
				baseResult.setErrMsg("会员信息添加成功");
			}else {
				baseResult.setSuccess(false);
				baseResult.setErrMsg("会员信息添加失败");
			}
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setErrMsg("会员信息添加失败");
			e.printStackTrace();
		}
		
		return baseResult;
	}

	@Override
	public TbMembership selectByPrimaryKey(Integer id) {
		TbMembership count = null;
		try {
			count = tbMembershipMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<TbMembership> selectAll() {
		List<TbMembership> count = null;
		try {
			count = tbMembershipMapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public BaseResult<Boolean> updateByPrimaryKey(TbMembership record) {
		BaseResult<Boolean> baseResult = new BaseResult<>();
		try {
			int count = tbMembershipMapper.updateByPrimaryKey(record);
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
