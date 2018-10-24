package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月23日 下午7:45:33 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: ClockDetailDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class ClockDetailDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date clockIn;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date clockOut;
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
	public Date getClockIn() {
		return clockIn;
	}
	public void setClockIn(Date clockIn) {
		this.clockIn = clockIn;
	}
	public Date getClockOut() {
		return clockOut;
	}
	public void setClockOut(Date clockOut) {
		this.clockOut = clockOut;
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
	public ClockDetailDto(Long id, Long employeeId, String userName, String realName, Date clockIn, Date clockOut,
			Date createTime, String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.clockIn = clockIn;
		this.clockOut = clockOut;
		this.createTime = createTime;
		this.note = note;
	}
	public ClockDetailDto() {
		super();
	}
	@Override
	public String toString() {
		return "ClockDetailDto [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
				+ realName + ", clockIn=" + clockIn + ", clockOut=" + clockOut + ", createTime=" + createTime
				+ ", note=" + note + "]";
	}
	
	
}
