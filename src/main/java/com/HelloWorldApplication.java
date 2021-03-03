package com;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

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

	@Bean
	public LocaleResolver customLocaleResolver() {
		SessionLocaleResolver customLocaleResolver = new SessionLocaleResolver();
		customLocaleResolver.setDefaultLocale(Locale.US);
		return customLocaleResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
}
