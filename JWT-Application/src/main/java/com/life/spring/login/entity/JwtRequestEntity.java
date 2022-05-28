package com.life.spring.login.entity;

import java.io.Serializable;

public class JwtRequestEntity implements Serializable {

	private static final long serialVersionUID = -9029919188709146299L;
	String userName;
	String password;

	public JwtRequestEntity() {
	}

	public JwtRequestEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequestEntity [userName=" + userName + ", Password=" + password + "]";
	}

}
