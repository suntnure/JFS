package com.wipro.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	public int ID;

	public String Text;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

	public String Type;
	
	
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public List<Option> options = new ArrayList<>();
	
	public String[] optionsArray = null;


	public String[] getOptionsArray() {
		return optionsArray;
	}
	public void setOptionsArray(String[] optionsArray) {
		this.optionsArray = optionsArray;
	}
	

}
