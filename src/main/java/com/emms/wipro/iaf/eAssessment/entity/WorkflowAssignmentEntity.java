package com.emms.wipro.iaf.eAssessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_assignment")
public class WorkflowAssignmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assignmentid")
	private int assignmentid;

	@Column(name = "role")
	private String role;
	@Column(name = "userid")
	private long userid;
	@Column(name = "timecreated")
	private long timecreated;

	@Column(name = "timeupdated")
	private long timeupdated;

	@Column(name = "createdby")
	private long createdby;

	@Column(name = "updatedby")
	private long updatedby;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "process_id", nullable = true, unique = false)
	private WorkflowProcessEntity wfprocess;

	public int getAssignmentid() {
		return assignmentid;
	}

	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}

	public long getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}

	public WorkflowProcessEntity getWfprocess() {
		return wfprocess;
	}

	public void setWfprocess(WorkflowProcessEntity wfprocess) {
		this.wfprocess = wfprocess;
	}

	@Override
	public String toString() {
		return "WorkflowAssignmentEntity [assignmentid=" + assignmentid + ", role=" + role + ", userid=" + userid
				+ ", timecreated=" + timecreated + ", timeupdated=" + timeupdated + ", createdby=" + createdby
				+ ", updatedby=" + updatedby + "]";
	}
}
