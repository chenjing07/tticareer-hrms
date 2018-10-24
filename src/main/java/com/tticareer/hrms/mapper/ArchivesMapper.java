package com.tticareer.hrms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tticareer.hrms.pojo.Archives;

import com.tticareer.hrms.util.MyMapper;

public interface ArchivesMapper extends MyMapper<Archives> {
	
	@Select("SELECT a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.in_time as 'inTime',a.out_time as 'outTime',"
			+ " a.archives_source as 'archivesSource',a.archives_destination as 'archivesDestination',a.archives_change as 'archivesChange',"
			+ " a.state as 'state',a.create_time as 'createTime', a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM archives a where "
			+ " a.employee_id in( SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0"
			+ " order by id desc" )
	List<Archives> queryJoinEmployeeAndArc(@Param("userName") String userName);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.in_time as 'inTime',a.out_time as 'outTime',"
			+ " a.archives_source as 'archivesSource',a.archives_destination as 'archivesDestination',a.archives_change as 'archivesChange',"
			+ " a.state as 'state',a.create_time as 'createTime', a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM archives a where "
			+ " a.employee_id in( SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 "
			+ " and a.create_time >= '${createTimeStart}' "
			+ " order by id desc" )
	List<Archives> queryJoinEmployeeAndArcTS(@Param("userName") String userName,
			 @Param("createTimeStart") String createTimeStart);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.in_time as 'inTime',a.out_time as 'outTime',"
			+ " a.archives_source as 'archivesSource',a.archives_destination as 'archivesDestination',a.archives_change as 'archivesChange',"
			+ " a.state as 'state',a.create_time as 'createTime', a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM archives a where "
			+ " a.employee_id in( SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 "
			+ " and a.create_time <= '${createTimeEnd}' "
			+ " order by id desc" )
	List<Archives> queryJoinEmployeeAndArcTE(@Param("userName") String userName,
			 @Param("createTimeStart") String createTimeEnd);
	
	@Select("SELECT a.id as 'id',"
			+ " a.employee_id as 'employeeId',a.in_time as 'inTime',a.out_time as 'outTime',"
			+ " a.archives_source as 'archivesSource',a.archives_destination as 'archivesDestination',a.archives_change as 'archivesChange',"
			+ " a.state as 'state',a.create_time as 'createTime', a.check_status as 'checkStatus',a.note as 'note' "
			+ " FROM archives a where "
			+ " a.employee_id in( SELECT id FROM employee where user_name like '%${userName}%' )and a.state != 0 "
			+ " and a.create_time >= '${createTimeStart}' and a.create_time <= '${createTimeEnd}' "
			+ " order by id desc" )
	List<Archives> queryJoinEmployeeAndArcTSAndE(@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart,@Param("createTimeStart") String createTimeEnd);
	
}