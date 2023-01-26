package com.eManagement.eManagement.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionDto {

	@JsonProperty("QUESID")
	public String QUESID;
	@JsonProperty("OPTION")
	public String OPTION;
	@JsonProperty("SUBOPTION")
	public String SUBOPTION;
	@JsonProperty("CATEGORY")
	public String CATEGORY;
	@JsonProperty("SUBCATEGORY")
	public String SUBCATEGORY;
	@JsonProperty("QUESTIONDESC")
	public String QUESTIONDESC;
	public String getQUESID() {
		return QUESID;
	}
	public void setQUESID(String qUESID) {
		QUESID = qUESID;
	}
	public String getOPTION() {
		return OPTION;
	}
	public void setOPTION(String oPTION) {
		OPTION = oPTION;
	}
	public String getSUBOPTION() {
		return SUBOPTION;
	}
	public void setSUBOPTION(String sUBOPTION) {
		SUBOPTION = sUBOPTION;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getSUBCATEGORY() {
		return SUBCATEGORY;
	}
	public void setSUBCATEGORY(String sUBCATEGORY) {
		SUBCATEGORY = sUBCATEGORY;
	}
	public String getQUESTIONDESC() {
		return QUESTIONDESC;
	}
	public void setQUESTIONDESC(String qUESTIONDESC) {
		QUESTIONDESC = qUESTIONDESC;
	}
	@Override
	public String toString() {
		return "QuestionDto [QUESID=" + QUESID + ", OPTION=" + OPTION + ", SUBOPTION=" + SUBOPTION + ", CATEGORY="
				+ CATEGORY + ", SUBCATEGORY=" + SUBCATEGORY + ", QUESTIONDESC=" + QUESTIONDESC + "]";
	}
	
}
