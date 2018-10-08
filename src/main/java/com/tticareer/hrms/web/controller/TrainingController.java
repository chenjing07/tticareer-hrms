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
	@PostMapping("/save")
	public JSONResult saveTrainingInfo(TrainingInfo ti, @Param("departmentNumber")String departmentNumber, @Param("userName")String userName) {
		if (ts.queryTrainingInfo(ti)==null) {
			if (departmentNumber!=null) {
				if (ds.queryDepartmentByDepartmentNumber(departmentNumber)!=null) {
					ti.setDepartmentId(ds.queryDepartmentByDepartmentNumber(departmentNumber).getId());
					
					//test
					ti.setLecturer("等死讲师1");
					ti.setTime(new Date());
					ti.setDuration(4+"");
					ti.setPurpose("如何等死1");
					ti.setNumber(50);
					ti.setCost(2000L);
					ti.setPlace("华为小机房");
					ti.setContent("等死讲师对等死的见解分享");
					ti.setNote("233");
					
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
					ti.setLecturer("等死讲师2");
					ti.setTime(new Date());
					ti.setDuration(4+"");
					ti.setPurpose("如何等死2");
					ti.setCost(2000L);
					ti.setPlace("华为小机房2");
					ti.setContent("等死讲师对等死的见解分享2");
					ti.setNote("666");
					
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
	 * 		1 修改成功
	 * 		0 修改失败，不存在该培训信息（或被删除）
	 * </p>
	 * @param ti
	 * @return
	 */
	@PutMapping
	public JSONResult updateTrainingInfo(TrainingInfo ti) {
		if (ts.queryTrainingInfoById(ti.getId())!=null && ts.queryTrainingInfoById(ti.getId()).getState()!=0) {
			ts.updateTrainingInfo(ti);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * 
	 * <p>Title: deleteTrainingInfo</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		2 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@DeleteMapping
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
	@GetMapping
	public JSONResult queryTrainingInfo(@Param("userName") String userName) {
		if (es.queryEmployeeByUserName(userName).getState()!=3 && !userName.equals("admin")) {
			return JSONResult.ok(ts.queryTrainingInfoWhoIsNotDelete());
		} 
		return JSONResult.ok(ts.queryAllTrainingInfo());
	}
	
}
