package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

	/**
	 * 
	 * When the JAR file is executed the main() method will be run. The main()
	 * method calls the static run() method from SpringApplication class, which will
	 * bootstrap the application, creating the Spring application context. The two
	 * parameters which are passed to the run() method is the configuration class
	 * and the command-line arguments.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
