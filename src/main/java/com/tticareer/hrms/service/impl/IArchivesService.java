package com.tticareer.hrms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.tticareer.hrms.mapper.ArchivesMapper;
import com.tticareer.hrms.pojo.Archives;

import com.tticareer.hrms.service.ArchivesService;

import tk.mybatis.mapper.entity.Example;



/**
* @author cfy
* @version 创建时间：2018年9月26日 上午8:47:57
*/
@Service
public class IArchivesService implements ArchivesService {

	@Autowired
	ArchivesMapper archivesMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void saveArchives(Archives archives) {
		// TODO Auto-generated method stub
		archivesMapper.insert(archives);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updateArchives(Archives archives) {
		// TODO Auto-generated method stub
		archivesMapper.updateByPrimaryKey(archives);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteArchives(Long id) {
		// TODO Auto-generated method stub
		Archives arc = archivesMapper.selectByPrimaryKey(id);
		if(arc != null) {
			arc.setState(0);
		}
		
	}

	@Override
	public Archives queryArchivesById(Long id) {
		// TODO Auto-generated method stub
		return archivesMapper.selectByPrimaryKey(id);
	}

	@Override
	public Archives queryArchivesByEmployerId(Long employerId) {
		// TODO Auto-generated method stub
		Example example = new Example(Archives.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("employerId", employerId);
		return archivesMapper.selectOneByExample(example);
	}

	@Override
	public List<Archives> queryAllArchives() {
		// TODO Auto-generated method stub
		return archivesMapper.selectAll();
	}

	@Override
	public List<Archives> queryArchivesWhoIsDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(Archives.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return archivesMapper.selectByExample(example);
	}

	@Override
	public List<Archives> queryArchivesWhoIsNotDelete(Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(Archives.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return archivesMapper.selectByExample(example);
	}

	@Override
	public List<Archives> queryArchivesList(Archives archives) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public List<Archives> queryArchivesListByEmployeeId(String userName,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		

		List<Archives> result =archivesMapper.queryJoinEmployeeAndArc(userName);
		//System.out.println("-----"+result.toString());
		return result;
	}
	
	@Override
	public List<Archives> queryArchivesListByCreateTime(Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(Archives.class);
		Example.Criteria criteria = example.createCriteria();

		if(createTimeStart!=null) {
			criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
		}
		if(createTimeEnd!=null) {
			criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
		}
		criteria.andNotEqualTo("state", 0);
		//System.out.println(departmentMapper.selectByExample(example));
		return archivesMapper.selectByExample(example);
	}
	
	@Override
	public List<Archives> queryArchivesListByMore(String userName,
				Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		if(userName!=null) {
			if(userName!=null && createTimeStart==null && createTimeEnd==null) {
				List<Archives> result =archivesMapper.queryJoinEmployeeAndArc(userName);
				return result;
			}
			else if(createTimeStart!=null && createTimeEnd==null) {
				//System.out.println("--");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createTimeStart);
				List<Archives> result =archivesMapper.queryJoinEmployeeAndArcTS(userName,dateString);
				return result;
			}
			else if(createTimeStart==null && createTimeEnd!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(createTimeEnd);
				List<Archives> result =archivesMapper.queryJoinEmployeeAndArcTE(userName,dateString);
				return result;
			}
			else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStringStart = formatter.format(createTimeStart);
				String dateStringEnd = formatter.format(createTimeEnd);
				List<Archives> result =archivesMapper.queryJoinEmployeeAndArcTSAndE(userName,dateStringStart,dateStringEnd);
				return result;
			}
		}else {
			if(createTimeStart!=null&&createTimeEnd==null) {
				Example example = new Example(Archives.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
				criteria.andNotEqualTo("state", 0);
				return archivesMapper.selectByExample(example);
			}
			else if(createTimeStart==null&&createTimeEnd!=null) {
				Example example = new Example(Archives.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andNotEqualTo("state", 0);
				return archivesMapper.selectByExample(example);
			}else if(createTimeStart!=null&&createTimeEnd!=null){
				Example example = new Example(Archives.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andLessThanOrEqualTo("createTime", createTimeEnd);
				criteria.andNotEqualTo("state", 0);
				return archivesMapper.selectByExample(example);
			}else {
				Example example = new Example(Archives.class);
				Example.Criteria criteria = example.createCriteria();
				criteria.andNotEqualTo("state", 0);
				return archivesMapper.selectByExample(example);
			}
		
		}
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			Archives emp = archivesMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			archivesMapper.updateByPrimaryKey(emp);
			
		}		
	}
	
	

	@Override
	public List<Archives> queryWaitApprove(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(Archives.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("checkStatus", 0);
		return archivesMapper.selectByExample(example);
	}
	
}
