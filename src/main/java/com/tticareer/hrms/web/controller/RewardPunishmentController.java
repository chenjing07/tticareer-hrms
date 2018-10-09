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

import com.tticareer.hrms.pojo.RewardPunishment;
import com.tticareer.hrms.service.impl.IRewardPunishmentService;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/rewardpunishment")
public class RewardPunishmentController {
	@Autowired
	private IRewardPunishmentService rewardPunishmentService;
	/**
	 * 返回id 录入奖惩信息成功
	 * msg 未知错误，数据未录入
	 * @param RewardPunishment
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveRewardPunishment(RewardPunishment rewardPunishment) {
		rewardPunishmentService.saveRewardPunishment(rewardPunishment);
		RewardPunishment r=rewardPunishmentService.queryRewardPunishmentByEmployeeIdAndCreateTime(rewardPunishment.getEmployeeId(), rewardPunishment.getCreateTime());
		if(r!=null) {
			String data=r.getId()+" ";
			return JSONResult.ok(data);
		}else {
		String msg = "未知错误，数据未录入";
		return JSONResult.errorMsg(msg);
	    }
	}
	/**
	 * 查询所有奖惩信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllRewardPunishment() {
		return JSONResult.ok(rewardPunishmentService.queryAllRewardPunishment());
	}
	/**
	 * 查看未被删除(冻结)奖惩信息
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryRewardPunishmentWhoIsNotDelete() {
		return JSONResult.ok(rewardPunishmentService.queryRewardPunishmentWhoIsNotDelete());
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
	@PutMapping("/update")
	public JSONResult updateRewardPunishment(RewardPunishment rewardPunishment) {
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
	@DeleteMapping("/delete")
	public JSONResult deleteRewardPunishment(@Param("id") Long id) {
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
	public JSONResult checkRewardPunishment(@Param("id") Long id) {
		RewardPunishment data=rewardPunishmentService.queryRewardPunishmentById(id);
		if(data.getCheckStatus()==0) {
			rewardPunishmentService.checkRewardPunishment(id);
			return JSONResult.ok(1);
		}else {
			return JSONResult.ok(0);
		}
	}
}
