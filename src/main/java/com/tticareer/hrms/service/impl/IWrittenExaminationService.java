package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.WrittenExaminationMapper;
import com.tticareer.hrms.pojo.WrittenExamination;
import com.tticareer.hrms.pojo.dto.WrittenExaminationDto;
import com.tticareer.hrms.service.WrittenExaminationService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IWrittenExaminationService implements WrittenExaminationService {

	@Autowired
	WrittenExaminationMapper writtenExaminationMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveWrittenExamination(WrittenExamination writtenExamination) {
		writtenExaminationMapper.insert(writtenExamination);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateWrittenExamination(WrittenExamination writtenExamination) {
		writtenExaminationMapper.updateByPrimaryKey(writtenExamination);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteWrittenExamination(Long id) {
		WrittenExamination writtenExamination = writtenExaminationMapper.selectByPrimaryKey(id);
		writtenExamination.setExamResult(0);
		writtenExaminationMapper.updateByPrimaryKey(writtenExamination);

	}

	@Override
	public void deleteWrittenExamination(Long[] ids) {
		for (Long id : ids) {
			WrittenExamination writtenExamination = writtenExaminationMapper.selectByPrimaryKey(id);
			writtenExamination.setExamResult(0);
			writtenExaminationMapper.updateByPrimaryKey(writtenExamination);
		}
	}

	@Override
	public WrittenExamination queryWrittenExaminationById(Long id) {
		return writtenExaminationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationByExamScore(Long examScore) {
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examScore", examScore);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryAllWrittenExamination() {
		return writtenExaminationMapper.selectAll();
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationWhoIsDelete() {
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examResult", 0);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationWhoIsPass() {
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("examResult", 1);
		return writtenExaminationMapper.selectByExample(example);
	}

	@Override
	public List<WrittenExamination> queryWrittenExaminationList(WrittenExaminationDto writtenExaminationDto) {
		Example example = new Example(WrittenExamination.class);
		Example.Criteria criteria = example.createCriteria();
		if(null!=writtenExaminationDto.getExamResult())
			criteria.andLike("examResult", "%" + writtenExaminationDto.getExamResult() + "%");
		if(null!=writtenExaminationDto.getCreateTimeStart())
			criteria.andGreaterThanOrEqualTo("createTime", writtenExaminationDto.getCreateTimeStart());
		if(null!=writtenExaminationDto.getCreateTimeEnd())
			criteria.andLessThanOrEqualTo("createTime", writtenExaminationDto.getCreateTimeEnd());
		criteria.andNotEqualTo("examResult", 0);
		return writtenExaminationMapper.selectByExample(example);
	}

}
