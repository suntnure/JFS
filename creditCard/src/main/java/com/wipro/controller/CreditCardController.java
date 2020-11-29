package com.wipro.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.model.CreditBean;
import com.wipro.service.CreditCardService;




@Controller
public class CreditCardController {


	@Autowired
	private CreditCardService creditCardService;

	
	@RequestMapping(value = "/checkEligibility", method = RequestMethod.GET)
	public String showIndexPage(ModelMap model) {
		return "index";
	}

	
	@RequestMapping(value = "/checkEligibility", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String panNo, HttpServletRequest request)
			throws SQLException {
		CreditBean creditBean = null;
		List<CreditBean> lstBeans = creditCardService.getAllUserDetail();
		for(CreditBean cb:lstBeans) {
			if(cb.getPanNo().equals(panNo)) {
				creditBean = cb;
				break;
			}
		}
		if (creditBean != null && creditBean.getCredit_score() < 5) {
			model.put("title", "CreditCard-Not Eligible");
			model.put("Msg", "Sorry!!! You are not eligible for a credit card");
			return "Noneligible";
		} else if (creditBean!= null && creditBean.getCredit_score() >= 5) {
			model.put("title", "CreditCard-Eligible");
			model.put("Msg", "Congratulations!!! You are eligible for a credit card");
			return "eligible";
		} else {
			model.put("title", "CreditCard-Invalid");
			model.put("Msg", "Invalid PAN Entry !!!");
			return "Invalid";
		}

	}
	

}
