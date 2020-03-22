package com.mtit.account;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mtit.patient.account.MockPatientController;
//comment
public class AccountActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	ServiceRegistration patientServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		MockAccountController mockAccountController = new MockAccountController();
		MockPatientController mockPatientController = new MockPatientController();
		serviceRegistration = context.registerService(MockAccountController.class.getName(), 
				mockAccountController, null);
		System.out.println("Account service started");
		patientServiceRegistration = context.registerService(MockPatientController.class.getName(), 
				mockPatientController, null);
		System.out.println("Patient service started");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Account Service went down!");
		serviceRegistration.unregister();
	}

}
