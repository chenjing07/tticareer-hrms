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
	public List<AssessmentStandard> queryAssessmentStandardWhoIsDelete();
	public List<AssessmentStandard> queryAssessmentStandardWhoIsNotDelete();
	public List<AssessmentStandard> queryAssessmentStandardWhoIsUse();
	public List<AssessmentStandard> queryAssessmentStandardToBeAudited();
	public List<AssessmentStandard> queryAssessmentStandardAuditPass();
	public List<AssessmentStandard> queryAssessmentStandardAuditFailed();
	public List<AssessmentStandard> queryAssessmentStandardList(AssessmentStandard as);
	
	public void saveEmployeeAssessment(EmployeeAssessment ea);
	public void updateEmployeeAssessment(EmployeeAssessment ea);
	public void deleteEmployeeAssessment(Long id);
	public void deleteEmployeeAssessmentList(Long[] ids);
	public EmployeeAssessment queryEmployeeAssessmentById(Long id);
	public List<EmployeeAssessment> queryEmployeeAssessmentByEmployeeId(Long employeeId);
	public List<EmployeeAssessment> queryAllEmployeeAssessment();
	public List<EmployeeAssessment> queryEmployeeAssessmentWhoIsDelete();
	public List<EmployeeAssessment> queryEmployeeAssessmentWhoIsNotDelete();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentTypeExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentTypeGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentTypePass();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentTypeFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultPass();
	public List<EmployeeAssessment> queryEmployeeAssessmentWorkResultFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudeExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudeGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudePass();
	public List<EmployeeAssessment> queryEmployeeAssessmentAttitudeFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityPass();
	public List<EmployeeAssessment> queryEmployeeAssessmentQualityFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillPass();
	public List<EmployeeAssessment> queryEmployeeAssessmentSkillFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultExcellent();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultGood();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultPass();
	public List<EmployeeAssessment> queryEmployeeAssessmentAssessmentResultFail();
	public List<EmployeeAssessment> queryEmployeeAssessmentAuditPass();
	public List<EmployeeAssessment> queryEmployeeAssessmentAuditFailed();
	public List<EmployeeAssessment> queryEmployeeAssessmentList(EmployeeAssessment ea);
	
	public void saveGreatTeam(GreatTeam gt);
	public void updateGreatTeam(GreatTeam gt);
	public void deleteGreatTeam(Long id);
	public void deleteGreatTeamList(Long[] ids);
	public GreatTeam queryGreatTeamById(Long id);
	public List<GreatTeam> queryGreatTeamByDepartmentId(Long departmentId);
	public List<GreatTeam> queryAllGreatTeam();
	public List<GreatTeam> queryGreatTeamWhoIsDelete();
	public List<GreatTeam> queryGreatTeamWhoIsNotDelete();
	public List<GreatTeam> queryGreatTeamToBeAudited();
	public List<GreatTeam> queryGreatTeamAuditPass();
	public List<GreatTeam> queryGreatTeamAuditFailed();
	public List<GreatTeam> queryGreatTeamList(GreatTeam gt);
}
