package com.codingdojo.gotnxt.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class LoginUser {
	
	@NotEmpty(message="You need a userName") 
	@Size(min=3, message="User Name must be min 3 characters")
	private String userName;
	
	@Size(min=8, message="Password must be min 8 charactors")
	private String password;

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
}
