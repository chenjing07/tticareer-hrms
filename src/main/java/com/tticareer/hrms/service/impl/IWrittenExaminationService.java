package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.WrittenExaminationMapper;
import com.tticareer.hrms.pojo.WrittenExamination;
import com.tticareer.hrms.service.WrittenExaminationService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IWrittenExaminationService implements WrittenExaminationService {

	@Autowired
	WrittenExaminationMapper writtenExaminationMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveWrittenExamination(WrittenExamination writtenExamination) {
		writtenExaminationMapper.insert(writtenExamination);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateWrittenExamination(WrittenExamination writtenExamination) {
		writtenExaminationMapper.updateByPrimaryKey(writtenExamination);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteWrittenExamination(Long id) {
		WrittenExamination writtenExamination = writtenExaminationMapper.selectByPrimaryKey(id);
		writtenExamination.setExamResult(0);
		writtenExaminationMapper.updateByPrimaryKey(writtenExamination);

	}

	@Override
	public void deleteWrittenExamination(Long[] ids) {
		for (Long id : ids) {
			WrittenExamination writtenExamination = writtenExaminationMapper.selectByPrimaryKey(id);
			writtenExamination.setExamResult(0);
			writtenExaminationMapper.updateByPrimaryKey(writtenExamination);
		}
	}

	@Override
	public WrittenExamination queryWrittenExaminationById(Long id) {
		return writtenExaminationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationByExamScore(Long examScore,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examScore", examScore);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationByExamResult(Integer examResult,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("examResult", examResult);
		return writtenExaminationMapper.selectByExample(example);
	}
	
	@Override
	public List<WrittenExamination> queryWrittenExaminationByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("examResult", 0);
		return writtenExaminationMapper.selectByExample(example);
	}
	
	@Override
	public List<WrittenExamination> queryAllWrittenExamination(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return writtenExaminationMapper.selectAll();
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examResult", 0);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationWhoIsPass(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examResult", 1);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationList(Integer examResult,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=examResult)
			criteria.andEqualTo("examResult", examResult);
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("examResult", 0);
		return writtenExaminationMapper.selectByExample(example);
	}

}
