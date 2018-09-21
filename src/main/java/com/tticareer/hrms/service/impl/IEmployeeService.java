package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.EmployeeMapper;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.service.EmployeeService;

import tk.mybatis.mapper.entity.Example;

/**
* @author dong
* @version 创建时间：2018年9月21日 下午3:47:57
*/
@Service
public class IEmployeeService implements EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveEmployee(Employee employee) {
		employeeMapper.insert(employee);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateByPrimaryKey(employee);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteEmployee(Long id) {
		Employee emp = employeeMapper.selectByPrimaryKey(id);
		emp.setState(0);
	}

	@Override
	public Employee queryEmployeeById(Long id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Employee queryEmployeeByUserName(String userName) {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userName", userName);
		return employeeMapper.selectOneByExample(example);
	}

	@Override
	public List<Employee> queryAllEmployee() {
		return employeeMapper.selectAll();
	}
	
	@Override
	public List<Employee> queryEmployeeWhoIsDelete() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public List<Employee> queryEmployeeWhoIsNotDelete() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public List<Employee> queryOtherEmployee() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public List<Employee> queryPersonnelEmployee() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 2);
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public Employee queryPersonnelManager() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 3);
		return employeeMapper.selectOneByExample(example);
	}

	@Override
	public List<Employee> queryEmployeeList(Employee employee) {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("userName", "%" + employee.getUserName() + "%");
		criteria.andNotEqualTo("state", 0);
		return employeeMapper.selectByExample(example);
	}

}
