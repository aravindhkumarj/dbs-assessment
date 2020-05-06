package com.demo.ioc.dependencyinjection.injector;

import com.demo.ioc.dependencyinjection.consumer.Consumer;
import com.demo.ioc.dependencyinjection.consumer.MyDIApplication;
import com.demo.ioc.dependencyinjection.service.SMSServiceImpl;

/**
 * A Singleton class
 * @author Arvind
 *
 */
public class SMSServiceInjector implements MessageServiceInjector {

	private static SMSServiceInjector smsServiceInjector = null;

	private SMSServiceInjector() {
	}

	public static SMSServiceInjector getInstance() {
		if (smsServiceInjector == null) {
			smsServiceInjector = new SMSServiceInjector();
		}
		return smsServiceInjector;
	}

	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
