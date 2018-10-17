package com.tticareer.hrms.pojo.dto;

public class AuthenticationDto {

	private Long id;
	private String userName;
	private String password;
	private String realName;
	private String idCardNumber;
	private String idCardPicture;
	private Integer state;
	private Integer checkSatus;
	private String note;
	
	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getRealName() {
		return realName;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public String getIdCardPicture() {
		return idCardPicture;
	}
	public Integer getState() {
		return state;
	}
	public Integer getCheckSatus() {
		return checkSatus;
	}
	public String getNote() {
		return note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public void setIdCardPicture(String idCardPicture) {
		this.idCardPicture = idCardPicture;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setCheckSatus(Integer checkSatus) {
		this.checkSatus = checkSatus;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
