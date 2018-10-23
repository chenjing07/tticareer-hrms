package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.Interview;

public interface InterviewService {

	public void saveInterview(Interview interview);
	public void updateInterview(Interview interview);
	public void deleteInterview(Long id);
	public void deleteInterview(Long[] ids);
	public Interview queryInterviewById(Long id);
	public List<Interview> queryInterviewByState(Integer state,Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryInterviewByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryAllInterview(Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryInterviewWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryInterviewWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryInterviewWhoIsSecond(Integer pageNum,Integer pageSize,String orderBy);
	public List<Interview> queryInterviewWhoIsPass(Integer pageNum,Integer pageSize,String orderBy);
	/*
	 * 模糊查询
	*/
	public List<Interview> queryInterviewList(Integer state,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
}
