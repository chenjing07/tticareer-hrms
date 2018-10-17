package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class InterviewDto {

	private Long id;
	private Long resumeId;
	private String oneContent;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date oneStart;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date oneEnd;
	private String oneFeedback;
	private String twoContent;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date twoStart;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date twoEnd;
	private String twoFeedback;
	/**
     * 状态
            {
            	0落选 1二面 2录用
            }
     */
	private Integer state;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date createTime;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date createTimeStart;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
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

