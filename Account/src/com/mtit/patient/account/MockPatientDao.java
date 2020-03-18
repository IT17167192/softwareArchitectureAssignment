package com.mtit.patient.account;

import java.util.ArrayList;

public class MockPatientDao {
	private ArrayList<MockPatientModel> patientDetails = new ArrayList<MockPatientModel>();
	
	public void addPatient(MockPatientModel patient) {
		patientDetails.add(patient);
		System.out.println("Patient added successfully");
	}
	
	public ArrayList<MockPatientModel> getAllPaitents(){
		return patientDetails;
	}
}
