package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.Department;
import com.tticareer.hrms.pojo.dto.DepartmentIdAndName;




/**
* @author cfy
* @version 创建时间：2018年9月26日 上午9:00:00
*/
public interface DepartmentService {
	/**
	 * 添加部门
	 * @param department
	 */
	public void saveDepartment(Department department);
	
	/**
	 * 更新部门
	 * @param department
	 */
	public void updateDepartment(Department department);
	
	/**
	 * 根据  id 删除部门，非物理删除，状态设置为0
	 * @param id
	 */
	public void deleteDepartment(Long id);
	
	/**
	 * 通过  id 搜索部门
	 * @param id
	 * @return
	 */
	public Department queryDepartmentById(Long id);
	
	/**
	 * 根据  departmentName 搜索部门
	 * @param departmentName
	 * @return
	 */
	public Department queryDepartmentByDepartmentName(String departmentName);
	
	/**
	 * 查询所有部门，包括所有状态
	 * @return
	 */
	public List<Department> queryAllDepartment();
	
	/**
	 * 查询已被删除即状态为0的部门
	 * @return
	 */
	public List<Department> queryDepartmentWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的部门
	 * @return
	 */
	public List<Department> queryDepartmentWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);
	
	
	/**
	 * 根据部门工号模糊查询
	 * @param department
	 * @return
	 */
	public List<Department> queryDepartmentList(Department department);
	
	public List<Department> queryDepartmentListByDepartmentNumber(String departmentNumber,Integer pageNum,Integer pageSize,String orderBy);
	public List<Department> queryDepartmentListByDepartmentName(String departmentName,Integer pageNum,Integer pageSize,String orderBy);
	public List<Department> queryDepartmentListByDepartmentNumberAndDepartmentName(String departmentNumber,String departmentName,Integer pageNum,Integer pageSize,String orderBy);

	public void deleteAll(Long[] ids);
	public List<Department> queryWaitApprove(Integer pageNum,Integer pageSize,String orderBy);

	
	public List<DepartmentIdAndName> getDepartmentIdAndName();

	public Department queryDepartmentByDepartmentNumber(String departmentNumber);
	
}
