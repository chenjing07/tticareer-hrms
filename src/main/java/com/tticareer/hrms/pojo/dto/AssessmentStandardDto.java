package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月24日 上午9:02:58 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: AssessmentStandardDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class AssessmentStandardDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long positionId;
	private String positionNumber;
	private String positionName;
	private String workResult;
	private String attitude;
	private String quality;
	private String skill;
	private String calculationWay;
	private String assessmentType;
	private String resultLevel;
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
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getPositionNumber() {
		return positionNumber;
	}
	public void setPositionNumber(String positionNumber) {
		this.positionNumber = positionNumber;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
	public String getCalculationWay() {
		return calculationWay;
	}
	public void setCalculationWay(String calculationWay) {
		this.calculationWay = calculationWay;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public String getResultLevel() {
		return resultLevel;
	}
	public void setResultLevel(String resultLevel) {
		this.resultLevel = resultLevel;
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
	public AssessmentStandardDto(Long id, Long positionId, String positionNumber, String positionName,
			String workResult, String attitude, String quality, String skill, String calculationWay,
			String assessmentType, String resultLevel, Date createTime, String checkStatus, String note) {
		super();
		this.id = id;
		this.positionId = positionId;
		this.positionNumber = positionNumber;
		this.positionName = positionName;
		this.workResult = workResult;
		this.attitude = attitude;
		this.quality = quality;
		this.skill = skill;
		this.calculationWay = calculationWay;
		this.assessmentType = assessmentType;
		this.resultLevel = resultLevel;
		this.createTime = createTime;
		this.checkStatus = checkStatus;
		this.note = note;
	}
	public AssessmentStandardDto() {
		super();
	}
	@Override
	public String toString() {
		return "AssessmentStandardDto [id=" + id + ", positionId=" + positionId + ", positionNumber=" + positionNumber
				+ ", positionName=" + positionName + ", workResult=" + workResult + ", attitude=" + attitude
				+ ", quality=" + quality + ", skill=" + skill + ", calculationWay=" + calculationWay
				+ ", assessmentType=" + assessmentType + ", resultLevel=" + resultLevel + ", createTime=" + createTime
				+ ", checkStatus=" + checkStatus + ", note=" + note + "]";
	}
	
}
