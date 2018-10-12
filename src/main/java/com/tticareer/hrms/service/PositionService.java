package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.Position;



/**
* @author cfy
* @version 创建时间：2018年9月26日 上午9:12:00
*/
public interface PositionService {
	/**
	 * 添加岗位
	 * @param position
	 */
	public void savePosition(Position position);
	
	/**
	 * 更新岗位
	 * @param position
	 */
	public void updatePosition(Position position);
	
	/**
	 * 根据  id 删除岗位，非物理删除，状态设置为0
	 * @param id
	 */
	public void deletePosition(Long id);
	
	/**
	 * 通过  id 搜索岗位
	 * @param id
	 * @return
	 */
	public Position queryPositionById(Long id);
	
	/**
	 * 根据  positionNumber 搜索岗位
	 * @param positionNumber
	 * @return
	 */
	public Position queryPositionByPositionNumber(String positionNumber);
	
	/**
	 * 根据  positionName 搜索岗位
	 * @param positionName
	 * @return
	 */
	public Position queryPositionByPositionName(String positionName);
	
	/**
	 * 查询所有岗位，包括所有状态
	 * @return
	 */
	public List<Position> queryAllPosition();
	
	/**
	 * 查询已被删除即状态为0的岗位
	 * @return
	 */
	public List<Position> queryPositionWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的岗位
	 * @return
	 */
	public List<Position> queryPositionWhoIsNotDelete();
	
	
	/**
	 * 根据岗位工号模糊查询
	 * @param position
	 * @return
	 */
	public List<Position> queryPositionList(Position position);
	
	public List<Position> queryPositionListByPositionNumber(String positionNumber);
	public List<Position> queryPositionListByPositionName(String positionName);
	public List<Position> queryPositionListByPositionNumberAndPositionName(String positionNumber,String positionName);
	
}
