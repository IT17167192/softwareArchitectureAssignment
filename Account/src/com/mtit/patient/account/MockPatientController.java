package com.mtit.patient.account;

import java.util.Scanner;

import com.mtit.account.Account;
import com.mtit.account.AccountImpl;
import com.mtit.account.MockAccountController;

public class MockPatientController {

	MockPatientDao mockPatientDao = new MockPatientDao();
	MockAccountController mockAccountController = new MockAccountController();
	
	public MockPatientModel getPatientByAccountId(String accountId) {
		for(MockPatientModel patient : mockPatientDao.getAllPaitents()) {
			if(patient.getAccount().getAccountId().equals(accountId)) {
				return patient;
			}
		}
		
		return null;
	}
	
	public void addPatient() {
		Scanner sc = new Scanner(System.in);
		MockPatientModel patient = new MockPatientModel();
		
		System.out.println("\n===========================\nPatient personal details\n===========================\n");
		System.out.print("Enter patient name : ");
		String name = sc.nextLine();
		patient.setPatientName(name);
		
		mockAccountController.addAccount(patient, mockPatientDao);
		
	}
	
	public MockAccountController getMockAccountController() {
		return mockAccountController;
	}
	
}
