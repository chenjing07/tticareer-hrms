package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tticareer.hrms.pojo.Employee;
import com.tticareer.hrms.pojo.SalaryDetail;
import com.tticareer.hrms.service.EmployeeService;
import com.tticareer.hrms.util.BeanUtils;

public class SalaryDetailDTO {
	
   private Long id;
   private Long employeeId;
   private String userName;
   private String realName;
   private Long basicSalary;
   private Long bonus;
   private Long subsidy;
   private Long overWorkSalary;
   private Long attendanceDeduction;
   private Long salaryTotal;
   @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8") 
   private Date nowYearMonth;
   private Integer state;
   @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")  
   private Date createTime;
   private Integer checkStatus;
   private String note;
   private String statement;
   private String checkStatusment;
public Long getId() {
	return id;
}
public Long getEmployeeId() {
	return employeeId;
}
public String getUserName() {
	return userName;
}
public Long getBasicSalary() {
	return basicSalary;
}
public Long getBonus() {
	return bonus;
}
public Long getSubsidy() {
	return subsidy;
}
public Long getOverWorkSalary() {
	return overWorkSalary;
}
public Long getAttendanceDeduction() {
	return attendanceDeduction;
}
public Long getSalaryTotal() {
	return salaryTotal;
}
public Date getNowYearMonth() {
	return nowYearMonth;
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
public String getNote() {
	return note;
}
public String getRealName() {
	return realName;
}
public String getStatement() {
	return statement;
}
public String getCheckStatusment() {
	return checkStatusment;
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
public void setBasicSalary(Long basicSalary) {
	this.basicSalary = basicSalary;
}
public void setBonus(Long bonus) {
	this.bonus = bonus;
}
public void setSubsidy(Long subsidy) {
	this.subsidy = subsidy;
}
public void setOverWorkSalary(Long overWorkSalary) {
	this.overWorkSalary = overWorkSalary;
}
public void setAttendanceDeduction(Long attendanceDeduction) {
	this.attendanceDeduction = attendanceDeduction;
}
public void setSalaryTotal(Long salaryTotal) {
	this.salaryTotal = salaryTotal;
}
public void setNowYearMonth(Date nowYearMonth) {
	this.nowYearMonth = nowYearMonth;
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
public void setNote(String note) {
	this.note = note;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public void setStatement(String statement) {
	this.statement = statement;
}
public void setCheckStatusment(String checkStatusment) {
	this.checkStatusment = checkStatusment;
}
@Override
public String toString() {
	return "SalaryDetailDTO [id=" + id + ", employeeId=" + employeeId + ", userName=" + userName + ", realName="
			+ realName + ", basicSalary=" + basicSalary + ", bonus=" + bonus + ", subsidy=" + subsidy
			+ ", overWorkSalary=" + overWorkSalary + ", attendanceDeduction=" + attendanceDeduction + ", salaryTotal="
			+ salaryTotal + ", nowYearMonth=" + nowYearMonth + ", state=" + state + ", createTime=" + createTime
			+ ", checkStatus=" + checkStatus + ", note=" + note + "]";
}
public static void entityToDTO(SalaryDetail entity,SalaryDetailDTO dto) {
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
  
}
