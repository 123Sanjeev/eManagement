package com.eManagement.eManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eManagement.eManagement.forms.AddQuestionForm;
import com.eManagement.eManagement.forms.ViewQuestionsForm;
import com.eManagement.eManagement.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
@RequestMapping("/question")
public class QuestionBankController {

	@Autowired
	QuestionService questionService;

	@GetMapping("/initQuestion")
	@ResponseBody
	public String initNewQuesion() {
		return this.questionService.initQuestion();
	}

	@PostMapping("/addQuestion")
	@ResponseBody
	public String addQuestion(@RequestBody final AddQuestionForm params) {
		System.out.println(params);
		return this.questionService.getAddQuestion(params);
	}

	@PostMapping("/suboption")
	@ResponseBody
	public String getSubOption(String option) {
		System.out.println("Option is : " + option);
		return this.questionService.getSubOption(option);
	}

	@PostMapping("/viewQuestions")
	@ResponseBody
	public String getQuestions(@RequestBody final ViewQuestionsForm params) {
		System.out.println(params.toString());
		return this.questionService.getQuestions(params);
	}

	@PostMapping("/viewQuestionWithId")
	@ResponseBody
	public String getQuestionWithId(@RequestParam int id) {
		try {
			System.out.println("Id is: " + id);
			return this.questionService.getQuestionWithId(id);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@PostMapping("/updateQuestion")
	@ResponseBody
	public String updateQuestion(@RequestBody final AddQuestionForm params) {
		return this.questionService.updateQuestion(params);
	}

}
