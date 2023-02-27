package com.emms.wipro.iaf.eAssessment.dto;

public class BluePrintMarksbean {

	private double FIBobjMarks;

	private double FIBsubMarks;

	private double VSAMarks;

	private double SAMarks;

	private double LAMarks;

	private double TFMarks;

	private double MCQMarks;

	private double totalMarks;

	public double getFIBobjMarks() {
		return FIBobjMarks;
	}

	public void setFIBobjMarks(double fIBobjMarks) {
		FIBobjMarks = fIBobjMarks;
	}

	public double getFIBsubMarks() {
		return FIBsubMarks;
	}

	public void setFIBsubMarks(double fIBsubMarks) {
		FIBsubMarks = fIBsubMarks;
	}

	public double getVSAMarks() {
		return VSAMarks;
	}

	public void setVSAMarks(double vSAMarks) {
		VSAMarks = vSAMarks;
	}

	public double getSAMarks() {
		return SAMarks;
	}

	public void setSAMarks(double sAMarks) {
		SAMarks = sAMarks;
	}

	public double getLAMarks() {
		return LAMarks;
	}

	public void setLAMarks(double lAMarks) {
		LAMarks = lAMarks;
	}

	public double getTFMarks() {
		return TFMarks;
	}

	public void setTFMarks(double tFMarks) {
		TFMarks = tFMarks;
	}

	public double getMCQMarks() {
		return MCQMarks;
	}

	public void setMCQMarks(double mCQMarks) {
		MCQMarks = mCQMarks;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "BluePrintMarksbean [FIBobjMarks=" + FIBobjMarks + ", FIBsubMarks=" + FIBsubMarks + ", VSAMarks="
				+ VSAMarks + ", SAMarks=" + SAMarks + ", LAMarks=" + LAMarks + ", TFMarks=" + TFMarks + ", MCQMarks="
				+ MCQMarks + ", totalMarks=" + totalMarks + "]";
	}

}
