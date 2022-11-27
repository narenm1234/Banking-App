package com.greatlearning.model;

public class Customer {

	
	public Customer(String bankAccountNo, String password) {
		this.bankAccountNo = bankAccountNo;
		this.password = password;
	}

	private String bankAccountNo;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

}
