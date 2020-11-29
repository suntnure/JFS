package com.wipro.model;

import java.util.ArrayList;
import java.util.List;

public class TempSurvey {

	public int ID;
	
	public String Title;
	
	public List<Question> Question = new ArrayList<>();
	
	
	public String getTitle() {
		return Title;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public List<Question> getQuestion() {
		return Question;
	}

	public void setQuestion(List<Question> question) {
		Question = question;
	}

	public void setTitle(String title) {
		Title = title;
	}

	

}
