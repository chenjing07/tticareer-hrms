package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.AssessmentStandard;
import com.tticareer.hrms.pojo.dto.AssessmentStandardDto;
import com.tticareer.hrms.util.MyMapper;

public interface AssessmentStandardMapper extends MyMapper<AssessmentStandard> {
	@Select("select aa.*, aa.work_result as workResult,aa.calculation_way as calculationWay,aa.assessment_type as assessmentType,aa.result_level as resultLevel,aa.note,aa.check_status as checkStatus,aa.position_id as positionId, aa.create_time as `createTime`,p.position_number as positionNumber,p.position_name as positionName from (select * from assessment_standard where state != 0 and check_status != 0) as aa left join position p on aa.position_id=p.id")
	List<AssessmentStandardDto> selectAssessmentStandard();
	
	@Select("select aa.*, aa.work_result as workResult,aa.calculation_way as calculationWay,aa.assessment_type as assessmentType,aa.result_level as resultLevel,aa.note,aa.check_status as checkStatus,aa.position_id as positionId, aa.create_time as `createTime`,p.position_number as positionNumber,p.position_name as positionName from (select * from assessment_standard where check_status != 0) as aa left join position p on aa.position_id=p.id")
	List<AssessmentStandardDto> selectAssessmentStandardAll();
	
	@Select("select aa.*, aa.work_result as workResult,aa.calculation_way as calculationWay,aa.assessment_type as assessmentType,aa.result_level as resultLevel,aa.note,aa.check_status as checkStatus,aa.position_id as positionId, aa.create_time as `createTime`,p.position_number as positionNumber,p.position_name as positionName from (select * from assessment_standard where state != 0 and check_status = 0) as aa left join position p on aa.position_id=p.id")
	List<AssessmentStandardDto> selectAssessmentStandardCheck();
	
	@Select("select aa.*, aa.work_result as workResult,aa.calculation_way as calculationWay,aa.assessment_type as assessmentType,aa.result_level as resultLevel,aa.note,aa.check_status as checkStatus,aa.position_id as positionId, aa.create_time as `createTime`,p.position_number as positionNumber,p.position_name as positionName from (select * from assessment_standard where check_status = 0) as aa left join position p on aa.position_id=p.id")
	List<AssessmentStandardDto> selectAssessmentStandardCheckAll();
}