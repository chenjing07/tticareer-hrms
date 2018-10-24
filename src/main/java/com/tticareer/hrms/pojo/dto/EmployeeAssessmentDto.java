package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月24日 上午9:31:25 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: EmployeeAssessmentDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class EmployeeAssessmentDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	private String assessmentType;
	private String workResult;
	private String attitude;
	private String quality;
	private String skill;
	private String assessmentResult;
	private String evaluate;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	private String checkStatus;
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public String getWorkResult() {
		return workResult;
	}
	public void setWorkResult(String workResult) {
		this.workResult = workResult;
	}
	public String getAttitude() {
		return attitude;
	}
	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getAssessmentResult() {
		return assessmentResult;
	}
	public void setAssessmentResult(String assessmentResult) {
		this.assessmentResult = assessmentResult;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public EmployeeAssessmentDto(Long id, Long employeeId, String userName, String realName, String assessmentType,
			String workResult, String attitude, String quality, String skill, String assessmentResult, String evaluate,
			Date createTime, String checkStatus, String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.assessmentType = assessmentType;
		this.workResult = workResult;
		this.attitude = attitude;
		this.quality = quality;
		this.skill = skill;
		this.assessmentResult = assessmentResult;
		this.evaluate = evaluate;
		this.createTime = createTime;
		this.checkStatus = checkStatus;
		this.note = note;
	}
	public EmployeeAssessmentDto() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeAssessmentDto [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName
				+ ", realName=" + realName + ", assessmentType=" + assessmentType + ", workResult=" + workResult
				+ ", attitude=" + attitude + ", quality=" + quality + ", skill=" + skill + ", assessmentResult="
				+ assessmentResult + ", evaluate=" + evaluate + ", createTime=" + createTime + ", checkStatus="
				+ checkStatus + ", note=" + note + "]";
	}
	
	
}
