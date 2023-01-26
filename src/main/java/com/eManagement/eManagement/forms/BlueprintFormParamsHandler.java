package com.eManagement.eManagement.forms;

import java.util.Arrays;

public class BlueprintFormParamsHandler {

	private String blueprintid;
	private String location;
	private String mastercoursename;
	private String subject;
	private String title;
	private String option;
	private String term;
	private double marks[];
	private double totalmarks;
	private String status;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMastercoursename() {
		return mastercoursename;
	}
	public void setMastercoursename(String mastercoursename) {
		this.mastercoursename = mastercoursename;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public double[] getMarks() {
		return marks;
	}
	public void setMarks(double[] marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "BlueprintFormParamsHandler [location=" + location + ", mastercoursename=" + mastercoursename
				+ ", Subject=" + subject + ", title=" + title + ", option=" + option + ", term=" + term + ", marks="
				+ Arrays.toString(marks) + "]";
	}
	public double getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(double totalmarks) {
		this.totalmarks = totalmarks;
	}
	public String getBlueprintid() {
		return blueprintid;
	}
	public void setBlueprintid(String blueprintid) {
		this.blueprintid = blueprintid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
