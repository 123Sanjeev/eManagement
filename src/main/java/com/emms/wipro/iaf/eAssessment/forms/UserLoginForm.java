package com.emms.wipro.iaf.eAssessment.forms;

public class UserLoginForm {

	private int userId;
	private String password;
	private String loginkey;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginkey() {
		return loginkey;
	}
	public void setLoginkey(String loginkey) {
		this.loginkey = loginkey;
	}
	@Override
	public String toString() {
		return "UserLoginForm [userId=" + userId + ", password=" + password + ", loginkey=" + loginkey + "]";
	}
	
}
