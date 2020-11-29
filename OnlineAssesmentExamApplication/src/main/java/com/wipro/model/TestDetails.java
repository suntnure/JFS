package com.wipro.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTDETAILS")
public class TestDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private int id;

	@Column(name = "TestDate")
	private String testDate;

	@Column(name = "Assessment")
	private String Assessment;

	@Column(name = "TestMarks")
	private int testMarks;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "TotalMarks")
	private int totalMarks;

	@Column(name = "Result")
	private String result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String date) {
		this.testDate = date;
	}

	public String getAssessment() {
		return Assessment;
	}

	public void setAssessment(String assessment) {
		Assessment = assessment;
	}

	public int getTestMarks() {
		return testMarks;
	}

	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	}
