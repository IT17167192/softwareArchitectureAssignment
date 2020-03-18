package com.mtit.patient;

import com.mtit.account.MedicalHistory;
import com.mtit.account.MockAccountController;
import com.mtit.hospital.Doctor;
import com.mtit.hospital.Hospital;
import com.mtit.patient.account.MockPatientController;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class PatientActivator implements BundleActivator {

	ServiceReference hospitalServiceReference;
	ServiceReference accountServiceReference;
	Hospital hospitalService;
	MockAccountController mockAccountController;
	MockPatientController mockPatientController;
	
	public void start(BundleContext context) throws Exception {
		hospitalServiceReference = context.getServiceReference(Hospital.class.getName());
		hospitalService = (Hospital)context.getService(hospitalServiceReference);
		
		accountServiceReference = context.getServiceReference(MockAccountController.class.getName());
		mockAccountController = (MockAccountController)context.getService(accountServiceReference);

		Executer executer = new Executer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("press 1 to access the Hospital portal || Press 0 to exit");
		System.out.print("cmd>>");
		
		int input;
		
		try {
			
			input = sc.nextInt();				
			
			while(input != 0) {
				
				Patient p = new Patient();
				hospitalService.addAppointement();
				p.setToken(hospitalService.getTocken());
				p.setDoctor(hospitalService.getDoctor());
				p.setAccountId(hospitalService.getAccountId());
				mockPatientController = hospitalService.getPatientController();
				p.setPatientName(hospitalService.getPatientController().getPatientByAccountId(p.getAccountId()).getPatientName());
				mockAccountController.addMedicalHistory(hospitalService.getMedicalHistory());
				
				if(executer.checkPatientAvaialableByAccId(p.getAccountId())) {
					executer.addPatient(p);				
				}
				
				System.out.println("press 1 to access the Hospital portal || Press 0 to exit");
				System.out.print("cmd>>");
				
				try {
					input = sc.nextInt();				
				}catch (InputMismatchException e) {
					System.out.println("***Invalid input***");
					System.out.println("press 1 to access the Hospital portal || Press 0 to exit");
					System.out.print("cmd>>");
					input = sc.nextInt();
				}
				
			}
		
		}catch (InputMismatchException e) {
			System.out.println("***Invalid input***");
			System.out.println("press 1 to access the Hospital portal || Press 0 to exit");
			System.out.print("cmd>>");
			input = sc.nextInt();
		}
		
		
		System.out.println("\n==================================\nDoctor starts analysing patients\n==================================");
		for(Patient patient : executer.getAllPatients()) {
			hospitalService.process(patient.getDoctor(), patient.getToken());
		}
		
		
		System.out.println("\n==================\nDoctors payments\n==================");
		for(Doctor doctor : hospitalService.getDoctorList()) {
			doctor.getPayment();
		}
						   
		System.out.println("\n==================\nPatients Medical History\n==================");
		
		for(Patient patient : executer.getAllPatients()) {
			
			System.out.println("Patient : " + patient.getPatientName() + " Medical history");
			System.out.println("=====================================================");
			int counter = 1;
			for(MedicalHistory medicalHistory : mockAccountController.getMedicalHistoryByAccountId(patient.getAccountId())) {
				System.out.println((counter++) + " )");
				System.out.println("Doctor Name : " + medicalHistory.getChanneledDoctorName());
				System.out.println("Appointment Time : " + medicalHistory.getAppointmentTime());
				System.out.println("Appointment Number : " + medicalHistory.getAppointmentNumber());
				System.out.println("Room Number : " + medicalHistory.getRoomNumber());
				System.out.println("Payment : " + medicalHistory.getPayment());	
				System.out.println("");
			}
			
			System.out.println("=====================================================");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
