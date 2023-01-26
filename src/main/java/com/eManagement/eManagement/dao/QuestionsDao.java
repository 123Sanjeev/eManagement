package com.eManagement.eManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.eManagement.eManagement.entity.McqQuestions;
import com.eManagement.eManagement.entity.Question;
import com.eManagement.eManagement.forms.AddQuestionForm;

@SuppressWarnings("deprecation")
@Repository
public class QuestionsDao {

	private EntityManager entityManager;

	QuestionsDao(EntityManager manager) {
		this.entityManager = manager;
	}

	public String addMCQQuestion(AddQuestionForm params) {

		Session sessions = this.entityManager.unwrap(Session.class);
		Question question = new Question();
		McqQuestions mcqQuestion = new McqQuestions();

		question.setCategory(params.getCategory());
		question.setSubcategory(params.getSubcategory());
		question.setSuboption(params.getSuboption());
		question.setOption(params.getOption());
		question.setQuestiondescription(params.getQuestion());
		question.setAnswer(params.getMcqanswer());
		question.setQuestionid(params.getQuestionid());

		mcqQuestion.setOption1(params.getMcqoptions()[0]);
		mcqQuestion.setOption2(params.getMcqoptions()[1]);
		mcqQuestion.setOption3(params.getMcqoptions()[2]);
		mcqQuestion.setOption4(params.getMcqoptions()[3]);
		
		mcqQuestion.setQuestion(question);
		question.setMcqQuestions(mcqQuestion);
		
		sessions.saveOrUpdate(question);

		return Integer.toString(params.getQuestionid());
	}
	
	public String addTFQuestions(AddQuestionForm params) {
		
		Session sessions = this.entityManager.unwrap(Session.class);
		Question question = new Question();
		question.setCategory(params.getCategory());
		question.setSubcategory(params.getSubcategory());
		question.setSuboption(params.getSuboption());
		question.setOption(params.getOption());
		question.setQuestiondescription(params.getQuestion());
		question.setAnswer(params.getTfanswer());
		question.setQuestionid(params.getQuestionid());
		
		sessions.saveOrUpdate(question);
		return Integer.toString(params.getQuestionid());
	}


	public String addFIBQuestion(AddQuestionForm params) {
		
		Session sessions = this.entityManager.unwrap(Session.class);
		Question question = new Question();
		question.setCategory(params.getCategory());
		question.setSubcategory(params.getSubcategory());
		question.setSuboption(params.getSuboption());
		question.setOption(params.getOption());
		question.setQuestiondescription(params.getQuestion());
		question.setAnswer(params.getFibanswer());
		question.setQuestionid(params.getQuestionid());
		
		sessions.saveOrUpdate(question);
		return Integer.toString(params.getQuestionid());
	}
	
	public String initQuestion() {
		Session session = this.entityManager.unwrap(Session.class);
		Query hql = session.createQuery("from Question q ");
		return Integer.toString(hql.list().size()+1);
	}

	public List<Question> viewQuestions(String whereClause) {
	
		Session session = this.entityManager.unwrap(Session.class);
		StringBuilder query = new StringBuilder();
		query.append(" from Question where ");
		query.append(whereClause);
		Query hql = session.createQuery(query.toString());
		List<Question> question = (List<Question>)hql.list();
		return question;
		
	}

}
