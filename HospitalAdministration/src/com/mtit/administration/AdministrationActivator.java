package com.mtit.administration;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.account.Account;
import com.mtit.account.MockAccountController;
import com.mtit.patient.MockPatientController;

public class AdministrationActivator implements BundleActivator {

	ServiceReference accountReference;
	
	public void start(BundleContext context) throws Exception {
		accountReference = context.getServiceReference(Account.class.getName());
		MockPatientController patient = (MockPatientController)context.getService(accountReference);
		MockAccountController account = (MockAccountController)context.getService(accountReference);
		patient.addPatient();
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
