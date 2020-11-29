package com.wipro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int surveyId;
	//(columnDefinition = "integer default 0")
	@Column
	public int responseCount;
	
	@Column
	public String surveyTitle;

	@Column
	public String surveySubmitDate;
	
	public String getSurveySubmitDate() {
		return surveySubmitDate;
	}

	public void setSurveySubmitDate(String surveySubmitDate) {
		this.surveySubmitDate = surveySubmitDate;
	}

	public int getResponseCount() {
		return responseCount;
	}

	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}

	@Column
	public Date timestamp;
	
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	
}
