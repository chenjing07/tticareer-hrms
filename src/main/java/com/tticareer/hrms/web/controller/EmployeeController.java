package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.util.JSONResult;

/**
 * <p>CreateTime: 创建时间：2018年9月21日 下午3:56:23 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: EmployeeController.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: EmployeeController</p>
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * -1账号不存在
	 * 0密码错误
	 * 1员工登录成功
	 * 2管理员登录成功
	 * @param userName
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public JSONResult login(@Param("userName") String userName, @Param("password") String password) {
		if (userName.equals("admin") && password.equals("123456")) {
			return JSONResult.ok(2);
		} else {
			if (employeeService.queryEmployeeByUserName(userName)==null) {
				return JSONResult.ok(-1);
			} else {
				if (employeeService.queryEmployeeByUserName(userName).getPassword().equals(password)) {
					
					return JSONResult.ok(1);
				} else {
					return JSONResult.ok(0);
				}
			}
		}
	}
	
	/**
	 * 返回0  数据库中存在该工号
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param employee
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveEmployee(@RequestBody Employee employee) {
		//System.out.println(employee.getUserName());
		
		if (employeeService.queryEmployeeByUserName(employee.getUserName())!=null) {
			//System.out.println(employeeService.queryEmployeeByUserName("test").getId());
			return JSONResult.ok(0);
		} else {
			employeeService.saveEmployee(employee);
			Employee emp = employeeService.queryEmployeeByUserName(employee.getUserName());
			if (emp!=null) {
				String data = emp.getId()+"";
				return JSONResult.ok(data);
			} else {
				String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
			}
		}
	}
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllEmployee() {
		return JSONResult.ok(employeeService.queryAllEmployee());
	}
	
	/**
	 * 查询已被删除的员工
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryEmployeeWhoIsDelete() {
		return JSONResult.ok(employeeService.queryEmployeeWhoIsDelete());
	}
	
	/**
	 * 查询未被删除的员工
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryEmployeeWhoIsNotDelete() {
		return JSONResult.ok(employeeService.queryEmployeeWhoIsNotDelete());
	}
	
	/**
	 * 查询其他员工，非人事部的员工
	 * @return
	 */
	@GetMapping("/other")
	public JSONResult queryOtherEmployee() {
		return JSONResult.ok(employeeService.queryOtherEmployee());
	}
	
	/**
	 * 查询人事部的员工
	 * @return
	 */
	@GetMapping("/personnel")
	public JSONResult queryPersonnelEmployee() {
		return JSONResult.ok(employeeService.queryPersonnelEmployee());
	}
	
	/**
	 * 查询人事部经理
	 * @return
	 */
	@GetMapping("/manager")
	public JSONResult queryPersonnelManager() {
		return JSONResult.ok(employeeService.queryPersonnelManager());
	}
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 */
	@PutMapping
	public JSONResult updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
		Employee data = employeeService.queryEmployeeById(employee.getId());
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除员工，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public JSONResult deleteEmployee(@Param("id") Long id) {
		employeeService.deleteEmployee(id);
		if (employeeService.queryEmployeeById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
}
