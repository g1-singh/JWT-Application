package com.life.spring.login.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	@Size(max = 30)
	private String userName;
	@NotBlank
	@Size(max = 120)
	private String password;
	private boolean loggedIn;

	public Admin() {
	}

	public Admin(int id, @NotBlank @Size(max = 30) String userName, @NotBlank @Size(max = 120) String password,
			@NotBlank boolean logggedIn) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.loggedIn = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean logggedIn) {
		this.loggedIn = logggedIn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Admin))
			return false;
		Admin admin = (Admin) o;
		return Objects.equals(userName, admin.userName) && Objects.equals(password, admin.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userName, password, loggedIn);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + ", logggedIn=" + loggedIn
				+ "]";
	}

}
