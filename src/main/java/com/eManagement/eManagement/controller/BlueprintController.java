package com.eManagement.eManagement.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eManagement.eManagement.dto.BluePrintData;
import com.eManagement.eManagement.dto.BluePrintMarksbean;
import com.eManagement.eManagement.forms.BlueprintFormParamsHandler;
import com.eManagement.eManagement.service.BluePrintService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/blueprint")
public class BlueprintController {

	@Autowired
	private BluePrintService bpService;

	@RequestMapping("/create")
	@ResponseBody
//	public String createBlueprint(@RequestParam String location, @RequestParam String mastercoursename,
//			@RequestParam String Subject, @RequestParam String term, @RequestParam String title,@RequestParam String option) {
	public String createBlueprint(@RequestBody final BlueprintFormParamsHandler params) {
		return bpService.createUpdateBlueprint(params);
	}

	@RequestMapping("/view")
	@ResponseBody
	public String viewBlueprint(@RequestBody final BlueprintFormParamsHandler params ) throws JsonProcessingException {
		System.out.println(params.toString());
		return this.bpService.getBluePrint(params);
	}

}
