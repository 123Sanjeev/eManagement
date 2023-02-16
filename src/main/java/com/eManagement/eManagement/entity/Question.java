package com.eManagement.eManagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seq_id")
	private int seq_id;
	
	@Column(name="questionid")
	private int questionid;
	
	@Column(name="question_desc")
	private String questiondescription;
	
	@Column(name="option")
	private String option;
	
	@Column(name="suboption")
	private String suboption;
	
	@Column(name="category")
	private String category;
	
	@Column(name="subcategory")
	private String subcategory;

	@Column(name="answer")
	private String answer;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "question")
	private McqQuestions mcqQuestions;
	

	public int getSeq_id() {
		return seq_id;
	}

	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestiondescription() {
		return questiondescription;
	}

	public void setQuestiondescription(String questiondescription) {
		this.questiondescription = questiondescription;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSuboption() {
		return suboption;
	}

	public void setSuboption(String suboption) {
		this.suboption = suboption;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public McqQuestions getMcqQuestions() {
		return mcqQuestions;
	}

	public void setMcqQuestions(McqQuestions mcqQuestions) {
		this.mcqQuestions = mcqQuestions;
	}

	@Override
	public String toString() {
		return "Question [seq_id=" + seq_id + ", questionid=" + questionid + ", questiondescription="
				+ questiondescription + ", option=" + option + ", suboption=" + suboption + ", category=" + category
				+ ", subcategory=" + subcategory + ", answer=" + answer + "]";
	}


}
