package com.tticareer.hrms.service;

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
	public List<WrittenExaminationContent> queryAllWrittenExaminationContent();
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsDelete();
	public List<WrittenExaminationContent> queryWrittenExaminationContentWhoIsNotDelete();
	/*
	 * 模糊查询
	*/
	public List<WrittenExaminationContent> queryWrittenExaminationContentList(WrittenExaminationContent wec);
	
	/*
	 * 笔试试题详情
	 */
	public void saveExaminationQuestions(ExaminationQuestions examinationQuestions);
	public void updateExaminationQuestions(ExaminationQuestions examinationQuestions);
	public void deleteExaminationQuestions(Long id);
	public void deleteExaminationQuestions(Long[] ids);
	public ExaminationQuestions queryExaminationQuestionsById(Long id);
	public List<ExaminationQuestions> queryExaminationQuestionsByCategory(int category);
	public List<ExaminationQuestions> queryAllExaminationQuestions();
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsDelete();
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsUsing();
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsNotUsing();
	public List<ExaminationQuestions> queryExaminationQuestionsWhoIsWrong();
	/*
	 * 模糊查询
	*/
	public List<ExaminationQuestions> queryExaminationQuestionsListA(ExaminationQuestions examinationQuestions);
	public List<ExaminationQuestions> queryExaminationQuestionsListB(ExaminationQuestions examinationQuestions);
}
