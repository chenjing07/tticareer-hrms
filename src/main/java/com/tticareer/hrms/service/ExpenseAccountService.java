package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.ExpenseAccount;

public interface ExpenseAccountService {
	/*
	 * 添加报销信息
	 * @Param ExpenseAccount
	 */
	public void saveExpenseAccount(ExpenseAccount expenseAccount);
	/*
	 * 修改报销信息
	 * @Param ExpenseAccount
	 */
	public void updateExpenseAccount(ExpenseAccount expenseAccount);
	/*
	 * 根据ID删除报销信息
	 * @Param id
	 */
	public void deleteExpenseAccount(Long id);
	/*
	 * 查询所有的报销信息
	 */
	public List<ExpenseAccount> queryAllExpenseAccount(Integer page,Integer pageSize);
	/*
	 * 查询已被冻结的报销信息
	 */
	public List<ExpenseAccount> queryExpenseAccountWhoIsDelete();
	/*
	 * 查询未被的报销信息
	 */
	public List<ExpenseAccount> queryExpenseAccountWhoIsNotDelete(Integer page,Integer pageSize);
	/*
	 * 根据ID查询报销信息
	 * @Param id
	 */
	public ExpenseAccount queryExpenseAccoutById(Long id);
	/*
	 * 根据employeeId查询报销信息（多个信息）
	 * @Param employeeId
	 */
	public List<ExpenseAccount> queryExpenseAccountByEmployeeId(Integer page,Integer pageSize,Long employeeId);
	/*
	 * 根据员工ID以及创建时间查询报销信息
	 * @Param employeeId createTime
	 */
	public ExpenseAccount queryExpenseAccoountByEmployeeIdAndCreateTime(Long employeeId,Date createTime);
	/*
	 * 根据ID审查报销信息
	 * @Param employeeId createTime
	 */
	public void checkExpenseAccount(Long id);
	/*
	 * 根据报销日期范围查询报销信息
	 * @Param employeeId createTime
	 */
	public List<ExpenseAccount> queryExpenseAccountByTime(Integer page,Integer pageSize,Date dateStart,Date dateEnd);
	/*
	 * 根据报销日期范围与员工Id查询报销信息
	 * @Param employeeId createTime
	 */
	public List<ExpenseAccount> queryExpenseAccountByEmployeeIdAndTime(Integer page,Integer pageSize,Long employeeId,Date dateStart,Date dateEnd);
}
