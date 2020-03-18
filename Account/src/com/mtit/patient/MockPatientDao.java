package com.mtit.patient;

import java.util.ArrayList;

public class MockPatientDao {
	private ArrayList<MockPatientModel> patientDetails = new ArrayList<MockPatientModel>();
	
	public void addPatient(MockPatientModel patient) {
		patientDetails.add(patient);
	}
	
	public ArrayList<MockPatientModel> getAllPaitents(){
		return patientDetails;
	}
}
