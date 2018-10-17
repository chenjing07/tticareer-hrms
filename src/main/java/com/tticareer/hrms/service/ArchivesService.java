package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.Archives;



/**
* @author cfy
* @version 创建时间：2018年9月26日 上午8:40:00
*/
public interface ArchivesService {
	/**
	 * 添加档案
	 * @param archives
	 */
	public void saveArchives(Archives archives);
	
	/**
	 * 更新档案
	 * @param archives
	 */
	public void updateArchives(Archives archives);
	
	/**
	 * 根据  id 删除档案，非物理删除，状态设置为0
	 * @param id
	 */
	public void deleteArchives(Long id);
	
	/**
	 * 通过  id 搜索档案
	 * @param id
	 * @return
	 */
	public Archives queryArchivesById(Long id);
	
	/**
	 * 根据  employerId 搜索档案
	 * @param employerId
	 * @return
	 */
	public Archives queryArchivesByEmployerId(Long employerId);
	
	/**
	 * 查询所有档案，包括所有状态
	 * @return
	 */
	public List<Archives> queryAllArchives();
	
	/**
	 * 查询已被删除即状态为0的档案
	 * @return
	 */
	public List<Archives> queryArchivesWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的档案
	 * @return
	 */
	public List<Archives> queryArchivesWhoIsNotDelete();
	
	
	/**
	 * 根据档案工号模糊查询
	 * @param archives
	 * @return
	 */
	public List<Archives> queryArchivesList(Archives archives);
	
	
	
	


	public List<Archives> queryArchivesListByEmployeeId(Long employeeId);
	public List<Archives> queryArchivesListByCreateTime(Date createTimeStart, Date createTimeEnd);
	public List<Archives> queryArchivesListByMore(Long employeeId,Date createTimeStart, Date createTimeEnd);
	
	

	public void deleteAll(Long[] ids);
	
	
	public List<Archives> queryWaitApprove();
}
