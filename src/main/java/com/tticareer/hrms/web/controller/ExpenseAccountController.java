package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.ExpenseAccount;
import com.tticareer.hrms.service.impl.IExpenseAccountService;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/expenseaccount")
public class ExpenseAccountController {
	@Autowired
	private IExpenseAccountService expenseAccountService;
	/**
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param expenseAccount
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveExpenseAccount(ExpenseAccount expenseAccount) {
		expenseAccountService.saveExpenseAccount(expenseAccount);
		ExpenseAccount s=expenseAccountService.queryExpenseAccoountByEmployeeIdAndCreateTime(expenseAccount.getEmployeeId(), expenseAccount.getCreateTime());
	    if(s!=null) {
	    	String data=s.getId()+"";
	    	return JSONResult.ok(data);
	    }else {
	    	String msg = "未知错误，数据未录入";
			return JSONResult.errorMsg(msg);
	    }
	}
	/**
	 * 查询所有报销信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllExpenseAccount() {
		return JSONResult.ok(expenseAccountService.queryAllExpenseAccount());
	}
	/**
	 * 修改报销信息
	 * @return
	 */
	@PutMapping("/update")
	public JSONResult updateExpneseAccount(ExpenseAccount expenseAccount) {
		expenseAccount.setCheckStatus(0);
		expenseAccountService.updateExpenseAccount(expenseAccount);
		ExpenseAccount data=expenseAccountService.queryExpenseAccoutById(expenseAccount.getId());
		return JSONResult.ok(data);
	}
	/**
	 * 删除(冻结)报销信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public JSONResult deleteExpenseAccount(@Param("id")Long id) {
		expenseAccountService.deleteExpenseAccount(id);
		ExpenseAccount data=expenseAccountService.queryExpenseAccoutById(id);
		if(data.getState()!=0) {
			return JSONResult.ok(0);
		}else {
			return JSONResult.ok(1);
		}
	}
	/**
	 * 查看未被删除(冻结)报销信息
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryExpenseAccountWhoisNotDelete() {
		return JSONResult.ok(expenseAccountService.queryExpenseAccountWhoIsNotDelete());
	}
	/**
	 * 查看被删除(冻结)报销信息
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryExpenseAccountWhoIsDelete() {
		return JSONResult.ok(expenseAccountService.queryExpenseAccountWhoIsDelete());
	}
	/**
	 * 审查报销信息
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@PutMapping("/checkExpenseAccount")
	public JSONResult checkExpenseAccount(@Param("id")Long id) {
		ExpenseAccount data=expenseAccountService.queryExpenseAccoutById(id);
		if(data.getCheckStatus()==0) {
			expenseAccountService.checkExpenseAccount(id);
			return JSONResult.ok(1);
		}else {
			return JSONResult.ok(0);
		}		
	}
}
