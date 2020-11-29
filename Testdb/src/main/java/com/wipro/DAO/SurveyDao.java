package com.wipro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Survey;

@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer> {

	Survey save(Survey survey);

	List<Survey> findBysurveyTitle(String surveyTitle);

	void deleteBysurveyId(int surveyId);

	List<Survey> findBysurveyId(int surveyId);

	Survey findBysurveyTitleIgnoreCase(String title);

	
	

}
