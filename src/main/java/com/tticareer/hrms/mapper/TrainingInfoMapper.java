package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.TrainingInfo;
import com.tticareer.hrms.pojo.dto.DepartmentTrainingDto;
import com.tticareer.hrms.pojo.dto.EmployeeTrainingDto;
import com.tticareer.hrms.util.MyMapper;

public interface TrainingInfoMapper extends MyMapper<TrainingInfo> {
	
	@Select("select ti.*,ti.department_id as departmentId, ti.create_time as `createTime`,d.department_number as departmentNumber,d.department_name as departmentName from (select * from training_info where department_id is not null and state != 0) as ti left join department d on ti.department_id=d.id")
	List<DepartmentTrainingDto> selectDepartTraining();
	
	@Select("select ti.*,ti.employee_id as employeeId, ti.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from training_info where employee_id is not null and state != 0) as ti left join employee e on ti.employee_id=e.id")
	List<EmployeeTrainingDto> selectEmpTraining();
}