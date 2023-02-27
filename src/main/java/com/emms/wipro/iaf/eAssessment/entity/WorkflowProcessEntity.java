package com.emms.wipro.iaf.eAssessment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_process")
public class WorkflowProcessEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "processid")
	private int processid;

	@Column(name = "ownerid")
	private String ownerid;

	@Column(name = "app")
	private String app;

	@Column(name = "memo")
	private String memo;
	
	@Column(name="pendingWith")
	private String pendingWith;
		
	@Column(name = "timecreated")
	private long timecreated;

	@Column(name = "timeupdated")
	private long timeupdated;

	@Column(name = "updatedby")
	private long updatedby;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wfprocess")
	private List<WorkflowAssignmentEntity> assignment;

	public int getProcessid() {
		return processid;
	}

	public void setProcessid(int processid) {
		this.processid = processid;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public long getTimecreated() {
		return timecreated;
	}

	public void setTimecreated(long timecreated) {
		this.timecreated = timecreated;
	}

	public long getTimeupdated() {
		return timeupdated;
	}

	public void setTimeupdated(long timeupdated) {
		this.timeupdated = timeupdated;
	}

	public long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}

	public List<WorkflowAssignmentEntity> getAssignment() {
		return assignment;
	}

	public void setAssignment(List<WorkflowAssignmentEntity> assignment) {
		this.assignment = assignment;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "WorkflowProcessEntity [processid=" + processid + ", ownerid=" + ownerid + ", app=" + app + ", memo="
				+ memo + ", timecreated=" + timecreated + ", timeupdated=" + timeupdated + ", updatedby=" + updatedby
				+ "]";
	}

	public String getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}

}
