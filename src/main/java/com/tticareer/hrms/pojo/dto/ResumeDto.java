package com.tticareer.hrms.pojo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ResumeDto {

	private Long id;
	private String applicationName;
	private String expectedPosition;
	private String idCardNumber;
	private String idCardPicture;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date birthday;
	/**
      * 性别1男0女
     */
	private Integer gender;
	private String nation;
	private String nativePlace;
	private String registeredAddress;
	private String houseAddress;
	/**
      * 政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }
     */
	private Integer politicalStatus;
	/**
     * 婚姻状况  0未婚 1已婚
     */
	private Integer maritalStatus;
	private String phoneNumber;
	private String email;
	private String qq;
	private String education;
	private String academicDegree;
	private String major;
	private String tie;
	private String graduatedSchool;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date graduatedTime;
	private String awardsReceived;
	private String languageLevel;
	private String workExperience;
	private String hobbies;
	private String selfEvaluation;
	/**
      * 状态
            {
            	0待处理 1进入笔试 2落选
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
	public String getApplicationName() {
		return applicationName;
	}
	public String getExpectedPosition() {
		return expectedPosition;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public String getIdCardPicture() {
		return idCardPicture;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public String getNation() {
		return nation;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public String getRegisteredAddress() {
		return registeredAddress;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}
	public Integer getMaritalStatus() {
		return maritalStatus;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getQq() {
		return qq;
	}
	public String getEducation() {
		return education;
	}
	public String getAcademicDegree() {
		return academicDegree;
	}
	public String getMajor() {
		return major;
	}
	public String getTie() {
		return tie;
	}
	public String getGraduatedSchool() {
		return graduatedSchool;
	}
	public Date getGraduatedTime() {
		return graduatedTime;
	}
	public String getAwardsReceived() {
		return awardsReceived;
	}
	public String getLanguageLevel() {
		return languageLevel;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public String getHobbies() {
		return hobbies;
	}
	public String getSelfEvaluation() {
		return selfEvaluation;
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
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public void setExpectedPosition(String expectedPosition) {
		this.expectedPosition = expectedPosition;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public void setIdCardPicture(String idCardPicture) {
		this.idCardPicture = idCardPicture;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setTie(String tie) {
		this.tie = tie;
	}
	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}
	public void setGraduatedTime(Date graduatedTime) {
		this.graduatedTime = graduatedTime;
	}
	public void setAwardsReceived(String awardsReceived) {
		this.awardsReceived = awardsReceived;
	}
	public void setLanguageLevel(String languageLevel) {
		this.languageLevel = languageLevel;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public void setSelfEvaluation(String selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
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
