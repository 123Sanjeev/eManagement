package com.emms.wipro.iaf.eAssessment.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emms.wipro.iaf.eAssessment.Repository.QuestionRepository;
import com.emms.wipro.iaf.eAssessment.entity.McqQuestions;
import com.emms.wipro.iaf.eAssessment.entity.Question;
import com.emms.wipro.iaf.eAssessment.forms.AddQuestionForm;

@SuppressWarnings("deprecation")
@Repository
public class QuestionsDao{

	@Autowired
	private QuestionRepository questionRepository;
	
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
		clearSessions(sessions);
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
		clearSessions(sessions);
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
		//Clearing current session
		clearSessions(sessions);
		return Integer.toString(params.getQuestionid());
	}
	
	public String initQuestion() {
		Session session = this.entityManager.unwrap(Session.class);
		Query hql = session.createQuery("from Question q ");
		//Clearing current session
		clearSessions(session);
		return Integer.toString(hql.list().size()+1);
	}

	public List<Question> viewQuestions(String whereClause) {
	
		Session session = this.entityManager.unwrap(Session.class);
		StringBuilder query = new StringBuilder();
		query.append(" from Question where ");
		query.append(whereClause);
		Query hql = session.createQuery(query.toString());
		List<Question> question = (List<Question>)hql.list();
		//Clearing current session
		clearSessions(session);
		return question;
	}

	public List<Question> getQuestionWithId(int id) {
		Session session = this.entityManager.unwrap(Session.class);
		StringBuilder query = new StringBuilder();
		query.append("from Question q where q.questionid=:id ");
		Query hql = session.createQuery(query.toString());
		hql.setParameter("id",id);
		List<Question> question = hql.list();
		//Clearing current session
		clearSessions(session);
		return question;	
	}
	
	
	
	public Question updateQuestion(Question question) {
		Session session = this.entityManager.unwrap(Session.class);
		
		System.out.println("Saving question using repository");
		Question questionUpdated = questionRepository.save(question);
		System.out.println("Updated question is: " + questionUpdated.getQuestiondescription());
//		if(question.getSuboption().equalsIgnoreCase("MCQ")) {
//			updateMcqQuestion(question.getMcqQuestions(), session);
//		}
		//Clearing current session		
		clearSessions(session);
		return questionUpdated;
	}
	
	public void updateMcqQuestion(McqQuestions mcqQuestion, Session session) {
		session.saveOrUpdate(mcqQuestion);
	}

	private void clearSessions(Session session) {
		try {
			session.disconnect();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isConnected()) {
				session.disconnect();
				session.close();
			}
		}
	}
	
	
	public int getMcqQuestionUniqueId(int questionid) {
		Session session = this.entityManager.unwrap(Session.class);
		System.out.println(" Question id received : " + questionid);
		Query sql = session.createQuery("from McqQuestions mcq where mcq.question.seq_id = :questionid");
		sql.setParameter("questionid",questionid);
		List<McqQuestions> mcqQuestions =(List<McqQuestions>)sql.list();
		int mcqQuestionid = mcqQuestions.get(0).getSeq_id();
		System.out.println("Mcq Question id : " + mcqQuestionid);
		return mcqQuestionid;
	}

}
