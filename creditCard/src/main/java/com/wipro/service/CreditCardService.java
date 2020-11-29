package com.wipro.service;

import java.util.List;

import com.wipro.model.CreditBean;



public interface CreditCardService {

	public List<CreditBean> getAllUserDetail();
	
	public CreditBean getUserDetail(String id);


}
