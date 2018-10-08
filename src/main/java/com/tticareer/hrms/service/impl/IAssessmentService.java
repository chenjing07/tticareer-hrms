package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tticareer.hrms.mapper.AssessmentStandardMapper;
import com.tticareer.hrms.mapper.EmployeeAssessmentMapper;
import com.tticareer.hrms.mapper.GreatTeamMapper;
import com.tticareer.hrms.pojo.AssessmentStandard;
import com.tticareer.hrms.pojo.EmployeeAssessment;
import com.tticareer.hrms.pojo.GreatTeam;
import com.tticareer.hrms.service.AssessmentService;

import tk.mybatis.mapper.entity.Example;

/**
 * <p>CreateTime: 2018年9月28日 上午8:45:25 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: IAssessmentService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
@Service
public class IAssessmentService implements AssessmentService {
	
	@Autowired
	AssessmentStandardMapper asMapper;
	
	@Autowired
	EmployeeAssessmentMapper eaMapper;
	
	@Autowired
	GreatTeamMapper gtMapper;
	
	@Override
	public void saveAssessmentStandard(AssessmentStandard as) {
		asMapper.insert(as);
	}

	@Override
	public void updateAssessmentStandard(AssessmentStandard as) {
		asMapper.updateByPrimaryKey(as);
	}

	@Override
	public void deleteAssessmentStandard(Long id) {
		AssessmentStandard as = asMapper.selectByPrimaryKey(id);
		as.setState(0);
		asMapper.updateByPrimaryKey(as);
	}

	@Override
	public void deleteAssessmentStandardList(Long[] ids) {
		for (Long id : ids) {
			AssessmentStandard as = asMapper.selectByPrimaryKey(id);
			as.setState(0);
			asMapper.updateByPrimaryKey(as);
		}
	}

	@Override
	public AssessmentStandard queryAssessmentStandardById(Long id) {
		return asMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AssessmentStandard> queryAssessmentStandardByPositionId(Long positionId) {
		Example example = new Example(AssessmentStandard.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("positionId", positionId);
		return asMapper.selectByExample(example);
	}

	@Override
	public List<AssessmentStandard> queryAllAssessmentStandard() {
		return asMapper.selectAll();
	}

	@Override
	public List<AssessmentStandard> queryAssessmentStandardState(AssessmentStandard as) {
		Example example = new Example(AssessmentStandard.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", as.getState());
		return asMapper.selectByExample(example);
	}
	
	@Override
	public List<AssessmentStandard> queryAssessmentStandardWhoIsNotDelete(){
		Example example = new Example(AssessmentStandard.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return asMapper.selectByExample(example);
	}

	@Override
	public List<AssessmentStandard> queryAssessmentStandardCheckStatus(AssessmentStandard as) {
		Example example = new Example(AssessmentStandard.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", as.getCheckStatus());
		return asMapper.selectByExample(example);
	}
	
	@Override
	public List<AssessmentStandard> queryAssessmentStandardAudited() {
		Example example = new Example(AssessmentStandard.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("checkStatus", 0);
		return asMapper.selectByExample(example);
	}

	@Override
	public List<AssessmentStandard> queryAssessmentStandardList(AssessmentStandard as) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployeeAssessment(EmployeeAssessment ea) {
		eaMapper.insert(ea);
	}

	@Override
	public void updateEmployeeAssessment(EmployeeAssessment ea) {
		eaMapper.updateByPrimaryKey(ea);
	}

	@Override
	public void deleteEmployeeAssessment(Long id) {
		EmployeeAssessment ea = eaMapper.selectByPrimaryKey(id);
		ea.setState(0);
		eaMapper.updateByPrimaryKey(ea);
	}

	@Override
	public void deleteEmployeeAssessmentList(Long[] ids) {
		for (Long id : ids) {
			EmployeeAssessment ea = eaMapper.selectByPrimaryKey(id);
			ea.setState(0);
			eaMapper.updateByPrimaryKey(ea);
		}
	}

	@Override
	public EmployeeAssessment queryEmployeeAssessmentById(Long id) {
		return eaMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentByEmployeeId(Long employeeId) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryAllEmployeeAssessment() {
		return eaMapper.selectAll();
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentState(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", ea.getState());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentWhoIsNotDelete(){
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentType(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("assessmentType", ea.getAssessmentType());
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResult(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("workResult", ea.getWorkResult());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultWhoIsNotFail() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("workResult", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitude(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("attitude", ea.getAttitude());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudeWhoIsNotFail() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("attitude", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentQuality(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("quality", ea.getQuality());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityWhoIsNotFail() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("quality", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentSkill(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("skill", ea.getSkill());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillWhoIsNotFail() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("skill", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResult(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("assessmentResult", ea.getAssessmentResult());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultWhoIsNotFail() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("assessmentResult", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentCheckStatus(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", ea.getCheckStatus());
		return eaMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentAudited() {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("checkStatus", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public List<EmployeeAssessment> queryEmployeeAssessmentList(EmployeeAssessment ea) {
		Example example = new Example(EmployeeAssessment.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("evaluate", "%" + ea.getEvaluate() + "%");
		criteria.andNotEqualTo("state", 0);
		return eaMapper.selectByExample(example);
	}

	@Override
	public void saveGreatTeam(GreatTeam gt) {
		gtMapper.insert(gt);
	}

	@Override
	public void updateGreatTeam(GreatTeam gt) {
		gtMapper.updateByPrimaryKey(gt);
	}

	@Override
	public void deleteGreatTeam(Long id) {
		GreatTeam gt = gtMapper.selectByPrimaryKey(id);
		gt.setState(0);
		gtMapper.updateByPrimaryKey(gt);
	}

	@Override
	public void deleteGreatTeamList(Long[] ids) {
		for (Long id : ids) {
			GreatTeam gt = gtMapper.selectByPrimaryKey(id);
			gt.setState(0);
			gtMapper.updateByPrimaryKey(gt);
		}
	}

	@Override
	public GreatTeam queryGreatTeamById(Long id) {
		return gtMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<GreatTeam> queryGreatTeamByDepartmentId(Long departmentId) {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("departmentId", departmentId);
		return gtMapper.selectByExample(example);
	}

	@Override
	public List<GreatTeam> queryAllGreatTeam() {
		return gtMapper.selectAll();
	}

	@Override
	public List<GreatTeam> queryGreatTeamState(GreatTeam gt) {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", gt.getState());
		return gtMapper.selectByExample(example);
	}
	
	@Override
	public List<GreatTeam> queryGreatTeamWhoIsNotDelete() {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return gtMapper.selectByExample(example);
	}

	@Override
	public List<GreatTeam> queryGreatTeamCheckStatus(GreatTeam gt) {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", gt.getCheckStatus());
		return gtMapper.selectByExample(example);
	}
	
	@Override
	public List<GreatTeam> queryGreatTeamAudited() {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("checkStatus", 0);
		return gtMapper.selectByExample(example);
	}

	@Override
	public List<GreatTeam> queryGreatTeamList(GreatTeam gt) {
		Example example = new Example(GreatTeam.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("commend", "%" + gt.getCommend() + "%");
		criteria.andNotEqualTo("state", 0);
		return gtMapper.selectByExample(example);
	}

	
}
