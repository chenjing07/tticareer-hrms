package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月23日 下午5:34:56 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: LateEarlyDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class LateEarlyDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date lateEarlyTime;
	private String lateEarlyReason;
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
	public Date getLateEarlyTime() {
		return lateEarlyTime;
	}
	public void setLateEarlyTime(Date lateEarlyTime) {
		this.lateEarlyTime = lateEarlyTime;
	}
	public String getLateEarlyReason() {
		return lateEarlyReason;
	}
	public void setLateEarlyReason(String lateEarlyReason) {
		this.lateEarlyReason = lateEarlyReason;
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
	public LateEarlyDto(Long id, Long employeeId, String userName, String realName, Date lateEarlyTime,
			String lateEarlyReason, String state, Date createTime, String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.lateEarlyTime = lateEarlyTime;
		this.lateEarlyReason = lateEarlyReason;
		this.state = state;
		this.createTime = createTime;
		this.note = note;
	}
	public LateEarlyDto() {
		super();
	}
	@Override
	public String toString() {
		return "LateEarlyDto [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
				+ realName + ", lateEarlyTime=" + lateEarlyTime + ", lateEarlyReason=" + lateEarlyReason + ", state="
				+ state + ", createTime=" + createTime + ", note=" + note + "]";
	}
	
	
}
