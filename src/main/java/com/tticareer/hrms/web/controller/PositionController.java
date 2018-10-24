package com.tticareer.hrms.web.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.Position;
import com.tticareer.hrms.service.PositionService;
import com.tticareer.hrms.util.BeanUtils;
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
		position.setState(1);
		position.setCheckStatus(0);
		positionService.savePosition(position);
		/*Position emp = positionService.queryPositionById(position.getId());
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
	 * 查询所有岗位信息
	 * @return
	 */
	@GetMapping
	/*public JSONResult queryRealAllPosition() {
		return JSONResult.ok(positionService.queryAllPosition());
	}*/
	public JSONResult getPage(@Param("positionNumber") String positionNumber,@Param("positionName") String positionName,
			ExtjsPageRequest pageRequest) 
	{
		//System.out.println(userName + "********" +realName);
		
		if(positionNumber!=null && positionName==null) {
			//System.out.println(userName);
			//return JSONResult.ok(positionService.queryPositionListByPositionNumber(positionNumber));
			List<Position> rdList=positionService.queryPositionListByPositionNumber(positionNumber,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Position> p=new PageInfo<Position>(rdList);
			PageImpl<Position> rdPage=new PageImpl<Position>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);
		}else if(positionNumber==null && positionName!=null) {
			//return JSONResult.ok(positionService.queryPositionListByPositionName(positionName));
			List<Position> rdList=positionService.queryPositionListByPositionName(positionName,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Position> p=new PageInfo<Position>(rdList);
			PageImpl<Position> rdPage=new PageImpl<Position>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);
		}else if(positionNumber!=null && positionName!=null) {
			//System.out.println(userName + "&&&&&&" +realName);
			//return JSONResult.ok(positionService.queryPositionListByPositionNumberAndPositionName(positionNumber,positionName));
			List<Position> rdList=positionService.queryPositionListByPositionNumberAndPositionName(positionNumber,positionName,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Position> p=new PageInfo<Position>(rdList);
			PageImpl<Position> rdPage=new PageImpl<Position>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);
		}
		else {
			//return JSONResult.ok(positionService.queryAllPosition());
			List<Position> rdList=positionService.queryPositionWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Position> p=new PageInfo<Position>(rdList);
			PageImpl<Position> rdPage=new PageImpl<Position>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);	
		}
		
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
	/*@GetMapping("/mockall")
	public JSONResult queryPositionWhoIsNotDelete() {
		return JSONResult.ok(positionService.queryPositionWhoIsNotDelete());
	}*/
	
	
	
	/**
	 * 修改岗位信息
	 * @param position
	 * @return
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updatePosition(@PathVariable("id") Long id,@RequestBody Position position) {
		Position entity = positionService.queryPositionById(id);
		if(entity!=null) {
			BeanUtils.copyProperties(position, entity);//使用自定义的BeanUtils
			//leaveService.save(entity);
			positionService.updatePosition(entity);
		}
		
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
	@DeleteMapping(value="{id}")
	public @ResponseBody JSONResult deletePosition(@PathVariable("id") Long id) {
		positionService.deletePosition(id);
		if (positionService.queryPositionById(id).getState()==0) {
			return JSONResult.ok(1);
		} else {
			return JSONResult.ok(0);
		}
	}
	
	
	@PostMapping("/deletes")
	public JSONResult deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				positionService.deleteAll(ids);
			}
			return JSONResult.ok(1);
		} catch (Exception e) {
			return JSONResult.ok(0);
		}
	}

	
	@GetMapping("/approve")
	public JSONResult queryApprove(ExtjsPageRequest pageRequest) {
		//return JSONResult.ok(positionService.queryAllPosition());
		//return JSONResult.ok(positionService.queryWaitApprove());
		List<Position> rdList=positionService.queryWaitApprove(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
		PageInfo<Position> p=new PageInfo<Position>(rdList);
		PageImpl<Position> rdPage=new PageImpl<Position>(rdList,pageRequest.getPageable(),p.getTotal());
		return JSONResult.ok(rdPage);
	}
	
	@PostMapping("/approvePass")
	public  JSONResult approvePass(@Param("pass") String pass,@Param("id") Long id) {
		//System.out.println(id+"-----"+pass);
		Position entity = positionService.queryPositionById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			if(pass.equals("pass")) {
				//System.out.println("pass");
				entity.setCheckStatus(1);
				positionService.updatePosition(entity);
			}else if(pass.equals("nopass"))  {
				//System.out.println("nopass");
				entity.setState(0);
				entity.setCheckStatus(2);
				positionService.updatePosition(entity);
			}
		}
		
		return JSONResult.ok(1);
	}

	
	@GetMapping("/getPositionIdAndName")
	public JSONResult getSuperior() {
		//return JSONResult.ok(departmentService.queryAllDepartment());
		return JSONResult.ok(positionService.getPositionIdAndName());
	}
	
	@GetMapping("/getPositionNameById")
	public JSONResult getPositionNameById(@Param("id") Long id) {
		//return JSONResult.ok(positionService.queryAllPosition());
		if(id!=0) {
			String positionName = (positionService.queryPositionById(id)).getPositionName();
			//System.out.println(positionName);
			return JSONResult.ok(positionName);
		}else
			return JSONResult.ok("");
	}
	
}
