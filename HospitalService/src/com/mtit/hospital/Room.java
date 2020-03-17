package com.mtit.hospital;

public class Room {
	private String roomNumber;
	private String reserveHours;
	private Doctor doctor;
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getReserveHours() {
		return reserveHours;
	}
	public void setReserveHours(int start, int end) {
		String reserveHours = start + ".00" + "-" + (start+end) + ".00";
		this.reserveHours = reserveHours;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}