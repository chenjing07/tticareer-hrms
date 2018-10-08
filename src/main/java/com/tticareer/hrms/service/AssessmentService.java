package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.AssessmentStandard;
import com.tticareer.hrms.pojo.EmployeeAssessment;
import com.tticareer.hrms.pojo.GreatTeam;

/**
 * <p>CreateTime: 2018年9月27日 下午8:39:47 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: AssessmentService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public interface AssessmentService {
	
	public void saveAssessmentStandard(AssessmentStandard as);
	public void updateAssessmentStandard(AssessmentStandard as);
	public void deleteAssessmentStandard(Long id);
	public void deleteAssessmentStandardList(Long[] ids);
	public AssessmentStandard queryAssessmentStandardById(Long id);
	public List<AssessmentStandard> queryAssessmentStandardByPositionId(Long positionId);
	public List<AssessmentStandard> queryAllAssessmentStandard();
	public List<AssessmentStandard> queryAssessmentStandardState(AssessmentStandard as);
	public List<AssessmentStandard> queryAssessmentStandardWhoIsNotDelete();
	public List<AssessmentStandard> queryAssessmentStandardCheckStatus(AssessmentStandard as);
	public List<AssessmentStandard> queryAssessmentStandardAudited();
	public List<AssessmentStandard> queryAssessmentStandardList(AssessmentStandard as);
	
	public void saveEmployeeAssessment(EmployeeAssessment ea);
	public void updateEmployeeAssessment(EmployeeAssessment ea);
	public void deleteEmployeeAssessment(Long id);
	public void deleteEmployeeAssessmentList(Long[] ids);
	public EmployeeAssessment queryEmployeeAssessmentById(Long id);
	public List<EmployeeAssessment> queryEmployeeAssessmentByEmployeeId(Long employeeId);
	public List<EmployeeAssessment> queryAllEmployeeAssessment();
	public List<EmployeeAssessment> queryEmployeeAssessmentState(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentWhoIsNotDelete();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentType(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResult(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultWhoIsNotFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitude(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudeWhoIsNotFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentQuality(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityWhoIsNotFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentSkill(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillWhoIsNotFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResult(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultWhoIsNotFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentCheckStatus(EmployeeAssessment ea);
	public List<EmployeeAssessment> queryEmployeeAssessmentAudited();
	public List<EmployeeAssessment> queryEmployeeAssessmentList(EmployeeAssessment ea);
	
	public void saveGreatTeam(GreatTeam gt);
	public void updateGreatTeam(GreatTeam gt);
	public void deleteGreatTeam(Long id);
	public void deleteGreatTeamList(Long[] ids);
	public GreatTeam queryGreatTeamById(Long id);
	public List<GreatTeam> queryGreatTeamByDepartmentId(Long departmentId);
	public List<GreatTeam> queryAllGreatTeam();
	public List<GreatTeam> queryGreatTeamState(GreatTeam gt);
	public List<GreatTeam> queryGreatTeamWhoIsNotDelete();
	public List<GreatTeam> queryGreatTeamCheckStatus(GreatTeam gt);
	public List<GreatTeam> queryGreatTeamAudited();
	public List<GreatTeam> queryGreatTeamList(GreatTeam gt);
}
