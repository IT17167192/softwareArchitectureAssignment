package com.mtit.patient;

import java.util.ArrayList;

public class Executer {
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public void addPatient(Patient patien) {
		patients.add(patien);
	}
	
	public ArrayList<Patient> getAllPatients(){
		return patients;
	}
}
