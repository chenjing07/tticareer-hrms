package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WrittenExaminationDto {

	private Long id;
	private Long resumeId;
	private Long examContentId;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date examStart;
	private String note;
	private Long examScore;
	/**
     * 笔试结果
            {
            	1一面 0落选
            }
     */
	private Integer examResult;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date createTime;
	
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date createTimeStart;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")  
	private Date createTimeEnd;
	
	private Date examEnd;
	public Long getId() {
		return id;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public Long getExamContentId() {
		return examContentId;
	}
	public Date getExamStart() {
		return examStart;
	}
	public String getNote() {
		return note;
	}
	public Long getExamScore() {
		return examScore;
	}
	public Integer getExamResult() {
		return examResult;
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
	public Date getExamEnd() {
		return examEnd;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public void setExamContentId(Long examContentId) {
		this.examContentId = examContentId;
	}
	public void setExamStart(Date examStart) {
		this.examStart = examStart;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setExamScore(Long examScore) {
		this.examScore = examScore;
	}
	public void setExamResult(Integer examResult) {
		this.examResult = examResult;
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
	public void setExamEnd(Date examEnd) {
		this.examEnd = examEnd;
	}
	
	
}
