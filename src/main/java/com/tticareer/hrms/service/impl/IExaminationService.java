package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.ExaminationQuestionsMapper;
import com.tticareer.hrms.mapper.WrittenExaminationContentMapper;
import com.tticareer.hrms.pojo.ExaminationQuestions;
import com.tticareer.hrms.pojo.WrittenExaminationContent;
import com.tticareer.hrms.service.ExaminationService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IExaminationService implements ExaminationService {

	@Autowired
	WrittenExaminationContentMapper writtenExaminationContentMapper;
	
	@Autowired
	ExaminationQuestionsMapper examinationQuestionsMapper;
	
	/*
	 *笔试内容
	 */
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveWrittenExaminationContent(WrittenExaminationContent wec) {
		writtenExaminationContentMapper.insert(wec);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateWrittenExaminationContent(WrittenExaminationContent wec) {
		writtenExaminationContentMapper.updateByPrimaryKey(wec);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteWrittenExaminationContent(Long id) {
		WrittenExaminationContent wec = writtenExaminationContentMapper.selectByPrimaryKey(id);
		wec.setState(0);
		writtenExaminationContentMapper.updateByPrimaryKey(wec);

	}

	@Override
	public void deleteWrittenExaminationContent(Long[] ids) {
		for (Long id : ids) {
			WrittenExaminationContent wec = writtenExaminationContentMapper.selectByPrimaryKey(id);
			wec.setState(0);
			writtenExaminationContentMapper.updateByPrimaryKey(wec);
		}
	}

	@Override
	public WrittenExaminationContent queryWrittenExaminationContentById(Long id) {
		return writtenExaminationContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WrittenExaminationContent> queryAllWrittenExaminationContent(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return writtenExaminationContentMapper.selectAll();
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentByState(Integer state,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", state);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state", 0);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=state)
			criteria.andEqualTo("state", state);
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		return writtenExaminationContentMapper.selectByExample(example);
	}
	
	/*
	 *笔试试题详情
	 */
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveExaminationQuestions(ExaminationQuestions examinationQuestions) {
		examinationQuestionsMapper.insert(examinationQuestions);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateExaminationQuestions(ExaminationQuestions examinationQuestions) {
		examinationQuestionsMapper.updateByPrimaryKey(examinationQuestions);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteExaminationQuestions(Long id) {
		ExaminationQuestions examinationQuestions = examinationQuestionsMapper.selectByPrimaryKey(id);
		examinationQuestions.setState(0);
		examinationQuestionsMapper.updateByPrimaryKey(examinationQuestions);

	}

	@Override
	public void deleteExaminationQuestions(Long[] ids) {
		for (Long id : ids) {
			ExaminationQuestions examinationQuestions = examinationQuestionsMapper.selectByPrimaryKey(id);
			examinationQuestions.setState(0);
			examinationQuestionsMapper.updateByPrimaryKey(examinationQuestions);
		}
	}

	@Override
	public ExaminationQuestions queryExaminationQuestionsById(Long id) {
		return examinationQuestionsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsByCategory(Integer category,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("category", category);
		criteria.andNotEqualTo("state", 0);
		criteria.andNotEqualTo("state", -1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsByState(Integer state,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", state);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state", 0);
		criteria.andNotEqualTo("state", -1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryAllExaminationQuestions(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return examinationQuestionsMapper.selectAll();
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotDeleteAndNotWrong(Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		criteria.andNotEqualTo("state", -1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsUsing(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return examinationQuestionsMapper.selectByExample(example);
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotUsing(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsWrong(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", -1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=state)
			criteria.andEqualTo("state",state);
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		return examinationQuestionsMapper.selectByExample(example);
	}


}
