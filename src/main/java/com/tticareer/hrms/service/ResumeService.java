package com.tticareer.hrms.service;

import java.util.List;


import com.tticareer.hrms.pojo.Resume;
import com.tticareer.hrms.pojo.dto.ResumeDto;

public interface ResumeService {

	public void updateResume(Resume resume);
	public void deleteResume(Long id);
	public void deleteResume(Long[] ids);
	public Resume queryResumeById(Long id);
	public List<Resume> queryResumeByApplicationName(String applicationName);
	public List<Resume> queryAllResume();
	/*
	 * 按状态查询
	*/
	public List<Resume> queryResumeListWhoIsWaiting();
	public List<Resume> queryResumeListWhoIsPass();
	public List<Resume> queryResumeListWhoIsNotPass();
	/*
	* 模糊查询
	*/
	public List<Resume> queryResumeList(ResumeDto resumeDto);
	public List<Resume> queryResumeListA(String expectedPosition);
	public List<Resume> queryResumeListB(String expectedPosition);
	
}
