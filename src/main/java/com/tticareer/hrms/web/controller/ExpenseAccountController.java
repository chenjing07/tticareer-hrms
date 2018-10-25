package com.tticareer.hrms.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.ExpenseAccount;
import com.tticareer.hrms.pojo.dto.ExpenseAccountDTO;
import com.tticareer.hrms.pojo.dto.RewardPunishmentDTO;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.service.impl.IExpenseAccountService;
import com.tticareer.hrms.util.ExtjsPageRequest;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/expenseaccount")
public class ExpenseAccountController {
	@Autowired
	private IExpenseAccountService expenseAccountService;
	@Autowired
	private EmployeeService employeeService;
	/**
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param expenseAccount
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveExpenseAccount(@RequestBody ExpenseAccountDTO dto) {
		ExpenseAccount expenseAccount=new ExpenseAccount();
		BeanUtils.copyProperties(dto, expenseAccount);
	    expenseAccount.setCheckStatus(0);
	    expenseAccount.setCreateTime(new Date());
	    expenseAccount.setState(1);
	    expenseAccount.setEmployeeId(employeeService.queryEmployeeByUserName(dto.getUserName()).getId());
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
	@GetMapping
	public JSONResult queryRealAllExpenseAccount(Integer page,String userName,String timeStart,String timeEnd,String checkStatus,ExtjsPageRequest pageRequest) {
		List<ExpenseAccount> expenseAccountList=new ArrayList<ExpenseAccount>();
		Date dateStart = null;
		Date dateEnd=null;
		dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
		dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
		if(StringUtils.isNotBlank(userName)&&StringUtils.isBlank(timeStart)&&StringUtils.isBlank(timeEnd)) {
			Employee employee=employeeService.queryEmployeeByUserName(userName);
			if(employee!=null) {
				expenseAccountList=expenseAccountService.queryExpenseAccountByEmployeeId(page, 12, employee.getId());
			}
		}else if((StringUtils.isNotBlank(timeStart)||StringUtils.isNotBlank(timeEnd))&&StringUtils.isBlank(userName)) {
//			    dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
//			    dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
			    expenseAccountList=expenseAccountService.queryExpenseAccountByTime(page, 15, dateStart, dateEnd);
		}else if((StringUtils.isNotBlank(timeStart)||StringUtils.isNotBlank(timeEnd))&&StringUtils.isNotBlank(userName)) {
//			dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
//			dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
			Employee employee=employeeService.queryEmployeeByUserName(userName);
			if(employee!=null) {
				expenseAccountList=expenseAccountService.queryExpenseAccountByEmployeeIdAndTime(page,15, employee.getId(), dateStart, dateEnd);
			}
		}else if(StringUtils.isNotBlank(checkStatus)) {
			Integer cs=Integer.valueOf(checkStatus);
			expenseAccountList=expenseAccountService.queryExpenseAccountWhoIsNotCheckStatus(page, 15, cs);
		}else {
		expenseAccountList=expenseAccountService.queryExpenseAccountWhoIsNotDelete(page, 15);
		}
		List<ExpenseAccountDTO> dtoList=new ArrayList<ExpenseAccountDTO>();
		for(ExpenseAccount expenseAccount: expenseAccountList) {
			ExpenseAccountDTO dto=new ExpenseAccountDTO();
			ExpenseAccountDTO.entityToDTO(expenseAccount, dto);
			Employee employee=employeeService.queryEmployeeById(expenseAccount.getEmployeeId());
			dto.setRealName(employee.getRealName());
			dto.setUserName(employee.getUserName());
			dtoList.add(dto);
		}
		PageInfo<ExpenseAccount> pageInfo=new PageInfo<ExpenseAccount>(expenseAccountList);
		Page<ExpenseAccountDTO> dtopage=new PageImpl<ExpenseAccountDTO>(dtoList,pageRequest.getPageable(),pageInfo.getTotal());
		return JSONResult.ok(dtopage);
	}
	/**
	 * 修改报销信息
	 * @return
	 */
	@PutMapping(value="{id}")
	public JSONResult updateExpneseAccount(@PathVariable("id")Long id,@RequestBody ExpenseAccountDTO dto) {
		ExpenseAccount expenseAccount=expenseAccountService.queryExpenseAccoutById(id);
		com.tticareer.hrms.util.BeanUtils.copyProperties(dto, expenseAccount);
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
	@DeleteMapping(value="{id}")
	public JSONResult deleteExpenseAccount(@PathVariable("id")Long id) {
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
	public JSONResult queryExpenseAccountWhoisNotDelete(Integer page) {
		return JSONResult.ok(expenseAccountService.queryExpenseAccountWhoIsNotDelete(page,15));
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
	@PutMapping("/checkstatus")
	public JSONResult checkExpenseAccount(@RequestParam(name="id") Long id,HttpSession session) {
//		String ssessionState=SessionUtil.getState(session);
//		int state=Integer.parseInt(ssessionState);
//		if(state==3) {
		ExpenseAccount data=expenseAccountService.queryExpenseAccoutById(id);
		if(data.getCheckStatus()==0) {
			expenseAccountService.checkExpenseAccount(id);
			return JSONResult.ok(1);
		}else {
			String msg="操作失败";
	    	return JSONResult.errorMsg(msg);
		}
//		}else {
//			   String msg="该用户没有操作权限";
//			   return JSONResult.errorMsg(msg);
//		   }
	}
	/**
	 * 删除多条报销信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public JSONResult deleteRows(@RequestParam(name="ids") Long[] ids) {
		if(ids!=null) {
			for(Long i:ids) {
				expenseAccountService.deleteExpenseAccount(i);
			}
			return JSONResult.ok(1);
	}
		String msg="操作失败";
		return JSONResult.errorMsg(msg);
	}
}
