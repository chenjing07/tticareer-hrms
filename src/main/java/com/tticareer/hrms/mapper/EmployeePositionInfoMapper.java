package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.util.MyMapper;

public interface EmployeePositionInfoMapper extends MyMapper<EmployeePositionInfo> {
	
	@Select("SELECT  a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.position_id as 'positionId',a.arrive_post as 'arrivePost',"
			+ " a.leave_post as 'leavePost',a.transfer_reason as 'transferReason',a.leave_opinion as 'leaveOpinion',"
			+ " a.arrive_opinion as 'arriveOpinion',a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM employee_position_info a where employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0"
			+ " order by id desc" )
	List<EmployeePositionInfo> queryJoinEmployeeAndEmP(@Param("userName") String userName);
	
	@Select("SELECT  a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.position_id as 'positionId',a.arrive_post as 'arrivePost',"
			+ " a.leave_post as 'leavePost',a.transfer_reason as 'transferReason',a.leave_opinion as 'leaveOpinion',"
			+ " a.arrive_opinion as 'arriveOpinion',a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM employee_position_info a where a.employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 and a.create_time >= '${createTimeStart}'"
			+ " order by id desc " )
	List<EmployeePositionInfo> queryJoinEmployeeAndEmPTS(@Param("userName") String userName,
			 @Param("createTimeStart") String createTimeStart);
		
	@Select("SELECT  a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.position_id as 'positionId',a.arrive_post as 'arrivePost',"
			+ " a.leave_post as 'leavePost',a.transfer_reason as 'transferReason',a.leave_opinion as 'leaveOpinion',"
			+ " a.arrive_opinion as 'arriveOpinion',a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM employee_position_info a where a.employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 and a.create_time <= '${createTimeEnd}' "
			+ " order by id desc" )
	List<EmployeePositionInfo> queryJoinEmployeeAndEmPTE(@Param("userName") String userName,
			 @Param("createTimeEnd") String createTimeEnd);
	
	@Select("SELECT  a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.position_id as 'positionId',a.arrive_post as 'arrivePost',"
			+ " a.leave_post as 'leavePost',a.transfer_reason as 'transferReason',a.leave_opinion as 'leaveOpinion',"
			+ " a.arrive_opinion as 'arriveOpinion',a.state as 'state',a.create_time as 'createTime',"
			+ " a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM employee_position_info a where a.employee_id in(" 
			+ " SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 "
			+ " and a.create_time >= '${createTimeStart}' and a.create_time <= '${createTimeEnd}' "
			+ " order by id desc" )
	List<EmployeePositionInfo> queryJoinEmployeeAndEmPTSAndE(@Param("userName") String userName,
			 @Param("createTimeStart") String createTimeStart, @Param("createTimeEnd") String createTimeEnd);
}