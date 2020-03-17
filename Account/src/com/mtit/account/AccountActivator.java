package com.mtit.account;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AccountActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Account service started");
		MockAccountController mockAccountController = new MockAccountController();
		serviceRegistration = context.registerService(MockAccountController.class.getName(), 
				mockAccountController, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Account Service went down!");
		serviceRegistration.unregister();
	}

}
