package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.OverWork;
import com.tticareer.hrms.pojo.dto.OverWorkDto;
import com.tticareer.hrms.util.MyMapper;

public interface OverWorkMapper extends MyMapper<OverWork> {
	@Select("select ow.*,ow.employee_id as employeeId, ow.create_time as `createTime`,e.user_name as userName,e.real_name as realName from (select * from over_work where state != 0) as ow left join employee e on ow.employee_id=e.id")
	List<OverWorkDto> selectOverWork();
}