package com.student.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginVo {
	@Id
	@GeneratedValue
	private int loginId;
	private String email;
	private String password;
	private String confirmPassword;
	private String role;
	
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="id")
	private StudentVo studentVo;
	public StudentVo getStudentVo() {
		return studentVo;
	}
	public void setStudentVo(StudentVo studentVo) {
		this.studentVo = studentVo;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
