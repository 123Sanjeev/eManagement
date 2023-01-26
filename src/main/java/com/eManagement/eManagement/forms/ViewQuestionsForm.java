package com.eManagement.eManagement.forms;

public class ViewQuestionsForm {

	public String QUESID;
	public String OPTION;
	public String SUBOPTION;
	public String CATEGORY;
	public String SUBCATEGORY;
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
		return "ViewQuestionsForm [QUESID=" + QUESID + ", OPTION=" + OPTION + ", SUBOPTION=" + SUBOPTION + ", CATEGORY="
				+ CATEGORY + ", SUBCATEGORY=" + SUBCATEGORY + ", QUESTIONDESC=" + QUESTIONDESC + "]";
	}
	public ViewQuestionsForm(String qUESID, String oPTION, String sUBOPTION, String cATEGORY, String sUBCATEGORY,
			String qUESTIONDESC) {
		super();
		QUESID = qUESID;
		OPTION = oPTION;
		SUBOPTION = sUBOPTION;
		CATEGORY = cATEGORY;
		SUBCATEGORY = sUBCATEGORY;
		QUESTIONDESC = qUESTIONDESC;
	}
	
	
}
