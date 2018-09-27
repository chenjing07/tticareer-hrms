package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.SalaryDetail;

public interface SalaryDetailService {
	/*
	 * 添加薪酬信息
	 * @Param salaryDetail
	 */
   public void saveSalaryDetail(SalaryDetail salaryDetail);
   /*
	 * 修改薪酬信息
	 * @Param salaryDetail
	 */
   public void updateSalaryDetail(SalaryDetail salaryDetail);
   /*
	 * 根据id删除薪酬信息
	 * @Param 根据  id 删除薪酬，非物理删除，状态设置为0冻结
	 */
   public void deleteSalaryDetail(Long id);
   /*
	 * 通过id搜索薪酬信息
	 * @Param id
	 */
   public SalaryDetail querySalaryDetailById(Long id);
   /*
  	 * 通过员工id搜索薪酬信息
  	 * @Param employee_id
  	 */
   public List<SalaryDetail> querySalaryDetailByEmployeeId(Long employeeId);
   /*
 	 * 查找出所有的薪酬信息
 	 */
   public List<SalaryDetail> queryAllSalaryDetail();
   /*
	 * 查找出所有被冻结（删除）的薪酬信息
	 */
   public List<SalaryDetail> querySalaryDetailWhoIsDelete();
   /*
  	 * 查找出所有未被冻结（删除）的薪酬信息
  	 */
   public List<SalaryDetail> querySalaryDetailWhoIsNotDelete();
   /**
	 * 通过id审查薪酬
	 * @param employee
	 */
   public void checkSalaryDetail(Long id);
}
