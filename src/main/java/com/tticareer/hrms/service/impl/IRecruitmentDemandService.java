package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.RecruitmentDemandMapper;
import com.tticareer.hrms.pojo.RecruitmentDemand;
import com.tticareer.hrms.service.RecruitmentDemandService;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class IRecruitmentDemandService implements RecruitmentDemandService {

	@Autowired
	RecruitmentDemandMapper rdMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveRecruitmentDemand(RecruitmentDemand rd) {
		rdMapper.insert(rd);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateRecruitmentDemand(RecruitmentDemand rd) {
		rdMapper.updateByPrimaryKey(rd);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteRecruitmentDemand(Long id) {
		RecruitmentDemand rd = rdMapper.selectByPrimaryKey(id);
		rd.setState(0);
		rdMapper.updateByPrimaryKey(rd);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteRecruitmentDemand(Long[] ids) {
		for (Long id : ids) {
			RecruitmentDemand rd = rdMapper.selectByPrimaryKey(id);
			rd.setState(0);
			rdMapper.updateByPrimaryKey(rd);
		}
	}

	@Override
	public RecruitmentDemand queryRecruitmentDemandById(Long id) {
		return rdMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandByPositionId(Long positionId,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=positionId)
			criteria.andLike("positionId", "%" + positionId + "%");
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}
	
	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}
	
	@Override
	public List<RecruitmentDemand> queryAllRecruitmentDemand(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return rdMapper.selectAll();
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandList(Long positionId,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=positionId)
			criteria.andLike("positionId", "%" + positionId + "%");
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime",createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

}
