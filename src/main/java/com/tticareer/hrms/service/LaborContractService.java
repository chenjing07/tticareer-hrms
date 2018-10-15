package com.tticareer.hrms.service;

import java.util.Date;
import java.util.List;


import com.tticareer.hrms.pojo.LaborContract;



/**
* @author cfy
* @version 创建时间：2018年9月25日 下午19:39:03
*/
public interface LaborContractService {
	/**
	 * 添加合同
	 * @param laborContract
	 */
	public void saveLaborContract(LaborContract laborContract);
	
	/**
	 * 更新合同
	 * @param laborContract
	 */
	public void updateLaborContract(LaborContract laborContract);
	
	/**
	 * 根据  id 删除合同，非物理删除，状态设置为0
	 * @param id
	 */
	public void deleteLaborContract(Long id);
	
	/**
	 * 通过  id 搜索合同
	 * @param id
	 * @return
	 */
	public LaborContract queryLaborContractById(Long id);
	
	/**
	 * 根据  employerName 搜索合同
	 * @param employerName
	 * @return
	 */
	public LaborContract queryLaborContractByEmployerName(String employerName);
	
	/**
	 * 查询所有合同，包括所有状态
	 * @return
	 */
	public List<LaborContract> queryAllLaborContract();
	
	/**
	 * 查询已被删除即状态为0的合同
	 * @return
	 */
	public List<LaborContract> queryLaborContractWhoIsDelete();
	
	/**
	 * 查询没有被删除即状态不为0的合同
	 * @return
	 */
	public List<LaborContract> queryLaborContractWhoIsNotDelete();
	
	/**
	 * 查询状态为1，即其他合同
	 * @return
	 */
	//public List<LaborContract> queryOtherLaborContract();
	
	/**
	 * 查询状态为2，即人事部普通合同
	 * @return
	 */
	//public List<LaborContract> queryPersonnelLaborContract();
	
	/**
	 * 查询状态为3，即人事部经理
	 * @return
	 */
	//public LaborContract queryPersonnelManager();
	
	/**
	 * 根据合同工号模糊查询
	 * @param laborContract
	 * @return
	 */
	public List<LaborContract> queryLaborContractList(LaborContract laborContract);
	
	
	
	public List<LaborContract> queryLaborContractListByEmployerName(String employerName);
	public List<LaborContract> queryLaborContractListByEmployeeId(Long employeeId);
	public List<LaborContract> queryLaborContractListByCreateTime(Date createTimeStart, Date createTimeEnd);
	public List<LaborContract> queryLaborContractListByMore(String employerName,Long employeeId,Date createTimeStart, Date createTimeEnd);
	
	
	public void deleteAll(Long[] ids);
	
	
	public List<LaborContract> queryWaitApprove();
}
