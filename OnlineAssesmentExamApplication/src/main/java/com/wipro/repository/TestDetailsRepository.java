package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.TestDetails;

@Repository
public interface TestDetailsRepository extends JpaRepository<TestDetails, Integer>{
	 public List<TestDetails> findAllByOrderByIdAsc();
}
