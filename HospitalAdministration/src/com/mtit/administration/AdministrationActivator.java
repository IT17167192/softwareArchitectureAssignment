package com.mtit.administration;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.account.Account;
import com.mtit.account.MockAccountController;
import com.mtit.hospital.Hospital;
import com.mtit.patient.account.MockPatientController;

public class AdministrationActivator implements BundleActivator {

	ServiceReference patientReference;
	ServiceReference hospitalServiceReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("\n===================================\nHospital Administration"
				+ "\n===================================\n");
		
		patientReference = context.getServiceReference(MockPatientController.class.getName());
		MockPatientController patient = (MockPatientController)context.getService(patientReference);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("To add new patient press 1 || To exit press 0");
		System.out.print("cmd>>");
		
		int input = sc.nextInt();
		
		while(input != 0) {
			System.out.println("\n===================================\nHospital Administration-Add Patient"
					+ "\n===================================\n");
			patient.addPatient();
			System.out.println("To add new patient press 1 || To exit press 0");
			System.out.print("cmd>>");
			input = sc.nextInt();
		}
		
		patient.getMockAccountController().createMockAccounts();
		hospitalServiceReference = context.getServiceReference(Hospital.class.getName());
		Hospital hospitalService = (Hospital)context.getService(hospitalServiceReference);
		hospitalService.setAccountController(patient.getMockAccountController());
		hospitalService.setPatientController(patient);
		
	
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
