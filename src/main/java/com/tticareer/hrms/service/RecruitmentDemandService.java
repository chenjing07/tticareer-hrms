package com.tticareer.hrms.service;


import java.util.Date;
import java.util.List;

import com.tticareer.hrms.pojo.RecruitmentDemand;

public interface RecruitmentDemandService {
	
	public void saveRecruitmentDemand(RecruitmentDemand rd);
	public void updateRecruitmentDemand(RecruitmentDemand rd);
	public void deleteRecruitmentDemand(Long id);
	public void deleteRecruitmentDemand(Long[] ids);
	public RecruitmentDemand queryRecruitmentDemandById(Long id);
	public List<RecruitmentDemand> queryRecruitmentDemandByPositionId(Long positionId,Integer pageNum,Integer pageSize,String orderBy);
	public List<RecruitmentDemand> queryRecruitmentDemandByCreateTime(Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
	public List<RecruitmentDemand> queryAllRecruitmentDemand(Integer pageNum,Integer pageSize,String orderBy);
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsDelete(Integer pageNum,Integer pageSize,String orderBy);
	public List<RecruitmentDemand> queryRecruitmentDemandWhoIsNotDelete(Integer pageNum,Integer pageSize,String orderBy);

	public List<RecruitmentDemand> queryRecruitmentDemandList(Long positionId,Date createTimeStart,Date createTimeEnd,Integer pageNum,Integer pageSize,String orderBy);
}
