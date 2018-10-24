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
import com.tticareer.hrms.pojo.dto.ResumeDto;
import com.tticareer.hrms.service.ResumeService;
import com.tticareer.hrms.util.BeanUtils;
import com.tticareer.hrms.util.JSONResult;

@RestController
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	ResumeService resumeService;
	
	/**
	 * 保存简历信息
	 * msg 未知错误，数据未录入
	 * @param recruitmentDemand
	 * @return
	 */
	@PostMapping("/save")
	public JSONResult saveResume(@RequestBody Resume resume) {
		if (resumeService.queryResumeById(resume.getId())!=null) {
			String msg = "已存在该id号";
			return JSONResult.errorMsg(msg);
		} else {
				resumeService.saveResume(resume);
				Resume resume1 = resumeService.queryResumeById(resume.getId());
				if (resume1!=null) {
					String data = resume1.getId()+"";
					return JSONResult.ok(data);
				} else {
					String msg = "未知错误，数据未录入";
					return JSONResult.errorMsg(msg);
				}
			}
	}
	
	/**
	 * 更新简历信息
	 */
	@PutMapping(value="{id}")
	public @ResponseBody JSONResult updateResume(@PathVariable("id") Long id,@RequestBody ResumeDto resumeDto) {
		//System.out.println(id);
		Resume resume=resumeService.queryResumeById(id);		
		if(resume==null) {
			String msg = "不存在该条记录";
			return JSONResult.errorMsg(msg);
		  }else {
			BeanUtils.copyProperties(resumeDto, resume);
			resumeService.updateResume(resume);
			Resume resume1 = resumeService.queryResumeById(resume.getId());
			if(resume1!=null) {
				String data = resume.getId()+"";
				return JSONResult.ok(data);
			}else {
				String msg = "未知错误，数据未录入";
				return JSONResult.errorMsg(msg);
			}
		}
	}
	
	/**
	 * 快捷查询,高级查询所有简历信息
	 * 返回rdPage，查询成功
	 * @return
	 */
	@GetMapping
	public JSONResult searchResume(ResumeDto resumeDto,BindingResult bindingResult,ExtjsPageRequest pageRequest) {
		if(resumeDto.getApplicationName()==null&&resumeDto.getState()==null&&resumeDto.getCreateTimeStart()==null&&resumeDto.getCreateTimeEnd()==null) {
			List<Resume> resumeList=resumeService.queryResumeListWhoIsNotDelete(pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Resume> p=new PageInfo<Resume>(resumeList);
			Page<Resume> resumePage=new PageImpl<Resume>(resumeList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(resumePage);			
		}
		else if(resumeDto.getApplicationName()!=null&&resumeDto.getState()==null&&resumeDto.getCreateTimeStart()==null&&resumeDto.getCreateTimeEnd()==null) {
			List<Resume> resumeList=resumeService.queryResumeByApplicationName(resumeDto.getApplicationName(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
			PageInfo<Resume> p=new PageInfo<Resume>(resumeList);
			Page<Resume> resumePage=new PageImpl<Resume>(resumeList,pageRequest.getPageable(),p.getTotal());
			return JSONResult.ok(resumePage);			    
			}else if(resumeDto.getApplicationName()==null&&resumeDto.getState()!=null&&resumeDto.getCreateTimeStart()==null&&resumeDto.getCreateTimeEnd()==null){
				//System.out.println(resumeDto.getState());
				List<Resume> resumeList=resumeService.queryResumeByState(resumeDto.getState(), pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
				PageInfo<Resume> p=new PageInfo<Resume>(resumeList);
				Page<Resume> resumePage=new PageImpl<Resume>(resumeList,pageRequest.getPageable(),p.getTotal());
				return JSONResult.ok(resumePage);
				}else if(resumeDto.getApplicationName()==null&&resumeDto.getState()==null&&(resumeDto.getCreateTimeStart()!=null||resumeDto.getCreateTimeEnd()!=null)) {
					List<Resume> resumeList=resumeService.queryResumeByCreateTime(resumeDto.getCreateTimeStart(), resumeDto.getCreateTimeEnd(), pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
					PageInfo<Resume> p=new PageInfo<Resume>(resumeList);
					Page<Resume> resumePage=new PageImpl<Resume>(resumeList,pageRequest.getPageable(),p.getTotal());
					return JSONResult.ok(resumePage);
					}else if(resumeDto.getApplicationName()!=null&&resumeDto.getState()==null&&(resumeDto.getCreateTimeStart()!=null||resumeDto.getCreateTimeEnd()!=null)) {
						List<Resume> resumeList=resumeService.queryResumeList(resumeDto.getApplicationName(), resumeDto.getCreateTimeStart(), resumeDto.getCreateTimeEnd(),pageRequest.getPage(), pageRequest.getLimit(),"id DESC");
						PageInfo<Resume> p=new PageInfo<Resume>(resumeList);
						Page<Resume> resumePage=new PageImpl<Resume>(resumeList,pageRequest.getPageable(),p.getTotal());
						return JSONResult.ok(resumePage);
						}else {
						String msg = "未知错误，不能查询";
						return JSONResult.errorMsg(msg);
					}
	}		
	
	/**
	 * 删除一条简历，状态设置为2落选
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="{id}")
	public JSONResult deleteOneResume(@PathVariable("id") Long id) {
		if(id!=null)
			resumeService.deleteResume(id);
		if (resumeService.queryResumeById(id).getState()==2) {
			String data = "删除成功";
			return JSONResult.ok(data);
		} else {
			String msg = "成功失败";
			return JSONResult.errorMsg(msg);
		}
	}
	
	/**
	 * 删除多条简历，状态设置为2落选
	 * @param id
	 * @return
	 */
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteMoreResume(@Param("ids") Long[] ids) {
		if(ids!=null)
			resumeService.deleteResume(ids);
		for(Long id:ids) {
			if (resumeService.queryResumeById(id).getState()!=2) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		return new ExtAjaxResponse(true,"批量删除成功！");
	}
	 /*测试数据*/
	
	@RequestMapping("/data")
	public String testData() {
		try {
			for (int i = 6; i <=50; i++) {
				Resume resume = new Resume();	
				resume.setApplicationName("name"+i);		
				resume.setExpectedPosition("posi"+i);			
				resume.setIdCardNumber("idcard"+i);			
				resume.setIdCardPicture("D://...");			
				resume.setBirthday(new Date());
				resume.setGender(1);
				resume.setNation("nation"+i);
				resume.setNativePlace("native"+i);
				resume.setRegisteredAddress("rAddress"+i);
				resume.setHouseAddress("hAddress"+i);
				resume.setPoliticalStatus(2);
				resume.setMaritalStatus(0);
				resume.setPhoneNumber("phone"+i);
				resume.setEmail("email"+i);
				resume.setQq("qq"+i);
				resume.setEducation("education"+i);
				resume.setAcademicDegree("aDegree"+i);
				resume.setMajor("major"+i);
				resume.setTie("tie"+i);
				resume.setGraduatedSchool("gSchool"+i);
				resume.setGraduatedTime(new Date());
				resume.setAwardsReceived("awards"+i);
				resume.setLanguageLevel("language"+i);
				resume.setWorkExperience("Experience"+i);
				resume.setHobbies("hobbies"+i);
				resume.setSelfEvaluation("self"+i);
				resume.setState(0);
				resume.setCreateTime(new Date());
				resume.setNote("note"+i);
				
				resumeService.saveResume(resume);
            }
		    return "success:true";
		}catch(Exception e) {
			e.printStackTrace();
			return "success:false";
		}
	}
}
