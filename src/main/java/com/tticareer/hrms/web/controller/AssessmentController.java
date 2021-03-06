package com.tticareer.hrms.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tticareer.hrms.pojo.AssessmentStandard;
import com.tticareer.hrms.pojo.Department;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.EmployeeAssessment;
import com.tticareer.hrms.pojo.GreatTeam;
import com.tticareer.hrms.pojo.Position;
import com.tticareer.hrms.pojo.dto.AssessmentStandardDto;
import com.tticareer.hrms.pojo.dto.EmployeeAssessmentDto;
import com.tticareer.hrms.service.AssessmentService;
import com.tticareer.hrms.service.DepartmentService;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.service.PositionService;
import com.tticareer.hrms.util.ExtjsPageRequest;
import com.tticareer.hrms.util.JSONResult;

/**
 * <p>CreateTime: 2018年10月9日 上午9:35:32 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: AssessmentController.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
@RestController
@RequestMapping("/assessment")
public class AssessmentController {
	
	@Autowired
	AssessmentService as;
	
	@Autowired
	PositionService ps;
	
	@Autowired
	EmployeeService es;
	
	@Autowired
	DepartmentService ds;
	
	/**
	 * <p>Title: saveAssessmentStandard</p>
	 * <p>Description: 
	 * 		0 不存在该岗位或被删除
	 * 		1 考核标准录入成功
	 * 		-1 该岗位未审核
	 * 		-2 已存在该岗位的考核信息但被删除
	 * 		-3 已存在该岗位的考核信息
	 * 		-4 已存在该岗位的考核信息但未审核
	 * </p>
	 * @param a
	 * @param positionNumber
	 * @return
	 */
	@PostMapping("/assave")
	public JSONResult saveAssessmentStandard(AssessmentStandard a, @Param("positionNumber")String positionNumber) {
		Position p = ps.queryPositionByPositionNumber(positionNumber);
		if (p!=null && p.getState()!=0) {
			if (p.getCheckStatus()!=0) {
				if (as.queryAssessmentStandardByPositionId(p.getId()).size()!=0) {
					AssessmentStandard aa = as.queryAssessmentStandardByPositionId(p.getId()).get(0);
					if (aa.getState()!=0) {
						if (aa.getCheckStatus()!=0) {
							return JSONResult.ok(-3);
						} else {
							return JSONResult.ok(-4);
						}
					} else {
						return JSONResult.ok(-2);
					}
				}
				a.setPositionId(p.getId());
				a.setState(1);
				a.setCreateTime(new Date());
				a.setCheckStatus(0);
				as.saveAssessmentStandard(a);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
		
	}
	
	/**
	 * <p>Title: updateAssessmentStandard</p>
	 * <p>Description: 
	 * 		-4不存在该岗位或被删除
	 * 		-3 该岗位未审核
	 *  	-2 存在该岗位对应的其他考核信息
	 * 		-1 不存在该考核标准或被删除
	 * 		0 该考核标准未审核
	 * 		1 修改成功
	 * </p>
	 * @param a
	 * @param positionNumber
	 * @return
	 */
	@PostMapping("/asupdate")
	public JSONResult updateAssessmentStandard(AssessmentStandard a, @Param("positionNumber")String positionNumber) {
		System.out.println(positionNumber);
		Position p = ps.queryPositionByPositionNumber(positionNumber);
		if (p!=null && p.getState()!=0) {
			if (p.getCheckStatus()!=0) {
				if (as.queryAssessmentStandardByPositionId(p.getId()).get(0).getId()!=a.getId()) {
					return JSONResult.ok(-2);
				}
				AssessmentStandard aa = as.queryAssessmentStandardById(a.getId());
				if (aa!=null && aa.getState()!=0) {
					if (aa.getCheckStatus()!=0) {
						aa.setPositionId(p.getId());
						aa.setWorkResult(a.getWorkResult());
						aa.setAttitude(a.getAttitude());
						aa.setQuality(a.getQuality());
						aa.setSkill(a.getSkill());
						aa.setCalculationWay(a.getCalculationWay());
						aa.setAssessmentType(a.getAssessmentType());
						aa.setResultLevel(a.getResultLevel());
						aa.setNote(a.getNote());
						as.updateAssessmentStandard(aa);
						return JSONResult.ok(1);
					} else {
						return JSONResult.ok(0);
					}
				} else {
					return JSONResult.ok(-1);
				}
			} else {
				return JSONResult.ok(-3);
			}
		} else {
			return JSONResult.ok(-4);
		}
	}
	
	/**
	 * <p>Title: checkAssessmentStandard</p>
	 * <p>Description: 
	 * 		1 审核成功
	 * 		0 不存在该考核标准或被删除
	 * 		-1 该考核标准已审核
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/aschecksuccess")
	public JSONResult checkAssessmentStandardSuccess(@Param("id")Long id) {
		AssessmentStandard a = as.queryAssessmentStandardById(id);
		if (a!=null && a.getState()!=0) {
			if (a.getCheckStatus()==0) {
				a.setCheckStatus(1);
				as.updateAssessmentStandard(a);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: checkAssessmentStandardFail</p>
	 * <p>Description: 
	 * 		1 审核不通过
	 * 		0 不存在该考核标准或被删除
	 * 		-1 该考核标准已审核通过
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/ascheckfail")
	public JSONResult checkAssessmentStandardFail(@Param("id")Long id) {
		AssessmentStandard a = as.queryAssessmentStandardById(id);
		if (a!=null && a.getState()!=0) {
			if (a.getCheckStatus()==0) {
				a.setState(0);
				as.updateAssessmentStandard(a);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: resetAssessmentStandard</p>
	 * <p>Description: 
	 * 		1 恢复数据（已删除的数据）
	 * 		0 不存在该数据或者该数据未被删除
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/asreset")
	public JSONResult resetAssessmentStandard(@Param("id")Long id) {
		AssessmentStandard a = as.queryAssessmentStandardById(id);
		if (a!=null && a.getState()==0) {
			a.setState(1);
			as.updateAssessmentStandard(a);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: deleteAssessmentStandard</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/asdeletes")
	public JSONResult deleteAssessmentStandard(@Param("ids")Long[] ids) {
		as.deleteAssessmentStandardList(ids);
		
		return JSONResult.ok(1);
	}
	
	
	@GetMapping("/asquery")
	public JSONResult queryAssessmentStandard(ExtjsPageRequest pageable,Integer page) {
		List<AssessmentStandardDto> tis = as.selectAssessmentStandardDto(page);
		for (AssessmentStandardDto lddto : tis) {
			lddto.setCheckStatus("已审核");
		}
		PageInfo<AssessmentStandardDto> tiss = new PageInfo<>(tis);
		PageImpl<AssessmentStandardDto> pages = new PageImpl<AssessmentStandardDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	
	@GetMapping("/ascheck")
	public JSONResult queryAssessmentStandardCheck(ExtjsPageRequest pageable,Integer page) {
		List<AssessmentStandardDto> tis = as.selectAssessmentStandardCheckDto(page);
		for (AssessmentStandardDto lddto : tis) {
			lddto.setCheckStatus("待审核");
		}
		PageInfo<AssessmentStandardDto> tiss = new PageInfo<>(tis);
		PageImpl<AssessmentStandardDto> pages = new PageImpl<AssessmentStandardDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: mockAssessmentStandardPositionName</p>
	 * <p>Description: 
	 * 		0 不存在该岗位或被删除
	 * 		-1 该岗位未审核
	 * 		假的视图分权（需要seesion）
	 * </p>
	 * @param positionName
	 * @param userName
	 * @return
	 */
	@GetMapping("/asquerymock")
	public JSONResult mockQueryAssessmentStandardPositionName(@Param("positionName")String positionName, @Param("userName")String userName) {
		Position p = ps.queryPositionByPositionName(positionName);
		if (p!=null && p.getState()!=0) {
			if (p.getCheckStatus()!=0) {
				if (es.queryEmployeeByUserName(userName)!=null) {
					if (es.queryEmployeeByUserName(userName).getState()!=3) {
						return JSONResult.ok(as.queryAssessmentStandardListA(p.getId()));
					} else {
						return JSONResult.ok(as.queryAssessmentStandardListB(p.getId()));
					}
				} else {
					if (userName.equals("admin")) {
						return JSONResult.ok(as.queryAssessmentStandardListB(p.getId()));
					} else {
						return JSONResult.ok("这辈子都不会进入这里");
					}
				}
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: mockCheckAssessmentStandardPositionName</p>
	 * <p>Description: 
	 * 		0 不存在该岗位或被删除
	 * 		-1 该岗位未审核
	 * 		审核模糊查询（审核情况查看，未删除待审核）
	 * </p>
	 * @param positionName
	 * @return
	 */
	@GetMapping("/ascheckmock")
	public JSONResult mockCheckAssessmentStandardPositionName(@Param("positionName")String positionName) {
		Position p = ps.queryPositionByPositionName(positionName);
		if (p!=null && p.getState()!=0) {
			if (p.getCheckStatus()!=0) {
				return JSONResult.ok(as.queryAssessmentStandardListC(p.getId()));
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: saveEmployeeAssessment</p>
	 * <p>Description: 
	 * 		1 员工考核信息录入成功
	 * 		0 不存在该员工
	 * 		-1 该员工信息未审核
	 * </p>
	 * @param ea
	 * @param userName
	 * @return
	 */
	@PostMapping("/easave")
	public JSONResult saveEmployeeAssessment(EmployeeAssessment ea, @Param("userName")String userName, @Param("workResult")String workResult, @Param("attitude")String attitude,@Param("quality")String quality,@Param("skill")String skill,@Param("calculationWay")String calculationWay,@Param("assessmentType")String assessmentType,@Param("assessmentResult")String assessmentResult) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				Integer a = Integer.parseInt(workResult);
				Integer b = Integer.parseInt(attitude);
				Integer c = Integer.parseInt(quality);
				Integer d = Integer.parseInt(skill);
				Integer e = Integer.parseInt(assessmentType);
				Integer f = Integer.parseInt(assessmentResult);
				ea.setEmployeeId(emp.getId());
				ea.setWorkResult(a);
				ea.setAttitude(b);
				ea.setQuality(c);
				ea.setSkill(d);
				ea.setAssessmentType(e);
				ea.setAssessmentResult(f);
				ea.setState(1);
				ea.setCreateTime(new Date());
				ea.setCheckStatus(0);
				as.saveEmployeeAssessment(ea);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateEmployeeAssessment</p>
	 * <p>Description: 
	 * 		1 员工考核信息修改成功
	 * 		0 不存在该员工
	 * 		-1 该员工信息未审核
	 * </p>
	 * @param ea
	 * @param userName
	 * @return
	 */
	@PostMapping("/eaupdate")
	public JSONResult updateEmployeeAssessment(EmployeeAssessment ea, @Param("userName")String userName) {
		Employee emp = es.queryEmployeeByUserName(userName);
		if (emp!=null && emp.getState()!=0) {
			if (emp.getCheckSatus()!=0) {
				EmployeeAssessment eaa = as.queryEmployeeAssessmentById(ea.getId());
				eaa.setEmployeeId(emp.getId());
				eaa.setAssessmentType(ea.getAssessmentType());
				eaa.setWorkResult(ea.getWorkResult());
				eaa.setAttitude(ea.getAttitude());
				eaa.setQuality(ea.getQuality());
				eaa.setSkill(ea.getSkill());
				eaa.setAssessmentResult(ea.getAssessmentResult());
				eaa.setEvaluate(ea.getEvaluate());
				eaa.setNote(ea.getNote());
				as.updateEmployeeAssessment(eaa);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: checkEmployeeAssessmentSuccess</p>
	 * <p>Description: 
	 * 		1 审核成功
	 * 		0 不存在该考核标准或被删除
	 * 		-1 该考核标准已审核
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/eachecksuccess")
	public JSONResult checkEmployeeAssessmentSuccess(@Param("id")Long id) {
		EmployeeAssessment ea = as.queryEmployeeAssessmentById(id);
		if (ea!=null && ea.getState()!=0) {
			if (ea.getCheckStatus()==0) {
				ea.setCheckStatus(1);
				as.updateEmployeeAssessment(ea);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: checkEmployeeAssessmentFail</p>
	 * <p>Description: 
	 * 		1 审核不通过
	 * 		0 不存在该考核结果信息或被删除
	 * 		-1 该考核结果信息已审核通过
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/eacheckfail")
	public JSONResult checkEmployeeAssessmentFail(@Param("id")Long id) {
		EmployeeAssessment ea = as.queryEmployeeAssessmentById(id);
		if (ea!=null && ea.getState()!=0) {
			if (ea.getCheckStatus()==0) {
				ea.setState(0);
				as.updateEmployeeAssessment(ea);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: resetEmployeeAssessment</p>
	 * <p>Description: 
	 * 		1 恢复数据（已删除的数据）
	 * 		0 不存在该数据或者该数据未被删除
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/eareset")
	public JSONResult resetEmployeeAssessment(@Param("id")Long id) {
		EmployeeAssessment ea = as.queryEmployeeAssessmentById(id);
		if (ea!=null && ea.getState()==0) {
			ea.setState(1);
			as.updateEmployeeAssessment(ea);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: deleteEmployeeAssessment</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@PostMapping("/eadeletes")
	public JSONResult deleteEmployeeAssessment(@Param("ids")Long[] ids) {
		as.deleteEmployeeAssessmentList(ids);		
		return JSONResult.ok(1);
	}
	
	
	@GetMapping("/eaquery")
	public JSONResult queryEmployeeAssessment(ExtjsPageRequest pageable,Integer page) {
		List<EmployeeAssessmentDto> tis = as.selectEmployeeAssessment(page);
		for (EmployeeAssessmentDto lddto : tis) {
			lddto.setCheckStatus("已审核");
			if (lddto.getAssessmentType().equals("1")) {
				lddto.setAssessmentType("日常考核");
			}
			if (lddto.getAssessmentType().equals("2")) {
				lddto.setAssessmentType("定期考核");
			}
			if (lddto.getAssessmentType().equals("3")) {
				lddto.setAssessmentType("长期考核");
			}
			if (lddto.getAssessmentType().equals("4")) {
				lddto.setAssessmentType("不定期考核");
			}
			if (lddto.getWorkResult().equals("1")) {
				lddto.setWorkResult("优秀");
			}
			if (lddto.getWorkResult().equals("2")) {
				lddto.setWorkResult("良好");
			}
			if (lddto.getWorkResult().equals("3")) {
				lddto.setWorkResult("及格");
			}
			if (lddto.getWorkResult().equals("4")) {
				lddto.setWorkResult("不及格");
			}
			if (lddto.getAttitude().equals("1")) {
				lddto.setAttitude("优秀");
			}
			if (lddto.getAttitude().equals("2")) {
				lddto.setAttitude("良好");
			}
			if (lddto.getAttitude().equals("3")) {
				lddto.setAttitude("及格");
			}
			if (lddto.getAttitude().equals("4")) {
				lddto.setAttitude("不及格");
			}
			if (lddto.getQuality().equals("1")) {
				lddto.setQuality("优秀");
			}
			if (lddto.getQuality().equals("2")) {
				lddto.setQuality("良好");
			}
			if (lddto.getQuality().equals("3")) {
				lddto.setQuality("及格");
			}
			if (lddto.getQuality().equals("4")) {
				lddto.setQuality("不及格");
			}
			if (lddto.getSkill().equals("1")) {
				lddto.setSkill("优秀");
			}
			if (lddto.getSkill().equals("2")) {
				lddto.setSkill("良好");
			}
			if (lddto.getSkill().equals("3")) {
				lddto.setSkill("及格");
			}
			if (lddto.getSkill().equals("4")) {
				lddto.setSkill("不及格");
			}
			if (lddto.getAssessmentResult().equals("1")) {
				lddto.setAssessmentResult("优秀");
			}
			if (lddto.getAssessmentResult().equals("2")) {
				lddto.setAssessmentResult("良好");
			}
			if (lddto.getAssessmentResult().equals("3")) {
				lddto.setAssessmentResult("及格");
			}
			if (lddto.getAssessmentResult().equals("4")) {
				lddto.setAssessmentResult("不及格");
			}
			
		}
		PageInfo<EmployeeAssessmentDto> tiss = new PageInfo<>(tis);
		PageImpl<EmployeeAssessmentDto> pages = new PageImpl<EmployeeAssessmentDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	@GetMapping("/eacheck")
	public JSONResult queryEmployeeAssessmentCheck(ExtjsPageRequest pageable,Integer page) {
		List<EmployeeAssessmentDto> tis = as.selectEmployeeAssessmentCheck(page);
		for (EmployeeAssessmentDto lddto : tis) {
			lddto.setCheckStatus("未审核");
			if (lddto.getAssessmentType().equals("1")) {
				lddto.setAssessmentType("日常考核");
			}
			if (lddto.getAssessmentType().equals("2")) {
				lddto.setAssessmentType("定期考核");
			}
			if (lddto.getAssessmentType().equals("3")) {
				lddto.setAssessmentType("长期考核");
			}
			if (lddto.getAssessmentType().equals("4")) {
				lddto.setAssessmentType("不定期考核");
			}
			if (lddto.getWorkResult().equals("1")) {
				lddto.setWorkResult("优秀");
			}
			if (lddto.getWorkResult().equals("2")) {
				lddto.setWorkResult("良好");
			}
			if (lddto.getWorkResult().equals("3")) {
				lddto.setWorkResult("及格");
			}
			if (lddto.getWorkResult().equals("4")) {
				lddto.setWorkResult("不及格");
			}
			if (lddto.getAttitude().equals("1")) {
				lddto.setAttitude("优秀");
			}
			if (lddto.getAttitude().equals("2")) {
				lddto.setAttitude("良好");
			}
			if (lddto.getAttitude().equals("3")) {
				lddto.setAttitude("及格");
			}
			if (lddto.getAttitude().equals("4")) {
				lddto.setAttitude("不及格");
			}
			if (lddto.getQuality().equals("1")) {
				lddto.setQuality("优秀");
			}
			if (lddto.getQuality().equals("2")) {
				lddto.setQuality("良好");
			}
			if (lddto.getQuality().equals("3")) {
				lddto.setQuality("及格");
			}
			if (lddto.getQuality().equals("4")) {
				lddto.setQuality("不及格");
			}
			if (lddto.getSkill().equals("1")) {
				lddto.setSkill("优秀");
			}
			if (lddto.getSkill().equals("2")) {
				lddto.setSkill("良好");
			}
			if (lddto.getSkill().equals("3")) {
				lddto.setSkill("及格");
			}
			if (lddto.getSkill().equals("4")) {
				lddto.setSkill("不及格");
			}
			if (lddto.getAssessmentResult().equals("1")) {
				lddto.setAssessmentResult("优秀");
			}
			if (lddto.getAssessmentResult().equals("2")) {
				lddto.setAssessmentResult("良好");
			}
			if (lddto.getAssessmentResult().equals("3")) {
				lddto.setAssessmentResult("及格");
			}
			if (lddto.getAssessmentResult().equals("4")) {
				lddto.setAssessmentResult("不及格");
			}
		}
		PageInfo<EmployeeAssessmentDto> tiss = new PageInfo<>(tis);
		PageImpl<EmployeeAssessmentDto> pages = new PageImpl<EmployeeAssessmentDto>(tis,pageable.getPageable(),tiss.getTotal());
		return JSONResult.ok(pages);
	}
	
	/**
	 * <p>Title: saveGreatTeam</p>
	 * <p>Description: 
	 * 		1 优秀团队录入成功
	 * 		0 不存在该部门
	 * 		-1 该部门信息未审核
	 * </p>
	 * @param gt
	 * @param departmentNumber
	 * @return
	 */
	@PostMapping("/gtsave")
	public JSONResult saveGreatTeam(GreatTeam gt, @Param("departmentNumber")String departmentNumber) {
		Department d = ds.queryDepartmentByDepartmentNumber(departmentNumber);
		if (d!=null && d.getState()!=0) {
			if (d.getCheckStatus()!=0) {
				gt.setDepartmentId(d.getId());
				gt.setState(1);
				gt.setCreateTime(new Date());
				gt.setCheckStatus(0);
				as.saveGreatTeam(gt);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: updateGreatTeam</p>
	 * <p>Description: 
	 * 		1 优秀团队修改成功
	 * 		0 不存在该部门
	 * 		-1 该部门信息未审核
	 * </p>
	 * @param gt
	 * @param departmentNumber
	 * @return
	 */
	@PutMapping("/gtupdate")
	public JSONResult updateGreatTeam(GreatTeam gt, @Param("departmentNumber")String departmentNumber) {
		Department d = ds.queryDepartmentByDepartmentNumber(departmentNumber);
		if (d!=null && d.getState()!=0) {
			if (d.getCheckStatus()!=0) {
				GreatTeam gtt = as.queryGreatTeamById(gt.getId());
				gtt.setDepartmentId(d.getId());
				gtt.setCommend(gt.getCommend());
				gtt.setReward(gt.getReward());
				gtt.setNote(gt.getNote());
				as.updateGreatTeam(gtt);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		} else {
			return JSONResult.ok(0);
		}
	}
	
	/**
	 * <p>Title: checkGreatTeamSuccess</p>
	 * <p>Description: 
	 * 		1 审核成功
	 * 		0 不存在该优秀团队或被删除
	 * 		-1 该优秀团队已审核
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/gtchecksuccess")
	public JSONResult checkGreatTeamSuccess(@Param("id")Long id) {
		GreatTeam gt = as.queryGreatTeamById(id);
		if (gt!=null && gt.getState()!=0) {
			if (gt.getCheckStatus()==0) {
				gt.setCheckStatus(1);
				as.updateGreatTeam(gt);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: checkGreatTeamFail</p>
	 * <p>Description: 
	 * 		1 审核不通过
	 * 		0 不存在该优秀团队或被删除
	 * 		-1 该优秀团队已审核通过
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/gtcheckfail")
	public JSONResult checkGreatTeamFail(@Param("id")Long id) {
		GreatTeam gt = as.queryGreatTeamById(id);
		if (gt!=null && gt.getState()!=0) {
			if (gt.getCheckStatus()==0) {
				gt.setState(0);
				as.updateGreatTeam(gt);
				return JSONResult.ok(1);
			} else {
				return JSONResult.ok(-1);
			}
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: resetGreatTeam</p>
	 * <p>Description: 
	 * 		1 恢复数据（已删除的数据）
	 * 		0 不存在该数据或者该数据未被删除
	 * </p>
	 * @param id
	 * @return
	 */
	@PutMapping("/gtreset")
	public JSONResult resetGreatTeam(@Param("id")Long id) {
		GreatTeam gt = as.queryGreatTeamById(id);
		if (gt!=null && gt.getState()==0) {
			gt.setState(1);
			as.updateGreatTeam(gt);
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: deleteGreatTeam</p>
	 * <p>Description: 
	 * 		1 删除成功
	 * 		0 删除失败
	 * </p>
	 * @param id
	 * @return
	 */
	@DeleteMapping("/gtdelete")
	public JSONResult deleteGreatTeam(@Param("id")Long id) {
		as.deleteGreatTeam(id);
		if (as.queryGreatTeamById(id).getState()==0) {
			return JSONResult.ok(1);
		}
		return JSONResult.ok(0);
	}
	
	/**
	 * <p>Title: queryGreatTeam</p>
	 * <p>Description: 
	 * 		（需要seesion）
	 * 		假的视图分权，如果用户为人事部管理或者超级管理员则显示全部已审核信息，如果是人事部员工则只显示未被删除已审核的信息
	 * </p>
	 * @param userName
	 * @return
	 */
	@GetMapping("/gtquery")
	public JSONResult queryGreatTeam(@Param("userName") String userName) {
		if (es.queryEmployeeByUserName(userName)!=null) {
			if (es.queryEmployeeByUserName(userName).getState()!=3) {
				return JSONResult.ok(as.queryGreatTeamWhoIsNotDeleteAndCheckStatus());
			} else {
				return JSONResult.ok(as.queryGreatTeamCheckStatus());
			}
		} else {
			if (userName.equals("admin")) {
				return JSONResult.ok(as.queryGreatTeamCheckStatus());
			} else {
				return JSONResult.ok("这辈子都不会进入这里");
			}
		}
	}
	
	/**
	 * <p>Title: queryGreatTeamCheck</p>
	 * <p>Description: 审核情况查看，未删除待审核</p>
	 * @return
	 */
	@GetMapping("/gtcheck")
	public JSONResult queryGreatTeamCheck() {
		return JSONResult.ok(as.queryGreatTeamWhoIsNotDeleteAndAudited());	
	}
}
