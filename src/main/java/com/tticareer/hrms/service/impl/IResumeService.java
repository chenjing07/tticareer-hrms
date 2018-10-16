package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.ResumeMapper;
import com.tticareer.hrms.pojo.Resume;
import com.tticareer.hrms.pojo.dto.ResumeDto;
import com.tticareer.hrms.service.ResumeService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IResumeService implements ResumeService {

	@Autowired
	ResumeMapper resumeMapper;
	
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
	public List<Resume> queryResumeByApplicationName(String applicationName) {
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("applicationName", applicationName);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryAllResume() {
		return resumeMapper.selectAll();
	}

	@Override
	public List<Resume> queryResumeListWhoIsWaiting() {
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryResumeListWhoIsPass() {
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return resumeMapper.selectByExample(example);
	}

	@Override
	public List<Resume> queryResumeListWhoIsNotPass() {
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeList(ResumeDto resumeDto){
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=resumeDto.getApplicationName())
			criteria.andLike("applicationName", "%" + resumeDto.getApplicationName() + "%");
		if(null!=resumeDto.getCreateTimeStart())
			criteria.andGreaterThanOrEqualTo("createTime", resumeDto.getCreateTimeStart());
		if(null!=resumeDto.getCreateTimeEnd())
			criteria.andLessThanOrEqualTo("createTime", resumeDto.getCreateTimeEnd());
		criteria.andNotEqualTo("state", 2);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeListA(String expectedPosition){
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("expectedPosition", "%" + expectedPosition + "%");
		criteria.andEqualTo("state", 0);
		return resumeMapper.selectByExample(example);
	}
	
	@Override
	public List<Resume> queryResumeListB(String expectedPosition){
		Example example = new Example(Resume.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("expectedPosition", "%" + expectedPosition + "%");
		criteria.andEqualTo("state", 1);
		return resumeMapper.selectByExample(example);
	}
}
