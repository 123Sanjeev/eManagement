package com.emms.wipro.iaf.eAssessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mcq_questions")
public class McqQuestions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seq_id")
	private int seq_id;
	
	@Column(name="option_1")
	private String option1;
	

	@Column(name="option_2")
	private String option2;
	

	@Column(name="option_3")
	private String option3;
	

	@Column(name="option_4")
	private String option4;
	
	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = true, unique = false)
	private Question question;
	public int getSeq_id() {
		return seq_id;
	}
	
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}

	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getOption3() {
		return option3;
	}



	public void setOption3(String option3) {
		this.option3 = option3;
	}



	public String getOption4() {
		return option4;
	}



	public void setOption4(String option4) {
		this.option4 = option4;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "McqQuestions [seq_id=" + seq_id + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + ", question=" + question + "]";
	}
	
}
