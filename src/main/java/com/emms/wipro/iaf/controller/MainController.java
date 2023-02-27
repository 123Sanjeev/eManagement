package com.emms.wipro.iaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String Home() {
		
		
		
		return "Home";
	}
	
}
