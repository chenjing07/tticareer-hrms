package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.util.MyMapper;

public interface LaborContractMapper extends MyMapper<LaborContract> {
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0"
			+ " order by id desc" )
	List<LaborContract> queryJoinEmployeeAndLaC(@Param("userName") String userName);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0 and a.employer_name like '%${employerName}%'"
			+ " order by id desc")
	List<LaborContract> queryJoinEmployeeAndLaCENAndUN(@Param("employerName") String employerName,@Param("userName") String userName);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0 and a.employer_name like '%${employerName}%' and a.create_time >= '${createTimeStart}'"
			+ " order by id desc" )
	List<LaborContract> queryJoinEmployeeAndLaCENAndUNAndTS(@Param("employerName") String employerName,@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0 and a.employer_name like '%${employerName}%' and a.create_time <= '${createTimeEnd}'"
			+ " order by id desc" )
	List<LaborContract> queryJoinEmployeeAndLaCENAndUNAndTE(@Param("employerName") String employerName,@Param("userName") String userName,
			@Param("createTimeEnd") String createTimeEnd);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0 and a.employer_name like '%${employerName}%' "
			+ " and a.create_time >= '${createTimeStart}' and a.create_time <= '${createTimeEnd}'"
			+ " order by id desc")
	List<LaborContract> queryJoinEmployeeAndLaCENAndUNAndTSE(@Param("employerName") String employerName,@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart,@Param("createTimeEnd") String createTimeEnd);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0  and a.create_time >= '${createTimeStart}'"
			+ " order by id desc")
	List<LaborContract> queryJoinEmployeeAndLaCUNAndTS(@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0  and a.create_time <= '${createTimeEnd}'"
			+ " order by id desc")
	List<LaborContract> queryJoinEmployeeAndLaCUNAndTE(@Param("userName") String userName,
			@Param("createTimeEnd") String createTimeEnd);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employer_name as 'employerName',a.employee_id as 'employeeId',a.contract_time_limit as 'contractTimeLimit',"
			+ " a.contract_start as 'contractStart',a.contract_end as 'contractEnd',a.work_content as 'workContent',"
			+ " a.work_place as 'workPlace',a.labor_protection as 'laborProtection',a.labor_conditions as 'laborConditions',"
			+ " a.labor_reward as 'laborReward',a.default_responsibility as 'defaultResponsibility',"
			+ " a.social_insurance as 'socialInsurance',a.contract_change as 'contractChange',"
			+ " a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM labor_contract a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )"
			+ " and a.state != 0  "
			+ " and a.create_time >= '${createTimeStart}' and a.create_time <= '${createTimeEnd}'"
			+ " order by id desc")
	List<LaborContract> queryJoinEmployeeAndLaCUNAndTSE(@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart,@Param("createTimeEnd") String createTimeEnd);
	
}