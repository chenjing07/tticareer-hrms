package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.ArchivesMapper;
import com.tticareer.hrms.pojo.Archives;
import com.tticareer.hrms.pojo.LaborContract;
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
		Example example = new Example(LaborContract.class);
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
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return archivesMapper.selectByExample(example);
	}

	@Override
	public List<Archives> queryArchivesWhoIsNotDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return archivesMapper.selectByExample(example);
	}

	@Override
	public List<Archives> queryArchivesList(Archives archives) {
		// TODO Auto-generated method stub
		return null;
	}

}
