package com.tticareer.hrms.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>CreateTime: 2018年10月23日 下午5:12:34 </p>
 * <p>ProjectName: hrms</p>
 * <p>FiletName: OverWorkDto.java</p>
 * @author dong
 * @version 1.0
 * <p>Description: </p>
 */
public class OverWorkDto implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long employeeId;
	private String userName;
	private String realName;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date time;
	private String duration;
	private String content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public OverWorkDto(Long id, Long employeeId, String userName, String realName, Date time, String duration,
			String content, Date createTime, String note) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.userName = userName;
		this.realName = realName;
		this.time = time;
		this.duration = duration;
		this.content = content;
		this.createTime = createTime;
		this.note = note;
	}
	public OverWorkDto() {
		super();
	}
	@Override
	public String toString() {
		return "OverWorkDto [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
				+ realName + ", time=" + time + ", duration=" + duration + ", content=" + content + ", createTime="
				+ createTime + ", note=" + note + "]";
	}
	
}
