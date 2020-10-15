package com.restful.services.reactiveMongoStarter;

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
public class ReactiveRESTStarterApp {
	public static void main(String[] args) {
		SpringApplication.run(ReactiveRESTStarterApp.class, args);
	}
}
