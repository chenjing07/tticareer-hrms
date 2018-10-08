package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tticareer.hrms.mapper.ClockDetailMapper;
import com.tticareer.hrms.mapper.LateEarlyMapper;
import com.tticareer.hrms.mapper.LeaveDetailMapper;
import com.tticareer.hrms.mapper.OverWorkMapper;
import com.tticareer.hrms.pojo.ClockDetail;
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
@Service
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
	public List<OverWork> queryOverWorkState(OverWork ow) {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", ow.getState());
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
	public List<OverWork> queryOverWorkList(OverWork ow) {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("content", "%" + ow.getContent() + "%");
		criteria.andNotEqualTo("state", 0);
		return owMapper.selectByExample(example);
	}

	@Override
	public void saveLateEarly(LateEarly le) {
		leMapper.insert(le);
	}

	@Override
	public void updateLateEarly(LateEarly le) {
		leMapper.updateByPrimaryKey(le);
	}

	@Override
	public void deleteLateEarly(Long id) {
		LateEarly le = leMapper.selectByPrimaryKey(id);
		le.setState(0);
		leMapper.updateByPrimaryKey(le);
	}

	@Override
	public void deleteLateEarlykList(Long[] ids) {
		for (Long id : ids) {
			LateEarly le = leMapper.selectByPrimaryKey(id);
			le.setState(0);
			leMapper.updateByPrimaryKey(le);
		}
	}

	@Override
	public LateEarly queryLateEarlyById(Long id) {
		return leMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LateEarly> queryLateEarlyByEmployeeId(Long employeeId) {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return leMapper.selectByExample(example);
	}

	@Override
	public List<LateEarly> queryAllLateEarly() {
		return leMapper.selectAll();
	}

	@Override
	public List<LateEarly> queryLateEarlyState(LateEarly le) {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", le.getState());
		return leMapper.selectByExample(example);
	}

	@Override
	public List<LateEarly> queryLateEarlyWhoIsNotDelete() {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return leMapper.selectByExample(example);
	}

	@Override
	public List<LateEarly> queryLateEarlyList(LateEarly le) {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("lateEarlyReason", "%" + le.getLateEarlyReason() + "%");
		criteria.andNotEqualTo("state", 0);
		return leMapper.selectByExample(example);
	}

	@Override
	public void saveClockDetail(ClockDetail cd) {
		cdMapper.insert(cd);
	}

	@Override
	public void updateClockDetail(ClockDetail cd) {
		cdMapper.updateByPrimaryKey(cd);
	}

	@Override
	public void deleteClockDetail(Long id) {
		ClockDetail cd = cdMapper.selectByPrimaryKey(id);
		cd.setState(0);
		cdMapper.updateByPrimaryKey(cd);
	}

	@Override
	public void deleteClockDetailList(Long[] ids) {
		for (Long id : ids) {
			ClockDetail cd = cdMapper.selectByPrimaryKey(id);
			cd.setState(0);
			cdMapper.updateByPrimaryKey(cd);
		}
	}

	@Override
	public ClockDetail queryClockDetailById(Long id) {
		return cdMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ClockDetail> queryClockDetailByEmployeeId(Long employeeId) {
		Example example = new Example(ClockDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return cdMapper.selectByExample(example);
	}

	@Override
	public List<ClockDetail> queryAllClockDetail() {
		return cdMapper.selectAll();
	}

	@Override
	public List<ClockDetail> queryClockDetailState(ClockDetail cd) {
		Example example = new Example(ClockDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", cd.getState());
		return cdMapper.selectByExample(example);
	}

	@Override
	public List<ClockDetail> queryClockDetailWhoIsNotDelete() {
		Example example = new Example(ClockDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return cdMapper.selectByExample(example);
	}
	
	@Override
	public List<ClockDetail> queryClockDetailList(ClockDetail cd){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLeaveDetail(LeaveDetail ld) {
		ldMapper.insert(ld);
	}

	@Override
	public void updateLeaveDetail(LeaveDetail ld) {
		ldMapper.updateByPrimaryKey(ld);
	}

	@Override
	public void deleteLeaveDetail(Long id) {
		LeaveDetail ld = ldMapper.selectByPrimaryKey(id);
		ld.setState(0);
		ldMapper.updateByPrimaryKey(ld);
	}

	@Override
	public void deleteLeaveDetailList(Long[] ids) {
		for (Long id : ids) {
			LeaveDetail ld = ldMapper.selectByPrimaryKey(id);
			ld.setState(0);
			ldMapper.updateByPrimaryKey(ld);
		}
	}

	@Override
	public LeaveDetail queryLeaveDetailById(Long id) {
		return ldMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailByEmployeeId(Long employeeId) {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return ldMapper.selectByExample(example);
	}

	@Override
	public List<LeaveDetail> queryAllLeaveDetail() {
		return ldMapper.selectAll();
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailState(LeaveDetail ld) {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", ld.getState());
		return ldMapper.selectByExample(example);
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDelete() {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return ldMapper.selectByExample(example);
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailCheckStatus(LeaveDetail ld) {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", ld.getCheckStatus());
		return ldMapper.selectByExample(example);
	}
	
	@Override
	public List<LeaveDetail> queryLeaveDetailAudited() {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("checkStatus", 0);
		return ldMapper.selectByExample(example);
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailList(LeaveDetail ld) {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("reason", "%" + ld.getReason() + "%");
		criteria.andNotEqualTo("state", 0);
		return ldMapper.selectByExample(example);
	}

}
