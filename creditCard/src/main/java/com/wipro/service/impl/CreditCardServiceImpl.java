package com.wipro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.CreditCardDao;
import com.wipro.model.CreditBean;
import com.wipro.service.CreditCardService;

public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private CreditCardDao creditCardDao;
	



	@Override
	public List<CreditBean> getAllUserDetail() {
		return creditCardDao.getAllUserDetail();
	}


	@Override
	public CreditBean getUserDetail(String id) {
		return creditCardDao.getUserDetail(id);
	}

}
