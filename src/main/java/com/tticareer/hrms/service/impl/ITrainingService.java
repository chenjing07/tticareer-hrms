package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tticareer.hrms.mapper.TrainingFeedbackMapper;
import com.tticareer.hrms.mapper.TrainingInfoMapper;
import com.tticareer.hrms.pojo.TrainingFeedback;
import com.tticareer.hrms.pojo.TrainingInfo;
import com.tticareer.hrms.service.TrainingService;

import tk.mybatis.mapper.entity.Example;

/**
 * <p>CreateTime: 2018年9月26日 上午11:20:00 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: ITrainingService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
@Service
public class ITrainingService implements TrainingService {
	
	@Autowired
	TrainingInfoMapper tiMapper;
	
	@Autowired
	TrainingFeedbackMapper tfMapper;
	
	@Override
	public void saveTrainingInfo(TrainingInfo ti) {
		tiMapper.insert(ti);
	}

	@Override
	public void updateTrainingInfo(TrainingInfo ti) {
		tiMapper.updateByPrimaryKey(ti);
	}

	@Override
	public void deleteTrainingInfo(Long id) {
		TrainingInfo ti = tiMapper.selectByPrimaryKey(id);
		ti.setState(0);
		tiMapper.updateByPrimaryKey(ti);
	}

	@Override
	public void deleteTrainingInfoList(Long[] ids) {
		for (Long id : ids) {
			TrainingInfo ti = tiMapper.selectByPrimaryKey(id);
			ti.setState(0);
			tiMapper.updateByPrimaryKey(ti);
		}
	}

	@Override
	public TrainingInfo queryTrainingInfoById(Long id) {
		return tiMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoByDepartmentId(Long departmentId) {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("departimeId", departmentId);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoByEmployeeId(Long employeeId) {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoByLecturer(String lecturer) {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("lecturer", lecturer);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryAllTrainingInfo() {
		return tiMapper.selectAll();
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoWhoIsDelete() {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoWhoIsNotDelete() {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoWhoIsNotCarriedOut() {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoWhoIsCarriedOut() {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoWhoIsFinish() {
		Example example = new Example(TrainingInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 3);
		return tiMapper.selectByExample(example);
	}

	@Override
	public List<TrainingInfo> queryTrainingInfoList(TrainingInfo ti) {
		return null;
	}

	@Override
	public void saveTrainingFeedback(TrainingFeedback tf) {
		tfMapper.insert(tf);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback tf) {
		tfMapper.updateByPrimaryKey(tf);
	}

	@Override
	public void deleteTrainingFeedback(Long id) {
		TrainingFeedback tf = tfMapper.selectByPrimaryKey(id);
		tf.setState(0);
		tfMapper.updateByPrimaryKey(tf);
	}

	@Override
	public void deleteTrainingFeedbackList(Long[] ids) {
		for (Long id : ids) {
			TrainingFeedback tf = tfMapper.selectByPrimaryKey(id);
			tf.setState(0);
			tfMapper.updateByPrimaryKey(tf);
		}
	}

	@Override
	public TrainingFeedback queryTrainingFeedbackById(Long id) {
		return tfMapper.selectByPrimaryKey(id);
	}

	@Override
	public TrainingFeedback queryTrainingFeedbackByTrainingInfoId(Long id) {
		Example example = new Example(TrainingFeedback.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("trainingInfoId", id);
		return tfMapper.selectOneByExample(example);
	}

	@Override
	public List<TrainingFeedback> queryAllTrainingFeedback() {
		return tfMapper.selectAll();
	}

	@Override
	public List<TrainingFeedback> queryTrainingFeedbackWhoIsDelete() {
		Example example = new Example(TrainingFeedback.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return tfMapper.selectByExample(example);
	}

	@Override
	public List<TrainingFeedback> queryTrainingFeedbackWhoIsNotDelete() {
		Example example = new Example(TrainingFeedback.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return tfMapper.selectByExample(example);
	}

	@Override
	public List<TrainingFeedback> queryTrainingFeedbackList(TrainingFeedback tf) {
		return null;
	}

}
