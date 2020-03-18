package com.mtit.hospital;

import java.util.ArrayList;

import com.mtit.account.Account;
import com.mtit.account.MedicalHistory;
import com.mtit.account.MockAccountController;
import com.mtit.patient.account.MockPatientController;

public interface Hospital {
	public ArrayList<Doctor> getDoctorList();
	public void addDoctor(Doctor doctor);
	public void setNumberOfRooms(int numberOfRooms);
	public void assignRooms(Room room);
	public ArrayList<Room> getAssignRooms();
	public void setHospitalCharge(double charge);
	public double getHospitalCharge();
	public void addAponitement();	
	public int getTocken();
	public void setToken(int patientToken);
	public void setDoctor(Doctor doctor);
	public Doctor getDoctor();
	public void process(Doctor doctor, int token);
	public void setAccount(Account account);
	public String getAccountId();
	public Account getAccount();
	public void setMedicalHistory(MedicalHistory medicalHistory);
	public MedicalHistory getMedicalHistory();
	public MockAccountController getAccountController();
	public void setAccountController(MockAccountController mockAccountController);
	public MockPatientController getPatientController();
	public void setPatientController(MockPatientController mockPatientController);
}
