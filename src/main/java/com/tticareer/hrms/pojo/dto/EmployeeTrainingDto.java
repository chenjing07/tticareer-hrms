package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月22日 下午4:38:38 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: EmployeeTrainingDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class EmployeeTrainingDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	private String lecturer;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date time;
	private String duration;
	private String purpose;
	private Long cost;
	private String place;
	private String content;
	private String state;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
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
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public EmployeeTrainingDto(Long id, Long employeeId, String userName, String realName, String lecturer, Date time,
			String duration, String purpose, Long cost, String place, String content, String state, Date createTime,
			String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.lecturer = lecturer;
		this.time = time;
		this.duration = duration;
		this.purpose = purpose;
		this.cost = cost;
		this.place = place;
		this.content = content;
		this.state = state;
		this.createTime = createTime;
		this.note = note;
	}
	public EmployeeTrainingDto() {
		super();
	}
	
}
