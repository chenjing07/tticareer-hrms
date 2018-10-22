package com.tticareer.hrms.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.Position;
import com.tticareer.hrms.pojo.RecruitmentDemand;
import com.tticareer.hrms.pojo.dto.RecruitmentDemandDto;
import com.tticareer.hrms.service.PositionService;
import com.tticareer.hrms.service.RecruitmentDemandService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/recruitmentdemand")
public class RecruitmentDemandController {

	@Autowired
	RecruitmentDemandService recruitmentDemandService;
	
	@Autowired
	PositionService positionService;
	
	/**
	 * 保存招聘需求信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveRecruitmentDemand(@RequestBody RecruitmentDemand recruitmentDemand) {
		Position p=positionService.queryPositionById(recruitmentDemand.getPositionId());
		if (recruitmentDemandService.queryRecruitmentDemandById(recruitmentDemand.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		} else if(p==null||p.getState()==0) { 
			String msg = "不存在该岗位id号";
			return JSONResult.errorMsg(msg);
				}
				else{
					recruitmentDemandService.saveRecruitmentDemand(recruitmentDemand);
					RecruitmentDemand rd = recruitmentDemandService.queryRecruitmentDemandById(recruitmentDemand.getId());
					if (rd!=null) {
						String data = rd.getId()+"";
						return JSONResult.ok(data);
					} else {
						String msg = "未知错误，数据未录入";
						return JSONResult.errorMsg(msg);
					}
				}
	}
	/**
	 * * 修改招聘标准信息
	 * msg 未知错误，数据未录入	 
	 * @param RecruitmentDemand
	 * @return
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateRecruitmentDemand(@PathVariable("id") Long id,@RequestBody RecruitmentDemandDto rdDto) {
		//System.out.println(id);
		RecruitmentDemand rd=recruitmentDemandService.queryRecruitmentDemandById(id);		
		if(rd==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  }else {
			  Position p=positionService.queryPositionById(rdDto.getPositionId());
			  //System.out.println(rdDto.getPositionId());
			  //System.out.println(p);
			  if(p==null||p.getState()==0) {
			  String msg = "不存在该岗位id号";
			  return JSONResult.errorMsg(msg); 
				}else {
					BeanUtils.copyProperties(rdDto, rd);
					recruitmentDemandService.updateRecruitmentDemand(rd);
					RecruitmentDemand rd1 = recruitmentDemandService.queryRecruitmentDemandById(rd.getId());
					if(rd1!=null) {
						String data = rd.getId()+"";
						return JSONResult.ok(data);
					}else {
						String msg = "未知错误，数据未录入";
						return JSONResult.errorMsg(msg);
					}
				}
		  }
	}
		
	/**
	 * 快捷查询,高级查询所有招聘标准信息
	 * 返回rdPage，查询成功
	 * 返回-1 ，不存在满足条件的结果
	 * @return
	 */
	@GetMapping
	public JSONResult searchRecruitmentDemand(RecruitmentDemandDto rdDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(rdDto.getPositionId()==null&&rdDto.getCreateTimeStart()==null&&rdDto.getCreateTimeEnd()==null) {
			List<RecruitmentDemand> rdList=recruitmentDemandService.queryRecruitmentDemandWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<RecruitmentDemand> p=new PageInfo<RecruitmentDemand>(rdList);
			Page<RecruitmentDemand> rdPage=new PageImpl<RecruitmentDemand>(rdList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(rdPage);			
		}
		else if(rdDto.getPositionId()==null&&(rdDto.getCreateTimeStart()!=null||rdDto.getCreateTimeEnd()!=null)) {
			//System.out.println(rdDto.getPositionId());
			//System.out.println(rdDto.getCreateTimeStart());
			//System.out.println(rdDto.getCreateTimeEnd());
				List<RecruitmentDemand> rdList=recruitmentDemandService.queryRecruitmentDemandByCreateTime(rdDto.getCreateTimeStart(), rdDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<RecruitmentDemand>  p=new PageInfo<RecruitmentDemand> (rdList);
				Page<RecruitmentDemand> rdPage=new PageImpl<RecruitmentDemand>(rdList,pageRequest.getPageable(),p.getTotal());
			    return JSONResult.ok(rdPage); 			    
			}else if(rdDto.getPositionId()!=null&&rdDto.getCreateTimeStart()==null&&rdDto.getCreateTimeEnd()==null){
				//System.out.println(rdDto.getPositionId());
				//System.out.println(rdDto.getCreateTimeStart());
				//System.out.println(rdDto.getCreateTimeEnd());
				List<RecruitmentDemand> rdList=recruitmentDemandService.queryRecruitmentDemandByPositionId(rdDto.getPositionId(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<RecruitmentDemand>  p=new PageInfo<RecruitmentDemand> (rdList);
				Page<RecruitmentDemand> rdPage=new PageImpl<RecruitmentDemand>(rdList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(rdPage);
				}else if(rdDto.getPositionId()!=null&&(rdDto.getCreateTimeStart()!=null||rdDto.getCreateTimeEnd()!=null)) {
					//System.out.println(rdDto.getPositionId());
					//System.out.println(rdDto.getCreateTimeStart());
					//System.out.println(rdDto.getCreateTimeEnd());
					List<RecruitmentDemand> rdList=recruitmentDemandService.queryRecruitmentDemandList(rdDto.getPositionId(), rdDto.getCreateTimeStart(), rdDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<RecruitmentDemand>  p=new PageInfo<RecruitmentDemand> (rdList);
					Page<RecruitmentDemand> rdPage=new PageImpl<RecruitmentDemand>(rdList,pageRequest.getPageable(),p.getTotal());
				    return JSONResult.ok(rdPage);
					}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
					}
	}		
	
	
	
	/**
	 * 删除一条招聘标准，状态设置为0冻结
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneRecruitmentDemand(@PathVariable("id") Long id) {
		if(id!=null)
			recruitmentDemandService.deleteRecruitmentDemand(id);
		if (recruitmentDemandService.queryRecruitmentDemandById(id).getState()==0) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条招聘标准，状态设置为0冻结
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreRecruitmentDemand(@Param("ids") Long[] ids) {
		if(ids!=null)
			recruitmentDemandService.deleteRecruitmentDemand(ids);
		for(Long id:ids) {
			if (recruitmentDemandService.queryRecruitmentDemandById(id).getState()!=0) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		return new ExtAjaxResponse(true,"批量删除成功！");
	}
	 /*测试数据*/
	
	@RequestMapping("/data")
	public String testData() {
		try {
			for (int i = 1; i <=50; i++) {
				RecruitmentDemand recruitmentDemand = new RecruitmentDemand();					
				recruitmentDemand.setPositionId(i+1L);			
				recruitmentDemand.setPlanNumber(i+10);			
				recruitmentDemand.setSalary(i+1000L);			
				recruitmentDemand.setSupplementalNumber(i+20);			
				recruitmentDemand.setSupplementReason("原因"+i);
				recruitmentDemand.setArrivalDate(new Date());
				recruitmentDemand.setLanguageRequirements("语言"+i);
				recruitmentDemand.setProfessionalRequirements("专业"+i);
				recruitmentDemand.setEducationalRequirements("学历"+i);
				recruitmentDemand.setComputerRequirements("电脑"+i);
				recruitmentDemand.setExperienceRequirements("经验"+i);
				recruitmentDemand.setAgeRequirements("年龄"+i);
				recruitmentDemand.setPostDuties("岗位职责"+i);
				recruitmentDemand.setPostRequirements("岗位要求"+i);
				recruitmentDemand.setState(1);
				recruitmentDemand.setCreateTime(new Date());
				recruitmentDemand.setNote("备注"+i);
				
				recruitmentDemandService.saveRecruitmentDemand(recruitmentDemand);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
}
