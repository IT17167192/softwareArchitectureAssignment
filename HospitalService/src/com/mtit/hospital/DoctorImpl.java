package com.mtit.hospital;

import java.lang.annotation.Retention;
import java.util.ArrayList;

public class DoctorImpl implements Doctor {
	private String name;
	private int id;
	private int numberOfPatientPerDay;
	private int consultingHours;
	private double chargePerPatient;
	private Room room;
	private int token = 1;
	private String specialization;
	private String availableHour;
	
	public int getConsultingHours() {
		return consultingHours;
	}

	public void setConsultingHours(int consultingHours) {
		this.consultingHours = consultingHours;
	}

	public double getChargePerPatient() {
		return chargePerPatient;
	}

	public void setChargePerPatient(double chargePerPatient) {
		this.chargePerPatient = chargePerPatient;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setNumberOfPatientPerDay(int numberOfPatientsPerDay) {
		this.numberOfPatientPerDay = numberOfPatientsPerDay;
	}

	@Override
	public int getNumberOfPatientPerDay() {
		return numberOfPatientPerDay;
	}

	@Override
	public void analysePatien(int token) {
		System.out.println("Dr. " + getName() + " analysing patien number : #" + (token));
	}

	@Override
	public void prescribePatient(int token) {
		System.out.println("Dr. " + getName() + " prescribing patien number : #" + (token));
	}
	
	@Override
	public void process(int token) {
		analysePatien(token);
		prescribePatient(token);
		System.out.println("*************************************************************************");
	}

	public int getToken() {
		if(token <= getNumberOfPatientPerDay()) {
			return token;
		}else {
			return -1;
		}
	}
	
	@Override
	public void getPayment() {
		double payment = token * getChargePerPatient();
		
		if(token > getNumberOfPatientPerDay()) {
			payment = getChargePerPatient() * getChargePerPatient();
		}
		
		System.out.println("Dr. " + getName() + " taking payment as :Rs. " + payment);
	}

	@Override
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public Room getRoom() {	
		return room;
	}

	@Override
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String getSpecialization() {
		return specialization;
	}

	@Override
	public void setAvailableHour(int hour, String prefix) {
		this.availableHour = hour + ".00 " + prefix;
	}

	@Override
	public String getAvaialableHour() {
		return availableHour;
	}

	@Override
	public void incrementToken() {
		token++;
	}
	
}
