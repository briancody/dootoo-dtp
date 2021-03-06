package com.roscode.dootoo.dtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan
@Configuration
@EnableMongoRepositories
//@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class DTPRunner {

	public static void main(String[] args) {
		SpringApplication.run(DTPRunner.class, args);
	}

}
