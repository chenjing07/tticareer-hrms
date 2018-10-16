package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.WrittenExamination;

public interface WrittenExaminationService {

	public void saveWrittenExamination(WrittenExamination writtenExamination);
	public void updateWrittenExamination(WrittenExamination writtenExamination);
	public void deleteWrittenExamination(Long id);
	public void deleteWrittenExamination(Long[] ids);
	public WrittenExamination queryWrittenExaminationById(Long id);
	public List<WrittenExamination> queryWrittenExaminationByExamScore(Long examScore);
	public List<WrittenExamination> queryAllWrittenExamination();
	public List<WrittenExamination> queryWrittenExaminationWhoIsDelete();
	public List<WrittenExamination> queryWrittenExaminationWhoIsPass();
	/*
	 * 模糊查询
	*/
	public List<WrittenExamination> queryWrittenExaminationList(WrittenExamination writtenExamination);
}
