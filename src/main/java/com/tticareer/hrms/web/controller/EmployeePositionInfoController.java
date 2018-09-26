package com.tticareer.hrms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.service.EmployeePositionInfoService;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月25日 上午11:36:23
*/
@RestController
@RequestMapping("/employeePositionInfo")
public class EmployeePositionInfoController {

	@Autowired
	EmployeePositionInfoService employeePositionInfoService;
	
	
	/**
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param employeePositionInfo
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveEmployeePositionInfo(EmployeePositionInfo employeePositionInfo) {
		System.out.print("-------------");
			employeePositionInfoService.saveEmployeePositionInfo(employeePositionInfo);
			EmployeePositionInfo emp = employeePositionInfoService.queryEmployeePositionInfoByEmployeeId(employeePositionInfo.getEmployeeId());
			if (emp!=null) {
				String data = emp.getId()+"";
				return JSONResult.ok(data);
			} else {
				String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
			}
		
	}
	
	
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllEmployeePositionInfo() {
		return JSONResult.ok(employeePositionInfoService.queryAllEmployeePositionInfo());
	}
	
	/**
	 * 查询已被删除的员工
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryEmployeePositionInfoWhoIsDelete() {
		return JSONResult.ok(employeePositionInfoService.queryEmployeePositionInfoWhoIsDelete());
	}
	
}
