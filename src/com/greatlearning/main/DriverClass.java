package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.interfaces.InternetBanking;
import com.greatlearning.model.Customer;
import com.greatlearning.service.IndianBank;

public class DriverClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String bankAccountNo;
		String password;

//		1. create customer object
		Customer customer1 = new Customer("32390016", "password");
		// Customer customer2 = new Customer("32390017", "password2");
		
//		2. object for Indian Bank
		InternetBanking banking = new IndianBank();
		
//		3. Welcome to login page
		System.out.println("welcome to the login page");
		System.out.println();
		
//		4. Ask customer to provide credentials
		System.out.println("Enter the bank Account no ");
		bankAccountNo = sc.nextLine();
		System.out.println("Enter the password for the corresponding bank account no ");
		password = sc.nextLine();

//		5. Validate the credentials and proceed
		if (customer1.getBankAccountNo().equals(bankAccountNo) && customer1.getPassword().equals(password)) {

			System.out.println("\n\n!!!!! Welcome to Indian Bank !!!!!\n\n");
			int option;
			
//			6. Use do while loop to recursively execute the logic till 0 is pressed
			do {

				System.out.println("-----------------------------------------------");
				System.out.println("Enter the operation number that you want to perform");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdrawl");
				System.out.println("4. Transfer");
				System.out.println("0. Logout");
				System.out.println("-----------------------------------------------");
				option = sc.nextInt();
				
//				7. Use switch case to implement the necessary logic 
				switch (option) {

				case 0: {
					option = 0;
					break;
				}
				
				case 1: {
					System.out.println("Current Bank Balance is: "+banking.checkBalance());
					break;
				}
				
				case 2: {
					banking.deposit();
					break;
				}
				
				case 3: {
					banking.withdrawal();
					break;
				}
				
				case 4 : {
					System.out.println("Transaction Status: " + (banking.transfer()? "Success" : "Failed"));
				}
				break;
				
				default:
					System.out.println("enter valid option");
				}

			} while (option != 0);
			
//			7. Print exit message after exiting the do while loop
			System.out.println("Exited successfully");
			sc.close();
			
		} else {
			System.out.println("Invalid credentials");
		}
	}
}
