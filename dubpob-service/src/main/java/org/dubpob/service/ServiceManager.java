package org.dubpob.service;

import java.util.List;

import org.dubpob.service.exception.ServiceAlreadyAddedException;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

public class ServiceManager {
	private List<Service> services = Lists.newArrayList();
	
	public void addService(Service service) {
		if(containsService(service)) {
			throw Throwables.propagate(new ServiceAlreadyAddedException());
		}
		services.add(service);
	}
	
	public boolean containsService(Service service) {
		for(Service iter : services) {
			if(iter.getClass().equals(service.getClass())) {
				return true;
			}
		}
		return false;
	}
	
	public void start() {
		for(final Service service : services) {
			new Thread(new Runnable() {
				public void run() {
					service.start();
				}
			}).start();
		}
	}
	
	public void stop() {
		for(Service service : services) {
			service.stop();
		}
	}
}