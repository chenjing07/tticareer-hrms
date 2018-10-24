package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月24日 上午8:47:44 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: LeaveDetailDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class LeaveDetailDto implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date leaveStart;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date leaveEnd;
	private Integer leaveDays;
	private String reason;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date realStart;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date realEnd;
	private String state;
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
	public Date getLeaveStart() {
		return leaveStart;
	}
	public void setLeaveStart(Date leaveStart) {
		this.leaveStart = leaveStart;
	}
	public Date getLeaveEnd() {
		return leaveEnd;
	}
	public void setLeaveEnd(Date leaveEnd) {
		this.leaveEnd = leaveEnd;
	}
	public Integer getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(Integer leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getRealStart() {
		return realStart;
	}
	public void setRealStart(Date realStart) {
		this.realStart = realStart;
	}
	public Date getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(Date realEnd) {
		this.realEnd = realEnd;
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
	public LeaveDetailDto(Long id, Long employeeId, String userName, String realName, Date leaveStart, Date leaveEnd,
			Integer leaveDays, String reason, Date realStart, Date realEnd, String state, Date createTime,
			String checkStatus, String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.leaveStart = leaveStart;
		this.leaveEnd = leaveEnd;
		this.leaveDays = leaveDays;
		this.reason = reason;
		this.realStart = realStart;
		this.realEnd = realEnd;
		this.state = state;
		this.createTime = createTime;
		this.checkStatus = checkStatus;
		this.note = note;
	}
	public LeaveDetailDto() {
		super();
	}
	@Override
	public String toString() {
		return "LeaveDetailDto [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
				+ realName + ", leaveStart=" + leaveStart + ", leaveEnd=" + leaveEnd + ", leaveDays=" + leaveDays
				+ ", reason=" + reason + ", realStart=" + realStart + ", realEnd=" + realEnd + ", state=" + state
				+ ", createTime=" + createTime + ", checkStatus=" + checkStatus + ", note=" + note + "]";
	}
	
	
}
