package com.eManagement.eManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eManagement.eManagement.beans.BlueprintDto;
import com.eManagement.eManagement.beans.QuestionDto;
import com.eManagement.eManagement.dao.QuestionsDao;
import com.eManagement.eManagement.entity.Question;
import com.eManagement.eManagement.forms.AddQuestionForm;
import com.eManagement.eManagement.forms.ViewQuestionsForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class QuestionService {

	@Autowired
	QuestionsDao questionDao;
	
	public String getSubOption(String option) {
		JSONObject subOptions = new JSONObject();
		if(option.equalsIgnoreCase("OBJ")) {
			subOptions.put("MCQ","Mutltiple choice question");
			subOptions.put("FIB","Fill in the blanks");
			subOptions.put("TF","True False");
		}else {
			subOptions.put("VLA","Very long answers");
			subOptions.put("VSA","Very short answers");
			subOptions.put("SA","Short answers");
			subOptions.put("LA","Long answers");
			subOptions.put("FIB","Fill in the blanks");
		}
		
		return subOptions.toString();
	}
	
	
	public String getAddQuestion(AddQuestionForm params) {
		if(params.getSuboption().equalsIgnoreCase("MCQ")) {
			return this.questionDao.addMCQQuestion(params);
		}else if(params.getSuboption().equalsIgnoreCase("TF")) {
			return this.questionDao.addTFQuestions(params);
		}else if(params.getSuboption().equalsIgnoreCase("FIB")) {
			return this.questionDao.addFIBQuestion(params);
		}
		return "";
	}


	public String initQuestion() {
		return this.questionDao.initQuestion();
	}


	public String getQuestions(ViewQuestionsForm params) {
		
		StringBuilder whereClause =new StringBuilder();
		
		String quesid = params.getQUESID();
		String option = params.getOPTION();
		String suboption = params.getSUBOPTION();
		String category = params.getCATEGORY();
		String subcategory = params.getSUBCATEGORY();
		String questiondescription = params.getQUESTIONDESC();
		whereClause.append(" 1=1 ");
		
		if(quesid != null && !quesid.equals("")) {
			whereClause.append(" and questionid='").append(quesid).append("'");
		}
		if(option != null && !option.equals("")) {
			whereClause.append(" and option='").append(option).append("'");
		}
		if(suboption != null && !suboption.equals("")) {
			whereClause.append(" and suboption='").append(suboption).append("'");
		}
		if(category != null && !category.equals("")) {
			whereClause.append(" and category='").append(category).append("'");
		}
		if(subcategory != null && !subcategory.equals("")) {
			whereClause.append(" and subcategory='").append(subcategory).append("'");
		}
		if(questiondescription != null && !questiondescription.equals("")) {
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
		
		for(Question question : questions) {
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
	
}
