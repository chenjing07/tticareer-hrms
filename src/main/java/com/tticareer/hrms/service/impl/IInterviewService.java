package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.InterviewMapper;
import com.tticareer.hrms.pojo.Interview;
import com.tticareer.hrms.pojo.dto.InterviewDto;
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
	public List<Interview> queryAllInterview() {
		return interviewMapper.selectAll();
	}

	@Override
	public List<Interview> queryInterviewWhoIsDelete() {
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewWhoIsSecond() {
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewWhoIsPass() {
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewList(InterviewDto interviewDto){
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=interviewDto.getState())
			criteria.andLike("state", "%" + interviewDto.getState() + "%");
		if(null!=interviewDto.getCreateTimeStart())
			criteria.andGreaterThanOrEqualTo("createTime", interviewDto.getCreateTimeStart());
		if(null!=interviewDto.getCreateTimeEnd())
			criteria.andLessThanOrEqualTo("createTime", interviewDto.getCreateTimeEnd());
		criteria.andNotEqualTo("state", 0);
		return interviewMapper.selectByExample(example);
	}
	
	@Override
	public List<Interview> queryInterviewListA(Interview interview) {
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("oneContent", "%" + interview.getOneContent() + "%");
		criteria.andNotEqualTo("state", 0);
		return interviewMapper.selectByExample(example);
	}

	@Override
	public List<Interview> queryInterviewListB(Interview interview) {
		Example example = new Example(Interview.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("twoContent", "%" + interview.getTwoContent() + "%");
		criteria.andNotEqualTo("state", 0);
		return interviewMapper.selectByExample(example);
	}

}
