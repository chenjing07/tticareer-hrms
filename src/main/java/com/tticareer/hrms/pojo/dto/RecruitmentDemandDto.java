package com.tticareer.hrms.pojo.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class RecruitmentDemandDto {

	private Long id;
	private Long positionId;
	private Integer planNumber;
	private Long salary;
	private Integer supplementalNumber;
	private String supplementReason;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date arrivalDate;
	private String languageRequirements;
	private String professionalRequirements;
	private String educationalRequirements;
	private String computerRequirements;
	private String experienceRequirements;
	private String ageRequirements;
	private String postDuties;
	private String postRequirements;
	/**
      * 状态
            {
            	0冻结1激活
            }
     */
	private Integer state;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")  
	private Date createTimeStart;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8") 
	private Date createTimeEnd;
	
	private String note;
	public Long getId() {
		return id;
	}
	public Long getPositionId() {
		return positionId;
	}
	public Integer getPlanNumber() {
		return planNumber;
	}
	public Long getSalary() {
		return salary;
	}
	public Integer getSupplementalNumber() {
		return supplementalNumber;
	}
	public String getSupplementReason() {
		return supplementReason;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public String getLanguageRequirements() {
		return languageRequirements;
	}
	public String getProfessionalRequirements() {
		return professionalRequirements;
	}
	public String getEducationalRequirements() {
		return educationalRequirements;
	}
	public String getComputerRequirements() {
		return computerRequirements;
	}
	public String getExperienceRequirements() {
		return experienceRequirements;
	}
	public String getAgeRequirements() {
		return ageRequirements;
	}
	public String getPostDuties() {
		return postDuties;
	}
	public String getPostRequirements() {
		return postRequirements;
	}
	public Integer getState() {
		return state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public Date getCreateTimeStart() {
		return createTimeStart;
	}
	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public void setPlanNumber(Integer planNumber) {
		this.planNumber = planNumber;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public void setSupplementalNumber(Integer supplementalNumber) {
		this.supplementalNumber = supplementalNumber;
	}
	public void setSupplementReason(String supplementReason) {
		this.supplementReason = supplementReason;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public void setLanguageRequirements(String languageRequirements) {
		this.languageRequirements = languageRequirements;
	}
	public void setProfessionalRequirements(String professionalRequirements) {
		this.professionalRequirements = professionalRequirements;
	}
	public void setEducationalRequirements(String educationalRequirements) {
		this.educationalRequirements = educationalRequirements;
	}
	public void setComputerRequirements(String computerRequirements) {
		this.computerRequirements = computerRequirements;
	}
	public void setExperienceRequirements(String experienceRequirements) {
		this.experienceRequirements = experienceRequirements;
	}
	public void setAgeRequirements(String ageRequirements) {
		this.ageRequirements = ageRequirements;
	}
	public void setPostDuties(String postDuties) {
		this.postDuties = postDuties;
	}
	public void setPostRequirements(String postRequirements) {
		this.postRequirements = postRequirements;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
