package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Department;
import com.tticareer.hrms.service.DepartmentService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月26日 上午10:30:00
*/
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	
	
	/**

	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param department
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveDepartment(@RequestBody Department department) {
		departmentService.saveDepartment(department);
		/*Department emp = departmentService.queryDepartmentById(department.getId());
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
	 * 查询所有部门信息
	 * @return
	 */
	@GetMapping
	/*public JSONResult queryRealAllDepartment() {
		return JSONResult.ok(departmentService.queryAllDepartment());
	}*/
	public JSONResult getPage(@Param("departmentNumber") String departmentNumber,@Param("departmentName") String departmentName) 
	{
		//System.out.println(userName + "********" +realName);
		
		if(departmentNumber!=null && departmentName==null) {
			//System.out.println(userName);
			return JSONResult.ok(departmentService.queryDepartmentListByDepartmentNumber(departmentNumber));
		}else if(departmentNumber==null && departmentName!=null) {
			return JSONResult.ok(departmentService.queryDepartmentListByDepartmentName(departmentName));
		}else if(departmentNumber!=null && departmentName!=null) {
			//System.out.println(userName + "&&&&&&" +realName);
			return JSONResult.ok(departmentService.queryDepartmentListByDepartmentNumberAndDepartmentName(departmentNumber,departmentName));
		}
		else {
			return JSONResult.ok(departmentService.queryAllDepartment());
		}
		
	}
	
	/**
	 * 查询已被删除的部门
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryDepartmentWhoIsDelete() {
		return JSONResult.ok(departmentService.queryDepartmentWhoIsDelete());
	}
	
	/**
	 * 查询未被删除的部门
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryDepartmentWhoIsNotDelete() {
		return JSONResult.ok(departmentService.queryDepartmentWhoIsNotDelete());
	}
	
	
	
	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateDepartment(@PathVariable("id") Long id,@RequestBody Department department) {
		Department entity = departmentService.queryDepartmentById(id);
		if(entity!=null) {
			BeanUtils.copyProperties(department, entity);//使用自定义的BeanUtils
			//leaveService.save(entity);
			departmentService.updateDepartment(entity);
		}
		
		Department data = departmentService.queryDepartmentById(id);
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除部门，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public @ResponseBody JSONResult deleteDepartment(@PathVariable("id") Long id) {
		departmentService.deleteDepartment(id);
		if (departmentService.queryDepartmentById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
	@PostMapping("/deletes")
	public JSONResult deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				departmentService.deleteAll(ids);
			}
			return JSONResult.ok(1);
		} catch (Exception e) {
			return JSONResult.ok(0);
		}
	}
	
	@GetMapping("/approve")
	public JSONResult queryApprove() {
		//return JSONResult.ok(departmentService.queryAllDepartment());
		return JSONResult.ok(departmentService.queryWaitApprove());
	}
	
	@PostMapping("/approvePass")
	public  JSONResult approvePass(@Param("pass") String pass,@Param("id") Long id) {
		//System.out.println(id+"-----"+pass);
		Department entity = departmentService.queryDepartmentById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			if(pass.equals("pass")) {
				//System.out.println("pass");
				entity.setCheckStatus(1);
				departmentService.updateDepartment(entity);
			}else if(pass.equals("nopass"))  {
				//System.out.println("nopass");
				entity.setCheckStatus(2);
				departmentService.updateDepartment(entity);
			}
		}
		
		return JSONResult.ok(1);
	}
}
