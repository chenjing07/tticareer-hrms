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
import com.tticareer.hrms.pojo.Resume;
import com.tticareer.hrms.pojo.WrittenExamination;
import com.tticareer.hrms.pojo.WrittenExaminationContent;
import com.tticareer.hrms.pojo.dto.WrittenExaminationDto;
import com.tticareer.hrms.service.ExaminationService;
import com.tticareer.hrms.service.ResumeService;
import com.tticareer.hrms.service.WrittenExaminationService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/writtenexamination")
public class WrittenExaminationController {

	@Autowired
	WrittenExaminationService weService;
	
	@Autowired
	ResumeService resumeService;
	@Autowired
	ExaminationService examinationService;
	
	/**
	 * 保存笔试信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveWrittenExamination(@RequestBody WrittenExamination we) {
		Resume resume=resumeService.queryResumeById(we.getResumeId());
		WrittenExaminationContent wec=examinationService.queryWrittenExaminationContentById(we.getExamContentId());
		if (weService.queryWrittenExaminationById(we.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		}else if(!(resume!=null&&wec!=null)) {
			String msg = "不存在该简历id号或试题内容id号";
			return JSONResult.errorMsg(msg);
			}else {
				weService.saveWrittenExamination(we);
				WrittenExamination we1 = weService.queryWrittenExaminationById(we.getId());
				if (we1!=null) {
					String data = we1.getId()+"";
					return JSONResult.ok(data);
				} else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
			}
	}
	
	/**
	 * 更新笔试信息
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateWrittenExamination(@PathVariable("id") Long id,@RequestBody WrittenExaminationDto weDto) {
		//System.out.println(id);
		Resume resume=resumeService.queryResumeById(weDto.getResumeId());
		WrittenExaminationContent wec=examinationService.queryWrittenExaminationContentById(weDto.getExamContentId());
		WrittenExamination we=weService.queryWrittenExaminationById(id);		
		if(we==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  }else if(!(resume!=null&&wec!=null)) {
				String msg = "不存在该简历id号或试题内容id号";
				return JSONResult.errorMsg(msg);
				}else {
					BeanUtils.copyProperties(weDto, we);
					weService.updateWrittenExamination(we);
					WrittenExamination we1 = weService.queryWrittenExaminationById(we.getId());
					if(we1!=null) {
						String data = we1.getId()+"";
						return JSONResult.ok(data);
					}else {
						String msg = "未知错误，数据未录入";
						return JSONResult.errorMsg(msg);
					}
		}
	}
	
	/**
	 * 快捷查询,高级查询所有笔试信息
	 * 返回rdPage，查询成功
	 * @return
	 */
	@GetMapping
	public JSONResult searchWrittenExamination(WrittenExaminationDto weDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(weDto.getExamScore()==null&&weDto.getExamResult()==null&&weDto.getCreateTimeStart()==null&&weDto.getCreateTimeEnd()==null) {
			List<WrittenExamination> weList=weService.queryWrittenExaminationWhoIsPass(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<WrittenExamination> p=new PageInfo<WrittenExamination>(weList);
			Page<WrittenExamination> wePage=new PageImpl<WrittenExamination>(weList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(wePage);			
		}
		else if(weDto.getExamScore()!=null&&weDto.getExamResult()==null&&weDto.getCreateTimeStart()==null&&weDto.getCreateTimeEnd()==null) {
			List<WrittenExamination> weList=weService.queryWrittenExaminationByExamScore(weDto.getExamScore(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<WrittenExamination> p=new PageInfo<WrittenExamination>(weList);
			Page<WrittenExamination> wePage=new PageImpl<WrittenExamination>(weList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(wePage);				    
			}else if(weDto.getExamScore()==null&&weDto.getExamResult()!=null&&weDto.getCreateTimeStart()==null&&weDto.getCreateTimeEnd()==null){
				//System.out.println(resumeDto.getState());
				List<WrittenExamination> weList=weService.queryWrittenExaminationByExamResult(weDto.getExamResult(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<WrittenExamination> p=new PageInfo<WrittenExamination>(weList);
				Page<WrittenExamination> wePage=new PageImpl<WrittenExamination>(weList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(wePage);
				}else if(weDto.getExamScore()==null&&weDto.getExamResult()==null&&(weDto.getCreateTimeStart()==null||weDto.getCreateTimeEnd()==null)) {
					List<WrittenExamination> weList=weService.queryWrittenExaminationByCreateTime(weDto.getCreateTimeStart(), weDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<WrittenExamination> p=new PageInfo<WrittenExamination>(weList);
					Page<WrittenExamination> wePage=new PageImpl<WrittenExamination>(weList,pageRequest.getPageable(),p.getTotal());
					return JSONResult.ok(wePage);
					}else if(weDto.getExamScore()==null&&weDto.getExamResult()!=null&&(weDto.getCreateTimeStart()==null||weDto.getCreateTimeEnd()==null)) {
						List<WrittenExamination> weList=weService.queryWrittenExaminationList(weDto.getExamResult(), weDto.getCreateTimeStart(), weDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
						PageInfo<WrittenExamination> p=new PageInfo<WrittenExamination>(weList);
						Page<WrittenExamination> wePage=new PageImpl<WrittenExamination>(weList,pageRequest.getPageable(),p.getTotal());
						return JSONResult.ok(wePage);
						}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
					}
	}	
	
	/**
	 * 删除一条笔试信息，状态设置为0落选
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneWrittenExamination(@PathVariable("id") Long id) {
		if(id!=null)
			weService.deleteWrittenExamination(id);
		if (weService.queryWrittenExaminationById(id).getExamResult()==0) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条笔试信息，状态设置为0落选
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreWrittenExamination(@Param("ids") Long[] ids) {
		if(ids!=null)
			weService.deleteWrittenExamination(ids);
		for(Long id:ids) {
			if (weService.queryWrittenExaminationById(id).getExamResult()!=0) {
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
				WrittenExamination we = new WrittenExamination();	
				we.setResumeId(i+1L);
				we.setExamContentId(i+1L);
				we.setExamStart(new Date());
				we.setNote("note"+i);
				we.setExamScore(i+40L);
				we.setExamResult(1);
				we.setCreateTime(new Date());
				we.setExamEnd(new Date());
				
				weService.saveWrittenExamination(we);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
}
