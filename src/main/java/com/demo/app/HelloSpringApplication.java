package com.demo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HelloSpringApplication {
	private static final Logger logger = LoggerFactory.getLogger(HelloSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
		logger.info("Start");
	}
}
