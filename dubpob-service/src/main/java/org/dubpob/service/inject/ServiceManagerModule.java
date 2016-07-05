package org.dubpob.service.inject;

import org.dubpob.service.Service;
import org.dubpob.service.ServiceManager;

import com.google.inject.AbstractModule;

public class ServiceManagerModule extends AbstractModule {
	private Service[] services;
	private ServiceManager manager;
	
	private ServiceManagerModule(Service[] services, ServiceManager manager) {
		this.services = services;
		this.manager = manager;
	}
	
	public static ServiceManagerModule with(ServiceManager manager, Service... services) {
		return new ServiceManagerModule(services, manager);
	}

	@Override
	protected void configure() {
		for(Service service : services) {
			requestInjection(service);
			manager.addService(service);
		}
		bind(ServiceManager.class).toInstance(manager);
	}
	
}
