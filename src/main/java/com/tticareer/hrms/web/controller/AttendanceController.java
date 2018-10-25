package com.tticareer.hrms.web.controller;
/**
 * <p>CreateTime: 2018年10月10日 上午8:36:16 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: AttendanceController.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.ClockDetail;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.HolidayStatistics;
import com.tticareer.hrms.pojo.LateEarly;
import com.tticareer.hrms.pojo.LeaveDetail;
import com.tticareer.hrms.pojo.OverWork;
import com.tticareer.hrms.pojo.dto.ClockDetailDto;
import com.tticareer.hrms.pojo.dto.LateEarlyDto;
import com.tticareer.hrms.pojo.dto.LeaveDetailDto;
import com.tticareer.hrms.pojo.dto.OverWorkDto;
import com.tticareer.hrms.service.AttendanceService;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.util.ExtjsPageRequest;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	AttendanceService as;
	
	@Autowired
	EmployeeService es;
	
	/**
	 * <p>Title: saveOverWork</p>
	 * <p>Description: 
	 * 		1 加班信息录入
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 存在该加班信息
	 * 		-3 存在该加班信息但被删除
	 * </p>
	 * @param ow
	 * @param userName
	 * @return
	 */
	@PostMapping("/owsave")
	public JSONResult saveOverWork(OverWork ow, @Param("userName")String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				ow.setEmployeeId(emp.getId());
				OverWork o = as.queryOverWork(ow);
				if (o==null) {
					//test
					//ow.setTime(new Date());
					ow.setState(1);
					ow.setCreateTime(new Date());
					as.saveOverWork(ow);
					return JSONResult.ok(1);
				} else {
					if (o.getState()==0) {
						return JSONResult.ok(-3);
					} else {
						return JSONResult.ok(-2);
					}
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateOverWork</p>
	 * <p>Description: 
	 * 		1 加班信息修改成功
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 不存在该加班信息
	 * </p>
	 * @param ow
	 * @param userName
	 * @return
	 */
	@PostMapping("/owupdate")
	public JSONResult updateOverWork(OverWork ow, @Param("userName")String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				OverWork o = as.queryOverWorkById(ow.getId());
				if (o!=null && o.getState()!=0) {
					o.setEmployeeId(emp.getId());
					//test
					//o.setTime(new Date());
					o.setTime(ow.getTime());
					o.setDuration(ow.getDuration());
					o.setContent(ow.getContent());
					o.setNote(ow.getNote());
					as.updateOverWork(o);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: resetOverWork</p>
	 * <p>Description: 
	 * 		1 恢复数据（已删除的数据）
	 * 		0 不存在该数据或者该数据未被删除
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/owreset")
	public JSONResult resetOverWork(@Param("id")Long id) {
		OverWork ow = as.queryOverWorkById(id);
		if (ow!=null && ow.getState()==0) {
			ow.setState(1);
			as.updateOverWork(ow);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(1);
	}
	
	/**
	 * <p>Title: deleteOverWork</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/owdeletes")
	public JSONResult deleteOverWork(@Param("ids")Long[] ids) {
		as.deleteOverWorkList(ids);
		return JSONResult.ok(1);
	}
	
	
	@GetMapping("/owquery")
	public JSONResult queryOverWork(ExtjsPageRequest pageable,Integer page) {
		List<OverWorkDto> tis = as.selectOverWork(page);
		PageInfo<OverWorkDto> tiss = new PageInfo<>(tis);
		PageImpl<OverWorkDto> pages = new PageImpl<OverWorkDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: saveLateEarly</p>
	 * <p>Description: 
	 * 		1 迟到早退信息录入
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 存在该迟到早退信息
	 * 		-3 存在该迟到早退信息但被删除
	 * </p>
	 * @param le
	 * @param userName
	 * @return
	 */
	@PostMapping("/lesave")
	public JSONResult saveLateEarly(LateEarly le, @Param("userName") String userName, @Param("state")String state) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				le.setEmployeeId(emp.getId());
				LateEarly l = as.queryLateEarly(le);
				if (l==null) {
					//test
					//le.setLateEarlyTime(new Date());
					Integer state1 = Integer.parseInt(state);
					le.setState(state1);
					le.setCreateTime(new Date());
					as.saveLateEarly(le);
					return JSONResult.ok(1);
				} else {
					if (l.getState()==0) {
						return JSONResult.ok(-3);
					} else {
						return JSONResult.ok(-2);
					}
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateLateEarly</p>
	 * <p>Description: 
	 * 		1 迟到早退信息修改成功
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 不存在该迟到早退信息
	 * </p>
	 * @param le
	 * @param userName
	 * @return
	 */
	@PostMapping("/leupdate")
	public JSONResult updateLateEarly(LateEarly le, @Param("userName") String userName) {
		System.out.println(le.getState());
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				LateEarly l = as.queryLateEarlyById(le.getId());
				if (l!=null && l.getState()!=0) {
					l.setEmployeeId(emp.getId());
					l.setLateEarlyTime(le.getLateEarlyTime());
					l.setLateEarlyReason(le.getLateEarlyReason());
					l.setState(le.getState());
					l.setNote(le.getNote());
					as.updateLateEarly(l);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: deleteLateEarly</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/ledeletes")
	public JSONResult deleteLateEarly(@Param("ids")Long[] ids) {
		as.deleteLateEarlyList(ids);
		return JSONResult.ok(1);
	}
	
	@GetMapping("/lequery")
	public JSONResult queryLateEarly(ExtjsPageRequest pageable,Integer page) {
		List<LateEarlyDto> tis = as.selectLateEarly(page);
		for (LateEarlyDto ledto : tis) {
			if (ledto.getState().equals("1")) {
				ledto.setState("迟到");
			} else {
				ledto.setState("早退");
			}
		}
		PageInfo<LateEarlyDto> tiss = new PageInfo<>(tis);
		PageImpl<LateEarlyDto> pages = new PageImpl<LateEarlyDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: clockDetail</p>
	 * <p>Description: 
	 * 		2 存在该打卡信息打卡成功
	 * 		1 打卡信息录入
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 存在该打卡信息但被删除
	 * 		-3 瞎打卡
	 * </p>
	 * @param cd
	 * @param userName
	 * @return
	 */
	@PostMapping("/cd")
	public JSONResult clockDetail(ClockDetail cd, HttpSession session) {
		String userName = SessionUtil.getUserName(session);
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				cd.setEmployeeId(emp.getId());
				ClockDetail c = as.queryClockDetail(cd);
				if (c==null) {
					cd.setClockIn(new Date());
					cd.setNote("已签到");
					cd.setCreateTime(new Date());
					cd.setState(1);
					as.saveClockDetail(cd);
					return JSONResult.ok(1);
				} else {
					if (c.getState()==0) {
						return JSONResult.ok(-2);
					} else {
						if(c.getClockIn()!=null && c.getClockOut()==null) {
							c.setClockOut(new Date());
							c.setNote("已签退");
							as.updateClockDetail(c);
							return JSONResult.ok(2);
						}
						
						return JSONResult.ok(-3);
					}
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: deleteClockDetail</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param ids
	 * @return
	 */
	@DeleteMapping("/clear")
	public JSONResult clearClockDetail() {
		List<ClockDetail> cds = as.queryClockDetailWhoIsNotDelete();
		for (ClockDetail cd : cds) {
			as.deleteClockDetail(cd.getId());
		}
		return JSONResult.ok(1);
	}
	
	/**
	 * <p>Title: queryClockDetail</p>
	 * <p>Description: 查爆</p>
	 * @return
	 */
	@GetMapping("/cdqueryall")
	public JSONResult queryClockDetail() {
		return JSONResult.ok(as.queryAllClockDetail());
	}
	
	/**
	 * <p>Title: queryClockDetail</p>
	 * <p>Description: 查今天的打卡信息</p>
	 * @return
	 */
	@GetMapping("/cdquerytoday")
	public JSONResult queryClockDetailToday(ExtjsPageRequest pageable,Integer page) {
		List<ClockDetailDto> tis = as.selectClockDetail(page);
		PageInfo<ClockDetailDto> tiss = new PageInfo<>(tis);
		PageImpl<ClockDetailDto> pages = new PageImpl<ClockDetailDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: saveLeaveDetail</p>
	 * <p>Description: 
	 * 		1 请假信息录入
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 存在该请假信息
	 * </p>
	 * @param ld
	 * @param userName
	 * @return
	 */
	@PostMapping("/ldsave")
	public JSONResult saveLeaveDetail(LeaveDetail ld, @Param("userName")String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				ld.setEmployeeId(emp.getId());
				LeaveDetail l = as.queryLeaveDetail(ld);
				if (l==null) {
					ld.setCreateTime(new Date());
					ld.setState(1);
					ld.setCheckStatus(0);
					as.saveLeaveDetail(ld);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateLeaveDetail</p>
	 * <p>Description: 
	 * 		1 请假信息修改成功
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 不存在该请假信息
	 * </p>
	 * @param ld
	 * @param userName
	 * @return
	 */
	@PostMapping("/ldupdate")
	public JSONResult updateLeaveDetail(LeaveDetail ld, @Param("userName")String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				LeaveDetail l = as.queryLeaveDetailById(ld.getId());
				if (l!=null && l.getState()!=0) {
					l.setEmployeeId(emp.getId());
					l.setLeaveStart(ld.getLeaveStart());
					l.setLeaveEnd(ld.getLeaveEnd());
					l.setLeaveDays(ld.getLeaveDays());
					l.setReason(ld.getReason());
					l.setNote(ld.getNote());
					l.setCheckStatus(0);
					as.updateLeaveDetail(l);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: resetLeaveDetail</p>
	 * <p>Description: 
	 * 		1 恢复已删除请假信息
	 * 		0 请假信息未被删除或者不存在
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/ldreset")
	public JSONResult resetLeaveDetail(@Param("id")Long id) {
		LeaveDetail l = as.queryLeaveDetailById(id);
		if (l!=null && l.getState()==0) {
			l.setState(1);
			as.updateLeaveDetail(l);
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: checkLeaveDatil</p>
	 * <p>Description: 
	 * 		-1 审核不通过
	 * 		0 不存在该请假信息
	 * 		1 审核通过 请假成功
	 * </p>
	 * @param id
	 * @param result
	 * @return
	 */
	@PostMapping("/ldcheck")
	public JSONResult checkLeaveDatil(@Param("id")Long id, @Param("result")String result) {
		LeaveDetail l = as.queryLeaveDetailById(id);
		if (l!=null && l.getState()!=0) {
			if (result.equals("通过")) {
				l.setRealStart(l.getLeaveStart());
				l.setCheckStatus(1);
				as.updateLeaveDetail(l);
				return JSONResult.ok(1);
			} else {
				l.setState(0);
				as.updateLeaveDetail(l);
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: xiaoJia</p>
	 * <p>Description: 
	 * 		0 不存在该请假信息或被删除
	 * 		1 销假申请已提交
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/ldxiaojia")
	public JSONResult xiaoJia(HttpSession session) {
		String userName = SessionUtil.getUserName(session);
		Employee e = es.queryEmployeeByUserName(userName);
		LeaveDetail l = as.queryLeaveDetailXiao(e.getId());
		if (l!=null && l.getState()!=0) {
			l.setState(2);
			l.setCheckStatus(0);
			as.updateLeaveDetail(l);
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: checkXiaoJia</p>
	 * <p>Description: 
	 * 		-1 审核不通过
	 * 		0 不存在该请假信息
	 * 		1 审核通过 销假成功
	 * </p>
	 * @param id
	 * @param result
	 * @param realEnd
	 * @return
	 */
	@PostMapping("/ldcheckxiao")
	public JSONResult checkXiaoJia(@Param("id")Long id, @Param("result")String result) {
		LeaveDetail l = as.queryLeaveDetailById(id);
		if (l!=null && l.getState()!=0) {
			if (result.equals("通过")) {
				l.setRealEnd(l.getLeaveEnd());
				l.setState(3);
				l.setCheckStatus(1);
				as.updateLeaveDetail(l);
				HolidayStatistics hs = as.queryHolidayStatisticsByEmployeeId(l.getEmployeeId());
				hs.setTotalLeaveDays(hs.getTotalLeaveDays()+l.getLeaveDays());
				hs.setTotalHolidays(hs.getTotalHolidays()-l.getLeaveDays());
				as.updateHolidayStatistics(hs);
				return JSONResult.ok(1);
			} else {
				l.setState(0);
				as.updateLeaveDetail(l);
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: deleteLeaveDetail</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/lddeletes")
	public JSONResult deleteLeaveDetail(@Param("ids")Long[] ids) {
		as.deleteLeaveDetailList(ids);
		return JSONResult.ok(1);
	}
	
	
	@GetMapping("/ldquery")
	public JSONResult queryLeaveDetail(ExtjsPageRequest pageable,Integer page) {
		List<LeaveDetailDto> tis = as.selectLeaveDetail(page);
		for (LeaveDetailDto lddto : tis) {
			lddto.setCheckStatus("已审核");
			if (lddto.getState().equals("1")) {
				lddto.setState("激活");
			} else if (lddto.getState().equals("2")) {
				lddto.setState("销假申请");
			} else {
				lddto.setState("销假成功");
			}
		}
		PageInfo<LeaveDetailDto> tiss = new PageInfo<>(tis);
		PageImpl<LeaveDetailDto> pages = new PageImpl<LeaveDetailDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	
	@GetMapping("/ldcheckquery")
	public JSONResult queryLeaveDetailCheck(ExtjsPageRequest pageable,Integer page) {
		List<LeaveDetailDto> tis = as.selectLeaveDetailCheck(page);
		for (LeaveDetailDto lddto : tis) {
			lddto.setCheckStatus("待审核");
			if (lddto.getState().equals("1")) {
				lddto.setState("激活");
			} else if (lddto.getState().equals("2")) {
				lddto.setState("销假申请");
			} else {
				lddto.setState("销假成功");
			}
		}
		PageInfo<LeaveDetailDto> tiss = new PageInfo<>(tis);
		PageImpl<LeaveDetailDto> pages = new PageImpl<LeaveDetailDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: saveHolidayStatistics</p>
	 * <p>Description: 
	 * 		1 假期统计信息添加成功
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 已存在该员工的假期统计信息
	 * </p>
	 * @param hs
	 * @param userName
	 * @return
	 */
	@PostMapping("/hssave")
	public JSONResult saveHolidayStatistics(HolidayStatistics hs, @Param("userName") String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				HolidayStatistics h = as.queryHolidayStatisticsByEmployeeId(emp.getId());
				if (h==null) {
					hs.setEmployeeId(emp.getId());
					hs.setTotalLeaveDays(0);
					hs.setCreateTime(new Date());
					hs.setState(1);
					hs.setCheckStatus(0);
					as.saveHolidayStatistics(hs);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateHolidayStatistics</p>
	 * <p>Description: 
	 * 		1 假期信息添加成功
	 * 		0 不存在该员工或被删除
	 * 		-1 该员工未审核
	 * 		-2 不存在该假期信息
	 * 		-3 该假期信息为审核
	 * </p>
	 * @param hs
	 * @param userName
	 * @return
	 */
	@PutMapping("/hsupdate")
	public JSONResult updateHolidayStatistics(HolidayStatistics hs, @Param("userName") String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				HolidayStatistics h = as.queryHolidayStatisticsById(hs.getId());
				if (h!=null && h.getState()!=0) {
					if (h.getCheckStatus()!=0) {
						h.setEmployeeId(emp.getId());
						h.setTotalHolidays(hs.getTotalHolidays());
						h.setTotalLeaveDays(hs.getTotalLeaveDays());
						h.setNote(hs.getNote());
						as.updateHolidayStatistics(h);
						return JSONResult.ok(1);
					} else {
						return JSONResult.ok(-3);
					}
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: resetHolidayStatistics</p>
	 * <p>Description: 
	 * 		1 恢复已删除假期信息
	 * 		0 假期信息未被删除或者不存在
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/hsreset")
	public JSONResult resetHolidayStatistics(@Param("id")Long id) {
		HolidayStatistics hs = as.queryHolidayStatisticsById(id);
		if (hs!=null && hs.getState()==0) {
			hs.setState(1);
			as.updateHolidayStatistics(hs);
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: checkHolidayStatistics</p>
	 * <p>Description: 
	 * 		-1 审核不通过
	 * 		0 不存在该请假信息
	 * 		1 审核通过 请假成功
	 * </p>
	 * @param id
	 * @param result
	 * @return
	 */
	@PutMapping("/hscheck")
	public JSONResult checkHolidayStatistics(@Param("id")Long id, @Param("result")String result) {
		HolidayStatistics hs = as.queryHolidayStatisticsById(id);
		if (hs!=null && hs.getState()!=0) {
			if (result.equals("通过")) {
				hs.setCheckStatus(1);
				as.updateHolidayStatistics(hs);
				return JSONResult.ok(1);
			} else {
				hs.setState(0);
				as.updateHolidayStatistics(hs);
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: deleteHolidayStatistics</p>
	 * <p>Description: 
	 * 		0 删除失败
	 * 		1 删除成功
	 * </p>
	 * @param id
	 * @return
	 */
	@DeleteMapping("/hsdelete")
	public JSONResult deleteHolidayStatistics(@Param("id")Long id) {
		as.deleteHolidayStatistics(id);
		if (as.queryHolidayStatisticsById(id).getState()==0) {
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: queryHolidayStatistics</p>
	 * <p>Description: 
	 * 		（需要seesion）
	 * 		假的视图分权，如果用户为人事部管理或者超级管理员则显示全部已审核信息，如果是人事部员工则只显示未被删除已审核的信息
	 * </p>
	 * @param userName
	 * @return
	 */
	@GetMapping("/hsquery")
	public JSONResult queryHolidayStatistics(@Param("userName") String userName) {
		if (es.queryEmployeeByUserName(userName)!=null) {
			if (es.queryEmployeeByUserName(userName).getState()!=3) {
				return JSONResult.ok(as.queryHolidayStatisticsWhoIsNotDeleteAndCheckStatus());
			} else {
				return JSONResult.ok(as.queryHolidayStatisticsCheckStatus());
			}
		} else {
			if (userName.equals("admin")) {
				return JSONResult.ok(as.queryHolidayStatisticsCheckStatus());
			} else {
				return JSONResult.ok("这辈子都不会进入这里");
			}
		}
	}
	
	/**
	 * <p>Title: queryHolidayStatisticsCheck</p>
	 * <p>Description: 
	 * 		请假审核
	 * </p>
	 * @return
	 */
	@GetMapping("/hscheckquery")
	public JSONResult queryHolidayStatisticsCheck() {
		return JSONResult.ok(as.queryHolidayStatisticsWhoIsNotDeleteAndAudited());	
	}
}
