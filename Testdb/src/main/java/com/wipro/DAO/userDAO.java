package com.wipro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.model.Users;

@Repository
public interface userDAO extends JpaRepository<Users, Integer>{


	List<Users> findAllBySurveyId(int surveyId);

	@Query("SELECT u.email FROM Users AS u where u.surveyId =:surveyId AND u.email =:email")
	String findBysurveyIdAndemail(@Param("surveyId")int surveyId, @Param("email")String email);
}
