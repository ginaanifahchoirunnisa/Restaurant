package com.google.codelab.spectaresto.response.register;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("status")
	private String status;

	@SerializedName("token")
	private String token;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"status = '" + status + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}