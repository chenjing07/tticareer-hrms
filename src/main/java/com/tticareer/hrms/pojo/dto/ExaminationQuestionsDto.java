package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExaminationQuestionsDto {

	private Long id;
	private String question;
	private String answer;
	private Long score;
	/**
     * 难度等级
            {
            	0易 1中 2难
            }	
     */
	private Integer difficultyLevel;
	/**
     * 分类
     	{
     		1选择题 2填空题 3问答题 4计算题
     	}
     */
	private Integer category;
	private String explanation;
	/**
     * 状态
            {
            	0冻结 1未使用 2使用 -1有错误
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
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	public Long getScore() {
		return score;
	}
	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}
	public Integer getCategory() {
		return category;
	}
	public String getExplanation() {
		return explanation;
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
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
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
