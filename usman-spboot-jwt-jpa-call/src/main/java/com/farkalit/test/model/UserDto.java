package com.farkalit.test.model;

public class UserDto {

	private String username;
	private String password;

	private String emailId;
	private String phoneNum;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", emailId=" + emailId + ", phoneNum="
				+ phoneNum + "]";
	}

}
