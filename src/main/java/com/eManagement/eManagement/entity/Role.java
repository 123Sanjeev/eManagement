package com.eManagement.eManagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLEID")
	private int roleid;
	
	@Column(name="rolename")
	private String roleName;
	
	@Column(name="timecreated")
	private long timeCreated;
	
	@Column(name="timeupdated")
	private long timeUpdated;
	
	@ManyToMany
	@JoinTable(name="user_roles",
	joinColumns = @JoinColumn(name="ROLEID"),
	inverseJoinColumns = @JoinColumn(name="USERID"))
	private List<User> user;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public long getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(long timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public List<User> getUser() {
		return user;
	}

	
	
}
