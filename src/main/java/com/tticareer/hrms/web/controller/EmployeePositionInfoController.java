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
import com.tticareer.hrms.pojo.EmployeePositionInfo;
import com.tticareer.hrms.service.EmployeePositionInfoService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

/**
* @author cfy
* @version 创建时间：2018年9月25日 上午11:36:23
*/
@RestController
@RequestMapping("/employeePositionInfo")
public class EmployeePositionInfoController {

	@Autowired
	EmployeePositionInfoService employeePositionInfoService;
	
	
	/**
	 * 返回id 录入成功
	 * msg 未知错误，数据未录入
	 * @param employeePositionInfo
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveEmployeePositionInfo(@RequestBody EmployeePositionInfo employeePositionInfo) {
		//System.out.print(employeePositionInfo.getArriveOpinion());
			employeePositionInfoService.saveEmployeePositionInfo(employeePositionInfo);
			/*EmployeePositionInfo emp = employeePositionInfoService.queryEmployeePositionInfoByEmployeeId(employeePositionInfo.getEmployeeId());
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
	 * 查询所有员工信息
	 * @return
	 */
	@GetMapping
	/*public JSONResult queryRealAllEmployeePositionInfo() {
		return JSONResult.ok(employeePositionInfoService.queryAllEmployeePositionInfo());
	}*/
	public JSONResult getPage(@Param("userName") String userName,
			@Param("createTimeStart") String createTimeStart,@Param("createTimeEnd") String createTimeEnd,
			ExtjsPageRequest pageRequest) 
	{
		if (userName==null && createTimeStart==null && createTimeEnd == null) {
			//System.out.println("+++++"+userName);
				//return JSONResult.ok(employeePositionInfoService.queryAllEmployeePositionInfo());
				List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit());
				//System.out.println("+++++"+rdList);
				PageInfo<EmployeePositionInfo> p=new PageInfo<EmployeePositionInfo>(rdList);
				//System.out.println("+++++"+p);
				PageImpl<EmployeePositionInfo> rdPage=new PageImpl<EmployeePositionInfo>(rdList,pageRequest.getPageable(),p.getTotal());
				//System.out.println("+++++"+rdPage);
				return JSONResult.ok(rdPage);	
		}else{
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 ParsePosition pos1 = new ParsePosition(0);
			 ParsePosition pos2 = new ParsePosition(0);
			 Date datecreateTimeStart = formatter.parse(createTimeStart, pos1);
			 Date datecreateTimeEnd = formatter.parse(createTimeEnd, pos2);		
			 //System.out.println("-----"+userName);
			if(userName!=null && datecreateTimeStart==null && datecreateTimeEnd==null) {
				//return JSONResult.ok(employeePositionInfoService.queryEmployeePositionInfoListByEmployeeId(employeeId));
				//List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoListByEmployeeId(employeeId,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoListByEmployeeId(userName,pageRequest.getPage(), pageRequest.getLimit());
				//System.out.println("----"+rdList);
				PageInfo<EmployeePositionInfo> p=new PageInfo<EmployeePositionInfo>(rdList);
				//System.out.println("----"+p);
				PageImpl<EmployeePositionInfo> rdPage=new PageImpl<EmployeePositionInfo>(rdList,pageRequest.getPageable(),p.getTotal());
				//System.out.println("----"+rdPage);
				return JSONResult.ok(rdPage);	
			}
			else if( userName=="" && (datecreateTimeStart!=null || datecreateTimeEnd!=null)) {	
				//return  JSONResult.ok(employeePositionInfoService.queryEmployeePositionInfoListByCreateTime(datecreateTimeStart,datecreateTimeEnd));
				//System.out.println("789789");
				List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoListByCreateTime(datecreateTimeStart,datecreateTimeEnd,pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<EmployeePositionInfo> p=new PageInfo<EmployeePositionInfo>(rdList);
				PageImpl<EmployeePositionInfo> rdPage=new PageImpl<EmployeePositionInfo>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);
			}else {
				//System.out.println("asdasd");
				//return JSONResult.ok(employeePositionInfoService.queryEmployeePositionInfoListByMore(employeeId,datecreateTimeStart,datecreateTimeEnd));
				//List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoListByMore(employeeId,datecreateTimeStart,datecreateTimeEnd,pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				List<EmployeePositionInfo> rdList=employeePositionInfoService.queryEmployeePositionInfoListByMore(userName,datecreateTimeStart,datecreateTimeEnd,pageRequest.getPage(), pageRequest.getLimit());
				PageInfo<EmployeePositionInfo> p=new PageInfo<EmployeePositionInfo>(rdList);
				PageImpl<EmployeePositionInfo> rdPage=new PageImpl<EmployeePositionInfo>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);
			}
		}
	}
	
	
	@GetMapping("/queryJoinEmployeeAndEmP")
	public JSONResult queryEmP(String userName) {
		return JSONResult.ok(employeePositionInfoService.queryJoinEmployeeAndEmP(userName));
		
	}
	
	/**
	 * 查询已被删除的员工
	 * @return
	 */
	@GetMapping("/isdelete")
	public JSONResult queryEmployeePositionInfoWhoIsDelete() {
		return JSONResult.ok(employeePositionInfoService.queryEmployeePositionInfoWhoIsDelete());
	}
	
	
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeePositionInfo employee) {
		EmployeePositionInfo entity = employeePositionInfoService.queryEmployeePositionInfoById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			BeanUtils.copyProperties(employee, entity);//使用自定义的BeanUtils
			//employeeService.save(entity);
			employeePositionInfoService.updateEmployeePositionInfo(entity);
		}
		
		EmployeePositionInfo data = employeePositionInfoService.queryEmployeePositionInfoById(id);
		return JSONResult.ok(data);
	}
	
	@DeleteMapping(value="{id}")
	public  @ResponseBody JSONResult deleteEmployeePositionInfo(@PathVariable("id") Long id) {
		//System.out.println("-----"+id);
		employeePositionInfoService.deleteEmployeePositionInfo(id);
		if (employeePositionInfoService.queryEmployeePositionInfoById(id).getState()==0) {
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
				employeePositionInfoService.deleteAll(ids);
			}
			return JSONResult.ok(1);
		} catch (Exception e) {
			return JSONResult.ok(0);
		}
	}
	
	@GetMapping("/approve")
	public JSONResult queryApprove(ExtjsPageRequest pageRequest) {
		//return JSONResult.ok(employeePositionInfoService.queryAllEmployeePositionInfo());
		//return JSONResult.ok(employeePositionInfoService.queryWaitApprove());
		List<EmployeePositionInfo> rdList=employeePositionInfoService.queryWaitApprove(pageRequest.getPage(), pageRequest.getLimit());
		PageInfo<EmployeePositionInfo> p=new PageInfo<EmployeePositionInfo>(rdList);
		PageImpl<EmployeePositionInfo> rdPage=new PageImpl<EmployeePositionInfo>(rdList,pageRequest.getPageable(),p.getTotal());
		return JSONResult.ok(rdPage);
	}
	
	@PostMapping("/approvePass")
	public  JSONResult approvePass(@Param("pass") String pass,@Param("id") Long id) {
		//System.out.println(id+"-----"+pass);
		EmployeePositionInfo entity = employeePositionInfoService.queryEmployeePositionInfoById(id);
		//System.out.println(entity.getRealName());
		if(entity!=null) {
			if(pass.equals("pass")) {
				//System.out.println("pass");
				entity.setCheckStatus(1);
				employeePositionInfoService.updateEmployeePositionInfo(entity);
			}else if(pass.equals("nopass"))  {
				//System.out.println("nopass");
				entity.setState(0);
				entity.setCheckStatus(2);
				employeePositionInfoService.updateEmployeePositionInfo(entity);
			}
		}
		
		return JSONResult.ok(1);
	}


}
