package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.pojo.LaborContract;


/**
* @author cfy
* @version 创建时间：2018年9月25日 上午9:17:03
*/
public interface EmployeePositionInfoService {

	/**
	 * 添加人员调动信息
	 * @param employeePositionInfo
	 */
	public void saveEmployeePositionInfo(EmployeePositionInfo employeePositionInfo);
	
	/**
	 * 更新人员调动信息
	 * @param employeePositionInfo
	 */
	public void updateEmployeePositionInfo(EmployeePositionInfo employeePositionInfo);
	
	/**
	 * 根据  id 删除人员调动信息，非物理删除，状态设置为0
	 * @param id
	 */
	public void deleteEmployeePositionInfo(Long id);
	
	/**
	 * 通过  id 搜索人员调动信息
	 * @param id
	 * @return
	 */
	public EmployeePositionInfo queryEmployeePositionInfoById(Long id);
	
	/**
	 * 根据  员工id 搜索人员调动信息
	 * @param employeeId
	 * @return
	 */
	public EmployeePositionInfo queryEmployeePositionInfoByEmployeeId(Long employeeId);
	
	/**
	 * 查询所有人员调动信息，包括所有状态
	 * @return
	 */
	public List<EmployeePositionInfo> queryAllEmployeePositionInfo();
	
	/**
	 * 查询已被删除即状态为0的人员调动信息
	 * @return
	 */
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的人员调动信息
	 * @return
	 */
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoIsNotDelete(Integer pageNum,Integer pageSize);
	
	/**
	 * 查询审核状态为0，即待审核
	 * @return
	 */
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoWaitCheck();
	
	/**
	 * 查询审核状态为1，即通过审核
	 * @return
	 */
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoPassCheck();
	
	/**
	 *  查询审核状态为2，即未通过审核
	 * @return
	 */
	public List<EmployeePositionInfo> queryEmployeePositionInfoWhoNoPassCheck();
	
	/**
	 * 根据员工工号模糊查询
	 * @param employee
	 * @return
	 */
	//public List<EmployeePositionInfo> queryEmployeePositionInfoList(EmployeePositionInfo employeePositionInfo);
	
	

	//public List<EmployeePositionInfo> queryEmployeePositionInfoListByEmployeeId(Long employeeId,Integer pageNum,Integer pageSize,String orderBy);
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByEmployeeId(String userName,Integer pageNum,Integer pageSize);
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByCreateTime(Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize);
	//public List<EmployeePositionInfo> queryEmployeePositionInfoListByMore(Long employeeId,Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<EmployeePositionInfo> queryEmployeePositionInfoListByMore(String userName,Date createTimeStart, Date createTimeEnd,Integer pageNum,Integer pageSize);
	
	
	public void deleteAll(Long[] ids);
	
	
	public List<EmployeePositionInfo> queryWaitApprove(Integer pageNum,Integer pageSize);
	
	
	public List<EmployeePositionInfo> queryJoinEmployeeAndEmP(String userName);
	
}
