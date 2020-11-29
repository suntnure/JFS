package com.wipro.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.CreditCardDao;
import com.wipro.model.CreditBean;
import com.wipro.rowmapper.UserDetailRowMapper;


public class CreditCardDaoImpl implements CreditCardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	@Transactional
	public List<CreditBean> getAllUserDetail() {
		List<CreditBean> userDetail = (List<CreditBean>) jdbcTemplate.query("select * from Credit",
				new UserDetailRowMapper());
		return userDetail;
	}
	@Transactional
	public CreditBean getUserDetail(String id) {
		CreditBean userDetail = (CreditBean) jdbcTemplate.queryForObject("select * from Credit where panNo = ?",
				new Object[] { id }, new UserDetailRowMapper());
		return userDetail;
	}
}
