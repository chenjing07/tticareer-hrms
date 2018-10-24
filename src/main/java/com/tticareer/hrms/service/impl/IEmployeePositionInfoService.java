package com.tticareer.hrms.service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
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
	public EmployeePositionInfo queryEmployeePositionInfoByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		//return employeePositionInfoMapper.;
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employeeId", employeeId);
		return employeePositionInfoMapper.selectOneByExample(example);
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
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoIsNotDelete(Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
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
	
	
	/*@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByEmployeeId(Long employeeId,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("employeeId", "%"+ employeeId+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return employeePositionInfoMapper.selectByExample(example);
	}*/
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByEmployeeId(String userName,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmP(userName);
		//System.out.println("-----"+result.toString());
		return result;
	}
	
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByCreateTime(Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
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
	
	/*@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByMore(Long employeeId,
				Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy) {
		PageHelper.startPage(pageNum, pageSize,orderBy);
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
	}*/
	@Override
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByMore(String userName,
			Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		if(userName!=null) {
			if(userName!=null && createTimeStart==null && createTimeEnd==null) {
				List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmP(userName);
				return result;
			}
			else if(createTimeStart!=null && createTimeEnd==null) {
				//System.out.println("--");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createTimeStart);
				List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmPTS(userName,dateString);
				return result;
			}
			else if(createTimeStart==null && createTimeEnd!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createTimeEnd);
				List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmPTE(userName,dateString);
				return result;
			}
			else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				String dateStringEnd = formatter.format(createTimeEnd);
				List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmPTSAndE(userName,dateStringStart,dateStringEnd);
				return result;
			}
		}else {
			if(createTimeStart!=null&&createTimeEnd==null) {
				Example example = new Example(EmployeePositionInfo.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				criteria.andNotEqualTo("state", 0);
				return employeePositionInfoMapper.selectByExample(example);
			}
			else if(createTimeStart==null&&createTimeEnd!=null) {
				Example example = new Example(EmployeePositionInfo.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andNotEqualTo("state", 0);
				return employeePositionInfoMapper.selectByExample(example);
			}else if(createTimeStart!=null&&createTimeEnd!=null){
				Example example = new Example(EmployeePositionInfo.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andNotEqualTo("state", 0);
				return employeePositionInfoMapper.selectByExample(example);
			}else {
				Example example = new Example(EmployeePositionInfo.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andNotEqualTo("state", 0);
				return employeePositionInfoMapper.selectByExample(example);
			}
		
		}
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
	
	@Override
	public List<EmployeePositionInfo> queryWaitApprove(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(EmployeePositionInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 0);
		return employeePositionInfoMapper.selectByExample(example);
	}
	
	
	@Override
	public List<EmployeePositionInfo> queryJoinEmployeeAndEmP(String userName) {
		//PageHelper.startPage(pageNum, pageSize,orderBy);
		//Example example = new Example(EmployeePositionInfo.class);
		//Example.Criteria criteria = example.createCriteria();
		//criteria.andEqualTo("checkStatus", 0);
		//return employeePositionInfoMapper.selectByExample(example);
		
		/*List<EmployeePositionInfo> result =employeePositionInfoMapper.queryJoinEmployeeAndEmP("SELECT * FROM employee_position_info where employee_id in(" + 
				"SELECT id FROM employee where user_name like '%"+userName+"%' )and state != 0" );*/
		return null;
	}
	
}
