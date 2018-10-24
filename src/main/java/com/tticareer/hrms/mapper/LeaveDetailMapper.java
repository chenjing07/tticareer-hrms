package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.dto.LeaveDetailDto;
import com.tticareer.hrms.util.MyMapper;

public interface LeaveDetailMapper extends MyMapper<LeaveDetail> {
	@Select("select ld.*, ld.id, ld.leave_start as leaveStart,ld.leave_end as leaveEnd,ld.leave_days as leaveDays,ld.reason,ld.real_start as realStart,ld.real_end as realEnd,ld.state,ld.note,ld.check_status as checkStatus,ld.employee_id as employeeId, ld.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from leave_detail where state != 0 and check_status != 0) as ld left join employee e on ld.employee_id=e.id")
	List<LeaveDetailDto> selectLeaveDetail();
	
	@Select("select ld.*,ld.id,ld.leave_start as leaveStart,ld.leave_end as leaveEnd,ld.leave_days as leaveDays,ld.reason,ld.real_start as realStart,ld.real_end as realEnd,ld.state,ld.note,ld.check_status as checkStatus,ld.employee_id as employeeId, ld.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from leave_detail where check_status != 0) as ld left join employee e on ld.employee_id=e.id")
	List<LeaveDetailDto> selectLeaveDetailAll();
	
	@Select("select ld.*,ld.id,ld.leave_start as leaveStart,ld.leave_end as leaveEnd,ld.leave_days as leaveDays,ld.reason,ld.real_start as realStart,ld.real_end as realEnd,ld.state,ld.note,ld.check_status as checkStatus,ld.employee_id as employeeId, ld.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from leave_detail where state != 0 and check_status = 0) as ld left join employee e on ld.employee_id=e.id")
	List<LeaveDetailDto> selectLeaveDetailCheck();
	
	@Select("select ld.*,ld.id,ld.leave_start as leaveStart,ld.leave_end as leaveEnd,ld.leave_days as leaveDays,ld.reason,ld.real_start as realStart,ld.real_end as realEnd,ld.state,ld.note,ld.check_status as checkStatus,ld.employee_id as employeeId, ld.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from leave_detail where check_status = 0) as ld left join employee e on ld.employee_id=e.id")
	List<LeaveDetailDto> selectLeaveDetailCheckAll();
}