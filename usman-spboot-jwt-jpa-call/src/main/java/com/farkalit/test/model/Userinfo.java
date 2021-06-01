package com.farkalit.test.model;

import java.io.Serializable;

public class Userinfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String username;
	
	protected String password;
	
	public Userinfo() {}

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
	
	
}
