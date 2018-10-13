package com.tticareer.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tticareer.hrms.mapper.PositionMapper;
import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.pojo.Position;
import com.tticareer.hrms.service.PositionService;

import tk.mybatis.mapper.entity.Example;

/**
* @author cfy
* @version 创建时间：2018年9月26日 上午9:16:00
*/
@Service
public class IPositionService implements PositionService {

	@Autowired
	PositionMapper positionMapper;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void savePosition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.insertSelective(position);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void updatePosition(Position position) {
		// TODO Auto-generated method stub
		positionMapper.updateByPrimaryKey(position);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deletePosition(Long id) {
		// TODO Auto-generated method stub
		Position p = positionMapper.selectByPrimaryKey(id);
		if(p!=null) {
			p.setState(0);
		}
	}

	@Override
	public Position queryPositionById(Long id) {
		// TODO Auto-generated method stub
		return positionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Position queryPositionByPositionNumber(String positionNumber) {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("positionNumber", positionNumber);
		return positionMapper.selectOneByExample(example);
	}

	@Override
	public Position queryPositionByPositionName(String positionName) {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("positionName", positionName);
		return positionMapper.selectOneByExample(example);
	}

	@Override
	public List<Position> queryAllPosition() {
		// TODO Auto-generated method stub
		return positionMapper.selectAll();
	}

	@Override
	public List<Position> queryPositionWhoIsDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("state", 0);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> queryPositionWhoIsNotDelete() {
		// TODO Auto-generated method stub
		Example example = new Example(LaborContract.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("state", 0);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> queryPositionList(Position position) {
		// TODO Auto-generated method stub
		Example example = new Example(Position.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("positionName", "%" + position.getPositionName() + "%");
		criteria.andNotEqualTo("state", 0);
		return positionMapper.selectByExample(example);
	}

	
	@Override
	public List<Position> queryPositionListByPositionNumber(String positionNumber) {
		Example example = new Example(Position.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("positionNumber", "%"+ positionNumber+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(positionMapper.selectByExample(example));
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> queryPositionListByPositionName(String positionName) {
		Example example = new Example(Position.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("positionName", "%"+ positionName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(positionMapper.selectByExample(example));
		return positionMapper.selectByExample(example);
	}
	
	@Override
	public List<Position> queryPositionListByPositionNumberAndPositionName(String positionNumber,String positionName){
		Example example = new Example(Position.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("positionNumber", "%"+ positionNumber+"%");
		criteria.andLike("positionName", "%"+ positionName+"%");
		criteria.andNotEqualTo("state", 0);
		//System.out.println(positionMapper.selectByExample(example));
		return positionMapper.selectByExample(example);
	}
	
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void deleteAll(Long[] ids) {
		
		for(int i=0;i<ids.length;i++) {
			Position emp = positionMapper.selectByPrimaryKey(ids[i]);
			System.out.println(ids[i]);
			emp.setState(0);
			//System.out.println(emp.getState());
			positionMapper.updateByPrimaryKey(emp);
			
		}
		
		
	}
	
}
