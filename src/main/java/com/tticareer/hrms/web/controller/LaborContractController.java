package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.tticareer.hrms.pojo.LaborContract;
import com.tticareer.hrms.service.LaborContractService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月25日 下午20:47:57
*/
@RestController
@RequestMapping("/laborContract")
public class LaborContractController {

	@Autowired
	LaborContractService laborContractService;
	
	
	/**
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param laborContract
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveLaborContract(@RequestBody LaborContract laborContract) {
		laborContractService.saveLaborContract(laborContract);
		/*LaborContract emp = laborContractService.queryLaborContractByEmployerName(laborContract.getEmployerName());
		if (emp!=null) {
			String data = emp.getId()+"";
			return JSONResult.ok(data);
		} else {
			String msg = "未知错误，数据未录入";
			return JSONResult.errorMsg(msg);
		}*/
		return JSONResult.ok();
	}
	
	/**
	 * 查询所有合同信息
	 * @return
	 */
	@GetMapping
	public JSONResult queryRealAllLaborContract() {
		return JSONResult.ok(laborContractService.queryAllLaborContract());
	}
	
	/**
	 * 查询已被删除的合同
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryLaborContractWhoIsDelete() {
		return JSONResult.ok(laborContractService.queryLaborContractWhoIsDelete());
	}
	
	/**
	 * 查询未被删除的合同
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryLaborContractWhoIsNotDelete() {
		return JSONResult.ok(laborContractService.queryLaborContractWhoIsNotDelete());
	}
	
	
	/**
	 * 修改合同信息
	 * @param laborContract
	 * @return
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateLaborContract(@PathVariable("id") Long id,@RequestBody LaborContract laborContract) {
		LaborContract entity = laborContractService.queryLaborContractById(id);
		if(entity!=null) {
			BeanUtils.copyProperties(laborContract, entity);//使用自定义的BeanUtils
			//leaveService.save(entity);
			laborContractService.updateLaborContract(entity);
		}
		
		LaborContract data = laborContractService.queryLaborContractById(id);
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除合同，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public JSONResult deleteLaborContract(@Param("id") Long id) {
		
		laborContractService.deleteLaborContract(id);
		if (laborContractService.queryLaborContractById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
}
