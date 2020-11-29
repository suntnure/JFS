package com.wipro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

	 Admin findByusername(String username);
}
