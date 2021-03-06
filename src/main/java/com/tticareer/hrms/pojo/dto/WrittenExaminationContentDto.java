package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WrittenExaminationContentDto {

	private Long id;
	private Long oneId;
	private Long twoId;
	private Long threeId;
	private Long fourId;
	private Long fiveId;
	private Long sixId;
	private Long sevenId;
	private Long eightId;
	private Long nineId;
	private Long tenId;
	/**
        * 状态
            {
            	0冻结 1激活
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
	public Long getOneId() {
		return oneId;
	}
	public Long getTwoId() {
		return twoId;
	}
	public Long getThreeId() {
		return threeId;
	}
	public Long getFourId() {
		return fourId;
	}
	public Long getFiveId() {
		return fiveId;
	}
	public Long getSixId() {
		return sixId;
	}
	public Long getSevenId() {
		return sevenId;
	}
	public Long getEightId() {
		return eightId;
	}
	public Long getNineId() {
		return nineId;
	}
	public Long getTenId() {
		return tenId;
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
	public void setOneId(Long oneId) {
		this.oneId = oneId;
	}
	public void setTwoId(Long twoId) {
		this.twoId = twoId;
	}
	public void setThreeId(Long threeId) {
		this.threeId = threeId;
	}
	public void setFourId(Long fourId) {
		this.fourId = fourId;
	}
	public void setFiveId(Long fiveId) {
		this.fiveId = fiveId;
	}
	public void setSixId(Long sixId) {
		this.sixId = sixId;
	}
	public void setSevenId(Long sevenId) {
		this.sevenId = sevenId;
	}
	public void setEightId(Long eightId) {
		this.eightId = eightId;
	}
	public void setNineId(Long nineId) {
		this.nineId = nineId;
	}
	public void setTenId(Long tenId) {
		this.tenId = tenId;
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
	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	
}
