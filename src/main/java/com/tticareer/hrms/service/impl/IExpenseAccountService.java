package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.ExpenseAccountMapper;
import com.tticareer.hrms.pojo.ExpenseAccount;
import com.tticareer.hrms.service.ExpenseAccountService;

import tk.mybatis.mapper.entity.Example;


@Service
public class IExpenseAccountService implements ExpenseAccountService {
	@Autowired
	private ExpenseAccountMapper expenseAccountMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveExpenseAccount(ExpenseAccount expenseAccount) {
		expenseAccountMapper.insert(expenseAccount);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateExpenseAccount(ExpenseAccount expenseAccount) {
		expenseAccountMapper.updateByPrimaryKey(expenseAccount);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteExpenseAccount(Long id) {
		ExpenseAccount expenseAccount=expenseAccountMapper.selectByPrimaryKey(id);
		expenseAccount.setState(0);
		expenseAccount.setCheckStatus(0);
		expenseAccountMapper.updateByPrimaryKey(expenseAccount);
	}

	@Override
	public List<ExpenseAccount> queryAllExpenseAccount(Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		return expenseAccountMapper.selectAll();
	}

	@Override
	public List<ExpenseAccount> queryExpenseAccountWhoIsDelete() {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("state",0);
		return expenseAccountMapper.selectByExample(example);
	}

	@Override
	public List<ExpenseAccount> queryExpenseAccountWhoIsNotDelete(Integer page,Integer pageSize) {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("state",1);
		PageHelper.startPage(page, pageSize);
		return expenseAccountMapper.selectByExample(example);
	}

	@Override
	public ExpenseAccount queryExpenseAccoutById(Long id) {
		return expenseAccountMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ExpenseAccount> queryExpenseAccountByEmployeeId(Integer page,Integer pageSize,Long employeeId) {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("employeeId",employeeId);
		PageHelper.startPage(page, pageSize);
		return expenseAccountMapper.selectByExample(example);
	}

	@Override
	public ExpenseAccount queryExpenseAccoountByEmployeeIdAndCreateTime(Long employeeId, Date createTime) {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andEqualTo("employeeId",employeeId);
		criteria.andEqualTo("createTime",createTime);
		return expenseAccountMapper.selectOneByExample(example);
	}

	@Override
	public void checkExpenseAccount(Long id) {
	   ExpenseAccount expenseAccount=expenseAccountMapper.selectByPrimaryKey(id);
       expenseAccount.setCheckStatus(1);
       expenseAccountMapper.updateByPrimaryKey(expenseAccount);
	}

	@Override
	public List<ExpenseAccount> queryExpenseAccountByTime(Integer page, Integer pageSize, Date dateStart,
			Date dateEnd) {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andBetween("time", dateStart, dateEnd);
		PageHelper.startPage(page, pageSize);
		return expenseAccountMapper.selectByExample(example);
	}

	@Override
	public List<ExpenseAccount> queryExpenseAccountByEmployeeIdAndTime(Integer page, Integer pageSize, Long employeeId,
			Date dateStart, Date dateEnd) {
		Example example=new Example(ExpenseAccount.class);
		Example.Criteria criteria=example.createCriteria();
		criteria.andBetween("time", dateStart, dateEnd);
		criteria.andEqualTo("employeeId", employeeId);
		PageHelper.startPage(page, pageSize);
		return expenseAccountMapper.selectByExample(example);
	}

}
