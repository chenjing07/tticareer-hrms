package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.SalaryDetail;
import com.tticareer.hrms.service.SalaryDetailService;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/salarydetail")
public class SalaryDeatilController {
	@Autowired
	private SalaryDetailService salaryDetailService;
	/**
	 * 返回0  数据库中存在该员工此月薪酬信息
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param salaryDetail
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveSalaryDetail(SalaryDetail salaryDetail) {
		if(salaryDetailService.querySalaryDetailByEmpIdAndNowYearMonth(salaryDetail.getEmployeeId(),salaryDetail.getNowYearMonth())!=null) {
			    return JSONResult.ok(0);
		}else {
			salaryDetailService.saveSalaryDetail(salaryDetail);
			SalaryDetail s=salaryDetailService.querySalaryDetailByEmpIdAndNowYearMonth(salaryDetail.getEmployeeId(),salaryDetail.getNowYearMonth());
		    if(s!=null) {	
		    	String data=s.getId()+"";
		    	return JSONResult.ok(data);
		    }else {
		    	String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
		    }
		}	
	}
	/**
	 * 查询所有薪酬信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllSalaryDetail() {
		return JSONResult.ok(salaryDetailService.queryAllSalaryDetail());
	}
	/**
	 * 查看已被删除薪酬信息
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult querySalaryDetailWhoIsDelete(){
		return JSONResult.ok(salaryDetailService.querySalaryDetailWhoIsDelete());
	}
	/**
	 * 查看未被删除薪酬信息
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult querySalaryDetailWhoIsNotDelete() {
		return JSONResult.ok(salaryDetailService.querySalaryDetailWhoIsNotDelete());
	}
	/**
	 * 修改薪酬信息
	 * @param SalaryDetail
	 */
	@PutMapping("/update")
	public JSONResult updateSalaryDetail(SalaryDetail salaryDetail) {
		salaryDetail.setCheckStatus(0);
		salaryDetailService.updateSalaryDetail(salaryDetail);
		SalaryDetail data=salaryDetailService.querySalaryDetailById(salaryDetail.getId());
		return JSONResult.ok(data);		
	}
	/**
	 * 删除薪酬信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public JSONResult deleteSalaryDetail(@Param("id") Long id) {
		salaryDetailService.deleteSalaryDetail(id);
		SalaryDetail data=salaryDetailService.querySalaryDetailById(id);
		if(data.getState()!=0) {
			return JSONResult.ok(0);
		}
		return JSONResult.ok(1);
	}
	/**
	 * 审查薪酬信息，状态设置为1
	 * 成功返回1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PutMapping("/checkstatus")
	public JSONResult checkSalaryDetail(@Param("id") Long id) {
		SalaryDetail s=salaryDetailService.querySalaryDetailById(id);
		if(s.getCheckStatus()==0) {
		salaryDetailService.checkSalaryDetail(id);
		return JSONResult.ok(1);
	    }else {
	    	return JSONResult.ok(0);
	    }
	}
}
