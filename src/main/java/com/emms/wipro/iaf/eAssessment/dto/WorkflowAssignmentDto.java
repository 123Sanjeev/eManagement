package com.emms.wipro.iaf.eAssessment.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkflowAssignmentDto {

	@JsonProperty("role")
	private String role;
	@JsonProperty("userid")
	private long userid;
	@JsonProperty("timecreated")
	private long timecreated;
	@JsonProperty("timeupdated")
	private long timeupdated;
	@JsonProperty("createdby")
	private long createdby;
	@JsonProperty("updatedby")
	private long updatedby;
	private String app;
	
	private String memo;
	private String pendingWith;
	

	@Override
	public String toString() {
		return "WorkflowAssignmentDto [role=" + role + ", userid=" + userid + ", timecreated=" + timecreated
				+ ", timeupdated=" + timeupdated + ", createdby=" + createdby + ", updatedby=" + updatedby + "]";
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

	public WorkflowAssignmentDto(String role, long userid, long timecreated, long timeupdated, long createdby,
			long updatedby, String app, String memo, String pendingWith) {
		super();
		this.role = role;
		this.userid = userid;
		this.timecreated = timecreated;
		this.timeupdated = timeupdated;
		this.createdby = createdby;
		this.updatedby = updatedby;
		this.app = app;
		this.memo = memo;
		this.pendingWith = pendingWith;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}

}
