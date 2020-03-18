package com.mtit.account;

import java.util.ArrayList;
import java.util.Scanner;

public class MockAccountController {
	MockAccountDao mockAccountDao = new MockAccountDao();
	
	public Account checkAuthorization(String userName, String password) {
		 
		for(Account account : mockAccountDao.getAllAccounts()) {
			if(account.getUserName().equals(userName.trim()) && account.getPassword().equals(password.trim())) {
				return account;
			}
		}
		
		return null;
	}
	
	public Account getAccountById(String accountId) {
		for(Account account : mockAccountDao.getAllAccounts()) {
			if(account.getAccountId().equals(accountId)) {
				return account;
			}
		}
		
		return null;
	}
	
	public ArrayList<MedicalHistory> getMedicalHistoryByAccountId(String accountId) {
		ArrayList<MedicalHistory> mHistory = new ArrayList<MedicalHistory>();
		for(MedicalHistory medicalHistory : mockAccountDao.getAllMedicalHistories()) {
			if(medicalHistory.getAccountId().equals(accountId)) {
				mHistory.add(medicalHistory);
			}
		}
		
		return mHistory;
	}
	
	public void addMedicalHistory(MedicalHistory medicalHistory) {
		mockAccountDao.addMedicalHistory(medicalHistory);
	}
	
	public void addAccount() {
		Account account = new AccountImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n===========================\nAccount credential details\n===========================\n");
		
		System.out.print("Create username : ");
		String userName = sc.nextLine();
		account.setUserName(userName);
		
		System.out.print("Create password : ");
		String password = sc.nextLine();
		account.setPassword(password);
		
		System.out.println("\n===========================\nCredit card details\n===========================\n");

		System.out.print("Add credit card : ");
		String creditCardNo = sc.nextLine();
		account.setCreditCardNo(creditCardNo);
		
		System.out.print("Enter cvv : ");
		String cvv = sc.nextLine();
		account.setCvv(cvv);
		
		account.setAccountId("account" + mockAccountDao.getMaxAccountId());
				
		//add to mock db
		mockAccountDao.addAccount(account);
		
	}
}
