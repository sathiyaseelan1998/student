package com.student.bo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class StudentBo {
	
	private int id;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Name Should be a Character")
	@Size(min = 3, max = 20)
	private String name;
	
	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid Email Format")
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 4, max = 8,message = "Password Size Must be 4 to 8")
	private String password;
	
	@NotEmpty
	@Size(min = 4 , max = 8 ,message= "Password Size Must be 4 to 8")
	@Valid
	private String confirmPassword;
	
	@NotNull
	@NotEmpty
	private String role;
	
	@NotNull
	@NotEmpty
	private String address;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
