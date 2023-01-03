package com.eManagement.eManagement.forms;

public class RegisterUserForm {
	
	private int userId;
	private String username;
	private String password;
	private String location;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RegisterUserForm [userId=" + userId + ", username=" + username + ", password=" + password
				+ ", location=" + location + "]";
	}
	
	
}
