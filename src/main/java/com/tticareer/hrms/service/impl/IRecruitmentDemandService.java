package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.RecruitmentDemandMapper;
import com.tticareer.hrms.pojo.RecruitmentDemand;
import com.tticareer.hrms.service.RecruitmentDemandService;

import tk.mybatis.mapper.entity.Example;

@Service
public class IRecruitmentDemandService implements RecruitmentDemandService {

	@Autowired
	RecruitmentDemandMapper rdMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveRecruitmentDemand(RecruitmentDemand rd) {
		rdMapper.insert(rd);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateRecruitmentDemand(RecruitmentDemand rd) {
		rdMapper.updateByPrimaryKey(rd);

	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteRecruitmentDemand(Long id) {
		RecruitmentDemand rd = rdMapper.selectByPrimaryKey(id);
		rd.setState(0);
		rdMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void deleteRecruitmentDemand(Long[] ids) {
		for (Long id : ids) {
			RecruitmentDemand rd = rdMapper.selectByPrimaryKey(id);
			rd.setState(0);
			rdMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public RecruitmentDemand queryRecruitmentDemandById(Long id) {
		return rdMapper.selectByPrimaryKey(id);
	}

	@Override
	public RecruitmentDemand queryRecruitmentDemandByPositionId(Long positionId) {
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("positionId", positionId);
		return rdMapper.selectOneByExample(example);
	}

	@Override
	public List<RecruitmentDemand> queryAllRecruitmentDemand() {
		return rdMapper.selectAll();
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsDelete() {
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsNotDelete() {
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

	@Override
	public List<RecruitmentDemand> queryRecruitmentDemandList(RecruitmentDemand rd) {
		Example example = new Example(RecruitmentDemand.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("supplementReason", "%" + rd.getSupplementReason() + "%");
		criteria.andNotEqualTo("state", 0);
		return rdMapper.selectByExample(example);
	}

}
