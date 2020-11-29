package com.wipro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Credit")
public class CreditBean {

	@Id
	@Column
	public String panNo;
	@Column(name = "credit_score")
	public double credit_score;

	public double getCredit_score() {
		return credit_score;
	}

	public void setCredit_score(double credit_score) {
		this.credit_score = credit_score;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
}
