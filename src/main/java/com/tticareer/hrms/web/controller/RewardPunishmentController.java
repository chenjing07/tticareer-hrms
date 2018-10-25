package com.tticareer.hrms.web.controller;


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
import com.tticareer.hrms.pojo.RewardPunishment;
import com.tticareer.hrms.pojo.dto.RewardPunishmentDTO;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.service.impl.IRewardPunishmentService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.ExtjsPageRequest;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/rewardpunishment")
public class RewardPunishmentController {
	@Autowired
	private IRewardPunishmentService rewardPunishmentService;
	@Autowired
	private EmployeeService employeeService;
	/**
	 * 返回id 录入奖惩信息成功
	 * msg 未知错误，数据未录入
	 * @param RewardPunishment
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveRewardPunishment(@RequestBody RewardPunishmentDTO dto) {
		RewardPunishment rewardPunishment=new RewardPunishment();
		BeanUtils.copyProperties(dto, rewardPunishment);
		rewardPunishment.setState(1);
		rewardPunishment.setCheckStatus(0);
		rewardPunishment.setCreateTime(new Date());
		rewardPunishment.setEmployeeId(employeeService.queryEmployeeByUserName(dto.getUserName()).getId());
		rewardPunishmentService.saveRewardPunishment(rewardPunishment);
		RewardPunishment r=rewardPunishmentService.queryRewardPunishmentByEmployeeIdAndCreateTime(rewardPunishment.getEmployeeId(), rewardPunishment.getCreateTime());
		if(r!=null) {
			String data=r.getId()+" ";
			return JSONResult.ok(dto);
		}else {
		String msg = "未知错误，数据未录入";
		return JSONResult.errorMsg(msg);
	    }
	}
	/**
	 * 查询所有奖惩信息
	 * @return
	 */
	@GetMapping
	public JSONResult queryRealAllRewardPunishment(Integer page,String userName,String timeStart,String timeEnd,String checkStatus,ExtjsPageRequest pageRequest) {
		List<RewardPunishment> rewardPunishmentList=new ArrayList<RewardPunishment>();
		Date dateStart = null;
		Date dateEnd=null;
		dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
		dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
		if(StringUtils.isNotBlank(userName)&&StringUtils.isBlank(timeStart)&&StringUtils.isBlank(timeEnd)) {
			Employee employee=employeeService.queryEmployeeByUserName(userName);
			if(employee!=null) {
			rewardPunishmentList=rewardPunishmentService.queryRewardPunishmentByEmployeeId(page, 15, employee.getId());
			}
		}else if((StringUtils.isNotBlank(timeStart)||StringUtils.isNotBlank(timeEnd))&&StringUtils.isBlank(userName)) {
//			dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
//			dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
			rewardPunishmentList=rewardPunishmentService.queryRewardPunishmentByTime(page, 15, dateStart, dateEnd);
		}else if((StringUtils.isNotBlank(timeStart)||StringUtils.isNotBlank(timeEnd))&&StringUtils.isNotBlank(userName)) {
//			dateStart=RewardPunishmentDTO.dealTimeStart(timeStart);
//			dateEnd=RewardPunishmentDTO.dealTimeEnd(timeEnd);
			Employee employee=employeeService.queryEmployeeByUserName(userName);
			if(employee!=null) {
			rewardPunishmentList=rewardPunishmentService.queryRewardPunishmentByEmployeeIdAndTime(page, 15, employee.getId(), dateStart, dateEnd);
		}
		}else if(StringUtils.isNotBlank(checkStatus)) {
			Integer cs=Integer.valueOf(checkStatus);
			rewardPunishmentList=rewardPunishmentService.queryRewardPunishmentWhoIsNotCheckStatus(page, 15, cs);
		}
		else {
		rewardPunishmentList=rewardPunishmentService.queryRewardPunishmentWhoIsNotDelete(page, 15);
		}
		 List<RewardPunishmentDTO> dtoList=new ArrayList<RewardPunishmentDTO>();
		 for(RewardPunishment rewardPunishment: rewardPunishmentList) {
			 RewardPunishmentDTO dto=new RewardPunishmentDTO();
			 RewardPunishmentDTO.entityToDTO(rewardPunishment, dto);
			 Employee employee= employeeService.queryEmployeeById(rewardPunishment.getEmployeeId());
			 dto.setRealName(employee.getRealName());
			 dto.setUserName(employee.getUserName());
			 dtoList.add(dto);
		 }
		 PageInfo<RewardPunishment> pageInfo=new PageInfo<RewardPunishment>(rewardPunishmentList);
		 Page<RewardPunishmentDTO> dtopage=new PageImpl<RewardPunishmentDTO>(dtoList,pageRequest.getPageable(),pageInfo.getTotal());
		return JSONResult.ok(dtopage);
	}
	/**
	 * 查看未被删除(冻结)奖惩信息
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryRewardPunishmentWhoIsNotDelete(Integer page) {
		return JSONResult.ok(rewardPunishmentService.queryRewardPunishmentWhoIsNotDelete(page,15));
	}
	/**
	 * 查看被删除(冻结)奖惩信息
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryRewardPunishmentWhoIsDelete() {
		return JSONResult.ok(rewardPunishmentService.queryRewardPunishmentWhoIsDelete());
	}
	/**
	 * 修改奖惩信息
	 * @param RewardPunishment
	 */
	@PutMapping(value="{id}")
	public JSONResult updateRewardPunishment(@PathVariable("id") Long id,@RequestBody RewardPunishmentDTO dto) {
		RewardPunishment rewardPunishment=rewardPunishmentService.queryRewardPunishmentById(id);
		BeanUtils.copyProperties(dto, rewardPunishment);
		rewardPunishment.setCheckStatus(0);
		rewardPunishmentService.updateRewardPunishment(rewardPunishment);
		RewardPunishment data=rewardPunishmentService.queryRewardPunishmentById(rewardPunishment.getId());
		return JSONResult.ok(data);
	}
	/**
	 * 删除奖惩信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteRewardPunishment(@PathVariable("id") Long id) {
		rewardPunishmentService.deleteRewardPunishment(id);
		RewardPunishment data=rewardPunishmentService.queryRewardPunishmentById(id);
		if(data.getState()!=0) {
			return JSONResult.ok(0);
		}else {
			return JSONResult.ok(1);
		}
	}
	/**
	 * 审查奖惩信息，状态设置为1
	 * 成功返回1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PutMapping("/checkstatus")
	public JSONResult checkRewardPunishment(@RequestParam(name="id") Long id,HttpSession session) {
		String ssessionState=SessionUtil.getState(session);
		int state=Integer.parseInt(ssessionState);
		if(state==3) {
		RewardPunishment data=rewardPunishmentService.queryRewardPunishmentById(id);
		if(data.getCheckStatus()==0) {
			rewardPunishmentService.checkRewardPunishment(id);
			return JSONResult.ok(1);
		}else {
			String msg="操作失败";
	    	return JSONResult.errorMsg(msg);
		}
		}else {
			   String msg="该用户没有操作权限";
			   return JSONResult.errorMsg(msg);
		   }
	}
	/**
	 * 删除多条奖惩信息，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0 已通过审核
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public JSONResult deleteRows(@RequestParam(name="ids") Long[] ids) {
		if(ids!=null) {
			for(Long i:ids) {
				rewardPunishmentService.deleteRewardPunishment(i);
			}
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
}
