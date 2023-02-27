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
@Table(name="blue_print_marks_details")
public class Blueprintmarksdetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blueprint_id", nullable = true, unique = false)
	private BluePrintTb blueprint;
	
	@Column(name="FIB_OBJ")
	private double FIBobjMarks;
	
	@Column(name="FIB_SUB")
	private double FIBsubMarks;
	
	@Column(name="VSA")
	private double VSAMarks;
	
	@Column(name="SA")
	private double SAMarks;
	
	@Column(name="LA")
	private double LAMarks;
	
	@Column(name="TF")
	private double TFMarks;
	
	@Column(name="MCQ")
	private double MCQMarks;
	
	@Column(name="Totalmarks")
	private double totalMarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BluePrintTb getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(BluePrintTb blueprint) {
		this.blueprint = blueprint;
	}

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
		return "Blueprintmarksdetails [id=" + id + ", blueprint=" + blueprint + ", FIBobjMarks=" + FIBobjMarks
				+ ", FIBsubMarks=" + FIBsubMarks + ", VSAMarks=" + VSAMarks + ", SAMarks=" + SAMarks + ", LAMarks="
				+ LAMarks + ", TFMarks=" + TFMarks + ", MCQMarks=" + MCQMarks + ", totalMarks=" + totalMarks + "]";
	}
	
	
}
