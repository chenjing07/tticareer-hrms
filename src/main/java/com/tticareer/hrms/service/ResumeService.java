package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.Resume;

public interface ResumeService {

	public void saveResume(Resume resume);
	public void updateResume(Resume resume);
	public void deleteResume(Long id);
	public void deleteResume(Long[] ids);
	public Resume queryResumeById(Long id);
	public List<Resume> queryResumeByApplicationName(String applicationName,Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryResumeByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryAllResume(Integer pageNum,Integer pageSize,String orderBy);
	/*
	 * 按状态查询
	*/
	public List<Resume> queryResumeByState(Integer state,Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryResumeListWhoIsWaiting(Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryResumeListWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryResumeListWhoIsPass(Integer pageNum,Integer pageSize,String orderBy);
	public List<Resume> queryResumeListWhoIsNotPass(Integer pageNum,Integer pageSize,String orderBy);

	public List<Resume> queryResumeList(String applicationName,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	
}
