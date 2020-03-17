package com.mtit.hospital;

public interface Doctor {
	public void setName(String name);
	public String getName();
	public void setId(int id);
	public int getId();
	public void setNumberOfPatientPerDay(int numberOfPatientsPerDay);
	public int getNumberOfPatientPerDay();
	public void analysePatien(int token);
	public void prescribePatient(int token);
	public void getPayment();
	public int getConsultingHours();
	public void setConsultingHours(int consultingHours);
	public double getChargePerPatient();
	public void setChargePerPatient(double chargePerPatient);
	public void setRoom(Room room);
	public Room getRoom();
	public void setSpecialization(String specialization);
	public String getSpecialization();
	public void setAvailableHour(int hour, String prefix);
	public String getAvaialableHour();
	public int getToken();
	public void incrementToken();
	public void process(int token);
}
