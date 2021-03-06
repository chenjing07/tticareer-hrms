package com.tticareer.hrms.service;

import java.util.Date;
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
   public List<SalaryDetail> querySalaryDetailByEmployeeId(Long employeeId,Integer page,Integer pageSize);
   /*
 	 * 查找出所有的薪酬信息
 	 */
   public List<SalaryDetail> queryAllSalaryDetail(Integer page,Integer pazeSize);
   /*
	 * 查找出所有被冻结（删除）的薪酬信息
	 */
   public List<SalaryDetail> querySalaryDetailWhoIsDelete();
   /*
  	 * 查找出所有未被冻结（删除）的薪酬信息
  	 */
   public List<SalaryDetail> querySalaryDetailWhoIsNotDelete(Integer page,Integer pageSize);
   /*
  	 * 审查薪酬信息
  	 */
   public void checkSalaryDetail(Long id);
   /*
  	 * 通过员工id以及年月查找薪酬信息
  	 */
   public List<SalaryDetail> querySalaryDetailByEmpIdAndNowYearMonth(Long employeeId,Date nowYearMonth);
   /*
 	 * 通过年月查找薪酬信息
 	 */
   public List<SalaryDetail> querySalaryDetailByNowYearMonth(Date nowYearMonth,Integer page,Integer pageSize);
   /*
	 * 通过分页年月查找薪酬信息
	 */
   public List<SalaryDetail> querySalaryDetailByEmpIdAndNowYearMonth(Integer page,Integer pageSize,Long employeeId, Date nowYearMonth);
   /*
	 * 查找未审核的薪酬信息
	 */
   public List<SalaryDetail> querySalaryDetailWhoIsNotCheckStatus(Integer page,Integer pageSize,Integer checkStatus);
}
