package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.ExaminationQuestionsMapper;
import com.tticareer.hrms.mapper.WrittenExaminationContentMapper;
import com.tticareer.hrms.pojo.ExaminationQuestions;
import com.tticareer.hrms.pojo.WrittenExaminationContent;
import com.tticareer.hrms.pojo.dto.ExaminationQuestionsDto;
import com.tticareer.hrms.pojo.dto.WrittenExaminationContentDto;
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
	public List<WrittenExaminationContent> queryAllWrittenExaminationContent() {
		return writtenExaminationContentMapper.selectAll();
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsDelete() {
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsNotDelete() {
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return writtenExaminationContentMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExaminationContent> queryWrittenExaminationContentList(WrittenExaminationContentDto wecDto) {
		Example example = new Example(WrittenExaminationContent.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=wecDto.getState())
			criteria.andLike("state", "%" + wecDto.getState() + "%");
		if(null!=wecDto.getCreateTimeStart())
			criteria.andGreaterThanOrEqualTo("createTime", wecDto.getCreateTimeStart());
		if(null!=wecDto.getCreateTimeEnd())
			criteria.andLessThanOrEqualTo("createTime", wecDto.getCreateTimeEnd());
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
	public List<ExaminationQuestions> queryExaminationQuestionsByCategory(int category){
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("category", category);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryAllExaminationQuestions() {
		return examinationQuestionsMapper.selectAll();
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsDelete() {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return examinationQuestionsMapper.selectByExample(example);
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsUsing() {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return examinationQuestionsMapper.selectByExample(example);
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotUsing() {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsWrong() {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", -1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsList(ExaminationQuestionsDto examinationQuestionsDto){
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=examinationQuestionsDto.getState())
			criteria.andLike("state", "%" + examinationQuestionsDto.getState() + "%");
		if(null!=examinationQuestionsDto.getCategory())
			criteria.andLike("category", "%" + examinationQuestionsDto.getCategory() + "%");
		if(null!=examinationQuestionsDto.getCreateTimeStart())
			criteria.andGreaterThanOrEqualTo("createTime", examinationQuestionsDto.getCreateTimeStart());
		if(null!=examinationQuestionsDto.getCreateTimeEnd())
			criteria.andLessThanOrEqualTo("createTime", examinationQuestionsDto.getCreateTimeEnd());
		criteria.andNotEqualTo("state", 0);
		return examinationQuestionsMapper.selectByExample(example);
	}

	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsListA(ExaminationQuestions examinationQuestions) {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("question", "%" + examinationQuestions.getQuestion() + "%");
		criteria.andEqualTo("state", 1);
		return examinationQuestionsMapper.selectByExample(example);
	}
	
	@Override
	public List<ExaminationQuestions> queryExaminationQuestionsListB(ExaminationQuestions examinationQuestions) {
		Example example = new Example(ExaminationQuestions.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("question", "%" + examinationQuestions.getQuestion() + "%");
		criteria.andEqualTo("state", 2);
		return examinationQuestionsMapper.selectByExample(example);
	}

}
