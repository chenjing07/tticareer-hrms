package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InterviewDto {

	private Long id;
	private Long resumeId;
	private String oneContent;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date oneStart;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date oneEnd;
	private String oneFeedback;
	private String twoContent;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date twoStart;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date twoEnd;
	private String twoFeedback;
	/**
     * 状态
            {
            	0落选 1二面 2录用
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
	public Long getResumeId() {
		return resumeId;
	}
	public String getOneContent() {
		return oneContent;
	}
	public Date getOneStart() {
		return oneStart;
	}
	public Date getOneEnd() {
		return oneEnd;
	}
	public String getOneFeedback() {
		return oneFeedback;
	}
	public String getTwoContent() {
		return twoContent;
	}
	public Date getTwoStart() {
		return twoStart;
	}
	public Date getTwoEnd() {
		return twoEnd;
	}
	public String getTwoFeedback() {
		return twoFeedback;
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
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public void setOneContent(String oneContent) {
		this.oneContent = oneContent;
	}
	public void setOneStart(Date oneStart) {
		this.oneStart = oneStart;
	}
	public void setOneEnd(Date oneEnd) {
		this.oneEnd = oneEnd;
	}
	public void setOneFeedback(String oneFeedback) {
		this.oneFeedback = oneFeedback;
	}
	public void setTwoContent(String twoContent) {
		this.twoContent = twoContent;
	}
	public void setTwoStart(Date twoStart) {
		this.twoStart = twoStart;
	}
	public void setTwoEnd(Date twoEnd) {
		this.twoEnd = twoEnd;
	}
	public void setTwoFeedback(String twoFeedback) {
		this.twoFeedback = twoFeedback;
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

