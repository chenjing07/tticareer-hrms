package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.Interview;

public interface InterviewService {

	public void saveInterview(Interview interview);
	public void updateInterview(Interview interview);
	public void deleteInterview(Long id);
	public void deleteInterview(Long[] ids);
	public Interview queryInterviewById(Long id);
	public List<Interview> queryAllInterview();
	public List<Interview> queryInterviewWhoIsDelete();
	public List<Interview> queryInterviewWhoIsSecond();
	public List<Interview> queryInterviewWhoIsPass();
	/*
	 * 模糊查询
	*/
	public List<Interview> queryInterviewListA(Interview interview);
	public List<Interview> queryInterviewListB(Interview interview);
}
