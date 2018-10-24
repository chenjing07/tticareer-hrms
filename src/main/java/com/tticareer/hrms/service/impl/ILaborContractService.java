package com.tticareer.hrms.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
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
	public List<LaborContract> queryLaborContractWhoIsNotDelete(Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
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
	
	
	@Override
	public List<LaborContract> queryLaborContractListByEmployerName(String employerName,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("employerName", "%"+ employerName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return laborContractMapper.selectByExample(example);
	}
	
	
	@Override
	public List<LaborContract> queryLaborContractListByEmployeeId(String userName,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaC(userName);
		return result;
	}
	
	@Override
	public List<LaborContract> queryLaborContractListByCreateTime(Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		if(createTimeStart!=null) {
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		}
		if(createTimeEnd!=null) {
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		}
		criteria.andNotEqualTo("state", 0);
		return laborContractMapper.selectByExample(example);
	}
	
	@Override
	public List<LaborContract> queryLaborContractListByMore(String employerName,String userName,
				Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if(employerName!="") {
			if(userName=="" && createTimeStart==null && createTimeEnd==null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLike("employerName", "%"+ employerName+"%");
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);   
			}else if(userName=="" && createTimeStart!=null && createTimeEnd==null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLike("employerName", "%"+ employerName+"%");
				if(createTimeStart!=null) {
					criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName=="" && createTimeStart==null && createTimeEnd!=null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLike("employerName", "%"+ employerName+"%");
				if(createTimeEnd!=null) {
					criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName=="" && createTimeStart!=null && createTimeEnd!=null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLike("employerName", "%"+ employerName+"%");
				if(createTimeStart!=null) {
					criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				}
				if(createTimeEnd!=null) {
					criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName!="" && createTimeStart==null && createTimeEnd==null) {
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCENAndUN(employerName,userName);
				return result;
			}else if(userName!="" && createTimeStart!=null && createTimeEnd==null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCENAndUNAndTS(employerName,userName,dateStringStart);
				return result;
			}else if(userName!="" && createTimeStart==null && createTimeEnd!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringEnd = formatter.format(createTimeEnd);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCENAndUNAndTE(employerName,userName,dateStringEnd);
				return result;
			}else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				String dateStringEnd = formatter.format(createTimeEnd);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCENAndUNAndTSE(employerName,userName,dateStringStart,dateStringEnd);
				return result;
			}
		}
		else{
			if(userName=="" && createTimeStart==null && createTimeEnd==null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName=="" && createTimeStart!=null && createTimeEnd==null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				if(createTimeStart!=null) {
					criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName=="" && createTimeStart==null && createTimeEnd!=null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				if(createTimeEnd!=null) {
					criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName=="" && createTimeStart!=null && createTimeEnd!=null) {
				Example example = new Example(LaborContract.class);
				Example.Criteria criteria = example.createCriteria();
				if(createTimeStart!=null) {
					criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				}
				if(createTimeEnd!=null) {
					criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				}
				criteria.andNotEqualTo("state", 0);
				return laborContractMapper.selectByExample(example);
			}else if(userName!="" && createTimeStart==null && createTimeEnd==null) {
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaC(userName);
				return result;
			}else if(userName!="" && createTimeStart!=null && createTimeEnd==null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCUNAndTS(userName,dateStringStart);
				return result;
			}else if(userName!="" && createTimeStart==null && createTimeEnd!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringEnd = formatter.format(createTimeEnd);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCUNAndTE(userName,dateStringEnd);
				return result;
			}else  {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				String dateStringEnd = formatter.format(createTimeEnd);
				List<LaborContract> result =laborContractMapper.queryJoinEmployeeAndLaCUNAndTSE(userName,dateStringStart,dateStringEnd);
				return result;
			}
		
		}
	}
	

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			LaborContract emp = laborContractMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			laborContractMapper.updateByPrimaryKey(emp);
			
		}
	
	}
	

	@Override
	public List<LaborContract> queryWaitApprove(Integer pageNum,Integer pageSize ) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 0);
		return laborContractMapper.selectByExample(example);
	}
	
	
	

}
