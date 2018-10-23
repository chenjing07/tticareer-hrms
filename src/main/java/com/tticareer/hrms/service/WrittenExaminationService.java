package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.WrittenExamination;

public interface WrittenExaminationService {

	public void saveWrittenExamination(WrittenExamination writtenExamination);
	public void updateWrittenExamination(WrittenExamination writtenExamination);
	public void deleteWrittenExamination(Long id);
	public void deleteWrittenExamination(Long[] ids);
	public WrittenExamination queryWrittenExaminationById(Long id);
	public List<WrittenExamination> queryWrittenExaminationByExamScore(Long examScore,Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExamination> queryWrittenExaminationByExamResult(Integer examResult,Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExamination> queryWrittenExaminationByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExamination> queryAllWrittenExamination(Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExamination> queryWrittenExaminationWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<WrittenExamination> queryWrittenExaminationWhoIsPass(Integer pageNum,Integer pageSize,String orderBy);
	/*
	 * 模糊查询
	*/
	public List<WrittenExamination> queryWrittenExaminationList(Integer examResult,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	
}
