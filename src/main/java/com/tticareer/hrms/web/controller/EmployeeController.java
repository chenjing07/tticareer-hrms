package com.tticareer.hrms.web.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
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

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.util.BeanUtils;
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
		employee.setState(1);
		employee.setCheckSatus(0);
		//System.out.println(employee.getUserName());
		try{
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
		}catch(Exception e){
			return JSONResult.errorMsg("请正确填写数据");
		}
		
	}
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	//@GetMapping("/realall")
	@GetMapping
	/*public JSONResult queryRealAllEmployee() {
		//System.out.println(userName);
		return JSONResult.ok(employeeService.queryAllEmployee());
	}*/
	//public JSONResult getPage(EmployeeQueryDTO employeeQueryDTO /*, ExtjsPageRequest pageRequest*/) 
	public JSONResult getPage(@Param("userName") String userName,@Param("realName") String realName,
			ExtjsPageRequest pageRequest) 
	{
		//System.out.println(userName + "********" +realName);
		
		if(userName!=null && realName=="") {
			//System.out.println(userName);
			//return JSONResult.ok(employeeService.queryEmployeeListByUserName(userName));
			List<Employee> rdList=employeeService.queryEmployeeListByUserName(userName,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Employee> p=new PageInfo<Employee>(rdList);
			PageImpl<Employee> rdPage=new PageImpl<Employee>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);	
		}else if(userName=="" && realName!=null) {
			//return JSONResult.ok(employeeService.queryEmployeeListByRealName(realName));
			List<Employee> rdList=employeeService.queryEmployeeListByRealName(realName,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Employee> p=new PageInfo<Employee>(rdList);
			PageImpl<Employee> rdPage=new PageImpl<Employee>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);
		}else if(userName!=null && realName!=null) {
			//System.out.println(userName + "&&&&&&" +realName);
			//return JSONResult.ok(employeeService.queryEmployeeListByUserNameAndRealName(userName,realName));
			List<Employee> rdList=employeeService.queryEmployeeListByUserNameAndRealName(userName,realName,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Employee> p=new PageInfo<Employee>(rdList);
			PageImpl<Employee> rdPage=new PageImpl<Employee>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);
		}
		else {
			//return JSONResult.ok(employeeService.queryAllEmployee());
			List<Employee> rdList=employeeService.queryEmployeeWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Employee> p=new PageInfo<Employee>(rdList);
			PageImpl<Employee> rdPage=new PageImpl<Employee>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);	
		}
		
	}
	
	
	/**
	 * 快速查询
	 * @return
	 */
	/*@GetMapping("/quickUserName")
	public JSONResult queryRealAllEmployee(@Param("userName") String userName) {
		//System.out.println(userName);
		//System.out.println("--------------------");
		return JSONResult.ok(employeeService.queryEmployeeListByUserName(userName));
		//return JSONResult.ok("qweqwe");
	}*/
	
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
	/*@GetMapping("/mockall")
	public JSONResult queryEmployeeWhoIsNotDelete() {
		return JSONResult.ok(employeeService.queryEmployeeWhoIsNotDelete());
	}
	*/
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
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
		Employee entity = employeeService.queryEmployeeById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			BeanUtils.copyProperties(employee, entity);//使用自定义的BeanUtils
			//employeeService.save(entity);
			employeeService.updateEmployee(entity);
		}
		
		Employee data = employeeService.queryEmployeeById(id);
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除员工，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public  @ResponseBody JSONResult deleteEmployee(@PathVariable("id") Long id) {
		//System.out.println("-----"+id);
		employeeService.deleteEmployee(id);
		if (employeeService.queryEmployeeById(id).getState()==0) {
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
				employeeService.deleteAll(ids);
			}
			return JSONResult.ok(1);
		} catch (Exception e) {
			return JSONResult.ok(0);
		}
	}
	
	
	@GetMapping("/approve")
	public JSONResult queryApprove(ExtjsPageRequest pageRequest) {
		//return JSONResult.ok(employeeService.queryAllEmployee());
		//return JSONResult.ok(employeeService.queryWaitApprove());
		List<Employee> rdList=employeeService.queryWaitApprove(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
		PageInfo<Employee> p=new PageInfo<Employee>(rdList);
		PageImpl<Employee> rdPage=new PageImpl<Employee>(rdList,pageRequest.getPageable(),p.getTotal());
		return JSONResult.ok(rdPage);	
	}
	
	@PostMapping("/approvePass")
	public  JSONResult approvePass(@Param("pass") String pass,@Param("id") Long id) {
		//System.out.println(id+"-----"+pass);
		Employee entity = employeeService.queryEmployeeById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			if(pass.equals("pass")) {
				//System.out.println("pass");
				entity.setCheckSatus(1);
				employeeService.updateEmployee(entity);
			}else if(pass.equals("nopass"))  {
				//System.out.println("nopass");
				entity.setState(0);
				entity.setCheckSatus(2);
				employeeService.updateEmployee(entity);
			}
		}
		
		return JSONResult.ok(1);
	}
	
	
	@GetMapping("/getEmployeeIdAndName")
	public JSONResult getSuperior() {
		//return JSONResult.ok(departmentService.queryAllDepartment());
		return JSONResult.ok(employeeService.getEmployeeIdAndName());
	}
	
	@GetMapping("/getEmployeeNameById")
	public JSONResult getEmployeeNameById(@Param("id") Long id) {
		//return JSONResult.ok(employeeService.queryAllEmployee());
		if(id!=0) {
			String employeeName = (employeeService.queryEmployeeById(id)).getUserName();
			//System.out.println(employeeName);
			return JSONResult.ok(employeeName);
		}else
			return JSONResult.ok("");
	}
	
	
	
}
