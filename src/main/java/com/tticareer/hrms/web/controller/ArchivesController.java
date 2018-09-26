package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Archives;
import com.tticareer.hrms.service.ArchivesService;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月26日 上午10:07:00
*/
@RestController
@RequestMapping("/archives")
public class ArchivesController {
	
	@Autowired
	ArchivesService archivesService;
	
	
	
	/**

	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param archives
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveArchives(Archives archives) {
		archivesService.saveArchives(archives);
		Archives emp = archivesService.queryArchivesById(archives.getId());
		if (emp!=null) {
			String data = emp.getId()+"";
			return JSONResult.ok(data);
		} else {
			String msg = "未知错误，数据未录入";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 查询所有档案信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllArchives() {
		return JSONResult.ok(archivesService.queryAllArchives());
	}
	
	/**
	 * 查询已被删除的档案
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryArchivesWhoIsDelete() {
		return JSONResult.ok(archivesService.queryArchivesWhoIsDelete());
	}
	
	/**
	 * 查询未被删除的档案
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryArchivesWhoIsNotDelete() {
		return JSONResult.ok(archivesService.queryArchivesWhoIsNotDelete());
	}
	
	
	
	/**
	 * 修改档案信息
	 * @param archives
	 * @return
	 */
	@PutMapping
	public JSONResult updateArchives(Archives archives) {
		archivesService.updateArchives(archives);
		Archives data = archivesService.queryArchivesById(archives.getId());
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除档案，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public JSONResult deleteArchives(@Param("id") Long id) {
		archivesService.deleteArchives(id);
		if (archivesService.queryArchivesById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
}
