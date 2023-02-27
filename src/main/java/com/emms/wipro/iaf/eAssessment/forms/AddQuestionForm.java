package com.emms.wipro.iaf.eAssessment.forms;

import java.util.Arrays;

public class AddQuestionForm {

	private int seq_id;
	private String option;
	private int questionid;
	private String suboption;
	private String category;
	private String subcategory;
	private String questiondsc;
	private boolean tfoptions[];
	private String mcqoptions[];
	private String tfanswer;
	private String mcqanswer;
	private String fibanswer;
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
	public String getQuestion() {
		return questiondsc;
	}
	public void setQuestion(String questiondsc) {
		this.questiondsc = questiondsc;
	}
	public boolean[] getTfoptions() {
		return tfoptions;
	}
	public void setTfoptions(boolean[] tfoptions) {
		this.tfoptions = tfoptions;
	}
	public String[] getMcqoptions() {
		return mcqoptions;
	}
	public void setMcqoptions(String[] mcqoptions) {
		this.mcqoptions = mcqoptions;
	}
	public String getTfanswer() {
		return tfanswer;
	}
	public void setTfanswer(String tfanswer) {
		this.tfanswer = tfanswer;
	}
	public String getMcqanswer() {
		return mcqanswer;
	}
	public void setMcqanswer(String mcqanswer) {
		this.mcqanswer = mcqanswer;
	}
	public String getFibanswer() {
		return fibanswer;
	}
	public void setFibanswer(String fibanswer) {
		this.fibanswer = fibanswer;
	}
	@Override
	public String toString() {
		return "AddQuestionForm [seq_id=" + seq_id + ", option=" + option + ", questionid=" + questionid
				+ ", suboption=" + suboption + ", category=" + category + ", subcategory=" + subcategory
				+ ", questiondsc=" + questiondsc + ", tfoptions=" + Arrays.toString(tfoptions) + ", mcqoptions="
				+ Arrays.toString(mcqoptions) + ", tfanswer=" + tfanswer + ", mcqanswer=" + mcqanswer + ", fibanswer="
				+ fibanswer + "]";
	}
	public AddQuestionForm(String option, String suboption, String category, String subcategory, String questiondsc,
			boolean[] tfoptions, String[] mcqoptions, String tfanswer, String mcqanswer, String fibanswer) {
		super();
		this.option = option;
		this.suboption = suboption;
		this.category = category;
		this.subcategory = subcategory;
		this.questiondsc = questiondsc;
		this.tfoptions = tfoptions;
		this.mcqoptions = mcqoptions;
		this.tfanswer = tfanswer;
		this.mcqanswer = mcqanswer;
		this.fibanswer = fibanswer;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public int getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}
	public String getQuestiondsc() {
		return questiondsc;
	}
	public void setQuestiondsc(String questiondsc) {
		this.questiondsc = questiondsc;
	}
	
	
	
	
}
