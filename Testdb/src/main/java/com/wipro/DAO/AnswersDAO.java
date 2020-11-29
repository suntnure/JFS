package com.wipro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.model.Answers;

@Repository
public interface AnswersDAO extends JpaRepository<Answers, Integer>{

	Answers save(Answers answers);
	List<Answers> findAllBysurveyId(int id);
	
	@Query("SELECT c.answer,c.questionId FROM Answers AS c where c.surveyId =:surveyId GROUP BY c.questionId,c.answer order by c.questionId")
	List<Object[]> getAnswersBySurveyId(@Param("surveyId") int surveyId);
	
	List<Object[]> findAllBySurveyId(int surveyId);
}
