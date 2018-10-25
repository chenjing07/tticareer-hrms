package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.HolidayStatistics;
import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.OverWork;
import com.tticareer.hrms.pojo.dto.ClockDetailDto;
import com.tticareer.hrms.pojo.dto.LateEarlyDto;
import com.tticareer.hrms.pojo.dto.LeaveDetailDto;
import com.tticareer.hrms.pojo.dto.OverWorkDto;

/**
 * <p>CreateTime: 2018年9月27日 下午7:36:05 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: AttendanceService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public interface AttendanceService {
	
	public void saveOverWork(OverWork ow);
	public void updateOverWork(OverWork ow);
	public void deleteOverWork(Long id);
	public void deleteOverWorkList(Long[] ids);
	public OverWork queryOverWork(OverWork ow);
	public OverWork queryOverWorkById(Long id);
	public List<OverWork> queryOverWorkByEmployeeId(Long employeeId);
	public List<OverWork> queryAllOverWork();
	public List<OverWork> queryOverWorkWhoIsNotDelete();
	public List<OverWork> queryOverWorkList(OverWork ow);
	public List<OverWorkDto> selectOverWork(Integer page);
	
	public void saveLateEarly(LateEarly le);
	public void updateLateEarly(LateEarly le);
	public void deleteLateEarly(Long id);
	public LateEarly queryLateEarly(LateEarly le);
	public void deleteLateEarlyList(Long[] ids);
	public LateEarly queryLateEarlyById(Long id);
	public List<LateEarly> queryLateEarlyByEmployeeId(Long employeeId);
	public List<LateEarly> queryAllLateEarly();
	public List<LateEarly> queryLateEarlyWhoIsNotDelete();
	public List<LateEarly> queryLateEarlyList(LateEarly le);
	public List<LateEarlyDto> selectLateEarly(Integer page);
	
	public void saveClockDetail(ClockDetail cd);
	public void updateClockDetail(ClockDetail cd);
	public void deleteClockDetail(Long id);
	public void deleteClockDetailList(Long[] ids);
	public ClockDetail queryClockDetail(ClockDetail cd);
	public ClockDetail queryClockDetailById(Long id);
	public List<ClockDetail> queryClockDetailByEmployeeId(Long employeeId);
	public List<ClockDetail> queryAllClockDetail();
	public List<ClockDetail> queryClockDetailWhoIsNotDelete();
	public List<ClockDetail> queryClockDetailList(ClockDetail cd);
	public List<ClockDetailDto> selectClockDetail(Integer page);
	
	public void saveLeaveDetail(LeaveDetail ld);
	public void updateLeaveDetail(LeaveDetail ld);
	public void deleteLeaveDetail(Long id);
	public void deleteLeaveDetailList(Long[] ids);
	public LeaveDetail queryLeaveDetail(LeaveDetail ld);
	public LeaveDetail queryLeaveDetailById(Long id);
	public LeaveDetail queryLeaveDetailXiao(Long employeeId);
	public List<LeaveDetail> queryLeaveDetailByEmployeeId(Long employeeId);
	public List<LeaveDetail> queryAllLeaveDetail();
	public List<LeaveDetail> queryLeaveDetailCheckStatus();
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDeleteAndCheckStatus();
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDeleteAndAudited();
	public List<LeaveDetail> queryLeaveDetailList(LeaveDetail ld);
	public List<LeaveDetailDto> selectLeaveDetail(Integer page);
	public List<LeaveDetailDto> selectLeaveDetailCheck(Integer page);
	
	public void saveHolidayStatistics(HolidayStatistics hs);
	public void updateHolidayStatistics(HolidayStatistics hs);
	public void deleteHolidayStatistics(Long id);
	public void deleteHolidayStatisticsList(Long[] ids);
	public HolidayStatistics queryHolidayStatisticsById(Long id);
	public HolidayStatistics queryHolidayStatisticsByEmployeeId(Long employeeId);
	public List<HolidayStatistics> queryAllHolidayStatistics();
	public List<HolidayStatistics> queryHolidayStatisticsCheckStatus();
	public List<HolidayStatistics> queryHolidayStatisticsWhoIsNotDeleteAndCheckStatus();
	public List<HolidayStatistics> queryHolidayStatisticsWhoIsNotDeleteAndAudited();
	
}
