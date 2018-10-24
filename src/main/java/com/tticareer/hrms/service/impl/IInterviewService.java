package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.InterviewMapper;
import com.tticareer.hrms.pojo.Interview;
import com.tticareer.hrms.service.InterviewService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IInterviewService implements InterviewService {

	@Autowired
	InterviewMapper interviewMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveInterview(Interview interview) {
		interviewMapper.insert(interview);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateInterview(Interview interview) {
		interviewMapper.updateByPrimaryKey(interview);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteInterview(Long id) {
		Interview interview = interviewMapper.selectByPrimaryKey(id);
		interview.setState(0);
		interviewMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void deleteInterview(Long[] ids) {
		for (Long id : ids) {
			Interview interview = interviewMapper.selectByPrimaryKey(id);
			interview.setState(0);
			interviewMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public Interview queryInterviewById(Long id) {
		return interviewMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Interview> queryInterviewByState(Integer state,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();	
		criteria.andEqualTo("state",state);
		return interviewMapper.selectByExample(example);
	}
	
	@Override
	public List<Interview> queryInterviewByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();	
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state",0);
		return interviewMapper.selectByExample(example);
	}
	
	@Override
	public List<Interview> queryAllInterview(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return interviewMapper.selectAll();
	}

	@Override
	public List<Interview> queryInterviewWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();	
		criteria.andNotEqualTo("state",0);
		return interviewMapper.selectByExample(example);
	}

	
	@Override
	public List<Interview> queryInterviewWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewWhoIsSecond(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewWhoIsPass(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=state)
			criteria.andEqualTo("state",state);
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		return interviewMapper.selectByExample(example);
	}
	

}
