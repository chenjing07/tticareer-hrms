package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.dto.LateEarlyDto;
import com.tticareer.hrms.util.MyMapper;

public interface LateEarlyMapper extends MyMapper<LateEarly> {
	@Select("select le.*,le.late_early_time as lateEarlyTime, le.late_early_reason as lateEarlyReason,le.employee_id as employeeId, le.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from late_early where state != 0) as le left join employee e on le.employee_id=e.id")
	List<LateEarlyDto> selectLateEarly();
}