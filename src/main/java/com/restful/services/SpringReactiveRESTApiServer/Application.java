package com.restful.services.SpringReactiveRESTApiServer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
/*
	Author: Giri Jeedigunta
	Git: https://github.com/giri-jeedigunta/java-spring-mongo-starter-reactive
*/

@SpringBootApplication
@EnableReactiveMongoRepositories
@Slf4j
public class Application {
	private final ApplicationContext context;

	public Application(ApplicationContext context) {
		this.context = context;
		log.info("Mongo URI -> {}", context.getEnvironment().getProperty("spring.data.mongodb.uri"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
