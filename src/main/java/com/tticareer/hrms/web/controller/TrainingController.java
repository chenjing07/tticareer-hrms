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
	 * 		-1 不存在该部门
	 * 		-2 不存在该员工
	 * 		0 已存在该培训信息
	 * 		1 录入部门培训信息
	 * 		2 录入高层培训信息
	 * </p>
	 * @param ti
	 * @param departmentNumber
	 * @param employeeNumber
	 * @return
	 */
	@PostMapping("/ti")
	public JSONResult saveTrainingInfo(TrainingInfo ti, @Param("departmentNumber")String departmentNumber, @Param("userName")String userName) {
		if (ts.queryTrainingInfo(ti)==null) {
			if (departmentNumber!=null) {
				if (ds.queryDepartmentByDepartmentNumber(departmentNumber)!=null) {
					ti.setDepartmentId(ds.queryDepartmentByDepartmentNumber(departmentNumber).getId());
					
					//test
					/*ti.setLecturer("等死讲师1");
					ti.setTime(new Date());
					ti.setDuration(4+"");
					ti.setPurpose("如何等死1");
					ti.setNumber(50);
					ti.setCost(2000L);
					ti.setPlace("华为小机房");
					ti.setContent("等死讲师对等死的见解分享");
					ti.setNote("233");*/
					
					ti.setEmployeeId(null);
					ti.setState(1);
					ti.setCreatetime(new Date());
					
					ts.saveTrainingInfo(ti);
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(-1);
				}
			} else {
				if (es.queryEmployeeByUserName(userName)!=null) {
					ti.setEmployeeId(es.queryEmployeeByUserName(userName).getId());
					
					//test
					/*ti.setLecturer("等死讲师2");
					ti.setTime(new Date());
					ti.setDuration(4+"");
					ti.setPurpose("如何等死2");
					ti.setCost(2000L);
					ti.setPlace("华为小机房2");
					ti.setContent("等死讲师对等死的见解分享2");
					ti.setNote("666");*/
					
					ti.setDepartmentId(null);
					ti.setNumber(null);
					ti.setState(1);
					ti.setCreatetime(new Date());
					
					ts.saveTrainingInfo(ti);
					return JSONResult.ok(2);
				} else {
					return JSONResult.ok(-2);
				}
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: updateTrainingInfo</p>
	 * <p>Description: 
	 * 		1/2 修改成功（1为部门培训信息修改，2为员工培训信息修改）
	 * 		0 修改失败，不存在该培训信息（或被删除）
	 * 		-1/-2 修改失败，不存在该部门或者该员工
	 * </p>
	 * @param ti
	 * @return
	 */
	@PutMapping("/ti")
	public JSONResult updateTrainingInfo(TrainingInfo ti) {
		System.out.println(ti.getId());
		if (ts.queryTrainingInfoById(ti.getId())!=null && ts.queryTrainingInfoById(ti.getId()).getState()!=0) {
			TrainingInfo t = ts.queryTrainingInfoById(ti.getId());
			if (t.getDepartmentId()!=null) {
				if (ds.queryDepartmentById(ti.getDepartmentId())==null) {
					return JSONResult.ok(-1);
				}
				t.setDepartmentId(ti.getDepartmentId());
				t.setLecturer(ti.getLecturer());
				
				//test
				t.setTime(new Date());
				
				t.setDuration(ti.getDuration());
				t.setPurpose(ti.getPurpose());
				t.setNumber(ti.getNumber());
				t.setCost(ti.getCost());
				t.setPlace(ti.getPlace());
				t.setContent(ti.getContent());
				t.setState(ti.getState());
				ts.updateTrainingInfo(t);
				return JSONResult.ok(1);
			} else {
				if (es.queryEmployeeById(ti.getEmployeeId())==null) {
					return JSONResult.ok(-2);
				}
				t.setEmployeeId(ti.getEmployeeId());
				t.setLecturer(ti.getLecturer());
				//test
				//t.setTime(new Date());
				t.setTime(ti.getTime());
				t.setDuration(ti.getDuration());
				t.setPurpose(ti.getPurpose());
				t.setCost(ti.getCost());
				t.setPlace(ti.getPlace());
				t.setContent(ti.getContent());
				t.setState(ti.getState());
				ts.updateTrainingInfo(t);
				return JSONResult.ok(2);
			}
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
	@DeleteMapping("/ti")
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
	 * 		视图分权，如果用户为人事部管理或者超级管理员则显示全部信息，如果是人事部员工则只显示未被删除的信息
	 * </p>
	 * @param userName
	 * @return
	 */
	@GetMapping("/ti")
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
	
	/*
	@PostMapping("/tf")
	public JSONResult saveTrainingFeedback(TrainingFeedback tf, @Param("userName")String userName) {
		Long employeeId = es.queryEmployeeByUserName(userName).getId();
		
		if (ts.queryTrainingInfoById(tf.getTrainingInfoId()).getDepartmentId()!=null) {
			
			//test
			tf.setEmployeeId(null);
			
			ts.saveTrainingFeedback(tf);
		} else if (ts.queryTrainingInfoById(tf.getTrainingInfoId()).getEmployeeId()!=null) {
			
		}
		
		return null;
	}*/
	
	
	
}
