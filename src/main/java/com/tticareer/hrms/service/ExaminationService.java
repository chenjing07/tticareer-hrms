package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.ExaminationQuestions;
import com.tticareer.hrms.pojo.WrittenExaminationContent;

public interface ExaminationService {

	/*
	 * 笔试内容
	 */
	public void saveWrittenExaminationContent(WrittenExaminationContent wec);
	public void updateWrittenExaminationContent(WrittenExaminationContent wec);
	public void deleteWrittenExaminationContent(Long id);
	public void deleteWrittenExaminationContent(Long[] ids);
	public WrittenExaminationContent queryWrittenExaminationContentById(Long id);
	public List<WrittenExaminationContent> queryAllWrittenExaminationContent(Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExaminationContent> queryWrittenExaminationContentByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExaminationContent> queryWrittenExaminationContentByState(Integer state,Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);
	/*
	 * 模糊查询
	*/
	public List<WrittenExaminationContent> queryWrittenExaminationContentList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	
	/*
	 * 笔试试题详情
	 */
	public void saveExaminationQuestions(ExaminationQuestions examinationQuestions);
	public void updateExaminationQuestions(ExaminationQuestions examinationQuestions);
	public void deleteExaminationQuestions(Long id);
	public void deleteExaminationQuestions(Long[] ids);
	public ExaminationQuestions queryExaminationQuestionsById(Long id);
	public List<ExaminationQuestions> queryExaminationQuestionsByCategory(Integer category,Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsByState(Integer state,Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryAllExaminationQuestions(Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotDeleteAndNotWrong(Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsUsing(Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotUsing(Integer pageNum,Integer pageSize,String orderBy);
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsWrong(Integer pageNum,Integer pageSize,String orderBy);
	/*
	 * 模糊查询
	*/
	public List<ExaminationQuestions> queryExaminationQuestionsList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	
}
