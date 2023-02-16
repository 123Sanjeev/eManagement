package com.eManagement.eManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eManagement.eManagement.dao.QuestionsDao;
import com.eManagement.eManagement.dto.McqQuestionDto;
import com.eManagement.eManagement.dto.QuestionDto;
import com.eManagement.eManagement.entity.McqQuestions;
import com.eManagement.eManagement.entity.Question;
import com.eManagement.eManagement.forms.AddQuestionForm;
import com.eManagement.eManagement.forms.ViewQuestionsForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuestionService {

	@Autowired
	QuestionsDao questionDao;
	ObjectMapper mapper;
	
	QuestionService(){
		this.mapper = new ObjectMapper();
	}

	public String getSubOption(String option) {
		JSONObject subOptions = new JSONObject();
		if (option.equalsIgnoreCase("OBJ")) {
			subOptions.put("MCQ", "Mutltiple choice question");
			subOptions.put("FIB", "Fill in the blanks");
			subOptions.put("TF", "True False");
		} else {
			subOptions.put("VLA", "Very long answers");
			subOptions.put("VSA", "Very short answers");
			subOptions.put("SA", "Short answers");
			subOptions.put("LA", "Long answers");
			subOptions.put("FIB", "Fill in the blanks");
		}

		return subOptions.toString();
	}

	public String getAddQuestion(AddQuestionForm params) {
		if (params.getSuboption().equalsIgnoreCase("MCQ")) {
			return this.questionDao.addMCQQuestion(params);
		} else if (params.getSuboption().equalsIgnoreCase("TF")) {
			return this.questionDao.addTFQuestions(params);
		} else if (params.getSuboption().equalsIgnoreCase("FIB")) {
			return this.questionDao.addFIBQuestion(params);
		}
		return "";
	}

	public String initQuestion() {
		return this.questionDao.initQuestion();
	}

	public String getQuestions(ViewQuestionsForm params) {

		StringBuilder whereClause = new StringBuilder();

		String quesid = params.getQUESID();
		String option = params.getOPTION();
		String suboption = params.getSUBOPTION();
		String category = params.getCATEGORY();
		String subcategory = params.getSUBCATEGORY();
		String questiondescription = params.getQUESTIONDESC();
		whereClause.append(" 1=1 ");

		if (quesid != null && !quesid.equals("")) {
			whereClause.append(" and questionid='").append(quesid).append("'");
		}
		if (option != null && !option.equals("")) {
			whereClause.append(" and option='").append(option).append("'");
		}
		if (suboption != null && !suboption.equals("")) {
			whereClause.append(" and suboption='").append(suboption).append("'");
		}
		if (category != null && !category.equals("")) {
			whereClause.append(" and category='").append(category).append("'");
		}
		if (subcategory != null && !subcategory.equals("")) {
			whereClause.append(" and subcategory='").append(subcategory).append("'");
		}
		if (questiondescription != null && !questiondescription.equals("")) {
			whereClause.append(" and questiondescription like '%").append(questiondescription).append("%'");
		}
		try {
			return questionsJsonString(this.questionDao.viewQuestions(whereClause.toString()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String questionsJsonString(List<Question> questions) throws JsonProcessingException {
		List<QuestionDto> questionDto = new ArrayList<QuestionDto>();

		for (Question question : questions) {
			QuestionDto qDto = new QuestionDto();
			qDto.setQUESID(Integer.toString(question.getQuestionid()));
			qDto.setOPTION(question.getOption());
			qDto.setSUBOPTION(question.getSuboption());
			qDto.setCATEGORY(question.getCategory());
			qDto.setSUBCATEGORY(question.getSubcategory());
			qDto.setQUESTIONDESC(question.getQuestiondescription());
			questionDto.add(qDto);
		}

		ObjectMapper mapper = new ObjectMapper();
		String questionString = mapper.writeValueAsString(questionDto);
		return questionString;
	}

	public String getQuestionWithId(int id) throws JsonProcessingException {

		List<Question> questionList = this.questionDao.getQuestionWithId(id);
		List<QuestionDto> quesDto = new ArrayList<QuestionDto>();

		for (Question question : questionList) {
			QuestionDto qDto = new QuestionDto();
			if (question.getSuboption().equals("MCQ")) {
				McqQuestionDto mcqDto = new McqQuestionDto();
				qDto = setQuestionDtoData(qDto, question);
				mcqDto = setMcqQuestionDtoData(mcqDto, question);
				qDto.setMcqQuestions(mcqDto);
			} else {
				qDto = setQuestionDtoData(qDto, question);
			}
			System.out.println(qDto.toString());
			quesDto.add(qDto);
		}

		ObjectMapper mapper = new ObjectMapper();
		String questionData = mapper.writeValueAsString(quesDto);
		return questionData;
	}

	public QuestionDto setQuestionDtoData(QuestionDto qDto, Question question) {
		qDto.setSeq_id(question.getSeq_id());
		qDto.setQUESID(Integer.toString(question.getQuestionid()));
		qDto.setOPTION(question.getOption());
		qDto.setSUBOPTION(question.getSuboption());
		qDto.setCATEGORY(question.getCategory());
		qDto.setSUBCATEGORY(question.getSubcategory());
		qDto.setQUESTIONDESC(question.getQuestiondescription());
		qDto.setAnswer(question.getAnswer());
		return qDto;
	}
	
	public McqQuestionDto setMcqQuestionDtoData(McqQuestionDto mcqDto, Question question) {
		mcqDto.setOption1(question.getMcqQuestions().getOption1());
		mcqDto.setOption2(question.getMcqQuestions().getOption2());
		mcqDto.setOption3(question.getMcqQuestions().getOption3());
		mcqDto.setOption4(question.getMcqQuestions().getOption4());
		return mcqDto;
	}


	public String updateQuestion(AddQuestionForm params) {
		
		System.out.println(params.toString());
		Question q = new Question();
		q.setSeq_id(params.getSeq_id());
		q.setOption(params.getOption());
		q.setSuboption(params.getSuboption());
		q.setCategory(params.getCategory());
		q.setSubcategory(params.getSubcategory());
		q.setQuestiondescription(params.getQuestiondsc());
		q.setQuestionid(params.getQuestionid());
		switch(params.getSuboption()) {
			case "MCQ":
				System.out.println("Inside mcq option ");
				McqQuestions mcqQuestion = new McqQuestions();
				mcqQuestion.setSeq_id(this.questionDao.getMcqQuestionUniqueId(q.getSeq_id()));
				mcqQuestion.setOption1(params.getMcqoptions()[0]);
				mcqQuestion.setOption2(params.getMcqoptions()[1]);
				mcqQuestion.setOption3(params.getMcqoptions()[2]);
				mcqQuestion.setOption4(params.getMcqoptions()[3]);
				System.out.println("Answer is: " + params.getMcqanswer());
				q.setAnswer(params.getMcqanswer());
				mcqQuestion.setQuestion(q);
				System.out.println("MCQ Question to string " + mcqQuestion.toString());
				q.setMcqQuestions(mcqQuestion);
				break;
			case "TF":
				q.setAnswer(params.getTfanswer());
				break;
			case "FIB":
				q.setAnswer(params.getFibanswer());
				break;
		}
		
		
		System.out.println(q.toString());
		
		
		
		Question question = this.questionDao.updateQuestion(q);
		QuestionDto qDto = new QuestionDto();
		switch(params.getSuboption()) {
			case "MCQ":
				McqQuestionDto mcqDto = new McqQuestionDto();
				mcqDto = setMcqQuestionDtoData(mcqDto, question);				
		}
		qDto = setQuestionDtoData(qDto, question);
		String questionString;
		try {
			questionString = this.mapper.writeValueAsString(qDto);
			return questionString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
