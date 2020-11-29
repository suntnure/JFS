package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.DAO.QuestionsDao;
import com.wipro.DAO.SurveyDao;
import com.wipro.model.QuestionTemp;
import com.wipro.model.Survey;
import com.wipro.model.TempSurvey;

@Service
public class CreateSurveyService {

	@Autowired
	SurveyDao surveyDao;
	
	@Autowired
	QuestionsDao questionsDao;
	
	public Survey createSurvey(Survey survey) {
		return surveyDao.save(survey);
	}
	
	public QuestionTemp AddQuestions(QuestionTemp question) {
		return questionsDao.save(question);
	}

	public List<Survey> findAll() {
		 return  surveyDao.findAll();
	}

	public List<Survey> getSurveyDetails(String surveyTitle) {
		return surveyDao.findBysurveyTitle(surveyTitle);
	}

	public List<QuestionTemp> getquestions(int id) {
		return questionsDao.findAllBysurveyId(id);
	}

	public void deleteBysurveyId(int surveyId) {
		 surveyDao.deleteBysurveyId(surveyId);
		
	}

	public List<Survey> findbysurveyId(int surveyId) {
		return surveyDao.findBysurveyId(surveyId);
	}

	public Survey findBysurveyTitleIgnoreCase(String title) {
		// TODO Auto-generated method stub
		return surveyDao.findBysurveyTitleIgnoreCase(title);
	}

	/*public void deleteOnTimeStampExpire() {
		surveyDao.deleteSurveyTimestampBefore();
		
	}
*/
}
