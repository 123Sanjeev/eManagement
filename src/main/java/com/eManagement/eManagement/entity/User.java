package com.eManagement.eManagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userid;
	
	@Column(name="user_id")
	private int user_id;
	

	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "location")
	private String location;
	@Column(name = "timecreated")
	private long timeCreated;
	@Column(name = "timeupdated")
	private long timeUpdated;
	@Column(name = "status")
	private String status;

	@ManyToMany(mappedBy = "user")
	private List<Role> roles;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", user_id=" + user_id + ", userName=" + userName + ", password=" + password
				+ ", location=" + location + ", timeCreated=" + timeCreated + ", timeUpdated=" + timeUpdated
				+ ", status=" + status + ", roles=" + roles + "]";
	}

}
