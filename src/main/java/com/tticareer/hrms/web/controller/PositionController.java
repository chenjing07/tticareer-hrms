package com.tticareer.hrms.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tticareer.hrms.pojo.Position;
import com.tticareer.hrms.service.PositionService;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月26日 上午10:40:00
*/
@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	PositionService positionService;
	
	
	
	/**

	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param position
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult savePosition(@RequestBody Position position) {
		positionService.savePosition(position);
		Position emp = positionService.queryPositionById(position.getId());
		if (emp!=null) {
			String data = emp.getId()+"";
			return JSONResult.ok(data);
		} else {
			String msg = "未知错误，数据未录入";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 查询所有岗位信息
	 * @return
	 */
	@GetMapping("/realall")
	public JSONResult queryRealAllPosition() {
		return JSONResult.ok(positionService.queryAllPosition());
	}
	
	/**
	 * 查询已被删除的岗位
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryPositionWhoIsDelete() {
		return JSONResult.ok(positionService.queryPositionWhoIsDelete());
	}
	
	/**
	 * 查询未被删除的岗位
	 * @return
	 */
	@GetMapping("/mockall")
	public JSONResult queryPositionWhoIsNotDelete() {
		return JSONResult.ok(positionService.queryPositionWhoIsNotDelete());
	}
	
	
	
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	@PutMapping
	public JSONResult updatePosition(Position position) {
		positionService.updatePosition(position);
		Position data = positionService.queryPositionById(position.getId());
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除岗位，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public JSONResult deletePosition(@Param("id") Long id) {
		positionService.deletePosition(id);
		if (positionService.queryPositionById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
}
