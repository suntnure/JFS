package com.wipro.dao;

import java.util.List;

import com.wipro.model.CreditBean;



public interface CreditCardDao {

	
	public List<CreditBean> getAllUserDetail();

	public CreditBean getUserDetail(String id);
}
