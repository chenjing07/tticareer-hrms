package com.tticareer.hrms.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.SalaryDetailMapper;
import com.tticareer.hrms.pojo.SalaryDetail;
import com.tticareer.hrms.service.SalaryDetailService;

import tk.mybatis.mapper.entity.Example;

@Service
public class ISalaryDetailService implements SalaryDetailService {
	@Autowired
	private SalaryDetailMapper salaryDetailMapper;
    
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveSalaryDetail(SalaryDetail salaryDetail) {
          salaryDetailMapper.insert(salaryDetail);
	}
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateSalaryDetail(SalaryDetail salaryDetail) {
		salaryDetailMapper.updateByPrimaryKey(salaryDetail);
	}
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteSalaryDetail(Long id) {
		SalaryDetail salaryDetail=salaryDetailMapper.selectByPrimaryKey(id);
		salaryDetail.setState(0);
		salaryDetail.setCheckStatus(0);
		salaryDetailMapper.updateByPrimaryKey(salaryDetail);
		}

	@Override
	public SalaryDetail querySalaryDetailById(Long id) {
		// TODO Auto-generated method stub
		return salaryDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SalaryDetail> querySalaryDetailByEmployeeId(Long employeeId) {
		Example example=new Example(SalaryDetail.class);
		Example.Criteria criteria= example.createCriteria();
		criteria.andEqualTo("employeId", employeeId);
		 return salaryDetailMapper.selectByExample(example);
	}

	@Override
	public List<SalaryDetail> queryAllSalaryDetail() {
		return salaryDetailMapper.selectAll();
	}

	@Override
	public List<SalaryDetail> querySalaryDetailWhoIsDelete() {
		Example example=new Example(SalaryDetail.class);
		Example.Criteria criteria= example.createCriteria();
		criteria.andEqualTo("state", 0);
		return salaryDetailMapper.selectByExample(example);
	}

	@Override
	public List<SalaryDetail> querySalaryDetailWhoIsNotDelete() {
		Example example=new Example(SalaryDetail.class);
		Example.Criteria criteria= example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return salaryDetailMapper.selectByExample(example);
	}
	@Override
	public void checkSalaryDetail(Long id) {
		SalaryDetail salaryDetail=salaryDetailMapper.selectByPrimaryKey(id);
		salaryDetail.setCheckStatus(1);
		salaryDetailMapper.updateByPrimaryKey(salaryDetail);		
	}
	@Override
	public SalaryDetail querySalaryDetailByEmpIdAndNowYearMonth(Long employeeId, Date nowYearMonth) {
		Example example=new Example(SalaryDetail.class);
		Example.Criteria criteria= example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		criteria.andEqualTo("nowYearMonth", nowYearMonth);
		return salaryDetailMapper.selectOneByExample(example);
	}
}
