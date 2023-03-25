package com.student.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBo {
	private int loginId;
	
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	private String confirmPassword;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
