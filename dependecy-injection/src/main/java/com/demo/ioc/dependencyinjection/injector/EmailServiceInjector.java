package com.demo.ioc.dependencyinjection.injector;

import com.demo.ioc.dependencyinjection.consumer.Consumer;
import com.demo.ioc.dependencyinjection.consumer.MyDIApplication;
import com.demo.ioc.dependencyinjection.service.EmailServiceImpl;

/**
 * A Prototype class
 * @author Arvind
 *
 */
public class EmailServiceInjector implements MessageServiceInjector {

	public Consumer getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
