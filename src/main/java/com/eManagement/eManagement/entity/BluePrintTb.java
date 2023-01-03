package com.eManagement.eManagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="blue_print_tb")
public class BluePrintTb {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="location")
	private String location;
	
	@Column(name="masterCourseName")
	private String masterCourseName;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="term")
	private String term;
	
	@Column(name="title")
	private String title;
	
	@Column(name="option")
	private String option;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdontimestamp")
	private long createdOnTimeStamp;
	
	@Column(name="updatedontimestamp")
	private long updatedOnTimeStamp;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	@Column(name="status")
	private String status;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "blueprint")
	private Blueprintmarksdetails bpMarksDetails;
	
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

	public void setUpdatedBy(String string) {
		this.updatedBy = string;
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

	public Blueprintmarksdetails getBpMarksDetails() {
		return bpMarksDetails;
	}

	public void setBpMarksDetails(Blueprintmarksdetails bpMarksDetails) {
		this.bpMarksDetails = bpMarksDetails;
	}
	
	
}
