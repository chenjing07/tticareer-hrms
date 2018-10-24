package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.dto.EmployeeIdAndName;

/**
 * <p>CreateTime: 2018年9月21日 下午3:39:03 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: EmployeeService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: IEmployeeService的接口</p>
 */
public interface EmployeeService {
	
	/**
	 * 添加员工
	 * @param employee
	 */
	public void saveEmployee(Employee employee);
	
	/**
	 * 更新员工
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	
	/**
	 * 根据  id 删除员工，非物理删除，状态设置为0
	 * @param id
	 */
	public void deleteEmployee(Long id);
	
	/**
	 * 通过  id 搜索员工
	 * @param id
	 * @return
	 */
	public Employee queryEmployeeById(Long id);
	
	/**
	 * 根据  userName 搜索员工
	 * @param userName
	 * @return
	 */
	public Employee queryEmployeeByUserName(String userName);
	
	/**
	 * 查询所有员工，包括所有状态
	 * @return
	 */
	public List<Employee> queryAllEmployee();
	
	/**
	 * 查询已被删除即状态为0的员工
	 * @return
	 */
	public List<Employee> queryEmployeeWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的员工
	 * @return
	 */
	public List<Employee> queryEmployeeWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);
	
	/**
	 * 查询状态为1，即其他员工
	 * @return
	 */
	public List<Employee> queryOtherEmployee();
	
	/**
	 * 查询状态为2，即人事部普通员工
	 * @return
	 */
	public List<Employee> queryPersonnelEmployee();
	
	/**
	 * 查询状态为3，即人事部经理
	 * @return
	 */
	public Employee queryPersonnelManager();
	
	/**
	 * 根据员工工号模糊查询
	 * @param employee
	 * @return
	 */
	public List<Employee> queryEmployeeListByUserName(String userName,Integer pageNum,Integer pageSize,String orderBy);
	public List<Employee> queryEmployeeListByRealName(String realName,Integer pageNum,Integer pageSize,String orderBy);
	public List<Employee> queryEmployeeListByUserNameAndRealName(String userName,String realName,Integer pageNum,Integer pageSize,String orderBy);
	
	
	public void deleteAll(Long[] ids);
	
	public List<Employee> queryWaitApprove(Integer pageNum,Integer pageSize,String orderBy);
	
	public List<EmployeeIdAndName> getEmployeeIdAndName();
}
