package com.tticareer.hrms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.service.EmployeePositionInfoService;
import com.tticareer.hrms.util.BeanUtils;
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
	public JSONResult saveEmployeePositionInfo(@RequestBody EmployeePositionInfo employeePositionInfo) {
		System.out.print(employeePositionInfo.getArriveOpinion());
			employeePositionInfoService.saveEmployeePositionInfo(employeePositionInfo);
			/*EmployeePositionInfo emp = employeePositionInfoService.queryEmployeePositionInfoByEmployeeId(employeePositionInfo.getEmployeeId());
			if (emp!=null) {
				String data = emp.getId()+"";
				return JSONResult.ok(data);
			} else {
				String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
			}*/
			return JSONResult.ok();
	}
	
	
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	@GetMapping
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
	
	
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeePositionInfo employee) {
		EmployeePositionInfo entity = employeePositionInfoService.queryEmployeePositionInfoById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			BeanUtils.copyProperties(employee, entity);//使用自定义的BeanUtils
			//employeeService.save(entity);
			employeePositionInfoService.updateEmployeePositionInfo(entity);
		}
		
		EmployeePositionInfo data = employeePositionInfoService.queryEmployeePositionInfoById(id);
		return JSONResult.ok(data);
	}
	
	@DeleteMapping(value="{id}")
	public  @ResponseBody JSONResult deleteEmployeePositionInfo(@PathVariable("id") Long id) {
		//System.out.println("-----"+id);
		employeePositionInfoService.deleteEmployeePositionInfo(id);
		if (employeePositionInfoService.queryEmployeePositionInfoById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
}
