package com.tticareer.hrms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
 * <p>CreateTime: 2018年9月21日 下午3:47:57 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: EmployeeService.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: 实现接口EmployeeService</p>
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
		//System.out.println(emp.getState());
		emp.setState(0);
		//System.out.println(emp.getState());
		employeeMapper.updateByPrimaryKey(emp);
	}

	@Override
	public Employee queryEmployeeById(Long id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Employee queryEmployeeByUserName(String userName) {
		//System.out.println(userName);
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userName", userName);
		//System.out.println(employeeMapper.selectOneByExample(example));
		return employeeMapper.selectOneByExample(example);
	}

	@Override
	public List<Employee> queryAllEmployee() {
		/*Employee e =  employeeMapper.selectByPrimaryKey(1L);
		System.out.println(e.getBirthday());
		Tue Sep 25 16:29:06 CST 2018*/
		
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
	public List<Employee> queryEmployeeListByUserName(String userName) {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("userName", "%"+ userName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(employeeMapper.selectByExample(example));
		return employeeMapper.selectByExample(example);
	}

	@Override
	public List<Employee> queryEmployeeListByRealName(String realName) {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("realName", "%"+ realName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(employeeMapper.selectByExample(example));
		return employeeMapper.selectByExample(example);
	}
	
	@Override
	public List<Employee> queryEmployeeListByUserNameAndRealName(String userName,String realName){
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("userName", "%"+ userName+"%");
		criteria.andLike("realName", "%"+ realName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(employeeMapper.selectByExample(example));
		return employeeMapper.selectByExample(example);
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			Employee emp = employeeMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			employeeMapper.updateByPrimaryKey(emp);
			
		}
	}
	
	@Override
	public List<Employee> queryWaitApprove() {
		Example example = new Example(Employee.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkSatus", 0);
		return employeeMapper.selectByExample(example);
	}
}
