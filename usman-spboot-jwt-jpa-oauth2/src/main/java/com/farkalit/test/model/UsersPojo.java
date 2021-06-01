package com.farkalit.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UsersPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String username;

	protected String password;

	private Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();

	public UsersPojo() {
	}

	public UsersPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	public Collection<GrantedAuthority> getListOfgrantedAuthorities() {
		return listOfgrantedAuthorities;
	}

	public void setListOfgrantedAuthorities(Collection<GrantedAuthority> listOfgrantedAuthorities) {
		this.listOfgrantedAuthorities = listOfgrantedAuthorities;
	}

}
