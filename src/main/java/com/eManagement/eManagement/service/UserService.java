package com.eManagement.eManagement.service;

import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eManagement.eManagement.dao.UserDao;
import com.eManagement.eManagement.entity.Role;
import com.eManagement.eManagement.entity.User;
import com.eManagement.eManagement.forms.RegisterUserForm;
import com.eManagement.eManagement.forms.UserLoginForm;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public String registerUser(String userid, RegisterUserForm registerForm) {
		Calendar c = Calendar.getInstance();
		User user = new User();
		user.setUser_id(Integer.parseInt(userid));
		user.setUserName(registerForm.getUsername());
		user.setPassword(registerForm.getPassword());
		user.setLocation(registerForm.getLocation());
		user.setStatus("Active");
		user.setTimeCreated(c.getTimeInMillis());
		user.setTimeUpdated(c.getTimeInMillis());
		return this.userDao.registerUser(user);
	}
	
	public int setUpRegisterUser() {
		int bufferedUserId = this.userDao.getLatestUserId();
		return bufferedUserId+1;
	}
	
	public String login(UserLoginForm loginForm){
		User user = this.userDao.login(loginForm);
		List<Role> roles =  user.getRoles();
		System.out.println(user.toString());
		
		JSONObject userData = new JSONObject();
		JSONArray role = new JSONArray();
		for(Role r : roles) {
			JSONObject roleData = new JSONObject();
			roleData.put("role",r.getRoleName());
			role.put(roleData);
		}
		userData.put("userid",user.getUser_id());
		userData.put("username",user.getUserName());
		userData.put("location",user.getLocation());
		userData.put("status", user.getStatus());
		userData.put("roles",role);
		
		
		return userData.toString();
	}
	
}
