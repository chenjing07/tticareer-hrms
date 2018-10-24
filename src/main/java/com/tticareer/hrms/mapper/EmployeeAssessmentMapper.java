package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.EmployeeAssessment;
import com.tticareer.hrms.pojo.dto.EmployeeAssessmentDto;
import com.tticareer.hrms.util.MyMapper;

public interface EmployeeAssessmentMapper extends MyMapper<EmployeeAssessment> {
	@Select("select ea.*,ea.assessment_type as assessmentType, ea.work_result as workResult,ea.assessment_result as assessmentResult, ea.check_status as checkStatus,ea.employee_id as employeeId, ea.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from employee_assessment where state != 0 and check_status != 0) as ea left join employee e on ea.employee_id=e.id")
	List<EmployeeAssessmentDto> selectEmployeeAssessment();
	
	@Select("select ea.*,ea.assessment_type as assessmentType, ea.work_result as workResult,ea.assessment_result as assessmentResult, ea.check_status as checkStatus,ea.employee_id as employeeId, ea.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from employee_assessment where check_status != 0) as ea left join employee e on ea.employee_id=e.id")
	List<EmployeeAssessmentDto> selectEmployeeAssessmentAll();
	
	@Select("select ea.*,ea.assessment_type as assessmentType, ea.work_result as workResult,ea.assessment_result as assessmentResult, ea.check_status as checkStatus,ea.employee_id as employeeId, ea.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from employee_assessment where state != 0 and check_status = 0) as ea left join employee e on ea.employee_id=e.id")
	List<EmployeeAssessmentDto> selectEmployeeAssessmentCheck();
	
	@Select("select ea.*,ea.assessment_type as assessmentType, ea.work_result as workResult,ea.assessment_result as assessmentResult, ea.check_status as checkStatus,ea.employee_id as employeeId, ea.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from employee_assessment where check_status = 0) as ea left join employee e on ea.employee_id=e.id")
	List<EmployeeAssessmentDto> selectEmployeeAssessmentCheckAll();
}