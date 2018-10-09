package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.RewardPunishmentMapper;
import com.tticareer.hrms.pojo.RewardPunishment;
import com.tticareer.hrms.service.RewardPunishmentService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IRewardPunishmentService implements RewardPunishmentService {
	
	@Autowired
	private RewardPunishmentMapper rewardPunishmentMapper;
    
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveRewardPunishment(RewardPunishment rewardPunishment) {
		rewardPunishmentMapper.insert(rewardPunishment);
	}
    
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateRewardPunishment(RewardPunishment rewardPunishment) {
		rewardPunishmentMapper.updateByPrimaryKey(rewardPunishment);

	}
    
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteRewardPunishment(Long id) {
		RewardPunishment rewardPunishment=rewardPunishmentMapper.selectByPrimaryKey(id);
		rewardPunishment.setState(0);
		rewardPunishment.setCheckStatus(0);
        rewardPunishmentMapper.updateByPrimaryKey(rewardPunishment);
	}

	@Override
	public RewardPunishment queryRewardPunishmentById(Long id) {
		return rewardPunishmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RewardPunishment> queryAllRewardPunishment() {
		return rewardPunishmentMapper.selectAll();
	}

	@Override
	public List<RewardPunishment> queryRewardPunishmentByEmployeeId(Long employeeId) {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("employe",employeeId);
		return rewardPunishmentMapper.selectByExample(example);
	}

	@Override
	public List<RewardPunishment> queryRewardPunishmentWhoIsDelete() {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("state",0);
		return rewardPunishmentMapper.selectByExample(example);
	}
	
	@Override
	public List<RewardPunishment> queryRewardPunishmentWhoisReward() {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("rewardAndPunishment",1);
		return rewardPunishmentMapper.selectByExample(example);
	}

	@Override
	public List<RewardPunishment> queryRewardPunishmentWhoisPunishment() {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("rewardAndPunishment",0);
		return rewardPunishmentMapper.selectByExample(example);
	}

	@Override
	public List<RewardPunishment> queryRewardPunishmentWhoIsNotDelete() {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andNotEqualTo("state",0);
		return rewardPunishmentMapper.selectByExample(example);
	}

	@Override
	public void checkRewardPunishment(Long id) {
		RewardPunishment rewardPunishment=rewardPunishmentMapper.selectByPrimaryKey(id);
		rewardPunishment.setCheckStatus(1);
        rewardPunishmentMapper.updateByPrimaryKey(rewardPunishment);
	}

	@Override
	public RewardPunishment queryRewardPunishmentByEmployeeIdAndCreateTime(Long employeeId, Date createTime) {
		Example example=new Example(RewardPunishment.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("employeeId",employeeId);
		criteria.andEqualTo("createTime",createTime);
		return rewardPunishmentMapper.selectOneByExample(example);
	}
   

}
