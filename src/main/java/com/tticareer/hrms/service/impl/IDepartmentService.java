package com.tticareer.hrms.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.DepartmentMapper;
import com.tticareer.hrms.pojo.Department;

import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.pojo.dto.DepartmentIdAndName;

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
		Example example = new Example(Department.class);
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
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> queryDepartmentWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Department.class);
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
	public List<Department> queryDepartmentListByDepartmentNumber(String departmentNumber,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentNumber", "%"+ departmentNumber+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> queryDepartmentListByDepartmentName(String departmentName,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentName", "%"+ departmentName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}
	
	@Override
	public List<Department> queryDepartmentListByDepartmentNumberAndDepartmentName(String departmentNumber,String departmentName,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("departmentNumber", "%"+ departmentNumber+"%");
		criteria.andLike("departmentName", "%"+ departmentName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return departmentMapper.selectByExample(example);
	}
	
	
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			Department emp = departmentMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			departmentMapper.updateByPrimaryKey(emp);
			
		}
		
	}
	
	

	@Override
	public List<Department> queryWaitApprove(Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 0);
		return departmentMapper.selectByExample(example);
	}
	
	@Override
	public List<DepartmentIdAndName> getDepartmentIdAndName(){
		
		Example example = new Example(Department.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 1);
		criteria.andEqualTo("checkStatus", 1);
		List<Department> departments = departmentMapper.selectByExample(example);
		
		
		List<DepartmentIdAndName> departmentSuperiors = new ArrayList<DepartmentIdAndName>();
		
		for( int i = 0 ; i < departments.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
		    //System.out.println(departments.get(i).get);
			DepartmentIdAndName departmentSuperior = new DepartmentIdAndName();
			departmentSuperior.setDepartmentId(departments.get(i).getId());
			departmentSuperior.setDepartmentName(departments.get(i).getDepartmentName());
			departmentSuperiors.add(departmentSuperior);
			//System.out.println(i+"*********"+departmentSuperiors.get(i).getSuperiorDepartmentId()+"**********"+
			//		departmentSuperiors.get(i).getDepartmentName());
		}
		/*System.out.println(0+"*********"+departmentSuperiors.get(0).getSuperiorDepartmentId()+"**********"+
				departmentSuperiors.get(0).getDepartmentName());*/
		return departmentSuperiors;
	}
}
