package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.ResumeMapper;
import com.tticareer.hrms.pojo.Resume;
import com.tticareer.hrms.service.ResumeService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IResumeService implements ResumeService {

	@Autowired
	ResumeMapper resumeMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveResume(Resume resume) {
			resumeMapper.insert(resume);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateResume(Resume resume) {
		resumeMapper.updateByPrimaryKey(resume);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteResume(Long id) {
		Resume resume = resumeMapper.selectByPrimaryKey(id);
		resume.setState(0);
		resumeMapper.updateByPrimaryKey(resume);

	}

	@Override
	public void deleteResume(Long[] ids) {
		for (Long id : ids) {
			Resume resume = resumeMapper.selectByPrimaryKey(id);
			resume.setState(0);
			resumeMapper.updateByPrimaryKey(resume);
		}
	}

	@Override
	public Resume queryResumeById(Long id) {
		return resumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Resume> queryResumeByApplicationName(String applicationName,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("applicationName","%"+ applicationName+"%");
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryResumeByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state", 2);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryAllResume(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		return resumeMapper.selectAll();
	}

	@Override
	public List<Resume> queryResumeByState(Integer state,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", state);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeListWhoIsWaiting(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryResumeListWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state",2);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeListWhoIsPass(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state",1);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryResumeListWhoIsNotPass(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state",2);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeList(String applicationName,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy){
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=applicationName)
			criteria.andLike("applicationName", "%" + applicationName + "%");
		if(null!=createTimeStart)
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		if(null!=createTimeEnd)
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		criteria.andNotEqualTo("state",2);
		return resumeMapper.selectByExample(example);
	}
	
}
