package com.tticareer.hrms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.EmployeePositionInfoMapper;

import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.service.EmployeePositionInfoService;

import tk.mybatis.mapper.entity.Example;



/**
* @author cfy
* @version 创建时间：2018年9月25日 上午10:40:57
*/
@Service
public class IEmployeePositionInfoService implements EmployeePositionInfoService {

	@Autowired
	EmployeePositionInfoMapper employeePositionInfoMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveEmployeePositionInfo(EmployeePositionInfo employeePositionInfo) {
		// TODO Auto-generated method stub
		employeePositionInfoMapper.insert(employeePositionInfo);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateEmployeePositionInfo(EmployeePositionInfo employeePositionInfo) {
		// TODO Auto-generated method stub
		employeePositionInfoMapper.updateByPrimaryKey(employeePositionInfo);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteEmployeePositionInfo(Long id) {
		// TODO Auto-generated method stub
		EmployeePositionInfo e = employeePositionInfoMapper.selectByPrimaryKey(id);
		if(e != null) {
			e.setState(0);
		}
	}

	@Override
	public EmployeePositionInfo queryEmployeePositionInfoById(Long id) {
		// TODO Auto-generated method stub
		return employeePositionInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		//return employeePositionInfoMapper.;
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return employeePositionInfoMapper.selectByExample(example);
	}

	@Override
	public List<EmployeePositionInfo> queryAllEmployeePositionInfo() {
		// TODO Auto-generated method stub
		return employeePositionInfoMapper.selectAll();
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoIsDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return employeePositionInfoMapper.selectByExample(example);
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoIsNotDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return employeePositionInfoMapper.selectByExample(example);
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoWaitCheck() {
		// TODO Auto-generated method stub
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 0);
		return employeePositionInfoMapper.selectByExample(example);
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoPassCheck() {
		// TODO Auto-generated method stub
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 1);
		return employeePositionInfoMapper.selectByExample(example);
	}

	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoNoPassCheck() {
		// TODO Auto-generated method stub
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 2);
		return employeePositionInfoMapper.selectByExample(example);
	}
	
	
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByEmployeeId(Long employeeId){
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("employeeId", "%"+ employeeId+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return employeePositionInfoMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByCreateTime(Date createTimeStart, Date createTimeEnd){
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();

		if(createTimeStart!=null) {
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		}
		if(createTimeEnd!=null) {
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		}
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return employeePositionInfoMapper.selectByExample(example);
	}
	
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByMore(Long employeeId,
				Date createTimeStart, Date createTimeEnd){
		
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();

		if(employeeId!=null)
			criteria.andLike("employeeId", "%"+ employeeId+"%");
		if(createTimeStart!=null) {
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		}
		if(createTimeEnd!=null) {
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		}
		criteria.andNotEqualTo("state", 0);
		return employeePositionInfoMapper.selectByExample(example);
	}
	

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			EmployeePositionInfo emp = employeePositionInfoMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			employeePositionInfoMapper.updateByPrimaryKey(emp);
			
		}
		
		
	}
	
}
