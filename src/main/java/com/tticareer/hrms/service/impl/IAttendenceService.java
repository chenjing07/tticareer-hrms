package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tticareer.hrms.mapper.ClockDetailMapper;
import com.tticareer.hrms.mapper.LateEarlyMapper;
import com.tticareer.hrms.mapper.LeaveDetailMapper;
import com.tticareer.hrms.mapper.OverWorkMapper;
import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.OverWork;
import com.tticareer.hrms.service.AttendanceService;

import tk.mybatis.mapper.entity.Example;

/**
 * <p>CreateTime: 2018年9月28日 上午8:44:38 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: IAttendenceService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class IAttendenceService implements AttendanceService {
	
	@Autowired
	OverWorkMapper owMapper;
	
	@Autowired
	LateEarlyMapper leMapper;
	
	@Autowired
	ClockDetailMapper cdMapper;
	
	@Autowired
	LeaveDetailMapper ldMapper;
	
	@Override
	public void saveOverWork(OverWork ow) {
		owMapper.insert(ow);
	}

	@Override
	public void updateOverWork(OverWork ow) {
		owMapper.updateByPrimaryKey(ow);
	}

	@Override
	public void deleteOverWork(Long id) {
		owMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteOverWorkList(Long[] ids) {
		for (Long id : ids) {
			OverWork ow = owMapper.selectByPrimaryKey(id);
			ow.setState(0);
			owMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public OverWork queryOverWorkById(Long id) {
		return owMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OverWork> queryOverWorkByEmployeeId(Long employeeId) {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return owMapper.selectByExample(example);
	}

	@Override
	public List<OverWork> queryAllOverWork() {
		return owMapper.selectAll();
	}

	@Override
	public List<OverWork> queryOverWorkWhoIsDelete() {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return owMapper.selectByExample(example);
	}

	@Override
	public List<OverWork> queryOverWorkWhoIsNotDelete() {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return owMapper.selectByExample(example);
	}

	@Override
	public List<OverWork> queryOverWorkWhoIsOverWork() {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return owMapper.selectByExample(example);
	}

	@Override
	public List<OverWork> queryOverWorkWhoIsNotOverWork() {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return owMapper.selectByExample(example);
	}

	@Override
	public List<OverWork> queryOverWorkList(OverWork ow) {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("content", "%" + ow.getContent() + "%");
		criteria.andNotEqualTo("state", 0);
		return owMapper.selectByExample(example);
	}

	@Override
	public void saveLateEarly(LateEarly le) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLateEarly(LateEarly le) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLateEarly(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLateEarlykList(Long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public LateEarly queryLateEarlyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryAllLateEarly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyWhoIsDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyWhoIsNotDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyLate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyEarly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LateEarly> queryLateEarlyList(LateEarly le) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClockDetail(ClockDetail cd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClockDetail(ClockDetail cd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClockDetail(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClockDetailList(Long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClockDetail queryClockDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryAllClockDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailWhoIsDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailWhoIsNotDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailNotAsUsual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailAsUsual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClockDetail> queryClockDetailList(ClockDetail cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLeaveDetail(LeaveDetail ld) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLeaveDetail(LeaveDetail ld) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLeaveDetail(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLeaveDetailList(Long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public LeaveDetail queryLeaveDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryAllLeaveDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailWhoIsDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailReadyLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailOnHoliday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailBackFromLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailToBeAudited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailAuditPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailAuditFailed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailList(LeaveDetail ld) {
		// TODO Auto-generated method stub
		return null;
	}

}
