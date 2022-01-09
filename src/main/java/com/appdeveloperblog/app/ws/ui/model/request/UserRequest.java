package com.appdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequest {
	
	@NotEmpty(message="First Name cannot be Empty")
	private String firstName;
	
	@NotEmpty(message="First Name cannot be Empty")
	private String lastName;

	@NotEmpty(message="First Name cannot be Empty")
	@Email
	private String email;
	
	@NotEmpty(message="Password cannot be Empty")
	@Size(min=8,max=16,message = "Password should behave properly, Nerd!")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}
