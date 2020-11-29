package com.wipro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wipro.model.CreditBean;

public class UserDetailRowMapper implements RowMapper<CreditBean> {

	/*
	 * public UserDetail mapRow(ResultSet rs, int row) throws SQLException {
	 * UserDetail userDetail = new UserDetail(); userDetail.setId(rs.getInt("id"));
	 * userDetail.setFirstName(rs.getString("first_name"));
	 * userDetail.setLastName(rs.getString("last_name"));
	 * userDetail.setEmail(rs.getString("email"));
	 * userDetail.setDob(rs.getString("dob")); return userDetail; }
	 */
	
	public CreditBean mapRow(ResultSet rs, int row) throws SQLException {
		CreditBean userDetail = new CreditBean();
		userDetail.setPanNo(rs.getString("panNo"));
		userDetail.setCredit_score(rs.getDouble("credit_score"));
		return userDetail;
	}

}
