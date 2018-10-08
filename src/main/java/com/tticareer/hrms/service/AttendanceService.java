package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.OverWork;

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
	public OverWork queryOverWorkById(Long id);
	public List<OverWork> queryOverWorkByEmployeeId(Long employeeId);
	public List<OverWork> queryAllOverWork();
	public List<OverWork> queryOverWorkState(OverWork ow);
	public List<OverWork> queryOverWorkWhoIsNotDelete();
	public List<OverWork> queryOverWorkList(OverWork ow);
	
	public void saveLateEarly(LateEarly le);
	public void updateLateEarly(LateEarly le);
	public void deleteLateEarly(Long id);
	public void deleteLateEarlykList(Long[] ids);
	public LateEarly queryLateEarlyById(Long id);
	public List<LateEarly> queryLateEarlyByEmployeeId(Long employeeId);
	public List<LateEarly> queryAllLateEarly();
	public List<LateEarly> queryLateEarlyState(LateEarly le);
	public List<LateEarly> queryLateEarlyWhoIsNotDelete();
	public List<LateEarly> queryLateEarlyList(LateEarly le);
	
	public void saveClockDetail(ClockDetail cd);
	public void updateClockDetail(ClockDetail cd);
	public void deleteClockDetail(Long id);
	public void deleteClockDetailList(Long[] ids);
	public ClockDetail queryClockDetailById(Long id);
	public List<ClockDetail> queryClockDetailByEmployeeId(Long employeeId);
	public List<ClockDetail> queryAllClockDetail();
	public List<ClockDetail> queryClockDetailState(ClockDetail cd);
	public List<ClockDetail> queryClockDetailWhoIsNotDelete();
	public List<ClockDetail> queryClockDetailList(ClockDetail cd);
	
	public void saveLeaveDetail(LeaveDetail ld);
	public void updateLeaveDetail(LeaveDetail ld);
	public void deleteLeaveDetail(Long id);
	public void deleteLeaveDetailList(Long[] ids);
	public LeaveDetail queryLeaveDetailById(Long id);
	public List<LeaveDetail> queryLeaveDetailByEmployeeId(Long employeeId);
	public List<LeaveDetail> queryAllLeaveDetail();
	public List<LeaveDetail> queryLeaveDetailState(LeaveDetail ld);
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDelete();
	public List<LeaveDetail> queryLeaveDetailCheckStatus(LeaveDetail ld);
	public List<LeaveDetail> queryLeaveDetailAudited();
	public List<LeaveDetail> queryLeaveDetailList(LeaveDetail ld);
}
