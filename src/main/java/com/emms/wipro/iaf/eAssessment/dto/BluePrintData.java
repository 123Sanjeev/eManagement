package com.emms.wipro.iaf.eAssessment.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BluePrintData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String location;
	private String masterCourseName;
	private String subject;
	private String term;
	private String title;
	private String option;
	private String createdBy;
	private long createdOnTimeStamp;
	private long updatedOnTimeStamp;
	private String updatedBy;
	private String status;

	private BluePrintMarksbean marksBean;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BluePrintData [id=" + id + ", location=" + location + ", masterCourseName=" + masterCourseName
				+ ", subject=" + subject + ", term=" + term + ", option=" + option + ", createdBy=" + createdBy
				+ ", createdOnTimeStamp=" + createdOnTimeStamp + ", updatedOnTimeStamp=" + updatedOnTimeStamp
				+ ", updatedBy=" + updatedBy + ", status=" + status + "]";
	}

	public BluePrintMarksbean getMarksBean() {
		return marksBean;
	}

	public void setMarksBean(BluePrintMarksbean marksBean) {
		this.marksBean = marksBean;
	}

}
