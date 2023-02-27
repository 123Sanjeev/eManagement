package com.emms.wipro.iaf.eAssessment.dto;

public class WorkFlowProcessDto {
	
	private String app;
	private String pendingWith;
	private String routedTo;
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getPendingWith() {
		return pendingWith;
	}
	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}
	public String getRoutedTo() {
		return routedTo;
	}
	public void setRoutedTo(String routedTo) {
		this.routedTo = routedTo;
	}
	public WorkFlowProcessDto(String app, String pendingWith, String routedTo) {
		super();
		this.app = app;
		this.pendingWith = pendingWith;
		this.routedTo = routedTo;
	}
	
}
