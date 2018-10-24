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
import com.tticareer.hrms.pojo.dto.ExaminationQuestionsDto;
import com.tticareer.hrms.service.ExaminationService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/examinationquestions")
public class ExaminationQuestionsController {

	@Autowired
	ExaminationService examinationService;
	
	/**
	 * 保存试题详情信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveExaminationQuestions(@RequestBody ExaminationQuestions eq) {
		if (examinationService.queryExaminationQuestionsById(eq.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		} else {
			examinationService.saveExaminationQuestions(eq);
			ExaminationQuestions eq1 = examinationService.queryExaminationQuestionsById(eq.getId());
				if (eq1!=null) {
					String data = eq1.getId()+"";
					return JSONResult.ok(data);
				} else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
			}
	}
	
	/**
	 * 更新试题详情信息
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateExaminationQuestions(@PathVariable("id") Long id,@RequestBody ExaminationQuestionsDto eqDto) {
		//System.out.println(id);
		ExaminationQuestions eq=examinationService.queryExaminationQuestionsById(id);		
		if(eq==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  }else {
			BeanUtils.copyProperties(eqDto, eq);
			examinationService.updateExaminationQuestions(eq);
			ExaminationQuestions eq1 = examinationService.queryExaminationQuestionsById(eq.getId());
			if(eq1!=null) {
				String data = eq1.getId()+"";
				return JSONResult.ok(data);
			}else {
				String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
			}
		  }
	}
	
	/**
	 * 快捷查询,高级查询所有试题详情信息
	 * 返回rdPage，查询成功
	 * @return
	 */
	@GetMapping
	public JSONResult searchExaminationQuestions(ExaminationQuestionsDto eqDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(eqDto.getState()==null&&eqDto.getCategory()==null&&eqDto.getCreateTimeStart()==null&&eqDto.getCreateTimeEnd()==null) {
			List<ExaminationQuestions> eqList=examinationService.queryExaminationQuestionsWhoIsNotDeleteAndNotWrong(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<ExaminationQuestions> p=new PageInfo<ExaminationQuestions>(eqList);
			Page<ExaminationQuestions> eqPage=new PageImpl<ExaminationQuestions>(eqList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(eqPage);			
		}
		else if(eqDto.getState()!=null&&eqDto.getCategory()==null&&eqDto.getCreateTimeStart()==null&&eqDto.getCreateTimeEnd()==null) {
			List<ExaminationQuestions> eqList=examinationService.queryExaminationQuestionsByState(eqDto.getState(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<ExaminationQuestions> p=new PageInfo<ExaminationQuestions>(eqList);
			Page<ExaminationQuestions> eqPage=new PageImpl<ExaminationQuestions>(eqList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(eqPage);			    
			}else if(eqDto.getState()==null&&eqDto.getCategory()!=null&&eqDto.getCreateTimeStart()==null&&eqDto.getCreateTimeEnd()==null){
				List<ExaminationQuestions> eqList=examinationService.queryExaminationQuestionsByCategory(eqDto.getCategory(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<ExaminationQuestions> p=new PageInfo<ExaminationQuestions>(eqList);
				Page<ExaminationQuestions> eqPage=new PageImpl<ExaminationQuestions>(eqList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(eqPage);
				}else if(eqDto.getState()==null&&eqDto.getCategory()==null&&(eqDto.getCreateTimeStart()==null||eqDto.getCreateTimeEnd()==null)) {
					List<ExaminationQuestions> eqList=examinationService.queryExaminationQuestionsByCreateTime(eqDto.getCreateTimeStart(), eqDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<ExaminationQuestions> p=new PageInfo<ExaminationQuestions>(eqList);
					Page<ExaminationQuestions> eqPage=new PageImpl<ExaminationQuestions>(eqList,pageRequest.getPageable(),p.getTotal());
					return JSONResult.ok(eqPage);
					}else if(eqDto.getState()!=null&&eqDto.getCategory()==null&&(eqDto.getCreateTimeStart()==null||eqDto.getCreateTimeEnd()==null)) {
						List<ExaminationQuestions> eqList=examinationService.queryExaminationQuestionsList(eqDto.getState(), eqDto.getCreateTimeStart(), eqDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
						PageInfo<ExaminationQuestions> p=new PageInfo<ExaminationQuestions>(eqList);
						Page<ExaminationQuestions> eqPage=new PageImpl<ExaminationQuestions>(eqList,pageRequest.getPageable(),p.getTotal());
						return JSONResult.ok(eqPage);
						}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
						}
	}	
	
	/**
	 * 删除一条试题详情，状态设置为0冻结
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneExaminationQuestions(@PathVariable("id") Long id) {
		if(id!=null)
			examinationService.deleteExaminationQuestions(id);
		if (examinationService.queryExaminationQuestionsById(id).getState()==0) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条试题详情，状态设置为0冻结
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreExaminationQuestions(@Param("ids") Long[] ids) {
		if(ids!=null)
			examinationService.deleteExaminationQuestions(ids);
		for(Long id:ids) {
			if (examinationService.queryExaminationQuestionsById(id).getState()!=0) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		return new ExtAjaxResponse(true,"批量删除成功！");
	}
	 /*测试数据*/
	
	@RequestMapping("/data")
	public String testData() {
		try {
			for (int i = 41; i <=50; i++) {
				ExaminationQuestions eq = new ExaminationQuestions();	
				eq.setQuestion("question"+i);		
				eq.setAnswer("answer"+i);
				eq.setScore(i+50L);
				eq.setDifficultyLevel(2);
				eq.setCategory(4);
				eq.setExplanation("explanation"+i);
				eq.setState(2);
				eq.setCreateTime(new Date());
				eq.setNote("note"+i);
	
				examinationService.saveExaminationQuestions(eq);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
}
