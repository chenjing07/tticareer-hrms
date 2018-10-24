package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月23日 上午10:47:45 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: TrainingFeedbackDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class TrainingFeedbackDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long trainingInfoId;
	private Long employeeId;
	private String userName;
	private String realName;
	private String lecturer;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date time;
	private String duration;
	private String purpose;
	private String place;
	private String content;
	private String trainingFeedback;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTrainingInfoId() {
		return trainingInfoId;
	}
	public void setTrainingInfoId(Long trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
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
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTrainingFeedback() {
		return trainingFeedback;
	}
	public void setTrainingFeedback(String trainingFeedback) {
		this.trainingFeedback = trainingFeedback;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public TrainingFeedbackDto(Long id, Long trainingInfoId, Long employeeId, String userName, String realName,
			String lecturer, Date time, String duration, String purpose, String place, String content,
			String trainingFeedback, Date createTime, String note) {
		super();
		this.id = id;
		this.trainingInfoId = trainingInfoId;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.lecturer = lecturer;
		this.time = time;
		this.duration = duration;
		this.purpose = purpose;
		this.place = place;
		this.content = content;
		this.trainingFeedback = trainingFeedback;
		this.createTime = createTime;
		this.note = note;
	}
	public TrainingFeedbackDto() {
		super();
	}
	@Override
	public String toString() {
		return "TrainingFeedbackDto [id=" + id + ", trainingInfoId=" + trainingInfoId + ", employeeId=" + employeeId
				+ ", userName=" + userName + ", realName=" + realName + ", lecturer=" + lecturer + ", time=" + time
				+ ", duration=" + duration + ", purpose=" + purpose + ", place=" + place + ", content=" + content
				+ ", trainingFeedback=" + trainingFeedback + ", createTime=" + createTime + ", note=" + note + "]";
	}
	
	
}
