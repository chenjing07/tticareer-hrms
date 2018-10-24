package com.tticareer.hrms.web.controller;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Department;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.TrainingFeedback;
import com.tticareer.hrms.pojo.TrainingInfo;
import com.tticareer.hrms.service.DepartmentService;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.service.TrainingService;
import com.tticareer.hrms.util.JSONResult;

/**
 * <p>CreateTime: 2018年9月30日 上午11:15:22 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: TrainingController.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
@RestController
@RequestMapping("/training")
public class TrainingController {
	
	@Autowired
	TrainingService ts;
	
	@Autowired
	DepartmentService ds;
	
	@Autowired
	EmployeeService es;
	
	/**
	 * <p>Title: saveTrainingInfo</p>
	 * <p>Description: 
	 * 		-4 不存在该部门
	 * 		-3 不存在该员工
	 * 		-1/-2 已存在该培训信息
	 * 		0 输入错误
	 * 		1 员工培训信息录入成功
	 * 		2 部门培训信息录入成功
	 * </p>
	 * @param ti
	 * @param departmentNumber
	 * @param employeeNumber
	 * @return
	 */
	@PostMapping("/tisave")
	public JSONResult saveTrainingInfo(TrainingInfo ti, @Param("departmentNumber")String departmentNumber, @Param("userName")String userName) {
		if (userName!=null) {
			Employee e = es.queryEmployeeByUserName(userName);
			if (e!=null) {
				ti.setEmployeeId(e.getId());
				if (ts.queryTrainingInfo(ti)==null) {
					//test
					ti.setTime(new Date());
					ti.setState(1);
					ti.setCreatetime(new Date());
					ts.saveTrainingInfo(ti);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-1);
				}
			} else {
				return JSONResult.ok(-3);
			}
		} else if (departmentNumber!=null) {
			Department d = ds.queryDepartmentByDepartmentNumber(departmentNumber);
			if (d!=null) {
				ti.setDepartmentId(d.getId());
				if (ts.queryTrainingInfo(ti)==null) {
					//test
					ti.setTime(new Date());
					ti.setState(1);
					ti.setCreatetime(new Date());
					ts.saveTrainingInfo(ti);
					return JSONResult.ok(2);
				} else {
					return JSONResult.ok(-2);
				}
			} else {
				return JSONResult.ok(-4);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateTrainingInfo</p>
	 * <p>Description: 
	 * 		1/2 修改成功（1为部门培训信息修改，2为员工培训信息修改）
	 * 		0 修改失败，不存在该培训信息（或被删除）
	 * 		-1/-2 修改失败，不存在该部门或者该员工
	 * 		-3 输入错误
	 * </p>
	 * @param ti
	 * @return
	 */
	@PutMapping("/tiupdate")
	public JSONResult updateTrainingInfo(TrainingInfo ti, @Param("departmentNumber")String departmentNumber, @Param("userName")String userName) {
		TrainingInfo tii = ts.queryTrainingInfoById(ti.getId());
		if (tii!=null && tii.getState()!=0) {
			if (tii.getDepartmentId()!=null) {
				if (departmentNumber!=null) {
					if (ds.queryDepartmentByDepartmentNumber(departmentNumber)==null) {
						return JSONResult.ok(-1);
					}
					tii.setDepartmentId(ds.queryDepartmentByDepartmentNumber(departmentNumber).getId());
					tii.setLecturer(ti.getLecturer());
					//test
					tii.setTime(new Date());
					//tii.setTime(ti.getTime());
					tii.setDuration(ti.getDuration());
					tii.setPurpose(ti.getPurpose());
					tii.setNumber(ti.getNumber());
					tii.setCost(ti.getCost());
					tii.setPlace(ti.getPlace());
					tii.setContent(ti.getContent());
					tii.setNote(ti.getNote());
					ts.updateTrainingInfo(tii);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-3);
				}
			} else {
				if (userName!=null) {
					if (es.queryEmployeeByUserName(userName)==null) {
						return JSONResult.ok(-2);
					}
					tii.setEmployeeId(es.queryEmployeeByUserName(userName).getId());
					tii.setLecturer(ti.getLecturer());
					//test
					tii.setTime(new Date());
					//tii.setTime(ti.getTime());
					tii.setDuration(ti.getDuration());
					tii.setPurpose(ti.getPurpose());
					tii.setCost(ti.getCost());
					tii.setPlace(ti.getPlace());
					tii.setContent(ti.getContent());
					tii.setNote(ti.getNote());
					ts.updateTrainingInfo(tii);
					return JSONResult.ok(2);
				} else {
					return JSONResult.ok(-3);
				}
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: startTraining</p>
	 * <p>Description: 
	 * 		1 培训启动成功
	 * 		0培训正在进行
	 * 		-1不存在该培训或者被删除
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/tistart")
	public JSONResult startTraining(@Param("id") Long id) {
		TrainingInfo ti = ts.queryTrainingInfoById(id);
		if (ti!=null && ti.getState()!=0) {
			if (ti.getState()==1) {
				ti.setState(2);
				ts.updateTrainingInfo(ti);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(0);
			}
		}
		return JSONResult.ok(-1);
	}
	
	/**
	 * <p>Title: resetTraining</p>
	 * <p>Description: 
	 * 		0不存在该培训或者该培训未被删除
	 * 		1恢复该培训为未进行状态
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/tireset")
	public JSONResult resetTraining(@Param("id") Long id){
		TrainingInfo ti = ts.queryTrainingInfoById(id);
		if (ti!=null && ti.getState()==0) {
			ti.setState(1);
			ts.updateTrainingInfo(ti);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: deleteTrainingInfo</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		2 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@DeleteMapping("/tidelete")
	public JSONResult deleteTrainingInfo(@Param("id") Long id) {
		ts.deleteTrainingInfo(id);
		if (ts.queryTrainingInfoById(id).getState()==0) {
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: queryTrainingInfo</p>
	 * <p>Description: 
	 * 		假的视图分权，如果用户为人事部管理或者超级管理员则显示全部信息，如果是人事部员工则只显示未被删除的信息
	 * </p>
	 * @param userName
	 * @return
	 */
	@GetMapping("/tiget")
	public JSONResult queryTrainingInfo(@Param("userName") String userName) {
		if (es.queryEmployeeByUserName(userName)!=null) {
			if (es.queryEmployeeByUserName(userName).getState()!=3) {
				return JSONResult.ok(ts.queryTrainingInfoWhoIsNotDelete());
			} else {
				return JSONResult.ok(ts.queryAllTrainingInfo());
			}
		} else {
			if (userName.equals("admin")) {
				return JSONResult.ok(ts.queryAllTrainingInfo());
			} else {
				return JSONResult.ok("这辈子都不会进入这里");
			}
		}	
	}
	
	/**
	 * <p>Title: saveTrainingFeedback</p>
	 * <p>Description: 
	 * 		-1 该员工不属于该部门，添加失败
	 * 		-2 该培训信息为员工培训只能添加一条反馈信息，添加失败
	 * 		0 反馈信息中已有该员工的反馈信息，添加失败
	 * 		1 部门培训的员工反馈信息，添加成功
	 * 		2员工培训的员工反馈信息，添加成功
	 * </p>
	 * @param userName
	 * @param trainingFeedback
	 * @param trainingInfoId
	 * @param note
	 * @return
	 */
	@PostMapping("/tfsave")
	public JSONResult saveTrainingFeedback(@Param("userName")String userName, @Param("trainingFeedback")String trainingFeedback, @Param("trainingInfoId")Long trainingInfoId, @Param("note")String note) {
		Employee e = es.queryEmployeeByUserName(userName);
		TrainingFeedback tf = new TrainingFeedback();
		if (ts.queryTrainingFeedbackByEmployeeIdAndTrainingInfoId(e.getId(), trainingInfoId)!=null) {
			return JSONResult.ok(0);
		} else {
			if (ts.queryTrainingInfoById(trainingInfoId).getDepartmentId()!=null) {
				/*
				 * 判断员工是否属于这个部门
				if () {
					return JSONResult.ok(-1);
				}
				 */
				tf.setEmployeeId(e.getId());
				tf.setTrainingInfoId(trainingInfoId);
				tf.setTrainingFeedback(trainingFeedback);
				tf.setState(1);
				tf.setCreateTime(new Date());
				tf.setNote(note);
				ts.saveTrainingFeedback(tf);
				return JSONResult.ok(1);
			} else {
				if (ts.queryTrainingFeedbackByTrainingInfoId(trainingInfoId).size()!=0) {
					return JSONResult.ok(-2);
				} else {
					tf.setEmployeeId(e.getId());
					tf.setTrainingInfoId(trainingInfoId);
					tf.setTrainingFeedback(trainingFeedback);
					tf.setState(1);
					tf.setCreateTime(new Date());
					tf.setNote(note);
					ts.saveTrainingFeedback(tf);
					return JSONResult.ok(2);
				}
			}
		}
	}
	
	/**
	 * <p>Title: updateTrainingFeedback</p>
	 * <p>Description: 
	 * 		0 该反馈信息不存在或者被删除
	 * 		1 修改反馈信息成功
	 * </p>
	 * @param tf
	 * @return
	 */
	@PutMapping("/tfupdate")
	public JSONResult updateTrainingFeedback(TrainingFeedback tf, @Param("userName")String userName) {
		TrainingFeedback tff = ts.queryTrainingFeedbackById(tf.getId());
		if (tff!=null && tff.getState()!=0) {
			if (es.queryEmployeeByUserName(userName)==null) {
				return JSONResult.ok(-1);
			}
			tff.setEmployeeId(es.queryEmployeeByUserName(userName).getId());
			tff.setTrainingInfoId(tf.getTrainingInfoId());
			tff.setTrainingFeedback(tf.getTrainingFeedback());
			tff.setNote(tf.getNote());
			ts.updateTrainingFeedback(tff);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: resetFeedback</p>
	 * <p>Description: 
	 * 		0不存在该反馈或者该反馈未被删除
	 * 		1恢复该反馈为激活状态
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/tfreset")
	public JSONResult resetFeedback(@Param("id") Long id){
		TrainingFeedback tf = ts.queryTrainingFeedbackById(id);
		if (tf!=null && tf.getState()==0) {
			tf.setState(1);
			ts.updateTrainingFeedback(tf);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: deleteTrainingFeedback</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@DeleteMapping("/tfdelete")
	public JSONResult deleteTrainingFeedback(@Param("id") Long id) {
		ts.deleteTrainingFeedback(id);
		if (ts.queryTrainingFeedbackById(id).getState()==0) {
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: queryTrainingFeedback</p>
	 * <p>Description: 
	 * 		假的视图分权，如果用户为人事部管理或者超级管理员则显示全部信息，如果是人事部员工则只显示未被删除的信息
	 * </p>
	 * @param userName
	 * @return
	 */
	@GetMapping("/tfquery")
	public JSONResult queryTrainingFeedback(@Param("userName") String userName) {
		if (es.queryEmployeeByUserName(userName)!=null) {
			if (es.queryEmployeeByUserName(userName).getState()!=3) {
				return JSONResult.ok(ts.queryTrainingFeedbackWhoIsNotDelete());
			} else {
				return JSONResult.ok(ts.queryAllTrainingFeedback());
			}
		} else {
			if (userName.equals("admin")) {
				return JSONResult.ok(ts.queryAllTrainingFeedback());
			} else {
				return JSONResult.ok("这辈子都不会进入这里");
			}
		}
	}
}
