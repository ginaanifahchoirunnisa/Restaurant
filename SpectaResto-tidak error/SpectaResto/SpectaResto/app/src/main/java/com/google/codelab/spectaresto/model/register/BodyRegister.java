package com.google.codelab.spectaresto.model.register;

import com.google.gson.annotations.SerializedName;

public class BodyRegister{

	@SerializedName("username")
	private String username;

	@SerializedName("password")
	private String password;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("email")
	private String email;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"BodyRegister{" + 
			"password = '" + password + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}