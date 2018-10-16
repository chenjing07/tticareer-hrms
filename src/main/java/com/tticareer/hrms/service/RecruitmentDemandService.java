package com.tticareer.hrms.service;

import java.util.List;

import com.tticareer.hrms.pojo.RecruitmentDemand;
import com.tticareer.hrms.pojo.dto.RecruitmentDemandDto;

public interface RecruitmentDemandService {
	
	public void saveRecruitmentDemand(RecruitmentDemand rd);
	public void updateRecruitmentDemand(RecruitmentDemand rd);
	public void deleteRecruitmentDemand(Long id);
	public void deleteRecruitmentDemand(Long[] ids);
	public RecruitmentDemand queryRecruitmentDemandById(Long id);
	public RecruitmentDemand queryRecruitmentDemandByPositionId(Long positionId);
	public List<RecruitmentDemand> queryAllRecruitmentDemand();
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsDelete();
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsNotDelete();
	/*
	 * 模糊查询
	*/
	public List<RecruitmentDemand> queryRecruitmentDemandList(RecruitmentDemandDto rdDto);
}
