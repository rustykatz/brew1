package com.example.brew1;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


//? What is SpringBootApplication
// @SpringBootApplication is a convenience annotation that adds all of the following:
// - @Configuration: Tags the class as a source of bean definitions for the application context.
// - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, 
// other beans, and various property settings. For example, if spring-webmvc is on the classpath, this 
// annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
// - @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.

//? What is a bean?
// Definition:
// A bean is simply a Java object that is instantiated, configured, and managed by the Spring container. 
// Beans are created based on the configuration metadata provided through annotations, XML, or Java-based configuration.

// Purpose:
// Beans allow you to create reusable and loosely coupled components in your application.
//  The Spring container takes care of creating and wiring these beans together, enabling dependency injection.

// Lifecycle:
// The Spring container controls the lifecycle of a bean:

// Instantiation: The bean is created.
// Initialization: Any initialization logic is executed.
// Usage: The bean is used in the application.
// Destruction: The bean is destroyed when the application context is closed.


@SpringBootApplication
public class Brew1Application {

	public static void main(String[] args) {
		SpringApplication.run(Brew1Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Lets inspect the beans provided byt Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);

			for (String beamName : beanNames) {
				System.out.println(beamName);
			}
		};
	}

}
