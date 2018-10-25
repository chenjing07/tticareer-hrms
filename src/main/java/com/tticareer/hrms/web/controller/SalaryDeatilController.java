package com.tticareer.hrms.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
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
import com.tticareer.hrms.pojo.SalaryDetail;
import com.tticareer.hrms.pojo.dto.SalaryDetailDTO;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.service.SalaryDetailService;
import com.tticareer.hrms.util.JSONResult;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.ExtjsPageRequest;

@RestController
@RequestMapping("/salarydetail")
public class SalaryDeatilController {
	@Autowired
	private SalaryDetailService salaryDetailService;
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 返回0  数据库中存在该员工此月薪酬信息
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param salaryDetail
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveSalaryDetail(@RequestBody SalaryDetailDTO dto) {
		List<SalaryDetail> checkList=salaryDetailService.querySalaryDetailByEmpIdAndNowYearMonth(dto.getEmployeeId(),dto.getNowYearMonth());
		 int i = 0;
		 for(SalaryDetail check : checkList ) {
			 if(check.getState()!=0) {
				 i=1;
			 }
		 }
		 if(i==0) {
			SalaryDetail salaryDetail=new SalaryDetail();
			BeanUtils.copyProperties(dto,salaryDetail);
			salaryDetail.setCheckStatus(0);
			salaryDetail.setState(1);
			salaryDetail.setCreateTime(new Date());
			salaryDetail.setSalaryTotal(dto.getBasicSalary()+dto.getBonus()+dto.getSubsidy()+dto.getOverWorkSalary()-dto.getAttendanceDeduction());
			salaryDetail.setEmployeeId(employeeService.queryEmployeeByUserName(dto.getUserName()).getId());
			salaryDetailService.saveSalaryDetail(salaryDetail);
		    	return JSONResult.ok(1);
		}else {
			String msg = "该员工此月数据已存在";
			return JSONResult.errorMsg(msg);
		}
	}
	/**
	 * 查询所有薪酬信息
	 * @return
	 */
	@GetMapping
	public JSONResult queryRealAllSalaryDetail(Integer page,String userName,String nowYearMonth,String checkStatus,ExtjsPageRequest pageRequest) {		
		List<SalaryDetail> salaryDetailList=new ArrayList<SalaryDetail>();
		if(StringUtils.isNotBlank(userName)&&StringUtils.isBlank(nowYearMonth)) {
			Employee e=employeeService.queryEmployeeByUserName(userName);
			if(e!=null){
				salaryDetailList=salaryDetailService.querySalaryDetailByEmployeeId(e.getId(), page, 15);
				}
		}else if(StringUtils.isNotBlank(nowYearMonth)&&StringUtils.isBlank(userName)) {
			Date date = null;
			DateFormat format= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
			try {
				date = format.parse(nowYearMonth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 salaryDetailList=salaryDetailService.querySalaryDetailByNowYearMonth(date, page, 15);
		}else if(StringUtils.isNotBlank(userName)&&StringUtils.isNotBlank(nowYearMonth)) {
			Employee m=employeeService.queryEmployeeByUserName(userName);
			if(m!=null){
				Date date = null;
				DateFormat format= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
				try {
					date = format.parse(nowYearMonth);
				} catch (ParseException e) {
					e.printStackTrace();
				}
                      salaryDetailList=salaryDetailService.querySalaryDetailByEmpIdAndNowYearMonth(page,15,m.getId(), date);
				}
		}else if(StringUtils.isNotBlank(checkStatus)) {
			 Integer cs=Integer.valueOf(checkStatus);
			 salaryDetailList=salaryDetailService.querySalaryDetailWhoIsNotCheckStatus(page, 15, cs);
		}else {
		     salaryDetailList=salaryDetailService.querySalaryDetailWhoIsNotDelete(page, 15);
		}
		List<SalaryDetailDTO> dtoList=new ArrayList<SalaryDetailDTO>();	 
		for(SalaryDetail salaryDetail: salaryDetailList) {
			if(salaryDetail!=null) {
			 SalaryDetailDTO dto=new SalaryDetailDTO();
			 SalaryDetailDTO.entityToDTO(salaryDetail, dto);
			 Employee employee=employeeService.queryEmployeeById(salaryDetail.getEmployeeId());
			 dto.setUserName(employee.getUserName());
			 dto.setRealName(employee.getRealName());
			 dtoList.add(dto);
		    }
		}	
		PageInfo<SalaryDetail> pageInfo = new PageInfo<SalaryDetail>(salaryDetailList);
		Page<SalaryDetailDTO> dtopage=new PageImpl<SalaryDetailDTO>(dtoList,pageRequest.getPageable(),pageInfo.getTotal());
		return JSONResult.ok(dtopage);
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
	public JSONResult querySalaryDetailWhoIsNotDelete(Integer page) {
		return JSONResult.ok(salaryDetailService.querySalaryDetailWhoIsNotDelete(page,15));
	}
	/**
	 * 修改薪酬信息
	 * @param SalaryDetail
	 */
	@PutMapping(value="{id}")
	public JSONResult updateSalaryDetail(@PathVariable("id") Long myId,@RequestBody SalaryDetailDTO dto) {
		SalaryDetail salaryDetail=salaryDetailService.querySalaryDetailById(myId);
		BeanUtils.copyProperties(dto, salaryDetail);
		salaryDetail.setSalaryTotal(salaryDetail.getBasicSalary()+salaryDetail.getBonus()+salaryDetail.getOverWorkSalary()+salaryDetail.getSubsidy()-salaryDetail.getAttendanceDeduction());
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
	@DeleteMapping(value="{id}")
	public JSONResult deleteSalaryDetail(@PathVariable("id") Long id) {
		salaryDetailService.deleteSalaryDetail(id);
		SalaryDetail data=salaryDetailService.querySalaryDetailById(id);
		if(data.getState()!=0) {
			return JSONResult.ok(1);
		}
		String msg="操作失败";
		return JSONResult.errorMsg(msg);
		
	}
	/**
	 * 删除多条薪酬信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public JSONResult deleteRows(@RequestParam(name="ids") Long[] ids) {
			if(ids!=null) {
				for(Long i:ids) {
					salaryDetailService.deleteSalaryDetail(i);
				}
				return JSONResult.ok(1);
			}
			String msg="操作失败";
			return JSONResult.errorMsg(msg);
	}
	/**
	 * 审查薪酬信息，状态设置为1
	 * 成功返回 1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PostMapping("/checkstatus")
	public JSONResult checkSalaryDetail(@RequestParam(name="id") Long id,HttpSession session) {
//		String ssessionState=SessionUtil.getState(session);
//		int state=Integer.parseInt(ssessionState);
//		if(state==3) {
		SalaryDetail s=salaryDetailService.querySalaryDetailById(id);
		if(s.getCheckStatus()==0) {
		salaryDetailService.checkSalaryDetail(id);
		return JSONResult.ok(1);
	    }else {
	    	String msg="操作失败";
	    	return JSONResult.errorMsg(msg);
	    }
//	   }else {
//		   String msg="该用户没有操作权限";
//		   return JSONResult.errorMsg(msg);
//	   }
		
	}
}
