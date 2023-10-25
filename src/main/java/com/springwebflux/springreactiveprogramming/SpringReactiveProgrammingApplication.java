package com.springwebflux.springreactiveprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class SpringReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProgrammingApplication.class, args);
	}

}
