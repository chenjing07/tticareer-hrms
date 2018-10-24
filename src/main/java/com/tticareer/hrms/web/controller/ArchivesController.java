package com.tticareer.hrms.web.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tticareer.hrms.pojo.Archives;
import com.tticareer.hrms.service.ArchivesService;
import com.tticareer.hrms.util.BeanUtils;
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
	public JSONResult saveArchives(@RequestBody Archives archives) {
		archives.setState(1);
		archives.setCheckStatus(0);
		archivesService.saveArchives(archives);
//		Archives emp = archivesService.queryArchivesById(archives.getId());
//		if (emp!=null) {
//			String data = emp.getId()+"";
//			return JSONResult.ok(data);
//		} else {
//			String msg = "未知错误，数据未录入";
//			return JSONResult.errorMsg(msg);
//		}
		return JSONResult.ok();
	}

	
	/**
	 * 查询所有档案信息
	 * @return
	 */
	@GetMapping
	/*public JSONResult queryRealAllArchives() {
		return JSONResult.ok(archivesService.queryAllArchives());
	}*/
	public JSONResult getPage(@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart,@Param("createTimeEnd") String createTimeEnd,
			 ExtjsPageRequest pageRequest) 
	{
		if (userName==null && createTimeStart==null && createTimeEnd == null) {
				//return JSONResult.ok(archivesService.queryArchivesWhoIsNotDelete();
				List<Archives> rdList=archivesService.queryArchivesWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<Archives> p=new PageInfo<Archives>(rdList);
				PageImpl<Archives> rdPage=new PageImpl<Archives>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);	
		}else{
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 ParsePosition pos1 = new ParsePosition(0);
			 ParsePosition pos2 = new ParsePosition(0);
			 Date datecreateTimeStart = formatter.parse(createTimeStart, pos1);
			 Date datecreateTimeEnd = formatter.parse(createTimeEnd, pos2);		
			
			if(userName!=null && datecreateTimeStart==null && datecreateTimeEnd==null) {
				//return JSONResult.ok(archivesService.queryArchivesListByEmployeeId(employeeId));
				List<Archives> rdList=archivesService.queryArchivesListByEmployeeId(userName,pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<Archives> p=new PageInfo<Archives>(rdList);
				PageImpl<Archives> rdPage=new PageImpl<Archives>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);	
			}
			else if( userName=="" && (datecreateTimeStart!=null || datecreateTimeEnd!=null)) {	
				//return  JSONResult.ok(archivesService.queryArchivesListByCreateTime(datecreateTimeStart,datecreateTimeEnd));
				List<Archives> rdList=archivesService.queryArchivesListByCreateTime(datecreateTimeStart,datecreateTimeEnd,pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<Archives> p=new PageInfo<Archives>(rdList);
				PageImpl<Archives> rdPage=new PageImpl<Archives>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);	
			}else {
				//return JSONResult.ok(archivesService.queryArchivesListByMore(employeeId,datecreateTimeStart,datecreateTimeEnd));
				List<Archives> rdList=archivesService.queryArchivesListByMore(userName,datecreateTimeStart,datecreateTimeEnd,pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<Archives> p=new PageInfo<Archives>(rdList);
				PageImpl<Archives> rdPage=new PageImpl<Archives>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);	
			}
		}
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
	 
	@GetMapping("/mockall")
	public JSONResult queryArchivesWhoIsNotDelete() {
		return JSONResult.ok(archivesService.queryArchivesWhoIsNotDelete());
	}*/
	
	
	
	/**
	 * 修改档案信息
	 * @param archives
	 * @return
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateArchives(@PathVariable("id") Long id,@RequestBody Archives archives) {
		Archives entity = archivesService.queryArchivesById(id);
		if(entity!=null) {
			BeanUtils.copyProperties(archives, entity);//使用自定义的BeanUtils
			//leaveService.save(entity);
			archivesService.updateArchives(entity);
		}
		
		Archives data = archivesService.queryArchivesById(id);
		return JSONResult.ok(data);
	}
	
	/**
	 * 删除档案，状态设置为0冻结
	 * 成功返回1
	 * 失败返回0
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public @ResponseBody JSONResult deleteArchives(@PathVariable("id") Long id) {
		archivesService.deleteArchives(id);
		if (archivesService.queryArchivesById(id).getState()==0) {
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
				archivesService.deleteAll(ids);
			}
			return JSONResult.ok(1);
		} catch (Exception e) {
			return JSONResult.ok(0);
		}
	}
	
	
	@GetMapping("/approve")
	public JSONResult queryApprove(ExtjsPageRequest pageRequest) {
		//return JSONResult.ok(archivesService.queryAllArchives());
		//return JSONResult.ok(archivesService.queryWaitApprove());
		List<Archives> rdList=archivesService.queryWaitApprove(pageRequest.getPage(), pageRequest.getLimit());
		PageInfo<Archives> p=new PageInfo<Archives>(rdList);
		PageImpl<Archives> rdPage=new PageImpl<Archives>(rdList,pageRequest.getPageable(),p.getTotal());
		return JSONResult.ok(rdPage);	
	}
	
	@PostMapping("/approvePass")
	public  JSONResult approvePass(@Param("pass") String pass,@Param("id") Long id) {
		//System.out.println(id+"-----"+pass);
		Archives entity = archivesService.queryArchivesById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			if(pass.equals("pass")) {
				//System.out.println("pass");
				entity.setCheckStatus(1);
				archivesService.updateArchives(entity);
			}else if(pass.equals("nopass"))  {
				//System.out.println("nopass");
				entity.setState(0);
				entity.setCheckStatus(2);
				archivesService.updateArchives(entity);
			}
		}
		
		return JSONResult.ok(1);
	}
	
	
}
