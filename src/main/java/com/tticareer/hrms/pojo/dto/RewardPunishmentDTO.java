package com.tticareer.hrms.pojo.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tticareer.hrms.pojo.RewardPunishment;
import com.tticareer.hrms.util.BeanUtils;

public class RewardPunishmentDTO {
   private Long id;
   private Long employeeId;
   private String userName;
   private String realName;
   private Integer rewardAndPunishment;
   private String content;
   private Integer state;
   private String rewardAndPunishmentState;
   @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
   private Date createTime;
   
   private Integer checkStatus;
   private String statement;
   private String checkStatusment;
   private String note;
public Long getId() {
	return id;
}
public Long getEmployeeId() {
	return employeeId;
}
public String getUserName() {
	return userName;
}
public String getRealName() {
	return realName;
}
public Integer getRewardAndPunishment() {
	return rewardAndPunishment;
}
public String getContent() {
	return content;
}
public Integer getState() {
	return state;
}
public Date getCreateTime() {
	return createTime;
}
public Integer getCheckStatus() {
	return checkStatus;
}
public String getStatement() {
	return statement;
}
public String getCheckStatusment() {
	return checkStatusment;
}
public String getNote() {
	return note;
}
public String getRewardAndPunishmentState() {
	return rewardAndPunishmentState;
}
public void setId(Long id) {
	this.id = id;
}
public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public void setRewardAndPunishment(Integer rewardAndPunishment) {
	this.rewardAndPunishment = rewardAndPunishment;
}
public void setContent(String content) {
	this.content = content;
}
public void setState(Integer state) {
	this.state = state;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public void setCheckStatus(Integer checkStatus) {
	this.checkStatus = checkStatus;
}
public void setStatement(String statement) {
	this.statement = statement;
}
public void setCheckStatusment(String checkStatusment) {
	this.checkStatusment = checkStatusment;
}
public void setNote(String note) {
	this.note = note;
}
public void setRewardAndPunishmentState(String rewardAndPunishmentState) {
	this.rewardAndPunishmentState = rewardAndPunishmentState;
}
@Override
public String toString() {
	return "RwardPunishmentDTO [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
			+ realName + ", rewardAndPunishment=" + rewardAndPunishment + ", content=" + content + ", state=" + state
			+ ", createTime=" + createTime + ", checkStatus=" + checkStatus + ", statement=" + statement
			+ ", checkStatusment=" + checkStatusment + ", note=" + note + "]";
}
  public static void entityToDTO(RewardPunishment entity,RewardPunishmentDTO dto) {
	  BeanUtils.copyProperties(entity,dto);
		 if(dto.getState()==0) {
			 dto.setStatement("已冻结");
		 }else {
			 dto.setStatement("未冻结");
		 }
		 if(dto.getCheckStatus()==0) {
			 dto.setCheckStatusment("待审核");
		 }else {
			 dto.setCheckStatusment("已审核");
		 }
		 if(dto.getRewardAndPunishment()==0) {
			 dto.setRewardAndPunishmentState("惩罚");
		 }else {
			 dto.setRewardAndPunishmentState("奖励");
		 }
  }
  public static Date dealTimeStart(String timeStart) {
	  Date dateStart=null;
	  DateFormat format= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  if(StringUtils.isNotBlank(timeStart)) {
			try {
				dateStart = format.parse(timeStart);
				}catch (ParseException e) {
					e.printStackTrace();
				}
		}else {
			try {
				dateStart=format.parse("2000/01/01 00:00:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	  return dateStart;
  }
  public static Date dealTimeEnd(String timeEnd) {
	  Date dateEnd=null;
	  DateFormat format= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  if(StringUtils.isNotBlank(timeEnd)) {
			try {
				dateEnd = format.parse(timeEnd);
				}catch (ParseException e) {
					e.printStackTrace();
				}
		}else {
				dateEnd=new Date();
		}
	  return dateEnd;
  }
}

