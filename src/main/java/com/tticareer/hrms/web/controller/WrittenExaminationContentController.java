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
import com.tticareer.hrms.pojo.ExaminationQuestions;
import com.tticareer.hrms.pojo.WrittenExaminationContent;
import com.tticareer.hrms.pojo.dto.WrittenExaminationContentDto;
import com.tticareer.hrms.service.ExaminationService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/writtenexaminationcontent")
public class WrittenExaminationContentController {

	@Autowired
	ExaminationService examinationService;
	
	/**
	 * 保存试题内容信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveWrittenExaminationContent(@RequestBody WrittenExaminationContent wec) {		
		ExaminationQuestions eq1=examinationService.queryExaminationQuestionsById(wec.getOneId());
		ExaminationQuestions eq2=examinationService.queryExaminationQuestionsById(wec.getTwoId());
		ExaminationQuestions eq3=examinationService.queryExaminationQuestionsById(wec.getThreeId());
		ExaminationQuestions eq4=examinationService.queryExaminationQuestionsById(wec.getFourId());
		ExaminationQuestions eq5=examinationService.queryExaminationQuestionsById(wec.getFiveId());
		ExaminationQuestions eq6=examinationService.queryExaminationQuestionsById(wec.getSixId());
		ExaminationQuestions eq7=examinationService.queryExaminationQuestionsById(wec.getSevenId());
		ExaminationQuestions eq8=examinationService.queryExaminationQuestionsById(wec.getEightId());
		ExaminationQuestions eq9=examinationService.queryExaminationQuestionsById(wec.getNineId());
		ExaminationQuestions eq10=examinationService.queryExaminationQuestionsById(wec.getTenId());
		if (examinationService.queryWrittenExaminationContentById(wec.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		}else if(!(eq1!=null&&eq2!=null&&eq3!=null&&eq4!=null&&eq5!=null&&eq6!=null&&eq7!=null&&eq8!=null&&eq9!=null&&eq10!=null)) {
			String msg = "不存在该试题详情id号";
			return JSONResult.errorMsg(msg);
			}
			else {
				examinationService.saveWrittenExaminationContent(wec);
				WrittenExaminationContent wec1 = examinationService.queryWrittenExaminationContentById(wec.getId());
					if (wec1!=null) {
						String data = wec1.getId()+"";
						return JSONResult.ok(data);
					} else {
						String msg = "未知错误，数据未录入";
						return JSONResult.errorMsg(msg);
					}
				}
	}
	/**
	 * 更新试题内容信息
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateWrittenExaminationContent(@PathVariable("id") Long id,@RequestBody WrittenExaminationContentDto wecDto) {
		//System.out.println(id);
		ExaminationQuestions eq1=examinationService.queryExaminationQuestionsById(wecDto.getOneId());
		ExaminationQuestions eq2=examinationService.queryExaminationQuestionsById(wecDto.getTwoId());
		ExaminationQuestions eq3=examinationService.queryExaminationQuestionsById(wecDto.getThreeId());
		ExaminationQuestions eq4=examinationService.queryExaminationQuestionsById(wecDto.getFourId());
		ExaminationQuestions eq5=examinationService.queryExaminationQuestionsById(wecDto.getFiveId());
		ExaminationQuestions eq6=examinationService.queryExaminationQuestionsById(wecDto.getSixId());
		ExaminationQuestions eq7=examinationService.queryExaminationQuestionsById(wecDto.getSevenId());
		ExaminationQuestions eq8=examinationService.queryExaminationQuestionsById(wecDto.getEightId());
		ExaminationQuestions eq9=examinationService.queryExaminationQuestionsById(wecDto.getNineId());
		ExaminationQuestions eq10=examinationService.queryExaminationQuestionsById(wecDto.getTenId());
		WrittenExaminationContent wec=examinationService.queryWrittenExaminationContentById(id);		
		if(wec==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  }else if(!(eq1!=null&&eq2!=null&&eq3!=null&&eq4!=null&&eq5!=null&&eq6!=null&&eq7!=null&&eq8!=null&&eq9!=null&&eq10!=null)) {
			  String msg = "不存在该试题详情id号";
			  return JSONResult.errorMsg(msg);
			  }else {
				BeanUtils.copyProperties(wecDto, wec);
				examinationService.updateWrittenExaminationContent(wec);
				WrittenExaminationContent wec1 = examinationService.queryWrittenExaminationContentById(wec.getId());
				if(wec1!=null) {
					String data = wec.getId()+"";
					return JSONResult.ok(data);
				}else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
			  }
	}
			
	/**
	 * 快捷查询,高级查询所有试题内容信息
	 * 返回rdPage，查询成功
	 * @return
	 */
	@GetMapping
	public JSONResult searchWrittenExaminationContent(WrittenExaminationContentDto wecDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(wecDto.getState()==null&&wecDto.getCreateTimeStart()==null&&wecDto.getCreateTimeEnd()==null) {
			List<WrittenExaminationContent> wecList=examinationService.queryWrittenExaminationContentWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<WrittenExaminationContent> p=new PageInfo<WrittenExaminationContent>(wecList);
			Page<WrittenExaminationContent> wecPage=new PageImpl<WrittenExaminationContent>(wecList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(wecPage);			
		}
		else if(wecDto.getState()!=null&&wecDto.getCreateTimeStart()==null&&wecDto.getCreateTimeEnd()==null) {
			List<WrittenExaminationContent> wecList=examinationService.queryWrittenExaminationContentByState(wecDto.getState(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<WrittenExaminationContent> p=new PageInfo<WrittenExaminationContent>(wecList);
			Page<WrittenExaminationContent> wecPage=new PageImpl<WrittenExaminationContent>(wecList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(wecPage);				    
			}else if(wecDto.getState()==null&&(wecDto.getCreateTimeStart()!=null||wecDto.getCreateTimeEnd()!=null)){
				List<WrittenExaminationContent> wecList=examinationService.queryWrittenExaminationContentByCreateTime(wecDto.getCreateTimeStart(), wecDto.getCreateTimeEnd(), pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<WrittenExaminationContent> p=new PageInfo<WrittenExaminationContent>(wecList);
				Page<WrittenExaminationContent> wecPage=new PageImpl<WrittenExaminationContent>(wecList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(wecPage);
				}else if(wecDto.getState()!=null&&(wecDto.getCreateTimeStart()!=null||wecDto.getCreateTimeEnd()!=null)) {
					List<WrittenExaminationContent> wecList=examinationService.queryWrittenExaminationContentList(wecDto.getState(), wecDto.getCreateTimeStart(), wecDto.getCreateTimeEnd(), pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<WrittenExaminationContent> p=new PageInfo<WrittenExaminationContent>(wecList);
					Page<WrittenExaminationContent> wecPage=new PageImpl<WrittenExaminationContent>(wecList,pageRequest.getPageable(),p.getTotal());
					return JSONResult.ok(wecPage);
					}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
					}
	}		

	/**
	 * 删除一条试题内容，状态设置为0异常
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneWrittenExaminationContent(@PathVariable("id") Long id) {
		if(id!=null)
			examinationService.deleteWrittenExaminationContent(id);
		if (examinationService.queryWrittenExaminationContentById(id).getState()==0) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条试题内容，状态设置为0异常
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreWrittenExaminationContent(@Param("ids") Long[] ids) {
		if(ids!=null)
			examinationService.deleteWrittenExaminationContent(ids);
		for(Long id:ids) {
			if (examinationService.queryWrittenExaminationContentById(id).getState()!=0) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		return new ExtAjaxResponse(true,"批量删除成功！");
	}
	 /*测试数据*/
	
	@RequestMapping("/data")
	public String testData() {
		try {
			for (int i = 51; i <=70; i++) {
				WrittenExaminationContent wec = new WrittenExaminationContent();	
				wec.setOneId(i+10L);		
				wec.setTwoId(i+11L);			
				wec.setThreeId(i+12L);			
				wec.setFourId(i+13L);			
				wec.setFiveId(i+14l);
				wec.setSixId(i+15l);
				wec.setSevenId(i+16L);
				wec.setEightId(i+17L);
				wec.setNineId(i+18L);
				wec.setTenId(i+19L);
				wec.setState(0);
				wec.setCreateTime(new Date());
				wec.setNote("note"+i);
				
				examinationService.saveWrittenExaminationContent(wec);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
}
