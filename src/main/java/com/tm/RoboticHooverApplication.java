package com.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories("com.tm.repository")
@ComponentScan({"com.tm.controller", "com.tm.service"})
public class RoboticHooverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboticHooverApplication.class, args);
	}
}
