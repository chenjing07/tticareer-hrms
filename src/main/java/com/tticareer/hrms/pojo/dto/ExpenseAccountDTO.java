package com.tticareer.hrms.pojo.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tticareer.hrms.pojo.ExpenseAccount;
import com.tticareer.hrms.util.BeanUtils;

public class ExpenseAccountDTO {
	   private Long id;
	   private Long employeeId;
	   private String userName;
	   private String realName;
	   private Long amount;
	   private String reason;
	   private String content;
	   private Integer state;
	   private String rewardAndPunishmentState;
	   @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	   private Date createTime;
	   @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	   private Date time;
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
	public Long getAmount() {
		return amount;
	}
	public String getContent() {
		return content;
	}
	public Integer getState() {
		return state;
	}
	public String getRewardAndPunishmentState() {
		return rewardAndPunishmentState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getTime() {
		return time;
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
	public void setId(Long id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
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
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setRewardAndPunishmentState(String rewardAndPunishmentState) {
		this.rewardAndPunishmentState = rewardAndPunishmentState;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setTime(Date time) {
		this.time = time;
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
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "ExpenseAccountDTO [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
				+ realName + ", amount=" + amount + ", reason=" + reason + ", content=" + content + ", state=" + state
				+ ", rewardAndPunishmentState=" + rewardAndPunishmentState + ", createTime=" + createTime + ", time="
				+ time + ", checkStatus=" + checkStatus + ", statement=" + statement + ", checkStatusment="
				+ checkStatusment + ", note=" + note + "]";
	}
	public static void entityToDTO(ExpenseAccount entity,ExpenseAccountDTO dto) {   
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
