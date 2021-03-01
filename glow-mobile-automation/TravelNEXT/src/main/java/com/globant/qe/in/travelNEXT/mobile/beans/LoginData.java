package com.globant.qe.in.travelNEXT.mobile.beans;

import org.springframework.stereotype.Component;

@Component
public class LoginData {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
