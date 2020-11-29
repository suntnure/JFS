package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.DAO.AnswersDAO;
import com.wipro.DAO.userDAO;
import com.wipro.model.Answers;
import com.wipro.model.Users;

@Service
public class SaveSurveyService {

	@Autowired
	AnswersDAO answersDAO;
	
	@Autowired
	userDAO userDAOobj;
	
	
	
	public Answers AddAnswer(Answers ans) {
		return answersDAO.save(ans);
	}

	public void addUsers(Users users) {		
		userDAOobj.save(users);
		
	}

	public String findByEmailIdIgnoreCase(String email,int surveyId) {
		return userDAOobj.findBysurveyIdAndemail(surveyId,email);
	}
	
	public List<Users> findAllBySurveyId(int surveyId) {
		return userDAOobj.findAllBySurveyId(surveyId);
	}

	public List<Object[]> getAnswersBySurveyId(int surveyId) {
		return answersDAO.getAnswersBySurveyId(surveyId);
	}

	public List<Object[]> findAllBySurveyId1(int surveyId) {
		return answersDAO.findAllBySurveyId(surveyId);
	}
	
}
