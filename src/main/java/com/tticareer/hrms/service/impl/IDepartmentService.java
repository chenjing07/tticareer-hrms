package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.DepartmentMapper;
import com.tticareer.hrms.pojo.Department;

import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.service.DepartmentService;

import tk.mybatis.mapper.entity.Example;

/**
* @author cfy
* @version 创建时间：2018年9月26日 上午9:05:00
*/
@Service
public class IDepartmentService implements DepartmentService {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.insert(department);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.updateByPrimaryKey(department);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		Department dpm = departmentMapper.selectByPrimaryKey(id);
		if(dpm!=null) {
			dpm.setState(0);
		}
	}

	@Override
	public Department queryDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public Department queryDepartmentByDepartmentName(String departmentName) {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("departmentName", departmentName);
		return departmentMapper.selectOneByExample(example);
	}

	@Override
	public List<Department> queryAllDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.selectAll();
	}

	@Override
	public List<Department> queryDepartmentWhoIsDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> queryDepartmentWhoIsNotDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> queryDepartmentList(Department department) {
		// TODO Auto-generated method stub
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentName", "%" + department.getDepartmentName() + "%");
		criteria.andNotEqualTo("state", 0);
		return departmentMapper.selectByExample(example);
	}

	
	
	@Override
	public List<Department> queryDepartmentListByDepartmentNumber(String departmentNumber) {
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentNumber", "%"+ departmentNumber+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> queryDepartmentListByDepartmentName(String departmentName) {
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentName", "%"+ departmentName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}
	
	@Override
	public List<Department> queryDepartmentListByDepartmentNumberAndDepartmentName(String departmentNumber,String departmentName){
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentNumber", "%"+ departmentNumber+"%");
		criteria.andLike("departmentName", "%"+ departmentName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}
}
