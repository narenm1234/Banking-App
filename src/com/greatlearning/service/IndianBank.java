package com.greatlearning.service;

import java.util.Scanner;
import com.greatlearning.interfaces.InternetBanking;

public class IndianBank implements InternetBanking{

	private int amount;
	private int otp;
	private int otpGenerated;
	private int bankAccountNo;
	private int bankBalance = 1000;

	Scanner sc = new Scanner(System.in);
	
	@Override
	public void deposit() {

//		a) Ask the amount that customer wants to deposit
		System.out.println("enter the amount you want to deposit");
		amount = sc.nextInt();
		
//		b) validate the amount that customer wants to deposit and proceed
		if (amount > 0) {
			System.out.println("amount " + amount + " deposited successfully");
			bankBalance = bankBalance + amount;
			System.out.println("Updated Bank balance is " + bankBalance+"\n");
		} else
			System.out.println("enter a valid amount greater than 0");
	}

	@Override
	public boolean withdrawal() {
		
//		a) Ask the amount that customer wants to withdraw
		System.out.println("enter the amount you want to withdrawl");
		amount = sc.nextInt();
		
//		b) check for sufficient balance and proceed
		if (bankBalance - amount >= 0) {
			System.out.println("amount " + amount + " withdrawl successfully");
			bankBalance = bankBalance - amount;
			System.out.println("Remaining Bank balance is " + bankBalance);
			return true;
		} else {
			System.out.println("insufficient funds");
			return false;
		}
	}

	@Override
	public boolean transfer() {
		
//		1) Generate OTP
		OTPGenerator otpG = new OTPGenerator();
		System.out.println("Enter the otp");
		otpGenerated = otpG.generateOTP();
		System.out.println(otpGenerated);
		otp = sc.nextInt();
		
//		2) Validate and process
		if (otp == otpGenerated) {
			System.out.println("otp verification Successful !!!");
			
//			a) Ask the amount that customer wants to transfer
			System.out.println("Enter the amount you want to transfer");
			amount = sc.nextInt();
			System.out.println("Enter the BankAccount no to which you want to transfer");
			bankAccountNo = sc.nextInt();

//			b) check for sufficient balance and proceed
			if (bankBalance - amount >= 0) {
				System.out.println("amount " + amount + " transferred successful to bankAccount " + bankAccountNo);
				bankBalance = bankBalance - amount;
				System.out.println("Remaining Bank balance is " + bankBalance);
				return true;
			} else {
				System.out.println("insufficient funds");
				return false;
			}
		} else {
			System.out.println("invalid otp please try again");
			return false;
		}
		
//		return false; // This line is not needed and there is a return statement in the else part 
	}

	@Override
	public int checkBalance() {
		
		if(this.bankBalance<=5000) {
			System.out.println("You are have to maintain a minimum of Rs 5000/- ");
		}
		return this.bankBalance;
	}
}