package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.dto.ClockDetailDto;
import com.tticareer.hrms.util.MyMapper;

public interface ClockDetailMapper extends MyMapper<ClockDetail> {
	
	@Select("select cd.*, cd.note, cd.clock_in as clockIn,cd.clock_out as clockOut,cd.employee_id as employeeId, cd.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from clock_detail where state != 0) as cd left join employee e on cd.employee_id=e.id")
	List<ClockDetailDto> selectClockDetail();
}