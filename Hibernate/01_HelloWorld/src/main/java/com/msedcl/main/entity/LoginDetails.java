package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private int loginId;
	@Column(name = "password")
	private String password;
	@Column(name = "invalid_login_count")
	private int invalidLoginCount;
	@Column(name = "max")
	private int max;
	@Column(name = "status")
	private String status;

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(int invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", password=" + password + ", invalidLoginCount="
				+ invalidLoginCount + ", max=" + max + ", status=" + status + "]";
	}

	public LoginDetails(int loginId, String password, int invalidLoginCount, int max, String status) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.invalidLoginCount = invalidLoginCount;
		this.max = max;
		this.status = status;
	}

}
