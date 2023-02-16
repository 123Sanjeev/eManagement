package com.eManagement.eManagement.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eManagement.eManagement.forms.RouteWfForm;
import com.eManagement.eManagement.service.RouteWFService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/wfaction")
public class WorkflowController {

	@Autowired
	RouteWFService wfService;

	@PostMapping("/routewf")
	@ResponseBody
	public String routeWorkFlow(@RequestBody final RouteWfForm params) {
		System.out.println(params.toString());
		try {
			return this.wfService.routeWorkFlow(params);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	@GetMapping("/getAssignments")
	@ResponseBody
	public String getAssignments(@RequestParam int userid) {
		try {
			return this.wfService.getAssignments(userid);
		} catch (Exception e) {
			JSONObject errorObject = new JSONObject();
			errorObject.put("error", e.getMessage());
			return errorObject.toString();
		}
	}

	@RequestMapping(value = "/checkRecordEntry/{ownerid}", method = { RequestMethod.GET })
	@ResponseBody
	public String checkRecordEntry(@PathVariable String ownerid) {
		try {
			return this.wfService.checkRecordEntry(ownerid);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			JSONObject errorObject = new JSONObject();
			errorObject.put("error", e.getMessage());
			return errorObject.toString();
		}
	}

}
