package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.ClockDetailMapper;
import com.tticareer.hrms.mapper.HolidayStatisticsMapper;
import com.tticareer.hrms.mapper.LateEarlyMapper;
import com.tticareer.hrms.mapper.LeaveDetailMapper;
import com.tticareer.hrms.mapper.OverWorkMapper;
import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.HolidayStatistics;
import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.OverWork;
import com.tticareer.hrms.pojo.dto.ClockDetailDto;
import com.tticareer.hrms.pojo.dto.LateEarlyDto;
import com.tticareer.hrms.pojo.dto.LeaveDetailDto;
import com.tticareer.hrms.pojo.dto.OverWorkDto;
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
	
	@Autowired
	HolidayStatisticsMapper hsMapper;
	
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
		OverWork ow = owMapper.selectByPrimaryKey(id);
		ow.setState(0);
		owMapper.updateByPrimaryKey(ow);
	}

	@Override
	public void deleteOverWorkList(Long[] ids) {
		for (Long id : ids) {
			OverWork ow = owMapper.selectByPrimaryKey(id);
			ow.setState(0);
			owMapper.updateByPrimaryKey(ow);
		}
	}

	@Override
	public OverWork queryOverWorkById(Long id) {
		return owMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public OverWork queryOverWork(OverWork ow) {
		Example example = new Example(OverWork.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", ow.getEmployeeId());
		criteria.andEqualTo("time", ow.getTime());
		criteria.andEqualTo("duration", ow.getDuration());
		criteria.andEqualTo("content", ow.getContent());
		return owMapper.selectOneByExample(example);
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
		criteria.andEqualTo("employeeId", ow.getEmployeeId());
		criteria.andNotEqualTo("state", 0);
		return owMapper.selectByExample(example);
	}
	
	@Override
	public List<OverWorkDto> selectOverWork(Integer page) {
		PageHelper.startPage(page, 20);
		return owMapper.selectOverWork();
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
	public void deleteLateEarlyList(Long[] ids) {
		for (Long id : ids) {
			LateEarly le = leMapper.selectByPrimaryKey(id);
			le.setState(0);
			leMapper.updateByPrimaryKey(le);
		}
	}
	
	@Override
	public LateEarly queryLateEarly(LateEarly le) {
		Example example = new Example(LateEarly.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", le.getEmployeeId());
		criteria.andEqualTo("lateEarlyTime", le.getLateEarlyTime());
		criteria.andEqualTo("lateEarlyReason", le.getLateEarlyReason());
		criteria.andEqualTo("state", le.getState());
		return leMapper.selectOneByExample(example);
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
	public List<LateEarlyDto> selectLateEarly(Integer page){
		PageHelper.startPage(page, 20);
		return leMapper.selectLateEarly();
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
	public ClockDetail queryClockDetail(ClockDetail cd) {
		Example example = new Example(ClockDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", cd.getEmployeeId());
		criteria.andEqualTo("state", 1);
		return cdMapper.selectOneByExample(example);
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
	public List<ClockDetailDto> selectClockDetail(Integer page){
		PageHelper.startPage(page, 20);
		return cdMapper.selectClockDetail();
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
	public LeaveDetail queryLeaveDetail(LeaveDetail ld) {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", ld.getEmployeeId());
		criteria.andEqualTo("leaveStart", ld.getLeaveStart());
		criteria.andEqualTo("leaveEnd", ld.getLeaveEnd());
		criteria.andEqualTo("leaveDays", ld.getLeaveDays());
		criteria.andLike("reason", "%" + ld.getReason() + "%");
		return ldMapper.selectOneByExample(example);
	}
	
	@Override
	public LeaveDetail queryLeaveDetailById(Long id) {
		return ldMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public LeaveDetail queryLeaveDetailXiao(Long employeeId) {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		criteria.andEqualTo("state", 1);
		return ldMapper.selectOneByExample(example);
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
	public List<LeaveDetail> queryLeaveDetailCheckStatus() {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 1);
		return ldMapper.selectByExample(example);
	}

	@Override
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDeleteAndCheckStatus() {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		criteria.andEqualTo("checkStatus", 1);
		return ldMapper.selectByExample(example);
	}
	
	@Override
	public List<LeaveDetail> queryLeaveDetailWhoIsNotDeleteAndAudited() {
		Example example = new Example(LeaveDetail.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		criteria.andEqualTo("checkStatus", 0);
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
	
	@Override
	public List<LeaveDetailDto> selectLeaveDetail(Integer page){
		PageHelper.startPage(page, 20);
		return ldMapper.selectLeaveDetail();
	}
	
	@Override
	public List<LeaveDetailDto> selectLeaveDetailCheck(Integer page){
		PageHelper.startPage(page, 20);
		return ldMapper.selectLeaveDetailCheck();
	}

	@Override
	public void saveHolidayStatistics(HolidayStatistics hs) {
		hsMapper.insert(hs);
	}

	@Override
	public void updateHolidayStatistics(HolidayStatistics hs) {
		hsMapper.updateByPrimaryKey(hs);
	}

	@Override
	public void deleteHolidayStatistics(Long id) {
		HolidayStatistics hs = hsMapper.selectByPrimaryKey(id);
		hs.setState(0);
		hsMapper.updateByPrimaryKey(hs);
	}

	@Override
	public void deleteHolidayStatisticsList(Long[] ids) {
		for (Long id : ids) {
			HolidayStatistics hs = hsMapper.selectByPrimaryKey(id);
			hs.setState(0);
			hsMapper.updateByPrimaryKey(hs);
		}
	}

	@Override
	public HolidayStatistics queryHolidayStatisticsById(Long id) {
		return hsMapper.selectByPrimaryKey(id);
	}

	@Override
	public HolidayStatistics queryHolidayStatisticsByEmployeeId(Long employeeId) {
		Example example = new Example(HolidayStatistics.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return hsMapper.selectOneByExample(example);
	}

	@Override
	public List<HolidayStatistics> queryAllHolidayStatistics() {
		return hsMapper.selectAll();
	}
	
	@Override
	public List<HolidayStatistics> queryHolidayStatisticsCheckStatus() {
		Example example = new Example(HolidayStatistics.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 1);
		return hsMapper.selectByExample(example);
	}

	@Override
	public List<HolidayStatistics> queryHolidayStatisticsWhoIsNotDeleteAndCheckStatus() {
		Example example = new Example(HolidayStatistics.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		criteria.andEqualTo("checkStatus", 1);
		return hsMapper.selectByExample(example);
	}

	@Override
	public List<HolidayStatistics> queryHolidayStatisticsWhoIsNotDeleteAndAudited() {
		Example example = new Example(HolidayStatistics.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		criteria.andEqualTo("checkStatus", 0);
		return hsMapper.selectByExample(example);
	}

}
