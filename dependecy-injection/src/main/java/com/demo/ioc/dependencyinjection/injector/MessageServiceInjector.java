package com.demo.ioc.dependencyinjection.injector;

import com.demo.ioc.dependencyinjection.consumer.Consumer;

public interface MessageServiceInjector {

	public Consumer getConsumer();
}
