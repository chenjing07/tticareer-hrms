package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.RewardPunishment;

public interface RewardPunishmentService {
	/*
	 * 添加奖惩信息
	 * @Param RewardPunishment
	 */
	public void saveRewardPunishment(RewardPunishment rewardPunishment);
	/*
	 * 修改奖惩信息
	 * @Param RewardPunishment
	 */
	public void updateRewardPunishment(RewardPunishment rewardPunishment);
	/*
	 * 删除奖惩信息（修改状态 为冻结）
	 * @Param RewardPunishment
	 */
	public void deleteRewardPunishment(Long id);
	/*
	 * 通过ID查询奖惩信息
	 * @Param RewardPunishment
	 */
	public RewardPunishment queryRewardPunishmentById(Long id);
	/*
	 * 查找所有的奖惩信息
	 */
	public List<RewardPunishment> queryAllRewardPunishment(Integer page,Integer pageSize);
	/*
	 * 通过员工id查找其所有奖惩信息
	 * @Param employeeId
	 */
	public List<RewardPunishment> queryRewardPunishmentByEmployeeId(Integer page,Integer pageSize,Long employeeId);
	/*
	 * 查找所有被冻结的奖惩
	 */
	public List<RewardPunishment> queryRewardPunishmentWhoIsDelete();
	/*
  	 * 查找出所有未被冻结（删除）的奖惩信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentWhoIsNotDelete(Integer page,Integer pageSize);
	/*
  	 * 查找出所有奖的信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentWhoisReward();
	/*
  	 * 查找出所有惩的信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentWhoisPunishment();
	  /*
  	 * 审查奖惩信息
  	 */
	public void checkRewardPunishment(Long id);
	 /*
  	 * 通过员工ID以及创建时间查找奖惩信息
  	 */
	public RewardPunishment queryRewardPunishmentByEmployeeIdAndCreateTime(Long employeeId,Date createTime);
	 /*
  	 * 通过创建时间范围查找奖惩信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentByTime(Integer page,Integer pageSize,Date timeStart,Date timeEnd);
	 /*
  	 * 通过员工id以及创建时间范围查找奖惩信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentByEmployeeIdAndTime(Integer page,Integer pageSize,Long employeeId,Date timeStart,Date timeEnd);
	/*
  	 * 通过未审查来查询奖惩信息
  	 */
	public List<RewardPunishment> queryRewardPunishmentWhoIsNotCheckStatus(Integer page,Integer pageSize,Integer checkStatus);
}
