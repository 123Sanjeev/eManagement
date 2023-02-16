package com.eManagement.eManagement.forms;

public class RouteWfForm {
	
	private String app;
	
	private String routedby;
	
	private String role;
	
	private String routedTo;
	
	private String memo;
	
	private String ownerid;

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getRoutedby() {
		return routedby;
	}

	public void setRoutedby(String routedby) {
		this.routedby = routedby;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRoutedTo() {
		return routedTo;
	}

	public void setRoutedTo(String routedTo) {
		this.routedTo = routedTo;
	}
	
	@Override
	public String toString() {
		return "RouteWfForm [app=" + app + ", routedby=" + routedby + ", role=" + role + ", memo=" + memo + ", routedTo"+ routedTo+"]";
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public RouteWfForm(String app, String routedby, String role, String routedTo, String memo, String ownerid) {
		super();
		this.app = app;
		this.routedby = routedby;
		this.role = role;
		this.routedTo = routedTo;
		this.memo = memo;
		this.ownerid = ownerid;
	}
	
	
}
