package com.wipro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.model.Answers;
import com.wipro.model.QuestionTemp;
@Repository
public interface QuestionsDao extends JpaRepository<QuestionTemp, Integer>{
	QuestionTemp save(QuestionTemp questionTemp);

	List<QuestionTemp> findAllBysurveyId(int id);
	
}
