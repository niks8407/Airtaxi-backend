package com.lti.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDto {
	
	@Id
	private String email_Id;
	private String password;
	
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginDetails [email_Id=" + email_Id + ", password=" + password + "]";
	}
	
	
	
	
}
