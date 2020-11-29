package com.wipro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class QuestionTemp implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	@Column
	public int questionId;
	@Column
	public String question;
	@Column
	public String questionType;
	@Column
	public int surveyId;
	@Column
	public String options;
	
	public String getOption() {
		return options;
	}
	public void setOptions(String option) {
		this.options = option;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	
	
	
}
