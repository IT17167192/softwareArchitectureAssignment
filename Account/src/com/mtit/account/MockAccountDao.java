package com.mtit.account;

import java.util.ArrayList;

import com.mtit.patient.account.MockPatientDao;
import com.mtit.patient.account.MockPatientModel;

public class MockAccountDao {
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private ArrayList<MedicalHistory> medicalHistories = new ArrayList<MedicalHistory>();
	private int uniqueId = 1;
	
	public void addMedicalHistory(MedicalHistory medicalHistory) {
		medicalHistories.add(medicalHistory);
	}
	
	public ArrayList<Account> getAllAccounts(){
		return accounts;
	}
	
	public void createMockData() {
		Account account1 = new AccountImpl();
		account1.setUserName("patient1");
		account1.setPassword("password1");
		account1.setAccountId("mockId3");
		account1.setCreditCardNo("155486248556");
		account1.setCvv("456");
		
		Account account2 = new AccountImpl();
		account2.setUserName("patient2");
		account2.setPassword("password2");
		account2.setAccountId("mockId4");
		account2.setCreditCardNo("155485584556");
		account2.setCvv("141");
		
		Account account3 = new AccountImpl();
		account3.setUserName("patient3");
		account3.setPassword("password3");
		account3.setAccountId("mockId5");
		account3.setCreditCardNo("1554855846");
		account3.setCvv("744");
		
		Account account4 = new AccountImpl();
		account4.setUserName("patient4");
		account4.setPassword("password4");
		account4.setAccountId("mockId6");
		account4.setCreditCardNo("155484452136");
		account4.setCvv("568");
		
		Account account5 = new AccountImpl();
		account5.setUserName("patient5");
		account5.setPassword("password5");
		account5.setAccountId("mockId7");
		account5.setCreditCardNo("155484136556");
		account5.setCvv("444");
		
		Account account6 = new AccountImpl();
		account6.setUserName("patient6");
		account6.setPassword("password6");
		account6.setAccountId("mockId8");
		account6.setCreditCardNo("474186248556");
		account1.setCvv("456");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		accounts.add(account5);
		accounts.add(account6);
	}
	
	ArrayList<MedicalHistory> getAllMedicalHistories(){
		return medicalHistories;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
		System.out.println("Account added successfully!");
	}
	
	public int getMaxAccountId() {
		return uniqueId++;
	}
	
}
