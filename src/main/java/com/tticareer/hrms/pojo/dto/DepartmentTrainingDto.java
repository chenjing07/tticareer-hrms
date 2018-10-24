package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月17日 下午4:31:39 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: TrainingInfoDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class DepartmentTrainingDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long departmentId;
	private String lecturer;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date time;
	private String duration;
	private String purpose;
	private Integer number;
	private Long cost;
	private String place;
	private String content;
	private String state;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	private String note;
	private String departmentNumber;
	private String departmentName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
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
	public Date getCreatetime() {
		return createTime;
	}
	public void setCreatetime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public DepartmentTrainingDto(Long id, Long departmentId, String departmentNumber, String departmentName,
			String lecturer, Date time, String duration, String purpose, Integer number, Long cost, String place,
			String content, String state, Date createTime, String note) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.lecturer = lecturer;
		this.time = time;
		this.duration = duration;
		this.purpose = purpose;
		this.number = number;
		this.cost = cost;
		this.place = place;
		this.content = content;
		this.state = state;
		this.createTime = createTime;
		this.note = note;
	}
	public DepartmentTrainingDto() {
		super();
	}
	@Override
	public String toString() {
		return "DepartmentTrainingDto [id=" + id + ", departmentId=" + departmentId + ", lecturer=" + lecturer
				+ ", time=" + time + ", duration=" + duration + ", purpose=" + purpose + ", number=" + number
				+ ", cost=" + cost + ", place=" + place + ", content=" + content + ", state=" + state + ", createTime="
				+ createTime + ", note=" + note + ", departmentNumber=" + departmentNumber + ", departmentName="
				+ departmentName + "]";
	}
	
	
}
