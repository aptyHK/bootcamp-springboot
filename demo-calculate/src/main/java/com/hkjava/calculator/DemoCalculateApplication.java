package com.hkjava.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // it is a configuration, so itself is a bean, so can autowired
// @Configuration < @SpringBootConfiguration < @SpringBootApplication
public class DemoCalculateApplication {

	private static ConfigurableApplicationContext context;
	private static String[] beans;

	public String[] getBeans() {
		return beans;
	}

	public static void main(String[] args) {
		//SpringApplication.run(DemoCalculateApplication.class, args);
		context = SpringApplication.run(DemoCalculateApplication.class, args);
		beans = context.getBeanDefinitionNames();
	}

}
