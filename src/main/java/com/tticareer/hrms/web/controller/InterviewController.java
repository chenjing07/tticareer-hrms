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
import com.tticareer.hrms.pojo.Interview;
import com.tticareer.hrms.pojo.Resume;
import com.tticareer.hrms.pojo.dto.InterviewDto;
import com.tticareer.hrms.service.InterviewService;
import com.tticareer.hrms.service.ResumeService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	InterviewService interviewService;
	
	@Autowired
	ResumeService resumeService;
	/**
	 * 保存面试信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveInterview(@RequestBody Interview interview) {
		Resume resume=resumeService.queryResumeById(interview.getId());
		if (interviewService.queryInterviewById(interview.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		} else if(resume==null) {
			String msg = "不存在该简历id号";
			return JSONResult.errorMsg(msg);
		}else {
			interviewService.saveInterview(interview);
			Interview interview1 = interviewService.queryInterviewById(interview.getId());
				if (interview1!=null) {
					String data = interview1.getId()+"";
					return JSONResult.ok(data);
				} else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
		}
	}
	
	/**
	 * 更新面试信息
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateInterview(@PathVariable("id") Long id,@RequestBody InterviewDto interviewDto) {
		//System.out.println(id);
		Interview interview=interviewService.queryInterviewById(id);	
		Resume resume=resumeService.queryResumeById(interviewDto.getId());
		if(interview==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  } else if(resume==null) {
				String msg = "不存在该简历id号";
				return JSONResult.errorMsg(msg);
			}else {
				BeanUtils.copyProperties(interviewDto, interview);
				interviewService.updateInterview(interview);
				Interview interview1 = interviewService.queryInterviewById(interview.getId());
				if(interview1!=null) {
					String data = interview1.getId()+"";
					return JSONResult.ok(data);
				}else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
		}
	}
	
	/**
	 * 快捷查询,高级查询所有面试信息
	 * 返回rdPage，查询成功
	 * @return
	 */
	@GetMapping
	public JSONResult searchInterview(InterviewDto interviewDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(interviewDto.getState()==null&&interviewDto.getCreateTimeStart()==null&&interviewDto.getCreateTimeEnd()==null) {
			List<Interview> interviewList=interviewService.queryInterviewWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Interview> p=new PageInfo<Interview>(interviewList);
			Page<Interview> interviewPage=new PageImpl<Interview>(interviewList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(interviewPage);			
		}
		else if(interviewDto.getState()!=null&&interviewDto.getCreateTimeStart()==null&&interviewDto.getCreateTimeEnd()==null) {
			List<Interview> interviewList=interviewService.queryInterviewByState(interviewDto.getState(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Interview> p=new PageInfo<Interview>(interviewList);
			Page<Interview> interviewPage=new PageImpl<Interview>(interviewList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(interviewPage);			
			}else if(interviewDto.getState()==null&&(interviewDto.getCreateTimeStart()==null||interviewDto.getCreateTimeEnd()==null)) {
				List<Interview> interviewList=interviewService.queryInterviewByCreateTime(interviewDto.getCreateTimeStart(), interviewDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<Interview> p=new PageInfo<Interview>(interviewList);
				Page<Interview> interviewPage=new PageImpl<Interview>(interviewList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(interviewPage);			
				}else if(interviewDto.getState()!=null&&(interviewDto.getCreateTimeStart()==null||interviewDto.getCreateTimeEnd()==null)) {
					List<Interview> interviewList=interviewService.queryInterviewList(interviewDto.getState(), interviewDto.getCreateTimeStart(), interviewDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<Interview> p=new PageInfo<Interview>(interviewList);
					Page<Interview> interviewPage=new PageImpl<Interview>(interviewList,pageRequest.getPageable(),p.getTotal());
					return JSONResult.ok(interviewPage);			
					}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
					}
	}
	
	/**
	 * 删除一条面试信息，状态设置为0落选
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneInterview(@PathVariable("id") Long id) {
		if(id!=null)
			interviewService.deleteInterview(id);
		if (interviewService.queryInterviewById(id).getState()==0) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条面试信息，状态设置为0落选
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreInterview(@Param("ids") Long[] ids) {
		if(ids!=null)
			interviewService.deleteInterview(ids);
		for(Long id:ids) {
			if (interviewService.queryInterviewById(id).getState()!=0) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		return new ExtAjaxResponse(true,"批量删除成功！");
	}
	 /*测试数据*/
	
	@RequestMapping("/data")
	public String testData() {
		try {
			for (int i = 26; i <=50; i++) {
				Interview interview = new Interview();	
				interview.setResumeId(i+1L);
				interview.setOneContent("oneContent"+i);
				interview.setOneStart(new Date());
				interview.setOneEnd(new Date());
				interview.setOneFeedback("oneFeedback"+i);
				interview.setTwoContent("twoContent"+i);
				interview.setTwoStart(new Date());
				interview.setTwoEnd(new Date());
				interview.setTwoFeedback("twoFeedback"+i);
				interview.setState(2);
				interview.setCreateTime(new Date());
				interview.setNote("note"+i);
				
				
				interviewService.saveInterview(interview);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
	
}
