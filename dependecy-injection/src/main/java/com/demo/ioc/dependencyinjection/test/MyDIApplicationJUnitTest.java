package com.demo.ioc.dependencyinjection.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.demo.ioc.dependencyinjection.consumer.Consumer;
import com.demo.ioc.dependencyinjection.consumer.MyDIApplication;
import com.demo.ioc.dependencyinjection.injector.MessageServiceInjector;
import com.demo.ioc.dependencyinjection.service.MessageService;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;

	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}

	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi abc", "abc@xyz.com");
	}

	@After
	public void tear() {
		injector = null;
	}

}
