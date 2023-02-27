package com.emms.wipro.iaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emms.wipro.iaf.eAssessment.forms.RegisterUserForm;
import com.emms.wipro.iaf.eAssessment.forms.UserLoginForm;
import com.emms.wipro.iaf.eAssessment.service.UserService;
import com.emms.wipro.iaf.maximo.service.MaximoService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MaximoService maximoService;
	@PostMapping("/login")
	@ResponseBody
	public String userLogin(@RequestBody final UserLoginForm userForm) {
		System.out.println(userForm.toString());
		return this.userService.login(userForm);
//		return "{\"status\":\"OK\",\"sessionkey\" :\"sfkashflsdhfksfsdfasdhfjkh\" }";// Login status with session key
	}

	@GetMapping("/register")
	@ResponseBody
	public int setUpRegisterUser() {
		return this.userService.setUpRegisterUser();
	}

	@PostMapping("/register/{userid}")
	@ResponseBody
	public String registerUser(@PathVariable String userid, @RequestBody final RegisterUserForm registerForm) {
		System.out.println("Userid : " + userid);
		System.out.println(registerForm.toString());
		return this.userService.registerUser(userid, registerForm);
//		return "{\"status\":\"OK\",\"sessionkey\" :\"sfkashflsdhfksfsdfasdhfjkh\" }";// Login status with session key
	}
	
	@GetMapping("/moodleAdminUser/{user}")
	@ResponseBody
	public String getMoodleAdminUser(@PathVariable String user) {
		return this.maximoService.getMoodleAdminUser(user);
	}
}
