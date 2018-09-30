package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.LaborContractMapper;

import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.service.LaborContractService;

import tk.mybatis.mapper.entity.Example;



/**
* @author cfy
* @version 创建时间：2018年9月25日 下午20:47:57
*/
@Service
public class ILaborContractService implements LaborContractService {

	
	@Autowired
	LaborContractMapper laborContractMapper; 
	
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveLaborContract(LaborContract laborContract) {
		// TODO Auto-generated method stub
		laborContractMapper.insert(laborContract);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateLaborContract(LaborContract laborContract) {
		// TODO Auto-generated method stub
		laborContractMapper.updateByPrimaryKey(laborContract);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteLaborContract(Long id) {
		// TODO Auto-generated method stub
		LaborContract lbc = laborContractMapper.selectByPrimaryKey(id);
		if(lbc != null) {
			lbc.setState(0);
		}
	}

	@Override
	public LaborContract queryLaborContractById(Long id) {
		// TODO Auto-generated method stub
		return laborContractMapper.selectByPrimaryKey(id);
	}

	@Override
	public LaborContract queryLaborContractByEmployerName(String employerName) {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employerName", employerName);
		return laborContractMapper.selectOneByExample(example);
	}

	@Override
	public List<LaborContract> queryAllLaborContract() {
		// TODO Auto-generated method stub
		return laborContractMapper.selectAll();
	}

	@Override
	public List<LaborContract> queryLaborContractWhoIsDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return laborContractMapper.selectByExample(example);
	}

	@Override
	public List<LaborContract> queryLaborContractWhoIsNotDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return laborContractMapper.selectByExample(example);
	}

	@Override
	public List<LaborContract> queryLaborContractList(LaborContract laborContract) {
		// TODO Auto-generated method stub
		return null;
	}

}