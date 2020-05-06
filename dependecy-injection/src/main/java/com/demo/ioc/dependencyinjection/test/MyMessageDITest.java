package com.demo.ioc.dependencyinjection.test;

import com.demo.ioc.dependencyinjection.consumer.Consumer;
import com.demo.ioc.dependencyinjection.injector.EmailServiceInjector;
import com.demo.ioc.dependencyinjection.injector.MessageServiceInjector;
import com.demo.ioc.dependencyinjection.injector.SMSServiceInjector;

public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi abc";
		String email = "abc@xyz.com";
		String phone = "8888888888";
		MessageServiceInjector injector = null;
		Consumer app = null;

		// Send SMS
//		cannot instantiate this object as its a Singleton class
		// A Singleton way of injecting the dependency

		injector = SMSServiceInjector.getInstance();
		app = injector.getConsumer();
		app.processMessages(msg, phone);

		// Send email
//   A prototype way of injecting the dependency
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);

	}

}
