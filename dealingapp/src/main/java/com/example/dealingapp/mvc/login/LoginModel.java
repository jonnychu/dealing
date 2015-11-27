package com.example.dealingapp.mvc.login;

import com.jgoodies.common.bean.Bean;

public class LoginModel extends Bean {
	private static final long serialVersionUID = -2472283469369282250L;
	public static final String PROPERTY_USERNAME = "username";
	public static final String PROPERTY_PASSWORD = "password";
	public static final String PROPERTY_REMEMBER_PASSWORD = "rememberPassword";
	public static final String ACTION_LOGIN = "Login";
	private String username;
	private String password;
	private boolean rememberPassword;
	//
	private int result=99;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public LoginModel() {
	}

	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String newValue) {
		String oldValue = getUsername();
		this.username = newValue;
		firePropertyChange(PROPERTY_USERNAME, oldValue, newValue);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String newValue) {
		String oldValue = getPassword();
		this.password = newValue;
		firePropertyChange(PROPERTY_PASSWORD, oldValue, newValue);
	}

	public boolean getRememberPassword() {
		return this.rememberPassword;
	}

	public void setRememberPassword(boolean newValue) {
		boolean oldValue = getRememberPassword();
		this.rememberPassword = newValue;
		firePropertyChange(PROPERTY_REMEMBER_PASSWORD, oldValue, newValue);
	}
}
