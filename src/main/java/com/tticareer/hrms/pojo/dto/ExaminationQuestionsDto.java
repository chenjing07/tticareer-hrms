package com.tticareer.hrms.pojo.dto;

import java.util.Date;

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
	private Integer category;
	private String explanation;
	/**
     * 状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }
     */
    private Integer state;
    private Date createTime;
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
	public void setNote(String note) {
		this.note = note;
	}
    
    
}
