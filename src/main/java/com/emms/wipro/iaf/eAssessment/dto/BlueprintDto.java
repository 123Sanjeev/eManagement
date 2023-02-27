package com.emms.wipro.iaf.eAssessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlueprintDto {

	@JsonProperty("blueprintid")
	private int id;
	@JsonProperty("location")
	private String location;
	@JsonProperty("mastercoursename")
	private String masterCourseName;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("term")
	private String term;
	@JsonProperty("title")
	private String title;
	@JsonProperty("option")
	private String option;
	@JsonProperty("createdBy")
	private String createdBy;
	@JsonProperty("createdOnTimeStamp")
	private long createdOnTimeStamp;
	@JsonProperty("updatedOnTimeStamp")
	private long updatedOnTimeStamp;
	@JsonProperty("updatedBy")
	private String updatedBy;
	@JsonProperty("status")
	private String status;
	@JsonProperty("totalMarks")
	private double totalMarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMasterCourseName() {
		return masterCourseName;
	}
	public void setMasterCourseName(String masterCourseName) {
		this.masterCourseName = masterCourseName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public long getCreatedOnTimeStamp() {
		return createdOnTimeStamp;
	}
	public void setCreatedOnTimeStamp(long createdOnTimeStamp) {
		this.createdOnTimeStamp = createdOnTimeStamp;
	}
	public long getUpdatedOnTimeStamp() {
		return updatedOnTimeStamp;
	}
	public void setUpdatedOnTimeStamp(long updatedOnTimeStamp) {
		this.updatedOnTimeStamp = updatedOnTimeStamp;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "BlueprintDto [id=" + id + ", location=" + location + ", masterCourseName=" + masterCourseName
				+ ", subject=" + subject + ", term=" + term + ", title=" + title + ", option=" + option + ", createdBy="
				+ createdBy + ", createdOnTimeStamp=" + createdOnTimeStamp + ", updatedOnTimeStamp="
				+ updatedOnTimeStamp + ", updatedBy=" + updatedBy + ", status=" + status + ", totalMarks=" + totalMarks
				+ "]";
	}
	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

}
